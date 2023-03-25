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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HOME extends FragmentActivity {


    BottomNavigationView navbar;

    homeFragment pageHome = new homeFragment();
    TransactionFragment transactionPage = new TransactionFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_atas, menu);

        MenuItem item = menu.findItem(R.id.logout_menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(HOME.this, MainActivity.class);
        startActivities(new Intent[]{intent});

        return super.onOptionsItemSelected(item);
    }
}