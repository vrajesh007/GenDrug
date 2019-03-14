package com.newproject.gendrug;

import android.accounts.Account;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class login extends AppCompatActivity {
    EditText email, password;
    Button login, createacc;
    TextView forgotp;
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userSessionManager = new UserSessionManager(login.this);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        createacc=(Button) findViewById(R.id.createacc);
        forgotp=(TextView)findViewById(R.id.forgotp);

        forgotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(login.this,forgotpassword.class);
                startActivity(intent);
            }
        });

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });
        login .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLoginRequest();
            }
        });
    }

    private void sendLoginRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.KEY_LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseLoginResponse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

               Map<String,String> params = new HashMap<>();

               params.put(JsonField.KEY_USER_EMAIL,email.getText().toString());
               params.put(JsonField.KEY_USER_PASSWORD,password.getText().toString());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(login.this);
        requestQueue.add(stringRequest);
    }

    private void parseLoginResponse(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                if (flag == 1) {
                    JSONObject jsonArray = jsonObject.optJSONObject(JsonField.USER_ARRAY);
                    Log.d("TAG",JsonField.USER_ARRAY);

                    String U_id= jsonArray.optString(JsonField.KEY_USER_ID);
                    String U_name= jsonArray.optString(JsonField.KEY_USER_NAME);
                    String Gender= jsonArray.optString(JsonField.KEY_USER_GENDER);
                    String DOB= jsonArray.optString(JsonField.KEY_USER_DOB);
                    String Email= jsonArray.optString(JsonField.KEY_USER_EMAIL);
                    String Address= jsonArray.optString(JsonField.KEY_USER_ADDRESS);
                    String Password= jsonArray.optString(JsonField.KEY_USER_PASSWORD);
                    String Phonenum= jsonArray.optString(JsonField.KEY_USER_MOBILE_NUMBER);

                    userSessionManager.setLoginStatus();

                    userSessionManager.setUserDetails(U_id,U_name,Gender,DOB,Email,Address,Password,Phonenum);

                    Intent intent = new Intent(login.this,categorylist.class);
                    finish();
                    startActivity(intent);
                    Toast.makeText(login.this, "Welcome", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Invalid Login Details", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
