package com.newproject.gendrug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.newproject.gendrug.Adapter.orderAdapter;
import com.newproject.gendrug.Adapter.prescriptionAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Model.order;
import com.newproject.gendrug.Model.prescribedmed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class orderdetails extends AppCompatActivity {
    ArrayList<order> orders;
    RecyclerView rvorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);

        rvorder=(RecyclerView) findViewById(R.id.rvorder);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(orderdetails.this);
        rvorder.setLayoutManager(linearLayoutManager);

        getorderdetails();
    }

    private void getorderdetails() {
        orders = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.ORDER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseJson(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(orderdetails.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String response) {
        Log.d("R",response);
        try {

            JSONObject jsonObject = new JSONObject(response);
            int flag=jsonObject.optInt(JsonField.FLAG);
            if(flag==1){
                JSONArray jsonArray= jsonObject.optJSONArray(JsonField.ORDER_ARRAY);
                if(jsonArray.length()>0){
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject objord = jsonArray.optJSONObject(i);
                        String orderid = objord.getString(JsonField.ORDER_ID);
                        String orderproducts = objord.getString(JsonField.ORDER_PRODUCTS);
                        String orderquantity = objord.getString(JsonField.ORDER_QUANTITY);
                        String orderamount = objord.getString(JsonField.ORDER_AMOUNT);
                        String orderdate = objord.getString(JsonField.ORDER_DATE);

                        order order1=new order();
                        order1.setOrder_id(orderid);
                        order1.setOrder_products(orderproducts);
                        order1.setOrder_quantity(orderquantity);
                        order1.setOrder_amount(orderamount);
                        order1.setOrder_date(orderdate);
                        orders.add(order1);
                    }
                    orderAdapter ordAdapter= new orderAdapter(orderdetails.this,orders);
                    rvorder.setAdapter(ordAdapter);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
