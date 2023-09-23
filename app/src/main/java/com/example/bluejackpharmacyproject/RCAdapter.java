package com.example.bluejackpharmacyproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.MedicineData;

import java.util.ArrayList;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCViewHolder> {

    Context context;
    ArrayList<MedicineData> modelArrayList = new ArrayList<MedicineData>();

    public RCAdapter(Context context, ArrayList<MedicineData> modelArrayList) {
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
        MedicineData medData = modelArrayList.get(position);
        holder.title.setText(medData.getName());
        holder.image_obat.setImageResource(medData.getImg());
        holder.price.setText(String.valueOf(medData.getPrice()));
        holder.pabrik.setText(medData.getPabrik());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class RCViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

       ImageView image_obat;
       TextView title;
       TextView price;
       TextView pabrik;

       CardView goToDet;

       public RCViewHolder(@NonNull View itemView) {
           super(itemView);

           image_obat = itemView.findViewById(R.id.image_obat);
           title = itemView.findViewById(R.id.title);
           price = itemView.findViewById(R.id.price);
           pabrik = itemView.findViewById(R.id.pabrik);
           goToDet = itemView.findViewById(R.id.items_cardView);
           goToDet.setOnClickListener(this);
       }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MedicineDetail.class);
            intent.putExtra("MedId", modelArrayList.get(getAdapterPosition()).getMedId());

            view.getContext().startActivity(intent);
        }
    }

}
