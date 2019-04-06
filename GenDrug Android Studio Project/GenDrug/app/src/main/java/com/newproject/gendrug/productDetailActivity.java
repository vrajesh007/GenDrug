package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class productDetailActivity extends AppCompatActivity {
    TextView tvproductname,tvproductdetails,tvproductcategory,tvproductprice,tvproductstock;
    ImageView ivmedimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        tvproductname=findViewById(R.id.tvproductname);
        tvproductdetails=findViewById(R.id.tvproductdetails);
        tvproductcategory=findViewById(R.id.tvproductcategory);
        tvproductprice=findViewById(R.id.tvproductprice);
        tvproductstock=findViewById(R.id.tvproductstock);
        ivmedimage=findViewById(R.id.ivmedimage);

        Intent intent= getIntent();
        final String id = intent.getStringExtra(JsonField.PRODUCT_ID);

        StringRequest stringRequest= new StringRequest(Request.Method.POST, WebURL.PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseResponse(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put(JsonField.PRODUCT_ID,id);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(productDetailActivity.this);
        requestQueue.add(stringRequest);

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



    private void parseResponse(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            int flag  =jsonObject.optInt(JsonField.FLAG);
            if(flag==1) {
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.PRODUCT_ARRAY);
                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject objproduct = jsonArray.optJSONObject(i);
                        String productid = objproduct.getString(JsonField.PRODUCT_ID);
                        String productname = objproduct.getString(JsonField.PRODUCT_NAME);
                        String productdetails = objproduct.getString(JsonField.PRODUCT_DETAILS);
                        String productcategory = objproduct.getString(JsonField.PRODUCT_CATEGORY);
                        String productprice = objproduct.getString(JsonField.PRODUCT_PRICE);
                        String productstock = objproduct.getString(JsonField.PRODUCT_STOCK);
                        String productphoto = objproduct.getString(JsonField.PRODUCT_PHOTO);

                        tvproductname.setText(productname);
                        tvproductdetails.setText(productdetails);
                        tvproductcategory.setText(productcategory);
                        tvproductprice.setText("Rs "+ productprice);
                        tvproductstock.setText(productstock + " left in stock!");
                        Glide.with(productDetailActivity.this).load(WebURL.PRODUCT_IMAGE_URL+productphoto).into(ivmedimage);

                    }
                }
            }

                    } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
