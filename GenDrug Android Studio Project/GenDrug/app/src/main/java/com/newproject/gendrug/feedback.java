package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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

import java.util.HashMap;
import java.util.Map;

public class feedback extends AppCompatActivity implements View.OnClickListener {
    EditText etfeedback,etfeedbackdate, etfeedbackemail;
    Button bfeedbacksubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        etfeedback = (EditText)findViewById(R.id.etfeedback);
        etfeedbackdate= (EditText)findViewById(R.id.etfeedbackdate);
        etfeedbackemail= (EditText)findViewById(R.id.etfeedbackemail);

        bfeedbacksubmit = (Button)findViewById(R.id.bfeedbacksubmit);

        bfeedbacksubmit.setOnClickListener(this);
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
        switch (view.getId()){
            case R.id.bfeedbacksubmit:

                if (checkEmail())
                {
                    sendFeedbackRequest();
                    Toast.makeText(feedback.this, "Feedback Sent", Toast.LENGTH_SHORT).show();

                }

                break;
        }

    }

    private void sendFeedbackRequest() {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebURL.KEY_FEEDBACK_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseFeedbackResponse(response);
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
                params.put(JsonField.FEEDBACK, etfeedback.getText().toString());
                params.put(JsonField.FEEDBACK_DATE, etfeedbackdate.getText().toString());
                params.put(JsonField.FEEDBACK_EMAIL,etfeedbackemail.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(feedback.this);
        requestQueue.add(stringRequest);
    }

    private void parseFeedbackResponse(String response) {
        Log.d("RESPONSE",response);

    }
    public boolean checkEmail() {
        boolean isEmailValid = false;
        String emailid = etfeedbackemail.getText().toString().trim();

        if (etfeedbackemail.getText().toString().trim().length() < 0) {
            etfeedbackemail.setError("Enter Email");
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            isEmailValid = true;
        } else {
            etfeedbackemail.setError("Enter Correct Email");
        }
        return isEmailValid;
    }

}
