package com.example.desafio1ejer3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafio1ejer3.Datos.DatosFarmacia;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FacturaActivity extends AppCompatActivity {

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refHistorial = database.getReference("historial");

    Query ordenada = refHistorial.orderByChild("nombre");

    List<DatosFarmacia> historial;
    private Button btnConfirmar;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;

    TableRow tblUno, tblDos, tblTres, tblCuatro, tblCinco, tblSeis, tblSiete, tblOcho, tblNueve, tblDiez;
    TextView tvcant1, tvtotal1, tvcant2, tvtotal2, tvcant3, tvtotal3, tvcant4, tvtotal4, tvcant5, tvtotal5,
            tvcant6, tvtotal6, tvcant7, tvtotal7, tvcant8, tvtotal8, tvcant9, tvtotal9, tvcant10, tvtotal10, tvtotal;
    int cant1 = 0, cant2 = 0, cant3 = 0, cant4 = 0, cant5 = 0
            , cant6 = 0, cant7 = 0, cant8 = 0, cant9 = 0, cant10 = 0;
    double total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0
            , total7 = 0, total8 = 0, total9 = 0, total10 = 0, total = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        btnConfirmar = findViewById(R.id.btnFinalizarCompra);
        tblUno = findViewById(R.id.tbl1);
        tvcant1 = findViewById(R.id.cantidad1);
        tvtotal1 = findViewById(R.id.subtotal1);
        tblDos = findViewById(R.id.tbl2);
        tvcant2 = findViewById(R.id.cantidad2);
        tvtotal2 = findViewById(R.id.subtotal2);
        tblTres = findViewById(R.id.tbl3);
        tvcant3 = findViewById(R.id.cantidad3);
        tvtotal3 = findViewById(R.id.subtotal3);
        tblCuatro = findViewById(R.id.tbl4);
        tvcant4 = findViewById(R.id.cantidad4);
        tvtotal4 = findViewById(R.id.subtotal4);
        tblCinco = findViewById(R.id.tbl5);
        tvcant5 = findViewById(R.id.cantidad5);
        tvtotal5 = findViewById(R.id.subtotal5);
        tblSeis = findViewById(R.id.tbl6);
        tvcant6 = findViewById(R.id.cantidad6);
        tvtotal6 = findViewById(R.id.subtotal6);
        tblSiete = findViewById(R.id.tbl7);
        tvcant7 = findViewById(R.id.cantidad7);
        tvtotal7 = findViewById(R.id.subtotal7);
        tblOcho = findViewById(R.id.tbl8);
        tvcant8 = findViewById(R.id.cantidad8);
        tvtotal8 = findViewById(R.id.subtotal8);
        tblNueve = findViewById(R.id.tbl9);
        tvcant9 = findViewById(R.id.cantidad9);
        tvtotal9 = findViewById(R.id.subtotal9);
        tblDiez = findViewById(R.id.tbl10);
        tvcant10 = findViewById(R.id.cantidad10);
        tvtotal10 = findViewById(R.id.subtotal10);
        tvtotal = findViewById(R.id.total);

        Bundle datos = getIntent().getExtras();
        cant1 = datos.getInt("cant1");
        total1 = datos.getDouble("total1");
        cant2 = datos.getInt("cant2");
        total2 = datos.getDouble("total2");
        cant3 = datos.getInt("cant3");
        total3 = datos.getDouble("total3");
        cant4 = datos.getInt("cant4");
        total4 = datos.getDouble("total4");
        cant5 = datos.getInt("cant5");
        total5 = datos.getDouble("total5");
        cant6 = datos.getInt("cant6");
        total6 = datos.getDouble("total6");
        cant7 = datos.getInt("cant7");
        total7 = datos.getDouble("total7");
        cant8 = datos.getInt("cant8");
        total8 = datos.getDouble("total8");
        cant9 = datos.getInt("cant9");
        total9 = datos.getDouble("total9");
        cant10 = datos.getInt("cant10");
        total10 = datos.getDouble("total10");
        total = datos.getDouble("total");

        tvcant1.setText(String.valueOf(cant1));
        tvtotal1.setText(String.valueOf("$"+total1));
        tvcant2.setText(String.valueOf(cant2));
        tvtotal2.setText(String.valueOf("$"+total2));
        tvcant3.setText(String.valueOf(cant3));
        tvtotal3.setText(String.valueOf("$"+total3));
        tvcant4.setText(String.valueOf(cant4));
        tvtotal4.setText(String.valueOf("$"+total4));
        tvcant5.setText(String.valueOf(cant5));
        tvtotal5.setText(String.valueOf("$"+total5));
        tvcant6.setText(String.valueOf(cant6));
        tvtotal6.setText(String.valueOf("$"+total6));
        tvcant7.setText(String.valueOf(cant7));
        tvtotal7.setText(String.valueOf("$"+total7));
        tvcant8.setText(String.valueOf(cant8));
        tvtotal8.setText(String.valueOf("$"+total8));
        tvcant9.setText(String.valueOf(cant9));
        tvtotal9.setText(String.valueOf("$"+total9));
        tvcant10.setText(String.valueOf(cant10));
        tvtotal10.setText(String.valueOf("$"+total10));
        tvtotal.setText(String.valueOf("$"+total));

        tblUno.setVisibility(View.GONE);
        tblDos.setVisibility(View.GONE);
        tblTres.setVisibility(View.GONE);
        tblCuatro.setVisibility(View.GONE);
        tblCinco.setVisibility(View.GONE);
        tblSeis.setVisibility(View.GONE);
        tblSiete.setVisibility(View.GONE);
        tblOcho.setVisibility(View.GONE);
        tblNueve.setVisibility(View.GONE);
        tblDiez.setVisibility(View.GONE);

        if(cant1 > 0){
            tblUno.setVisibility(View.VISIBLE);
        }
        if(cant2 > 0){
            tblDos.setVisibility(View.VISIBLE);
        }
        if(cant3 > 0){
            tblTres.setVisibility(View.VISIBLE);
        }
        if(cant4 > 0){
            tblCuatro.setVisibility(View.VISIBLE);
        }
        if(cant5 > 0){
            tblCinco.setVisibility(View.VISIBLE);
        }
        if(cant6 > 0){
            tblSeis.setVisibility(View.VISIBLE);
        }
        if(cant7 > 0){
            tblSiete.setVisibility(View.VISIBLE);
        }
        if(cant8 > 0){
            tblOcho.setVisibility(View.VISIBLE);
        }
        if(cant9 > 0){
            tblNueve.setVisibility(View.VISIBLE);
        }
        if(cant10 > 0){
            tblDiez.setVisibility(View.VISIBLE);
        }

        Inicializador();

    }

    private void Inicializador(){

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Iniciamos firebase auth
                firebaseAuth = FirebaseAuth.getInstance();
                //Iniciamos firebase usuario
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                String nombre = firebaseUser.getDisplayName();
                String correo = firebaseUser.getEmail();
                String fecha = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                String total = tvtotal.getText().toString();

                DatosFarmacia historial = new DatosFarmacia(nombre, correo, fecha, total);

                // Preparando cuadro de dialogo para preguntar al usuario
                // Si esta seguro de eliminar o no el registro
                AlertDialog.Builder ad = new AlertDialog.Builder(FacturaActivity.this);
                ad.setMessage("Está seguro de completar la compra")
                        .setTitle("Confirmación");

                ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getBaseContext(), MainActivity.class);
                        FacturaActivity.refHistorial.push().setValue(historial);
                        Toast.makeText(FacturaActivity.this,
                                "Compra completada", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent in = new Intent(getBaseContext(), MainActivity.class);
                        Toast.makeText(FacturaActivity.this,
                                "Operación cancelada!", Toast.LENGTH_SHORT).show();
                        startActivity(in);
                    }
                });

                ad.show();
            }
        });

    }


    public void Atras(View in){
        Intent antes = new Intent(this, MainActivity.class);
        startActivity(antes);
    }
}
