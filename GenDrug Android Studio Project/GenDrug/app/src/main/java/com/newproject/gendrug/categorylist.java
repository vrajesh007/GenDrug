package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

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
import com.newproject.gendrug.Adapter.categoryAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Listener.productsbycategory;
import com.newproject.gendrug.Model.category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class categorylist extends AppCompatActivity implements productsbycategory {
    RecyclerView rvcategory;
    ArrayList<category> listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorylist);

        rvcategory = (RecyclerView) findViewById(R.id.rvcategory);
        LinearLayoutManager linearLayout = new LinearLayoutManager(categorylist.this);
        rvcategory.setLayoutManager(linearLayout);

        getcategory();
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



    private void getcategory() {
        listCategory = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.CATEGORY_URL, new Response.Listener<String>() {
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
        RequestQueue requestQueue = Volley.newRequestQueue(categorylist.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String response) {
        Log.d("R",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag == 1){
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.CATEGORY_ARRAY);
                if (jsonArray.length() > 0){
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject objcategory = jsonArray.optJSONObject(i);
                        String categoryid  = objcategory.getString(JsonField.CATEGORY_ID);
                        String categoryname  = objcategory.getString(JsonField.CATEGORY_NAME);

                        category cat1 = new category();
                        cat1.setCateg_id(categoryid);
                        cat1.setCateg_name(categoryname);
                        listCategory.add(cat1);
                    }

                }
                categoryAdapter catAdapter = new categoryAdapter(categorylist.this,listCategory);
                catAdapter.setproductsbycategory(categorylist.this);
                rvcategory.setAdapter(catAdapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setoncategoryclicked(ArrayList<category> listCategory, int i) {
        Intent intent= new Intent(categorylist.this,productlist.class);
        category Category = listCategory.get(i);
        String id=Category.getCateg_id();
        intent.putExtra(JsonField.CATEGORY_ID,id);

        startActivity(intent);
    }
}
