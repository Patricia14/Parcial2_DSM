package com.example.desafio1ejer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PrimeraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera);
        Toast.makeText(getApplicationContext(), "Bienvenidos", Toast.LENGTH_SHORT).show();
    }

    public void Ingresar(View in){
        Intent calculos = new Intent(this, MedicineActivity.class);
        startActivity(calculos);
    }
}