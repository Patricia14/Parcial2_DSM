package com.example.desafio1ejer3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FacturaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        Toast.makeText(getApplicationContext(), "Compra realizada", Toast.LENGTH_SHORT).show();
    }

    public void Atras(View in){
        Intent antes = new Intent(this, MainActivity.class);
        startActivity(antes);
    }
}
