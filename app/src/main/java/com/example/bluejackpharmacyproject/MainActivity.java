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

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.UserData;

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

        if(DataApp.getMedData().isEmpty()){
            DataApp.getInstance().DataList();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill all of the form", Toast.LENGTH_SHORT).show();
                } else if (!email.getText().toString().endsWith(".com")){
                    Toast.makeText(MainActivity.this, "Please fill your email", Toast.LENGTH_SHORT).show();
                }else{
                  for (UserData userData : DataApp.getInstance().getUserList()){
                        if (userData.getEmail().matches(email.getText().toString())){
                            if (userData.getPassword().matches(password.getText().toString())){
                                DataApp.getInstance().setUserIdNow(userData.getId());
                                Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, HOME.class);
                                startActivity(intent);
                            }
                        }
                  }
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