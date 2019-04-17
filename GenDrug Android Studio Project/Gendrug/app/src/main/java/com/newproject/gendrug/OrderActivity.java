package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.newproject.gendrug.Adapter.MyOrderAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Model.MyOrder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    RecyclerView rvOrder;
    private ArrayList<MyOrder> listOrder = new ArrayList<>();
    private MyOrderAdapter orderAdapter;
    UserSessionManager userSessionManager;

    LinearLayout llOrders,llNoInternetConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setTitle("My Orders");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userSessionManager = new UserSessionManager(this);

        llOrders = findViewById(R.id.ll_order_list);
        llNoInternetConnection = findViewById(R.id.ll_no_internet);

        rvOrder = findViewById(R.id.rv_order);
        orderAdapter = new MyOrderAdapter(listOrder);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvOrder.setLayoutManager(mLayoutManager);
        rvOrder.setItemAnimator(new DefaultItemAnimator());
        rvOrder.setAdapter(orderAdapter);

        getOrder();
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


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(OrderActivity.this,Navigationactivity.class);
        startActivity(i);
        finish();
    }

    private void getOrder() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.ORDER_LISTING_URL+userSessionManager.getUserID(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());

                if (error instanceof ServerError) {
                    llOrders.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);
                } else if (error instanceof NoConnectionError) {
                    llOrders.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);

                } else if (error instanceof TimeoutError) {
                    llOrders.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);

                } else if (error instanceof NetworkError) {
                    llOrders.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);

                }
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


    private void parseResponse(String response) {
        Log.d("TAG", "parseSubCategoryResponse: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                if (flag == 1) {
                    JSONArray arrOrder = jsonObject.optJSONArray(JsonField.ORDER_DETAILS_ARRAY);
                    if (arrOrder.length() > 0) {
                        for (int i = 0; i < arrOrder.length(); i++) {
                            JSONObject orderObject = arrOrder.optJSONObject(i);
                            String order_id = orderObject.optString(JsonField.MY_ORDER_ID);
                            String order_date = orderObject.optString(JsonField.MY_ORDER_DATE);
                            String order_amount = orderObject.optString(JsonField.TOTAL_AMOUNT);

                            MyOrder order = new MyOrder();
                            order.setOrderID(order_id);
                            order.setDate(order_date);
                            order.setTotalAmount(order_amount);
                            listOrder.add(order);
                        }
                        orderAdapter.notifyDataSetChanged();
                        llOrders.setVisibility(View.VISIBLE);
                        llNoInternetConnection.setVisibility(View.GONE);
                    } else {
                        llOrders.setVisibility(View.GONE);
                        llNoInternetConnection.setVisibility(View.GONE);
                    }
                } else {
                    String Message = jsonObject.optString(JsonField.MESSAGE);
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                    llOrders.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.GONE);
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }
}
