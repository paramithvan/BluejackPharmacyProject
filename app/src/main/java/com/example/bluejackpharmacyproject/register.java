package com.example.bluejackpharmacyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.UserData;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {

    EditText name;
    EditText phoneNum;
    EditText email_regis;
    EditText pass_regis;
    EditText confirmPass_regis;

    ArrayList<UserData> userData = new ArrayList<>();

    Button register_btn;
    Button goto_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Log.i("register", "onCreate: Register Page");

        name = findViewById(R.id.name_edt);
        phoneNum = findViewById(R.id.phoneNum_edt);
        email_regis = findViewById(R.id.email_edt);
        pass_regis = findViewById(R.id.password_edt);
        confirmPass_regis = findViewById(R.id.confirmPass_edt);
        register_btn = findViewById(R.id.button_regis);
        goto_login = findViewById(R.id.login_button_regis);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().isEmpty() & phoneNum.getText().toString().isEmpty()
                & email_regis.getText().toString().isEmpty() & pass_regis.getText().toString().isEmpty()& confirmPass_regis.getText().toString().isEmpty()){
                    Toast.makeText(register.this, "Please fill all required form", Toast.LENGTH_SHORT).show();
                    return;
                } else if (name.getText().toString().length() < 5) {
                    Toast.makeText(register.this, "Name length must be greater than 5", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!email_regis.getText().toString().endsWith(".com")) {
                    Toast.makeText(register.this, "Email must ends with .com", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!Pattern.compile("^[a-zA-Z0-9_]*$").matcher(pass_regis.getText().toString()).matches()) {
                    Toast.makeText(register.this, "Password must be alphanumeric", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!pass_regis.getText().toString().matches(confirmPass_regis.getText().toString())) {
                    Toast.makeText(register.this, "Passwords don't match, please try again", Toast.LENGTH_SHORT).show();
                    return;
                } else{
                    userData.add(new UserData(DataApp.getInstance().getUserList().size(), name.getText().toString(), phoneNum.getText().toString(), email_regis.getText().toString(), pass_regis.getText().toString()));
                    Intent intent = new Intent(register.this, HOME.class);
                    startActivities(new Intent[]{intent});
                }

            }
        });

        goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, MainActivity.class);
                startActivities(new Intent[]{intent});
            }
        });
    }
}