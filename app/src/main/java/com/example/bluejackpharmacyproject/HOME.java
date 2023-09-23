package com.example.bluejackpharmacyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.MedicineData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HOME extends FragmentActivity {

    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<MedicineData> MedList = DataApp.getInstance().getMedData();



        navbar = findViewById(R.id.bottom_navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new homeFragment()).commit();

        navbar.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){
                case R.id.home_button:
                    getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new homeFragment()).commit();
                    return true;

                case R.id.transaction_button:
                   getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new TransactionFragment()).commit();
                    return true;

                case R.id.aboutUs_button:
                    getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new AboutUsFragment()).commit();
                    return true;
            }
            return false;
        });

    }

}