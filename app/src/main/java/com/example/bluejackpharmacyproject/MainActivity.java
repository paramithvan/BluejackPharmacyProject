package com.example.bluejackpharmacyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button loginButton;
    Button gotoRegisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate: Login Page");

        email = findViewById(R.id.EmailText);
        password = findViewById(R.id.PasswordText);
        loginButton = findViewById(R.id.LoginButton);
        gotoRegisButton = findViewById(R.id.goto_regis_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill your email", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, HOME.class);
                    startActivities(new Intent[]{intent});
                }
            }
        });

        gotoRegisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivities(new Intent[]{intent});
            }
        });
    }
}