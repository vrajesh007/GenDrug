package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newproject.gendrug.Model.order;
import com.newproject.gendrug.Model.prescribedmed;
import com.newproject.gendrug.R;

import java.util.ArrayList;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.ViewHolder> {

    Context context;
    ArrayList<order> orders;

    public orderAdapter(Context context, ArrayList<order> orders) {
        this.context = context;
        this.orders = orders;

        Log.d("size",String.valueOf(orders.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context =viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_orderdetails_recyclerview, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        order ord = orders.get(i);
        String oid=ord.getOrder_id();
        viewHolder.tvorderid.setText(oid);
        String oproducts=ord.getOrder_products();
        viewHolder.tvorderproducts.setText(oproducts);
        String oquantity=ord.getOrder_quantity();
        viewHolder.tvorderquantity.setText(oquantity);
        String oamt=ord.getOrder_amount();
        viewHolder.tvorderamount.setText(oamt);
        String odate=ord.getOrder_date();
        viewHolder.tvorderdate.setText(odate);
    }

    @Override
    public int getItemCount()
    {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvorderid,tvorderproducts,tvorderquantity,tvorderamount,tvorderdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvorderid= (TextView) itemView.findViewById(R.id.tvorderid);
            tvorderproducts= (TextView) itemView.findViewById(R.id.tvorderproducts);
            tvorderquantity= (TextView) itemView.findViewById(R.id.tvorderquantity);
            tvorderamount= (TextView) itemView.findViewById(R.id.tvorderamount);
            tvorderdate= (TextView)itemView.findViewById(R.id.tvorderdate);
        }
    }

}


