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
import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.Model.prescribedmed;
import com.newproject.gendrug.Model.product;
import com.newproject.gendrug.R;
import com.newproject.gendrug.prescription;

import java.util.ArrayList;

public class prescriptionAdapter extends RecyclerView.Adapter<prescriptionAdapter.ViewHolder> {

    Context context;
    ArrayList<prescribedmed> prescriptions;

    public prescriptionAdapter(Context context, ArrayList<prescribedmed> prescriptions) {
        this.context = context;
        this.prescriptions = prescriptions;

        Log.d("size",String.valueOf(prescriptions.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context =viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_prescription_recyclerview, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        prescribedmed Pres = prescriptions.get(i);
        String bname=Pres.getPres_bname();
        viewHolder.tvbname.setText(bname);
        String gname=Pres.getPres_gname();
        viewHolder.tvgename.setText(gname);
        String details=Pres.getPres_details();
        viewHolder.tvpdetails.setText(details);
        String price=Pres.getPres_price();
        viewHolder.tvpprice.setText(price);
    }

    @Override
    public int getItemCount()
    {
        return prescriptions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvbname,tvgename,tvpdetails,tvpprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvbname= (TextView) itemView.findViewById(R.id.tvbname);
            tvgename= (TextView) itemView.findViewById(R.id.tvgename);
            tvpdetails= (TextView) itemView.findViewById(R.id.tvpdetails);
            tvpprice= (TextView) itemView.findViewById(R.id.tvpprice);
        }
    }

}

