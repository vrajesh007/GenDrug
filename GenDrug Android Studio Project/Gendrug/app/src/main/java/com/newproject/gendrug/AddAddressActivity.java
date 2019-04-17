package com.newproject.gendrug;

import android.app.Dialog;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddAddressActivity extends AppCompatActivity {

    Button btnAddressAddAddress;
    TextInputEditText CustomerAddName, CustomerAddMobile, CustomerAddPincode, CustomerAddCity, CustomerAddState, CustomerAddArea, CustomerAddAddress;
    Dialog payMethod, Success;

    String productArray;
    UserSessionManager userSessionManager;
    String TotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        getSupportActionBar().setTitle("Shipping Address Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userSessionManager = new UserSessionManager(this);

        Intent i = getIntent();
        productArray = i.getStringExtra(JsonField.DETAILS_ARRAY);
        TotalAmount = i.getStringExtra(JsonField.TOTAL_AMOUNT);
        Log.d("Product Array", productArray);
        Log.d("Total Amount", TotalAmount);


        btnAddressAddAddress = findViewById(R.id.btn_address_add_address);

        CustomerAddName = findViewById(R.id.et_name);
        CustomerAddMobile = findViewById(R.id.et_mobile);
        CustomerAddPincode = findViewById(R.id.et_pincode);
        CustomerAddCity = findViewById(R.id.et_city);
        CustomerAddState = findViewById(R.id.et_state);
        CustomerAddArea = findViewById(R.id.et_area);
        CustomerAddAddress = findViewById(R.id.et_address);

        btnAddressAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkName() && checkMobile() && checkAddress() && checkProductArray() && checkTotalAmount()) {
                    PlaceOrder();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void PlaceOrder() {
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.NEW_ORDER_INSERT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseOrderJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = "";
                Log.d("ERROR", error.toString());
                if (error instanceof TimeoutError) {
                    message = "Connection timeout";
                } else if (error instanceof NoConnectionError) {
                    message = "No internet connection";
                } else if (error instanceof NetworkError) {
                    message = "No internet connection";
                } else if (error instanceof ServerError) {
                    message = "Server problem";
                }
                Toast.makeText(AddAddressActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.USER_ID, userSessionManager.getUserID());
                params.put(JsonField.TOTAL_AMOUNT, TotalAmount);
                params.put(JsonField.ORDER_DETAILS, productArray);
                params.put(JsonField.SHPPPING_NAME, CustomerAddName.getText().toString().trim());
                params.put(JsonField.SHIPPING_MOBILE, CustomerAddMobile.getText().toString().trim());
                params.put(JsonField.SHIPPING_ADDRESS, CustomerAddAddress.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void parseOrderJson(String response) {
        Log.d("INSERT_RESPONSE", response);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            String strMessage = jsonObject.optString(JsonField.MESSAGE);
            if (flag == 1) {
                btnAddressAddAddress.setEnabled(false);
                showOrderPlaceDialog(strMessage);
            } else {
                btnAddressAddAddress.setEnabled(true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showOrderPlaceDialog(String strMessage) {
        final Dialog orderDialog = new Dialog(this);
        orderDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        orderDialog.setCanceledOnTouchOutside(false);
        orderDialog.setCancelable(false);
        orderDialog.setContentView(R.layout.order_placed_succesfully_pop_up);
        orderDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        orderDialog.getWindow().getDecorView().setBackground(new ColorDrawable(Color.TRANSPARENT));
        Button btnContinue = orderDialog.findViewById(R.id.btn_place_dialog_continue);
        btnContinue.setEnabled(true);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderDialog.dismiss();
                TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(AddAddressActivity.this);
                taskStackBuilder.addParentStack(Navigationactivity.class);
                Intent intent = new Intent(AddAddressActivity.this, OrderActivity.class);
                taskStackBuilder.addNextIntentWithParentStack(intent);
                taskStackBuilder.startActivities();
            }
        });
        orderDialog.show();
    }

    private boolean checkTotalAmount() {
        boolean isTotalAmountValid = false;
        if (TotalAmount != null && !TotalAmount.isEmpty() && !TotalAmount.equals("")) {
            isTotalAmountValid = true;
        } else {
            Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            isTotalAmountValid = false;
        }
        return isTotalAmountValid;
    }


    private boolean checkProductArray() {
        boolean isProductArrayValid = false;
        if (productArray != null && !productArray.isEmpty() && !productArray.equals("")) {
            isProductArrayValid = true;
        } else {
            Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            isProductArrayValid = false;
        }
        return isProductArrayValid;
    }

    private boolean checkAddress() {
        boolean isAddressValid = false;
        if (CustomerAddAddress.getText().toString().trim().length() > 0) {
            isAddressValid = true;
        } else {
            CustomerAddAddress.setError("Enter Address");
        }
        return isAddressValid;
    }

    private boolean checkMobile() {
        boolean isMobileNumberValid = false;
        if (CustomerAddMobile.getText().toString().trim().length() < 0) {
            CustomerAddMobile.setError("Enter Number");
        } else if (CustomerAddMobile.getText().toString().trim().length() == 10) {
            isMobileNumberValid = true;
        } else {
            CustomerAddMobile.setError("Enter Correct Number");
        }
        return isMobileNumberValid;
    }

    private boolean checkName() {
        boolean isValid = false;
        if (CustomerAddName.getText().toString().trim().length() > 0) {
            isValid = true;
        } else {
            CustomerAddName.setError("Enter Name");
        }
        return isValid;
    }
}
