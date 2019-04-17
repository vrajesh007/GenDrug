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
import com.newproject.gendrug.Adapter.OrderDetailsAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Model.OrderDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {

    TextView tvOrderDetailsDate, tvOrderId, tvOrderDetailsTotalAmount;

    String OrderID, Date, TotalAmount;

    RecyclerView rvOrderDetails;
    private ArrayList<OrderDetails> listOrderDetails = new ArrayList<>();
    private OrderDetailsAdapter orderDetailsAdapter;

    UserSessionManager userSessionManager;

    LinearLayout llOrderDetails,llNoInternetConnection,llEmptyState;
    TextView tvEmptyStateMessage;
    TextView tvErrorTitle;
    Button btnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        getSupportActionBar().setTitle("Order Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userSessionManager = new UserSessionManager(this);

        Intent intent1 = getIntent();
        OrderID = intent1.getStringExtra("OrderID");

       /* Intent intent2 = getIntent();
        Date = intent2.getStringExtra("Date");

        Intent intent3 = getIntent();
        TotalAmount = intent3.getStringExtra("TotalAmount");*/


        llOrderDetails = findViewById(R.id.ll_order_details);
        llNoInternetConnection = findViewById(R.id.ll_no_internet);
        tvEmptyStateMessage = findViewById(R.id.tvEmptyStateMessage);
        tvErrorTitle = findViewById(R.id.tvErrorTitle);
        btnRetry = findViewById(R.id.btnRetry);

        tvOrderDetailsDate = findViewById(R.id.tv_order_details_date);
        tvOrderId = findViewById(R.id.tv_order_details_id);
        tvOrderDetailsTotalAmount = findViewById(R.id.tv_order_details_gross_amount);

        /*tvOrderDetailsDate.setText(Date);
        tvOrderId.setText(OrderID);
        tvOrderDetailsTotalAmount.setText(TotalAmount);
*/

        rvOrderDetails = findViewById(R.id.rv_order_details);
        orderDetailsAdapter = new OrderDetailsAdapter(listOrderDetails);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvOrderDetails.setLayoutManager(mLayoutManager);
        rvOrderDetails.setItemAnimator(new DefaultItemAnimator());
        //orderDetailsAdapter.setOnProductItemClickListener(ProductActivity.this);
        rvOrderDetails.setAdapter(orderDetailsAdapter);

        getOrderDetailsData();


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

    private void getOrderDetailsData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.ORDER_LISTING_URL+userSessionManager.getUserID()+"&&order_id="+OrderID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());

                if (error instanceof ServerError) {
                    tvErrorTitle.setText("Server Problem!");
                    llOrderDetails.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);
                } else if (error instanceof NoConnectionError) {

                    tvErrorTitle.setText("No Internet Connection!");
                    llOrderDetails.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);

                } else if (error instanceof TimeoutError) {
                    tvErrorTitle.setText("Timeout Error!");
                    llOrderDetails.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.VISIBLE);

                } else if (error instanceof NetworkError) {
                    tvErrorTitle.setText("Network Error!");
                    llOrderDetails.setVisibility(View.GONE);
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
                            String order_id = orderObject.optString(JsonField.ORDER_ID);
                            String order_date = orderObject.optString(JsonField.ORDER_DATE);
                            String order_amount = orderObject.optString(JsonField.TOTAL_AMOUNT);

                            tvOrderId.setText(order_id);
                            tvOrderDetailsDate.setText(order_date);


                            String Total = order_amount;
                            double total = Double.parseDouble(Total);
                            DecimalFormat df1 = new DecimalFormat("0.00");
                            df1.setMaximumFractionDigits(2);
                            String totalFinalAmount = (df1.format(total));

                            tvOrderDetailsTotalAmount.setText("₹"+totalFinalAmount);

                            JSONArray arrOrderDetails = orderObject.optJSONArray(JsonField.ORDER_DETAILS);
                            for(int j = 0; j<arrOrderDetails.length() ; j++)
                            {
                                JSONObject orderDetailsObject = arrOrderDetails.optJSONObject(j);
                                String product_id = orderDetailsObject.optString(JsonField.PRODUCT_ID);
                                String product_name = orderDetailsObject.optString(JsonField.PRODUCT_NAME);
                                String quantity = orderDetailsObject.optString(JsonField.QTY);
                                String price = orderDetailsObject.optString(JsonField.PRICE);

                                OrderDetails orderDetails = new OrderDetails();
                                orderDetails.setProductName(product_name);
                                orderDetails.setQuantity(quantity);


                                double Price = Double.parseDouble(price);
                                double Qty = Double.parseDouble(quantity);
                                double totalAmount = Price*Qty;
                                DecimalFormat df2 = new DecimalFormat("0.00");
                                df2.setMaximumFractionDigits(2);
                                String totalAmt = (df2.format(totalAmount));

                                String pPrice = (df2.format(Price));

                                orderDetails.setPrice(pPrice);
                                orderDetails.setAmount(totalAmt);
                                listOrderDetails.add(orderDetails);


                            }
                        }
                        orderDetailsAdapter.notifyDataSetChanged();
                        llOrderDetails.setVisibility(View.VISIBLE);
                        llNoInternetConnection.setVisibility(View.GONE);
                    } else {
                        llOrderDetails.setVisibility(View.GONE);
                        llNoInternetConnection.setVisibility(View.GONE);
                    }
                } else {
                    String Message = jsonObject.optString(JsonField.MESSAGE);
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                    llOrderDetails.setVisibility(View.GONE);
                    llNoInternetConnection.setVisibility(View.GONE);
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }
}
