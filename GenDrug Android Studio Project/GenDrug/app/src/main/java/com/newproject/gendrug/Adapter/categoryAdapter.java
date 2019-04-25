package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newproject.gendrug.Listener.ProductDetailClickListener;
import com.newproject.gendrug.Listener.productsbycategory;
import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.R;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {
        Context context;
        ArrayList<category> listCategory;


    productsbycategory productsByCategory;

    public productsbycategory getproductsbycategory() {
        return productsByCategory;
    }

    public void setproductsbycategory(productsbycategory productsByCategory){
        this.productsByCategory = productsByCategory;
    }


    public categoryAdapter(Context context, ArrayList<category> listCategory) {
        this.context = context;
        this.listCategory = listCategory;
    }

    public void filterList(ArrayList<category> filterdCategory) {
        this.listCategory = filterdCategory;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View mView = LayoutInflater.from(context).inflate(R.layout.category_row_item, parent,false);

        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        category Category = listCategory.get(position);
        String name = Category.getCateg_name();
        holder.medname.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productsbycategory listener = getproductsbycategory();
                listener.setoncategoryclicked(listCategory,position);


            }
        });
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView medname;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                medname = (TextView) itemView.findViewById(R.id.medname);
            }
        }
    }

