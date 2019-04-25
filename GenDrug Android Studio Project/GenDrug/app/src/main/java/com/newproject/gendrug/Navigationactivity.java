package com.newproject.gendrug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

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

public class Navigationactivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener, productsbycategory {
    UserSessionManager userSessionManager;
    ViewFlipper viewFlipper;
EditText etSearch;
    RecyclerView rvcategory;
    ArrayList<category> listCategory;
    category cat1;
    categoryAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userSessionManager=new UserSessionManager(Navigationactivity.this);
etSearch=findViewById(R.id.etSearch);

        viewFlipper =(ViewFlipper)findViewById(R.id.vf1);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (userSessionManager.getLoginStatus()) {
            Toast.makeText(this, "Welcome to GenDrug!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Navigationactivity.this, login.class);
            startActivity(intent);
        }

        //Categories


        rvcategory= (RecyclerView) findViewById(R.id.rvcategory);
        LinearLayoutManager linearLayout=new LinearLayoutManager(Navigationactivity.this);
        rvcategory.setLayoutManager(linearLayout);

        getcategory();

        
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
                filterCategory(editable.toString());
            }
        });

    }

    private void filterCategory(String toString) {
        //new array list that will hold the filtered data
        ArrayList<category> filterdCategory = new ArrayList<>();
        //looping through existing elements
        for (category modelCategory : listCategory) {
            //if the existing elements contains the search input
            if (modelCategory.getCateg_name().toLowerCase().contains(toString.toLowerCase())) {
                //adding the element to filtered list
                filterdCategory.add(modelCategory);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        catAdapter.filterList(filterdCategory);
        if (filterdCategory.size() > 0) {
            //Search Matched the item
        } else {
            //No Item in Search Query
        }

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
        RequestQueue requestQueue = Volley.newRequestQueue(Navigationactivity.this);
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

                         cat1 = new category();
                        cat1.setCateg_id(categoryid);
                        cat1.setCateg_name(categoryname);
                        listCategory.add(cat1);
                    }

                }
                catAdapter = new categoryAdapter(Navigationactivity.this,listCategory);
                catAdapter.setproductsbycategory(Navigationactivity.this);
                rvcategory.setAdapter(catAdapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setoncategoryclicked(ArrayList<category> listCategory, int i) {
        Intent intent= new Intent(Navigationactivity.this,productlist.class);
        category Category = listCategory.get(i);
        String id=Category.getCateg_id();
        intent.putExtra(JsonField.CATEGORY_ID,id);

        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigationactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(Navigationactivity.this, changepassword.class);
            startActivity(intent);

            return true;
        }

         if (id== R.id.action_logout){
             userSessionManager.logout();
             Intent intent = new Intent(Navigationactivity.this, login.class);
             startActivity(intent);

             return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        }   else if (id == R.id.nav_category) {
                Intent intent= new Intent(Navigationactivity.this,categorylist.class);
                startActivity(intent);

        } else if (id == R.id.nav_symptom) {
            Intent intent= new Intent(Navigationactivity.this,symptomlist.class);
            startActivity(intent);


        }else if (id == R.id.nav_upprescription) {
            Intent intent= new Intent(Navigationactivity.this,uploadprescription.class);
            startActivity(intent);


        }
        else if (id == R.id.nav_prescription) {
            Intent intent= new Intent(Navigationactivity.this,prescription.class);
            startActivity(intent);

        } else if (id == R.id.nav_cart) {
            Intent intent = new Intent(Navigationactivity.this, CartActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_account) {
            Intent intent = new Intent(Navigationactivity.this, youraccount.class);
            startActivity(intent);


        }else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(Navigationactivity.this, feedback.class);
            startActivity(intent);


        }else if (id == R.id.nav_about) {
            Intent intent= new Intent(Navigationactivity.this,aboutus.class);
            startActivity(intent);

        }

        // logout.set

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
