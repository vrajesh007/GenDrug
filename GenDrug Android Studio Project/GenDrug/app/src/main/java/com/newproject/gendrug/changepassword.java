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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.NetworkError;
import com.android.volley.error.NoConnectionError;
import com.android.volley.error.ServerError;
import com.android.volley.error.TimeoutError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class changepassword extends AppCompatActivity implements View.OnClickListener {
    EditText etOpass,etNpass,etCpass;
    Button submit;
    private  UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        etOpass= findViewById(R.id.etOpass);
        etNpass= findViewById(R.id.etNpass);
        etCpass= findViewById(R.id.etCpass);
        submit=findViewById(R.id.submit);
        userSessionManager= new UserSessionManager(changepassword.this);
        submit.setOnClickListener(this);
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
        sendChangePasswordRequest();

    }

    private void sendChangePasswordRequest() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebURL.KEY_CHANGE_PASSWORD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseChangePasswordResponse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params= new HashMap<>();
                params.put(JsonField.KEY_USER_ID,userSessionManager.getUserID());
                params.put(JsonField.KEY_OLD_PASSWORD,etOpass.getText().toString());
                params.put(JsonField.KEY_NEW_PASSWORD,etNpass.getText().toString());
                params.put(JsonField.KEY_CONFIRM_PASSWORD,etCpass.getText().toString());

                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(changepassword.this);
        requestQueue.add(stringRequest);
    }

    private void parseChangePasswordResponse(String response) {
        Log.d("RESPONSE",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag= jsonObject.optInt(JsonField.FLAG);
            String message = jsonObject.optString(JsonField.MESSAGE);
            if(flag==1) {
                Toast.makeText(this,"Password Changed Successfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(changepassword.this, Navigationactivity.class);
                startActivity(intent);


            }
            else{
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
