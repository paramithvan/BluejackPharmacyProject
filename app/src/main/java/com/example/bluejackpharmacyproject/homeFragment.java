package com.example.bluejackpharmacyproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.MedicineData;

import java.util.ArrayList;

public class homeFragment extends Fragment {

    private RecyclerView recyclerView;
    ArrayList<MedicineData> modelArrayList;
    RCAdapter rcAdapter;
    ImageButton logout_home;

    private  String[] title;
    private int[] image;
    private String[] price;
    private String[] pabrik;

    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setHasFixedSize(true);

        modelArrayList = DataApp.getMedData();

        rcAdapter = new RCAdapter(getContext(), modelArrayList);
        recyclerView.setAdapter(rcAdapter);
        rcAdapter.notifyDataSetChanged();

        logout_home = view.findViewById(R.id.logout_home);
        logout_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }}

