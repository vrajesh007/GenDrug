package com.newproject.gendrug;

import android.app.Dialog;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
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
import com.newproject.gendrug.Adapter.CartAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Model.Cart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;
    private ArrayList<Cart> listCart = new ArrayList<>();
    private CartAdapter cartAdapter;
    TextView tv_cart_amount;
    TextView tvCheckout;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    LinearLayout ll_amount;

    LinearLayout llCart;
    LinearLayout llNoInternet;
    LinearLayout llEmptyCart;
    TextView tvErrorTitle;
    Button btnStartShopping;
    JSONObject jsonProduct;

    UserSessionManager userSessionManager;

    String totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().setTitle("My Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        userSessionManager = new UserSessionManager(this);



        tv_cart_amount = findViewById(R.id.tv_cart_amount);
        tvCheckout = findViewById(R.id.tvCheckout);

        llCart = findViewById(R.id.ll_cart);
        llNoInternet = findViewById(R.id.ll_no_internet);
        llEmptyCart = findViewById(R.id.ll_no_items_in_cart);
        tvErrorTitle = findViewById(R.id.tvErrorTitle);
        btnStartShopping = findViewById(R.id.btnStartShopping);

        rvCart = findViewById(R.id.rv_cart_product);
        cartAdapter = new CartAdapter(listCart);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvCart.setLayoutManager(mLayoutManager);
        rvCart.setItemAnimator(new DefaultItemAnimator());
        rvCart.setAdapter(cartAdapter);

        ll_amount = findViewById(R.id.ll_amount);

        btnStartShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this,Navigationactivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        tvCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAmount()) {
                    generateJSON();
                }
            }
        });

        getCartRVData();
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
    private String CalculateTotalAmount() {
        String AmountTotal = null;
        double sum = 0;
        if (listCart != null && listCart.size() != 0) {
            for (int i = 0; i < listCart.size(); i++) {
                sum = sum + Double.parseDouble(listCart.get(i).getProductAmount());
                AmountTotal = String.valueOf(sum);
            }
        }
        return AmountTotal;
    }


    private boolean checkAmount() {
        boolean isAmountValid = false;
        if (ll_amount.getVisibility() == View.VISIBLE) {
            isAmountValid = true;
        } else {
            Toast.makeText(this, "Please Add Items in Cart and Try Again!", Toast.LENGTH_SHORT).show();
            isAmountValid = false;
        }
        return isAmountValid;
    }


    private void getCartRVData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.VIEW_CART_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseUpdateCartResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());

                if (error instanceof ServerError) {

                } else if (error instanceof NoConnectionError) {

                } else if (error instanceof TimeoutError) {

                } else if (error instanceof NetworkError) {

                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.USER_ID,userSessionManager.getUserID());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void parseUpdateCartResponse(String response) {
        Log.d("TAG", "parseSubCategoryResponse: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                String Message = jsonObject.optString(JsonField.MESSAGE);
                if (flag == 1) {
                    JSONArray arrProduct = jsonObject.optJSONArray(JsonField.CART_ARRAY);
                    if (arrProduct.length() > 0) {
                        for (int i = 0; i < arrProduct.length(); i++) {
                            JSONObject productObject = arrProduct.optJSONObject(i);
                            String cart_id = productObject.optString(JsonField.CART_ID);
                            String product_id = productObject.optString(JsonField.CART_PRODUCT_ID);
                            String product_name = productObject.optString(JsonField.CART_PRODUCT_NAME);
                            String product_image = productObject.optString(JsonField.CART_PRODUCT_IMAGE);
                            String product_quantity = productObject.optString(JsonField.CART_PRODUCT_QTY);
                            String product_details = productObject.optString(JsonField.CART_PRODUCT_DESCREPTION);
                            String product_amount = productObject.optString(JsonField.CART_PRODUCT_AMOUNT);
                            String product_price = productObject.optString(JsonField.CART_PRODUCT_UNIT_PRICE);

                            Cart cart = new Cart();
                            cart.setCartID(cart_id);
                            cart.setProductID(product_id);
                            cart.setProductName(product_name);
                            cart.setProductImage(product_image);
                            cart.setProductQty(product_quantity);
                            cart.setProductDescription(product_details);
                            cart.setProductUnitPrice(product_price);
                            cart.setProductAmount(product_amount);
                            listCart.add(cart);
                        }
                        cartAdapter.notifyDataSetChanged();

                        String TotalAmount = CalculateTotalAmount();

                        if (TotalAmount != null && !TotalAmount.isEmpty() && !TotalAmount.equals("")) {
                            String Total = TotalAmount;
                            double total = Double.parseDouble(Total);
                            DecimalFormat df1 = new DecimalFormat("0.00");
                            df1.setMaximumFractionDigits(2);
                            totalAmount = (df1.format(total));
                            Log.d("Total Amount", totalAmount);
                            tv_cart_amount.setText("₹" + totalAmount);
                            ll_amount.setVisibility(View.VISIBLE);
                            llCart.setVisibility(View.VISIBLE);
                            llEmptyCart.setVisibility(View.GONE);
                            llNoInternet.setVisibility(View.GONE);
                            tvCheckout.setBackgroundColor(Color.parseColor("#FA3B2A"));
                        } else {
                            ll_amount.setVisibility(View.GONE);
                            llCart.setVisibility(View.GONE);
                            llEmptyCart.setVisibility(View.VISIBLE);
                            llNoInternet.setVisibility(View.GONE);
                            tvCheckout.setBackgroundColor(Color.parseColor("#FA3B2A"));
                        }

                    }else
                    {
                        llCart.setVisibility(View.VISIBLE);
                        llEmptyCart.setVisibility(View.GONE);
                        llNoInternet.setVisibility(View.GONE);

                    }
                }  else if (flag == 0 && Message.equals("No Record Found.")) {
                    //Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                    llCart.setVisibility(View.GONE);
                    llEmptyCart.setVisibility(View.VISIBLE);
                    llNoInternet.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                    llCart.setVisibility(View.GONE);
                    llEmptyCart.setVisibility(View.GONE);
                    llNoInternet.setVisibility(View.GONE);
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }


    public void generateJSON() {
        jsonProduct = new JSONObject();
        if (listCart.size() > 0) {
            JSONArray jsonArray = new JSONArray();
            try {
                for (int i = 0; i < listCart.size(); i++) {
                    Cart cart = listCart.get(i);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put(JsonField.PRODUCT_ID, cart.getProductID());
                    jsonObject.put(JsonField.PRICE, cart.getProductUnitPrice());
                    jsonObject.put(JsonField.QTY, cart.getProductQty());
                    jsonArray.put(jsonObject);
                }
                jsonProduct.put(JsonField.DETAILS_ARRAY, jsonArray);
                Log.d("JSON", jsonProduct.toString());

                //PlaceOrder();
                Intent intent = new Intent(CartActivity.this, AddAddressActivity.class);
                intent.putExtra(JsonField.DETAILS_ARRAY,jsonProduct.toString());
                intent.putExtra(JsonField.TOTAL_AMOUNT,totalAmount);
                startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
