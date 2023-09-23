package com.example.bluejackpharmacyproject;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.TransactionData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransViewHolder> {

    Context context;
    ArrayList<TransactionData> modelTransList;

    public TransactionAdapter(Context context, ArrayList<TransactionData> modelTransList) {
        this.context = context;
        this.modelTransList = modelTransList;
    }

    @NonNull
    @NotNull
    @Override
    public TransViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View liat = inflater.inflate(R.layout.rc_transaction,parent,false);
        return new TransViewHolder(liat);
    }

    @Override
    public void onBindViewHolder(@NonNull TransViewHolder holder, int position) {
        TransactionData transAdapt = modelTransList.get(position);
        holder.rc_image_trans.setImageResource(transAdapt.getItem().getImg());
        holder.rc_name_trans.setText(transAdapt.getItem().getName());
        holder.rc_price_trans.setText(String.valueOf(transAdapt.getItem().getPrice() *  modelTransList.get(position).getQuantity()));
        holder.rc_quantity_trans.setText(String.valueOf(transAdapt.getQuantity()));
        holder.rc_date_trans.setText(transAdapt.getTransDate());
        holder.rc_delete_trans.setOnClickListener(menuItem -> {
            DataApp.getInstance().transactionList.remove(modelTransList.get(position));
            DataApp.UpdateTrans();
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
            Toast.makeText(context, "The record has been successfully removed from the system", Toast.LENGTH_SHORT).show();
        });

        holder.rc_update_trans.setOnClickListener(view -> {
            LayoutInflater layoutInflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            PopupWindow update = new PopupWindow(layoutInflater.inflate(R.layout.update_trans,null,false), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
            update.showAtLocation(view.getRootView(), Gravity.CENTER, 0, 0);

            EditText quantityNum = update.getContentView().findViewById(R.id.numQuantity_update);
            quantityNum.setText(String.valueOf(modelTransList.get(position).getQuantity()));

            Button save = update.getContentView().findViewById(R.id.save_btn);
            save.setOnClickListener(v -> {
                int index = Integer.parseInt(quantityNum.getText().toString());
                if (index > 1){
                    modelTransList.get(position).setQuantity(index);

                    notifyItemChanged(position);
                    notifyItemRangeChanged(position,getItemCount());

                    update.dismiss();
                }else{
                    Toast.makeText(context, "Please enter the quantity of the product", Toast.LENGTH_SHORT).show();
                }
            });
        });

    }


    @Override
    public int getItemCount() {
        return modelTransList.size();
    }

    public static class TransViewHolder extends RecyclerView.ViewHolder{
        ImageView rc_image_trans;
        TextView rc_name_trans;
        TextView rc_price_trans;
        TextView rc_quantity_trans;
        TextView rc_date_trans;
        Button rc_delete_trans;
        Button rc_update_trans;

        public TransViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            rc_image_trans = itemView.findViewById(R.id.imageMed_transaction);
            rc_name_trans = itemView.findViewById(R.id.NameMed_trans);
            rc_price_trans = itemView.findViewById(R.id.price_trans);
            rc_quantity_trans = itemView.findViewById(R.id.quantity_trans);
            rc_date_trans = itemView.findViewById(R.id.date_trans);
            rc_delete_trans = itemView.findViewById(R.id.delete_button);
            rc_update_trans = itemView.findViewById(R.id.update_button);
        }

    }


}
