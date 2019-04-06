package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class forgotpassword extends AppCompatActivity implements View.OnClickListener {
    EditText email;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        email = (EditText) findViewById(R.id.etmail);
        send = (Button) findViewById(R.id.bsend);
        send.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View view) {
        sendForgotPasswordRequest();

        Intent intent=new Intent(forgotpassword.this,login.class);
        startActivity(intent);
    }



    private void sendForgotPasswordRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.KEY_FORGOT_PASSWORD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseForgotPasswordResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put(JsonField.KEY_USER_EMAIL,email.getText().toString());

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(forgotpassword.this);
        requestQueue.add(stringRequest);
    }

    private void parseForgotPasswordResponse(String response) {
        Log.d("RESPONSE",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag= jsonObject.optInt(JsonField.FLAG);
            String message = jsonObject.optString(JsonField.MESSAGE);
            if(flag==1) {
                Toast.makeText(this,"Password sent to your mail!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
