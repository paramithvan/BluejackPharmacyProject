package com.example.bluejackpharmacyproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class homeFragment extends Fragment {

    private RecyclerView recyclerView;
    ArrayList<RCModel> modelArrayList;
    RCAdapter rcAdapter;

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

        dataInitialize();
        recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setHasFixedSize(true);

        rcAdapter = new RCAdapter(getContext(), modelArrayList);
        recyclerView.setAdapter(rcAdapter);
        rcAdapter.notifyDataSetChanged();

    }

    private void dataInitialize() {
        modelArrayList = new ArrayList<>();

        String[] title = new String[]{
                "Iliadin Nasal Spray",
                "Sanadryl Sirup",
                "Panadol Cold & Flu",
                "Longatin 50 mg",
                "Apolar 0.5 mg/g Cream",
                "Grantusif",
                "Minosep Obat Kumur 0.2%",
                "Cefixime 200 mg"
        };

        int[] image = new int[]{
                R.drawable.iliadin, R.drawable.sanadryl,R.drawable.panadol,
                R.drawable.longatine, R.drawable.apolar, R.drawable.gratusif,
                R.drawable.minosep, R.drawable.cefixime
        };

        String[] price = new String[]{
                "Rp 61.300","Rp 32.400",
                "Rp 11.000","Rp 40.000",
                "Rp 43.500","Rp 5.000",
                "Rp 43.400","Rp 15.000",
        };

        String[] pabrik = new String[]{
                "Merck Indonesia",
                "Sanbe Farma",
                "Sterling",
                "Actavis",
                "Actavis",
                "Graha Farma",
                "Minorock Mandiri",
                "Generic Manufacturer"
        };

        for (int i = 0; i < title.length; i++){
            RCModel rcModel = new RCModel(title[i],image[i], pabrik[i], price[i]);
            modelArrayList.add(rcModel);
        }

    }
}