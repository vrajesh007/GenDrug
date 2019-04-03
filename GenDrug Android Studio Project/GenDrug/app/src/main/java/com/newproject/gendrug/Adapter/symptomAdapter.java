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
import com.newproject.gendrug.Listener.productsbysymptom;
import com.newproject.gendrug.Model.category;
import com.newproject.gendrug.Model.symptom;
import com.newproject.gendrug.R;

import java.util.ArrayList;

public class symptomAdapter extends RecyclerView.Adapter<symptomAdapter.ViewHolder> {
    Context context;
    ArrayList<symptom> listSymptom;


    productsbysymptom productsBySymptom;

    public productsbysymptom getproductsbysymptom() {
        return productsBySymptom;
    }

    public void setproductsbysymptom(productsbysymptom productsBySymptom){
        this.productsBySymptom = productsBySymptom;
    }


    public symptomAdapter(Context context, ArrayList<symptom> listSymptom) {
        this.context = context;
        this.listSymptom = listSymptom;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View mView = LayoutInflater.from(context).inflate(R.layout.row_symptomlist_recyclerview, parent,false);

        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        symptom Symptom = listSymptom.get(position);
        String name = Symptom.getSymp_name();
        holder.symptomname.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productsbysymptom listener = getproductsbysymptom();
                listener.setonsymptomclicked(listSymptom,position);


            }
        });
    }

    @Override
    public int getItemCount() {
        return listSymptom.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView symptomname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symptomname = (TextView) itemView.findViewById(R.id.symptomname);
        }
    }
}

