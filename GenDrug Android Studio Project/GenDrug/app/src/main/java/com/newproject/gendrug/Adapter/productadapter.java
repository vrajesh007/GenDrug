package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.newproject.gendrug.ApiHelper.WebURL;
import com.newproject.gendrug.Listener.ProductDetailClickListener;
import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.Model.product;
import com.newproject.gendrug.R;

import java.util.ArrayList;

public class productadapter extends RecyclerView.Adapter<productadapter.ViewHolder> {

    Context context;
    ArrayList<product> products;

    ProductDetailClickListener productDetailClickListener;
    public ProductDetailClickListener getProductDetailClickListener(){
        return productDetailClickListener;
    }

    public void setProductDetailClickListener(ProductDetailClickListener productDetailClickListener){
        this.productDetailClickListener = productDetailClickListener;
    }

    public productadapter(Context context, ArrayList<product> products) {
        this.context = context;
        this.products = products;

        Log.d("size",String.valueOf(products.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context =viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_productlist_recyclerview, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        product Product = products.get(i);
        String name=Product.getP_name();
        viewHolder.tvmedname.setText(name);
        Glide.with(context).load(WebURL.PRODUCT_IMAGE_URL+Product.getP_photo()).into(viewHolder.ivmedimage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductDetailClickListener listener = getProductDetailClickListener();
                listener.setOnItemClicked(products,i);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvmedname;
        ImageView ivmedimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvmedname= (TextView) itemView.findViewById(R.id.tvmedname);
            ivmedimage= (ImageView) itemView.findViewById(R.id.ivmedimage);
        }
    }

}
