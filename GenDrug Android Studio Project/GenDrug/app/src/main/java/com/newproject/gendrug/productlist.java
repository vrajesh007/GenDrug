package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

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
import com.newproject.gendrug.Adapter.productadapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Listener.ProductDetailClickListener;
import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.Model.product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class productlist extends AppCompatActivity implements ProductDetailClickListener {
    ArrayList<product> products;
    RecyclerView rvproduct;
    private String id;
    private String symid;
    EditText etSearch;
    productadapter proadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);
        
        rvproduct=(RecyclerView) findViewById(R.id.rvproduct);
etSearch=findViewById(R.id.etSearch);
        Intent intent=getIntent();
        id=intent.getStringExtra(JsonField.CATEGORY_ID);


        symid=intent.getStringExtra(JsonField.SYMPTOM_ID);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(productlist.this);
        rvproduct.setLayoutManager(linearLayoutManager);
        
       // getCategid(id);
        getproduct(id);
        getproductbysymp(symid);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Search Logic
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filterProduct(editable.toString());
            }
        });

    }

    private void filterProduct(String toString) {

        //new array list that will hold the filtered data
        ArrayList<product> filterdCategory = new ArrayList<>();
        //looping through existing elements
        for (product modelCategory : products) {
            //if the existing elements contains the search input
            if (modelCategory.getP_name().toLowerCase().contains(toString.toLowerCase())) {
                //adding the element to filtered list
                filterdCategory.add(modelCategory);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        proadapter.filterList(filterdCategory);
        if (filterdCategory.size() > 0) {
            //Search Matched the item
        } else {
            //No Item in Search Query
        }

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


    private void getproductbysymp(final String symid) {
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
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(JsonField.SYMPTOM_ID, symid);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(productlist.this);
        requestQueue.add(stringRequest);
    }

//    private void getCategid(final String id) {
//     products= new ArrayList<>();
//     StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.PRODUCT_URL, new Response.Listener<String>() {
//         @Override
//         public void onResponse(String response) {
//             parseJson(response.toString());
//         }
//     }, new Response.ErrorListener() {
//         @Override
//         public void onErrorResponse(VolleyError error) {
//            error.printStackTrace();
//         }
//     }){
//
//         @Override
//         protected Map<String, String> getParams() throws AuthFailureError {
//             Map<String,String> map = new HashMap<>();
//             map.put(JsonField.CATEGORY_ID,id);
//             return map;
//         }
//     };
//
//    }

    private void getproduct(final String id) {
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
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(JsonField.CATEGORY_ID, id);
                return map;
            }
        };
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
                     proadapter= new productadapter(productlist.this,products);
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

