package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import com.bumptech.glide.Glide;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class productDetailActivity extends AppCompatActivity {
    TextView tvproductname, tvproductdetails, tvproductcategory, tvproductprice, tvproductstock;
    ImageView ivmedimage;

    Button btnAddtoCart;

    EditText etQty;

    String pp;

    String productid,productname,productdetails,productcategory,productprice,productstock,productphoto;

    UserSessionManager userSessionManager;

    String ProductID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().setTitle("Product Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        userSessionManager =new UserSessionManager(this);

        tvproductname = findViewById(R.id.tvproductname);
        tvproductdetails = findViewById(R.id.tvproductdetails);
        tvproductcategory = findViewById(R.id.tvproductcategory);
        tvproductprice = findViewById(R.id.tvproductprice);
        tvproductstock = findViewById(R.id.tvproductstock);
        ivmedimage = findViewById(R.id.ivmedimage);
        etQty = findViewById(R.id.etQty);
        btnAddtoCart = findViewById(R.id.btnAddtoCart);



        Intent intent = getIntent();
        ProductID = intent.getStringExtra(JsonField.PRODUCT_ID);
        getProductDetailsFromCart();

        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkProductID() && checkProductName() && checkProductPrice() && checkproductImage() && checkProductDescription() && checkProductQuantity()) {
                    if (btnAddtoCart.getTag().equals("INSERT")) {
                        AddProductToCart();
                        Log.d("Inside Insert Cart", "Yes");
                    } else {
                        updateCartProduct();
                        Log.d("Inside Update Cart", "Yes");
                    }
                }
            }
        });

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseResponse(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.PRODUCT_ID, ProductID);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(productDetailActivity.this);
        requestQueue.add(stringRequest);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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


    private void parseResponse(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag == 1) {
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.PRODUCT_ARRAY);
                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject objproduct = jsonArray.optJSONObject(i);
                        productid = objproduct.getString(JsonField.PRODUCT_ID);
                        productname = objproduct.getString(JsonField.PRODUCT_NAME);
                        productdetails = objproduct.getString(JsonField.PRODUCT_DETAILS);
                        productcategory = objproduct.getString(JsonField.PRODUCT_CATEGORY);
                        productprice = objproduct.getString(JsonField.PRODUCT_PRICE);
                        productstock = objproduct.getString(JsonField.PRODUCT_STOCK);
                        productphoto = objproduct.getString(JsonField.PRODUCT_PHOTO);

                        tvproductname.setText(productname);
                        tvproductdetails.setText(productdetails);
                        tvproductcategory.setText(productcategory);
                        //tvproductprice.setText("Rs "+ productprice);

                        String Price = productprice;
                        double productPrice = Double.parseDouble(Price);
                        DecimalFormat df1 = new DecimalFormat("0.00");
                        df1.setMaximumFractionDigits(2);
                        pp = (df1.format(productPrice));
                        tvproductprice.setText("₹" + pp);
                        tvproductstock.setText(productstock + " left in stock!");
                        Glide.with(productDetailActivity.this).load(WebURL.PRODUCT_IMAGE_URL + productphoto).into(ivmedimage);

                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private boolean checkProductQuantity() {
        boolean isProductQuantityValid = false;
        if (etQty.getText().toString().trim().length() > 0) {
            isProductQuantityValid = true;
        } else {
            etQty.setError("Enter Quantity");
        }
        return isProductQuantityValid;
    }

    private boolean checkProductDescription() {
        boolean isProductDescriptionValid = false;
        if (productphoto != null && !productphoto.isEmpty() && !productphoto.equals("")) {
            isProductDescriptionValid = true;
        } else {
            isProductDescriptionValid = false;
            Toast.makeText(this, "Product Description Not received!", Toast.LENGTH_SHORT).show();
        }
        return isProductDescriptionValid;
    }

    private boolean checkproductImage() {
        boolean isProductImageValid = false;
        if (productphoto != null && !productphoto.isEmpty() && !productphoto.equals("")) {
            isProductImageValid = true;
        } else {
            isProductImageValid = false;
            Toast.makeText(this, "Product Image Not received!", Toast.LENGTH_SHORT).show();
        }
        return isProductImageValid;
    }

    private boolean checkProductPrice() {
        boolean isProductPriceValid = false;
        if (productprice != null && !productprice.isEmpty() && !productprice.equals("")) {
            isProductPriceValid = true;
        } else {
            isProductPriceValid = false;
            Toast.makeText(this, "Product Price Not received!", Toast.LENGTH_SHORT).show();
        }
        return isProductPriceValid;
    }

    private boolean checkProductName() {
        boolean isProductNameValid = false;
        if (productname != null && !productname.isEmpty() && !productname.equals("")) {
            isProductNameValid = true;
        } else {
            isProductNameValid = false;
            Toast.makeText(this, "Product Name Not received!", Toast.LENGTH_SHORT).show();
        }
        return isProductNameValid;

    }

    private boolean checkProductID() {
        boolean isProductIDalid = false;
        if (productid != null && !productid.isEmpty() && !productid.equals("")) {
            isProductIDalid = true;
        } else {
            isProductIDalid = false;
            Toast.makeText(this, "Product ID Not received!", Toast.LENGTH_SHORT).show();
        }
        return isProductIDalid;
    }


    private void AddProductToCart() {
        String productQty = etQty.getText().toString().trim();

        if (productprice != null && !productprice.isEmpty() && !productprice.equals("") && productQty != null && !productQty.isEmpty() && !productQty.equals("")) {
            double price = Double.parseDouble(productprice);
            DecimalFormat df1 = new DecimalFormat("0.00");
            df1.setMaximumFractionDigits(2);
            String productPrice = (df1.format(price));
            Log.d("Product Price", productPrice);


            double amount = Double.parseDouble(productprice) * Double.parseDouble(productQty);
            DecimalFormat df2 = new DecimalFormat("0.00");
            df1.setMaximumFractionDigits(2);
            String productAmount = (df2.format(amount));
            Log.d("Product Amount", productAmount);

            String UserID = userSessionManager.getUserID();

            AddToCart(UserID,productid,productname,productdetails,productphoto,productAmount,productPrice,productQty);

        } else {
            Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
        }
    }


    private void AddToCart(final String userID, final String productID, final String productName, final String productDescription, final String productImage, final String productAmount, final String productPrice, final String productQty) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.ADD_TO_CART_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseAddToCartResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());

                if (error instanceof ServerError) {
                } else if (error instanceof NoConnectionError) {
                } else if (error instanceof TimeoutError) {
                } else if (error instanceof NetworkError) {
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.USER_ID,userID);
                params.put(JsonField.CART_PRODUCT_ID, productID);
                params.put(JsonField.CART_PRODUCT_NAME, productName);
                params.put(JsonField.CART_PRODUCT_DESCREPTION, productDescription);
                params.put(JsonField.CART_PRODUCT_IMAGE, productImage);
                params.put(JsonField.CART_PRODUCT_AMOUNT, productAmount);
                params.put(JsonField.CART_PRODUCT_UNIT_PRICE, productPrice);
                params.put(JsonField.CART_PRODUCT_QTY, productQty);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void parseAddToCartResponse(String response) {
        Log.d("TAG", "parseSubCategoryResponse: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                String Message = jsonObject.optString(JsonField.MESSAGE);
                if (flag == 1) {
                    Intent i = new Intent(productDetailActivity.this, CartActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                } else if (flag == 1 && Message.equals("Please Try Again Something Went Wrong")) {
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }



    private void updateCartProduct() {
        String productQty = etQty.getText().toString().trim();
        if (productprice != null && !productprice.isEmpty() && !productprice.equals("") && productQty != null && !productQty.isEmpty() && !productQty.equals("")) {
            double price = Double.parseDouble(productprice);
            DecimalFormat df1 = new DecimalFormat("0.00");
            df1.setMaximumFractionDigits(2);
            String productPrice = (df1.format(price));
            Log.d("Product Price", productPrice);

            double amount = Double.parseDouble(productprice) * Double.parseDouble(productQty);
            DecimalFormat df2 = new DecimalFormat("0.00");
            df1.setMaximumFractionDigits(2);
            String productAmount = (df2.format(amount));
            Log.d("Product Amount", productAmount);

            String UserID = userSessionManager.getUserID();

            updateCart(UserID,productid,productAmount,productPrice,productQty);


        } else {
            Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateCart(final String userID, final String productID, final String productAmount, final String productPrice, final String productQty) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.UPDATE_CART_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseUpdateCartResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());

                if (error instanceof ServerError) {
                } else if (error instanceof NoConnectionError) {
                } else if (error instanceof TimeoutError) {
                } else if (error instanceof NetworkError) {
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.USER_ID,userID);
                params.put(JsonField.CART_PRODUCT_ID, productID);
                params.put(JsonField.CART_PRODUCT_AMOUNT, productAmount);
                params.put(JsonField.CART_PRODUCT_UNIT_PRICE, productPrice);
                params.put(JsonField.CART_PRODUCT_QTY, productQty);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void parseUpdateCartResponse(String response) {
        Log.d("TAG", "parseSubCategoryResponse: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                String Message = jsonObject.optString(JsonField.MESSAGE);
                if (flag == 1) {
                    Intent i = new Intent(productDetailActivity.this, CartActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                } else if (flag == 1 && Message.equals("Please Try Again Something Went Wrong")) {
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }


    private void getProductDetailsFromCart() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.CART_PRODUCT_DETAIL_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseDetailsResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());

                if (error instanceof ServerError) {
                } else if (error instanceof NoConnectionError) {
                } else if (error instanceof TimeoutError) {
                } else if (error instanceof NetworkError) {
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.USER_ID, userSessionManager.getUserID());
                params.put(JsonField.CART_PRODUCT_ID, ProductID);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void parseDetailsResponse(String response) {
        Log.d("TAG", "parseSubCategoryResponse: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                String Message = jsonObject.optString(JsonField.MESSAGE);
                if (flag == 1) {
                    JSONArray arrProduct = jsonObject.optJSONArray(JsonField.CART_PRODUCT_ARRAY);
                    if (arrProduct.length() > 0) {
                        for (int i = 0; i < arrProduct.length(); i++) {
                            JSONObject productObject = arrProduct.optJSONObject(i);
                            String product_quantity = productObject.optString(JsonField.CART_PRODUCT_QTY);

                            etQty.setText(product_quantity);
                            Log.d("Value of Quantity", product_quantity);
                            btnAddtoCart.setTag("UPDATE");
                            btnAddtoCart.setText("UPDATE");
                            btnAddtoCart.setVisibility(View.VISIBLE);
                        }
                    }
                } else if (flag == 0 && Message.equals("No Record Found.")) {
                    etQty.setText("");
                    btnAddtoCart.setText("ADD");
                    btnAddtoCart.setTag("INSERT");
                } else {
                    etQty.setText("");
                    btnAddtoCart.setText("ADD");
                    btnAddtoCart.setVisibility(View.GONE);
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }



}
