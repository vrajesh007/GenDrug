package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.R;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {
        Context context;
        ArrayList<category> listCategory;

    public categoryAdapter(Context context, ArrayList<category> listCategory) {
        this.context = context;
        this.listCategory = listCategory;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View mView = LayoutInflater.from(context).inflate(R.layout.category_row_item, parent,false);

        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        category Category = listCategory.get(position);
        String name = Category.getCateg_name();
        holder.medname.setText(name);
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

