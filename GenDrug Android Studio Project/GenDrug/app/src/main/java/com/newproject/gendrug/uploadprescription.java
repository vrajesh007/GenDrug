package com.newproject.gendrug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.util.HashMap;
import java.util.Map;

public class uploadprescription extends AppCompatActivity implements View.OnClickListener {
    EditText enterpres,uploadpres,enteremail;
    Button  uploadsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadprescription);

        enterpres= (EditText)findViewById(R.id.etenterpres);
        uploadpres= (EditText) findViewById(R.id.buploadpres);
        enteremail=(EditText)findViewById(R.id.etenteremail);
        uploadsubmit= (Button)findViewById(R.id.buploadsubmit);

        uploadsubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        sendUploadRequest();
        Toast.makeText(uploadprescription.this, "Upload done successfully", Toast.LENGTH_SHORT).show();
    }

    private void sendUploadRequest() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebURL.UPLOAD_PRESCRIPTION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseUploadResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put(JsonField.UPLOAD_NAME, enterpres.getText().toString());
                params.put(JsonField.UPLOAD_PHOTO, uploadpres.getText().toString());
                params.put(JsonField.UPLOAD_EMAIL, enteremail.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(uploadprescription.this);
        requestQueue.add(stringRequest);
    }

    private void parseUploadResponse(String response) {
        Log.d("RESPONSE",response);

    }

}

