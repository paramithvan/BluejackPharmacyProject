package com.example.bluejackpharmacyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bluejackpharmacyproject.data.DataApp;
import com.example.bluejackpharmacyproject.data.MedicineData;
import com.example.bluejackpharmacyproject.data.TransactionData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MedicineDetail extends AppCompatActivity {

    ArrayList<MedicineData> medData;
    RCAdapter medAdapter;

    String medName;
    String medDesc;
    String medPabrik;
    int medPrice;
    int medImg;
    Button backButton;
    TextView judulPage;
    TextView namaMed;
    TextView MedDesc;
    TextView pabrik;
    TextView price;
    ImageView med_image;
    EditText quantity;
    Button buyNow;
    int MedId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_detail);

        MedId = getIntent().getIntExtra("MedId", 0);
        MedicineData obat = DataApp.getMedData().get(MedId);

        backButton = findViewById(R.id.back_button_medDet);
        judulPage = findViewById(R.id.medDet_tv);
        namaMed = findViewById(R.id.medName_det);
        med_image = findViewById(R.id.med_image_det);
        pabrik = findViewById(R.id.pabrik_det);
        price = findViewById(R.id.price_num);
        quantity = findViewById(R.id.quantityNum_det);
        MedDesc = findViewById(R.id.med_desc);
        buyNow = findViewById(R.id.buyNow_btn);



        med_image.setImageResource(obat.getImg());
        namaMed.setText(obat.getName());
        MedDesc.setText(obat.getMedDesc());
        pabrik.setText(obat.getPabrik());
        price.setText(String.valueOf(obat.getPrice()));


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineDetail.this, HOME.class);
                startActivity(intent);
            }
        });

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date dateTrans = new Date();
                MedicineData dataObat = DataApp.getMedData().get(MedId);
                DataApp.getInstance().addTrans(new TransactionData(dateTrans.toString(), dataObat, Integer.valueOf(quantity.getText().toString()), DataApp.getUserIdNow()));
                Intent intent = new Intent(MedicineDetail.this, HOME.class);
                startActivity(intent);
            }
        });



    }
}