package com.newproject.gendrug;

import android.content.Intent;
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
import com.newproject.gendrug.Adapter.productadapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Listener.ProductDetailClickListener;
import com.newproject.gendrug.Model.product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class productlist extends AppCompatActivity implements ProductDetailClickListener {
    ArrayList<product> products;
    RecyclerView rvproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);
        
        rvproduct=(RecyclerView) findViewById(R.id.rvproduct);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(productlist.this);
        rvproduct.setLayoutManager(linearLayoutManager);
        
        getproduct();
    }

    private void getproduct() {
        products = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.PRODUCT_URL, new Response.Listener<String>() {
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
        RequestQueue requestQueue = Volley.newRequestQueue(productlist.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String response) {
        Log.d("R",response);
        try {

            JSONObject  jsonObject = new JSONObject(response);
            int flag=jsonObject.optInt(JsonField.FLAG);
            if(flag==1){
                JSONArray jsonArray= jsonObject.optJSONArray(JsonField.PRODUCT_ARRAY);
                if(jsonArray.length()>0){
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject objproduct = jsonArray.optJSONObject(i);
                        String productid = objproduct.getString(JsonField.PRODUCT_ID);
                        String productname = objproduct.getString(JsonField.PRODUCT_NAME);
                        String productdetails = objproduct.getString(JsonField.PRODUCT_DETAILS);
                        String productcategory = objproduct.getString(JsonField.PRODUCT_CATEGORY);
                        String productprice = objproduct.getString(JsonField.PRODUCT_PRICE);
                        String productstock = objproduct.getString(JsonField.PRODUCT_STOCK);
                        String productphoto = objproduct.getString(JsonField.PRODUCT_PHOTO);

                        product prod1=new product();
                        prod1.setP_id(productid);
                        prod1.setP_name(productname);
                        prod1.setP_details(productdetails);
                        prod1.setP_category(productcategory);
                        prod1.setP_price(productprice);
                        prod1.setP_stock(productstock);
                        prod1.setP_photo(productphoto);
                        products.add(prod1);
                    }
                    productadapter proadapter= new productadapter(productlist.this,products);
                    proadapter.setProductDetailClickListener(productlist.this);
                    rvproduct.setAdapter(proadapter);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setOnItemClicked(ArrayList<product> products, int i) {
        Intent intent= new Intent(productlist.this,productDetailActivity.class);
        product Product = products.get(i);
        String id=Product.getP_id();
        intent.putExtra(JsonField.PRODUCT_ID,id);
        startActivity(intent);

    }
}

