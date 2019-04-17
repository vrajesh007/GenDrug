package com.newproject.gendrug.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newproject.gendrug.Model.MyOrder;
import com.newproject.gendrug.OrderDetailsActivity;
import com.newproject.gendrug.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<MyOrder> listOrder;

    SetOnOrderListItemClickListener onOrderListItemClickListener;

    public SetOnOrderListItemClickListener getOnOrderListItemClickListener() {
        return onOrderListItemClickListener;
    }

    public void setOnOrderListItemClickListener(SetOnOrderListItemClickListener onOrderListItemClickListener) {
        this.onOrderListItemClickListener = onOrderListItemClickListener;
    }

    public MyOrderAdapter(ArrayList<MyOrder> listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View mView = LayoutInflater.from(mContext).inflate(R.layout.order_row_tem_layout, parent, false);
        return new MyOrderAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final MyOrderAdapter.ViewHolder holder, final int position) {
        final MyOrder order = listOrder.get(position);
        holder.tvOrderID.setText(order.getOrderID());


        String Total = order.getTotalAmount();
        double total = Double.parseDouble(Total);
        DecimalFormat df1 = new DecimalFormat("0.00");
        df1.setMaximumFractionDigits(2);
        String totalAmount = (df1.format(total));
        Log.d("Total Amount", totalAmount);

        holder.tvTotalAmount.setText("₹"+totalAmount);
        holder.tvDate.setText(order.getDate());

        holder.ll_order_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, OrderDetailsActivity.class);
                i.putExtra("OrderID", order.getOrderID());
/*
                Log.d("OrderID", OrderID);
                i.putExtra("TotalAmount", TotalAmount);
                Log.d("TotalAmount", TotalAmount);
                i.putExtra("Date", Date);
                Log.d("Date", Date);
*/
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
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
        TextView tvOrderID, tvTotalAmount, tvDate;
        LinearLayout ll_order_list;

        public ViewHolder(View itemView) {
            super(itemView);
            tvOrderID = (TextView) itemView.findViewById(R.id.orderID);
            tvTotalAmount = (TextView) itemView.findViewById(R.id.total_amount);
            tvDate = (TextView) itemView.findViewById(R.id.date);

            ll_order_list = (LinearLayout) itemView.findViewById(R.id.ll_order_list);

        }
    }

    public interface SetOnOrderListItemClickListener {
        public void onOrderListItemClicked(MyOrder order, int position);
    }
}
