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
import com.newproject.gendrug.Adapter.prescriptionAdapter;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Model.prescribedmed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class prescription extends AppCompatActivity {
    ArrayList<prescribedmed> prescriptions;
    RecyclerView rvprescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        rvprescription=(RecyclerView) findViewById(R.id.rvprescription);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(prescription.this);
        rvprescription.setLayoutManager(linearLayoutManager);

        getprescribedmed();
    }

    private void getprescribedmed() {
        prescriptions = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.PRESCRIPTION_URL, new Response.Listener<String>() {
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
        RequestQueue requestQueue = Volley.newRequestQueue(prescription.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String response) {
        Log.d("R",response);
        try {

            JSONObject  jsonObject = new JSONObject(response);
            int flag=jsonObject.optInt(JsonField.FLAG);
            if(flag==1){
                JSONArray jsonArray= jsonObject.optJSONArray(JsonField.PRESCRIPTION_ARRAY);
                if(jsonArray.length()>0){
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject objpres = jsonArray.optJSONObject(i);
                        String prescriptionid = objpres.getString(JsonField.PRESCRIPTION_ID);
                        String prescriptionbname = objpres.getString(JsonField.PRESCRIPTION_BNAME);
                        String prescriptiongname = objpres.getString(JsonField.PRESCRIPTION_GNAME);
                        String prescriptiondetails = objpres.getString(JsonField.PRESCRIPTION_DETAILS);
                        String prescriptionprice = objpres.getString(JsonField.PRESCRIPTION_PRICE);

                        prescribedmed pres1=new prescribedmed();
                        pres1.setPres_id(prescriptionid);
                        pres1.setPres_bname(prescriptionbname);
                        pres1.setPres_gname(prescriptiongname);
                        pres1.setPres_details(prescriptiondetails);
                        pres1.setPres_price(prescriptionprice);
                        prescriptions.add(pres1);
                    }
                    prescriptionAdapter presAdapter= new prescriptionAdapter(prescription.this,prescriptions);
                    rvprescription.setAdapter(presAdapter);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

