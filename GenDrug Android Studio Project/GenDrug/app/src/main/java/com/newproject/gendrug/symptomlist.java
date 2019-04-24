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
import com.newproject.gendrug.Adapter.symptomAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Listener.productsbycategory;
import com.newproject.gendrug.Listener.productsbysymptom;
import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.Model.symptom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class symptomlist extends AppCompatActivity implements productsbysymptom {
    RecyclerView rvsymptom;
    ArrayList<symptom> listSymptom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptomlist);

        rvsymptom= (RecyclerView) findViewById(R.id.rvsymptom);
        LinearLayoutManager linearLayout=new LinearLayoutManager(symptomlist.this);
        rvsymptom.setLayoutManager(linearLayout);

        getsymptom();
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

    private void getsymptom() {
        listSymptom = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.SYMPTOM_URL, new Response.Listener<String>() {
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
        RequestQueue requestQueue = Volley.newRequestQueue(symptomlist.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String response) {
        Log.d("R",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag == 1){
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.SYMPTOM_ARRAY);
                if (jsonArray.length() > 0){
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject objsymptom = jsonArray.optJSONObject(i);
                        String symptomid  = objsymptom.getString(JsonField.SYMPTOM_ID);
                        String symptomname  = objsymptom.getString(JsonField.SYMPTOM_NAME);

                        symptom symp1 = new symptom();
                        symp1.setSymp_id(symptomid);
                        symp1.setSymp_name(symptomname);
                        listSymptom.add(symp1);
                    }

                }
                symptomAdapter symAdapter = new symptomAdapter(symptomlist.this,listSymptom);
                symAdapter.setproductsbysymptom(symptomlist.this);
                rvsymptom.setAdapter(symAdapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setonsymptomclicked(ArrayList<symptom> listSymptom, int i) {
        Intent intent= new Intent(symptomlist.this,productlist.class);
        symptom Symptom = listSymptom.get(i);
        String symid= Symptom.getSymp_id();
        intent.putExtra(JsonField.SYMPTOM_ID,symid);
        startActivity(intent);
    }
}
