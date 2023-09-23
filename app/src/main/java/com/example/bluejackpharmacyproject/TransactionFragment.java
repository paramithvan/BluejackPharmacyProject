package com.example.bluejackpharmacyproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.MedicineData;
import com.example.bluejackpharmacyproject.data.TransactionData;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {

    private RecyclerView recyclerTrans;
    ArrayList<TransactionData> transactionDataArrayList;
    TransactionAdapter tAdapter;
    ImageButton logout_trans;

    private Button menutrans;

    private String[] nameTrans;
    private int[] imageTrans;
    private String[] price;
    private int[] quantity;
    private String[] dateTrans;


    public TransactionFragment() {
        // Required empty public constructor
    }

    public static TransactionFragment newInstance(String param1, String param2) {
        TransactionFragment fragment = new TransactionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerTrans = view.findViewById(R.id.RC_trans);
        recyclerTrans.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerTrans.setHasFixedSize(true);

        DataApp.getInstance().resetTransUser();
        for (TransactionData trans :DataApp.getInstance().getTransactionList()) {
            if (trans.getUserId() == DataApp.getInstance().userIdNow){
                DataApp.getInstance().addTransUser(trans);
            }
        }
        transactionDataArrayList = DataApp.getInstance().gettransactionListUser();


        tAdapter = new TransactionAdapter(getContext(),transactionDataArrayList);
        recyclerTrans.setAdapter(tAdapter);
        tAdapter.notifyDataSetChanged();

        logout_trans = view.findViewById(R.id.logout_transaction);
        logout_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}