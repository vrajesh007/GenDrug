package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.newproject.gendrug.CartActivity;
import com.newproject.gendrug.Model.Cart;
import com.newproject.gendrug.Model.product;
import com.newproject.gendrug.R;
import com.newproject.gendrug.productDetailActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<Cart> listCart;
    SQLiteDatabase sqLiteDatabase;

    CartAdapter.SetOnProductItemClickListener onProductItemClickListener;


    public CartAdapter.SetOnProductItemClickListener getOnProductItemClickListener() {
        return onProductItemClickListener;
    }

    public void setOnProductItemClickListener(CartAdapter.SetOnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }


    public CartAdapter(ArrayList<Cart> listCart) {
        this.listCart = listCart;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View mView = LayoutInflater.from(mContext).inflate(R.layout.cart_row_item_layout, parent, false);
        return new CartAdapter.ViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(final CartAdapter.ViewHolder holder, final int position) {
        final Cart cart = listCart.get(position);
        holder.tvProductName.setText(cart.getProductName());
        holder.tvProductPrice.setText("₹"+cart.getProductUnitPrice());
        holder.ll_qty.setVisibility(View.VISIBLE);
        holder.tvQty.setText("Quantity : "+cart.getProductQty());
        Glide.with(mContext).load(WebURL.PRODUCT_IMAGE_URL + cart.getProductImage()).error(R.drawable.noimage).into(holder.iVProductImage);

        holder.ll_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, productDetailActivity.class);
                i.putExtra(JsonField.PRODUCT_ID,cart.getProductID());
                i.putExtra("ProductName",cart.getProductName());
                i.putExtra("ProductPrice",cart.getProductUnitPrice());
                i.putExtra("ProductDescription",cart.getProductDescription());
                i.putExtra("ProductImage",cart.getProductImage());
                mContext.startActivity(i);
                ((CartActivity)mContext).finish();
            }
        });


        holder.ivRemoveProductFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CartID = cart.getCartID();
                deleteProductFromCart(CartID);
                Log.d("Cart ID",CartID);


            }
        });

    }

    private void deleteProductFromCart(final String cartID) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURL.REMOVE_FROM_CART_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseDeleteCartResponse(response);
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
                params.put(JsonField.CART_ID,cartID);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(stringRequest);
    }


    private void parseDeleteCartResponse(String response) {
        Log.d("TAG", "parseSubCategoryResponse: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                String Message = jsonObject.optString(JsonField.MESSAGE);
                if (flag == 1) {
                    Intent i = new Intent(mContext,CartActivity.class);
                    mContext.startActivity(i);
                    ((CartActivity)mContext).finish();
                    Toast.makeText(mContext, Message, Toast.LENGTH_SHORT).show();
                } else if (flag == 0 && Message.equals("Please Try Again Something Went Wrong")) {
                    Toast.makeText(mContext, Message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, Message, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listCart.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductPrice,tv_cart_item;
        CircleImageView iVProductImage;
        LinearLayout ll_product;
        LinearLayout ll_add_to_cart;
        LinearLayout ll_qty;
        TextView tvQty;
        ImageView ivRemoveProductFromCart;


        public ViewHolder(View itemView) {
            super(itemView);

            tvProductName = (TextView) itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = (TextView) itemView.findViewById(R.id.tv_product_discount_price);
            iVProductImage = (CircleImageView) itemView.findViewById(R.id.iv_product_image);

            ll_add_to_cart = (LinearLayout) itemView.findViewById(R.id.ll_add_to_cart);
            ll_qty = (LinearLayout) itemView.findViewById(R.id.ll_qty);
            tvQty = (TextView) itemView.findViewById(R.id.tvQty);
            ivRemoveProductFromCart = (ImageView) itemView.findViewById(R.id.ivRemoveProductFromCart);
        }
    }

    public interface SetOnProductItemClickListener {
        public void onProductItemClicked(product products, int position);
    }

}


