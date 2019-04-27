package com.newproject.gendrug;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity implements View.OnClickListener {
    EditText username,phonenumber,email,password,confirmpassword,address;
    RadioButton male,female;
    TextView gender;
    EditText tvdate;
    Button submit;
    DatePickerDialog datePickerDialog;
    private String selectedGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username =(EditText) findViewById(R.id.etname);
        phonenumber =(EditText) findViewById(R.id.etnumber);
        email =(EditText) findViewById(R.id.etemail);
        password =(EditText) findViewById(R.id.etpassword);
        confirmpassword =(EditText) findViewById(R.id.etcpassword);
        address =(EditText) findViewById(R.id.etaddress);
        tvdate = (EditText) findViewById(R.id.tvdate);
        male =(RadioButton) findViewById(R.id.rbmale);
        female =(RadioButton) findViewById(R.id.rbfemale);
        submit =(Button) findViewById(R.id.bsubmit);
       submit.setOnClickListener(this);
       tvdate.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvdate:

                        final Calendar c = Calendar.getInstance();
                        int year= c.get(Calendar.YEAR);
                        int month =c.get(Calendar.MONTH);
                        int day=c.get(Calendar.DAY_OF_MONTH);
                        datePickerDialog=new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
                                tvdate.setText(dayofMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                        datePickerDialog.show();


                break;
            case R.id.bsubmit:

                if (checkUserName() && checkGender() && checkMobileNumber() && checkEmail() && checkPassword() && checkcPassword())
                {
                    selectedGender = female.isChecked()?"Female":"Male";
                    if(password.getText().toString().equals(confirmpassword.getText().toString()))
                    {
                        sendSignupRequest();
                        Toast.makeText(signup.this, "Registration done successfully", Toast.LENGTH_SHORT).show();
                        Intent  intent=new Intent(signup.this,login.class);
                        startActivity(intent);


                    }
                    else
                    {
                        Toast.makeText(this, "Password & confirm password does not match", Toast.LENGTH_SHORT).show();
                    }


                }

                break;

        }

    }

    private void sendSignupRequest() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebURL.KEY_SIGNUP_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseSignupResponse(response);
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
                params.put(JsonField.KEY_USER_NAME, username.getText().toString());
                params.put(JsonField.KEY_USER_EMAIL, email.getText().toString());
                params.put(JsonField.KEY_USER_GENDER, selectedGender);
                params.put(JsonField.KEY_USER_MOBILE_NUMBER, phonenumber.getText().toString());
                params.put(JsonField.KEY_USER_PASSWORD, password.getText().toString());
                params.put(JsonField.KEY_USER_DOB, tvdate.getText().toString());
                params.put(JsonField.KEY_USER_ADDRESS, address.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(signup.this);
        requestQueue.add(stringRequest);
    }

    private void parseSignupResponse(String response) {
        Log.d("RESPONSE",response);
    }


    private boolean checkUserName() {
        boolean isUserNameValid = false;
        if (username.getText().toString().trim().length() <= 0) {
            username.setError("Enter Name");
        } else {
            isUserNameValid = true;
        }
        return isUserNameValid;
    }
    private boolean checkMobileNumber() {
        boolean isMobileNumberValid = false;

        if (phonenumber.getText().toString().trim().length() <= 0) {
            phonenumber.setError("Enter Mobile Number");
        }

        else if (phonenumber.getText().toString().trim().length() == 10) {
            isMobileNumberValid = true;
        } else {
            phonenumber.setError("Enter Correct Mobile Number");
        }
        return isMobileNumberValid;
    }
    private boolean checkGender() {
        boolean isGenderValid;
        String selectedGender;
        isGenderValid = male.isChecked() || female.isChecked();
        if (male.isChecked()){
            selectedGender = "Male";
        }else {
            selectedGender = "Female";
        }
        if (isGenderValid == false) {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_LONG).show();
        }
        return isGenderValid;
    }
    public boolean checkEmail() {
        boolean isEmailValid = false;
        String emailid = email.getText().toString().trim();

        if (email.getText().toString().trim().length() < 0) {
            email.setError("Enter Email");
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            isEmailValid = true;
        } else {
            email.setError("Enter Correct Email");
        }
        return isEmailValid;
    }
    public boolean checkPassword() {
        boolean isPasswordValid = false;

        if (password.getText().toString().trim().length() <= 0) {
            password.setError("Enter Password");
        } else {
            isPasswordValid = true;
        }
        return isPasswordValid;
    }
    public boolean checkcPassword() {
        boolean isPasswordValid = false;

        if (confirmpassword.getText().toString().trim().length() <= 0) {
            confirmpassword.setError("Enter Confirm Password");
        } else {
            isPasswordValid = true;
        }
        return isPasswordValid;
    }

}

