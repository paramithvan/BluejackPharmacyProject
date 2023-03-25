package com.example.bluejackpharmacyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCViewHolder> {

    Context context;
    ArrayList<RCModel> modelArrayList;

    public RCAdapter(Context context, ArrayList<RCModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_obat, parent,false);
        return new RCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCViewHolder holder, int position) {
        RCModel rcModel = modelArrayList.get(position);
        holder.title.setText(rcModel.title);
        holder.image_obat.setImageResource(rcModel.image);
        holder.price.setText(rcModel.price);
        holder.pabrik.setText(rcModel.pabrik);
    }

    @Override
    public int getItemCount() {

        return modelArrayList.size();
    }

    public class RCViewHolder extends RecyclerView.ViewHolder {

       ImageView image_obat;
       TextView title;
       TextView price;
       TextView pabrik;

       public RCViewHolder(@NonNull View itemView) {
           super(itemView);

           image_obat = itemView.findViewById(R.id.image_obat);
           title = itemView.findViewById(R.id.title);
           price = itemView.findViewById(R.id.price);
           pabrik = itemView.findViewById(R.id.pabrik);

       }
   }

}
