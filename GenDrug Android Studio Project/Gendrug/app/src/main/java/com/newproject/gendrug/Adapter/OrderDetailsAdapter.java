package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newproject.gendrug.Model.OrderDetails;
import com.newproject.gendrug.R;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder> {
    private static final java.lang.String RUPEE_SYMBOL = "&#8377;";
    ArrayList<OrderDetails> listOrderDetails;
    Context mContext;

    public OrderDetailsAdapter(ArrayList<OrderDetails> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }


    @Override
    public OrderDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View mView = LayoutInflater.from(mContext).inflate(R.layout.order_details_row_item_layout, parent, false);
        return new OrderDetailsAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(OrderDetailsAdapter.ViewHolder holder, final int position) {
        OrderDetails order = listOrderDetails.get(position);
        holder.tvOrderPrice.setText(order.getPrice());
        holder.tvOrderName.setText(order.getProductName());
        holder.tvOrderQty.setText(order.getQuantity());
        holder.tvOrderAmount.setText("₹" + order.getAmount());
    }

    @Override
    public int getItemCount() {
        return listOrderDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderName, tvOrderPrice, tvOrderQty, tvOrderAmount;

        public ViewHolder(View itemView) {
            super(itemView);
            tvOrderName = (TextView) itemView.findViewById(R.id.tv_order_details_name);
            tvOrderPrice = (TextView) itemView.findViewById(R.id.tv_order_details_price);
            tvOrderAmount = (TextView) itemView.findViewById(R.id.tv_order_details_amount);
            tvOrderQty = (TextView) itemView.findViewById(R.id.tv_order_details_qty);


        }
    }
}
