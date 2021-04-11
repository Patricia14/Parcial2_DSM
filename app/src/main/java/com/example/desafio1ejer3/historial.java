package com.example.desafio1ejer3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.desafio1ejer3.Datos.DatosFarmacia;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class historial extends AppCompatActivity {

    ListView myListView;
    List<DatosFarmacia> listHistorial;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refHistorial = database.getReference("historial");
    FirebaseAuth firebaseAuth;
    boolean bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial2);

        Query ordenada = refHistorial.orderByChild("nombre");

        myListView = (ListView) findViewById(R.id.listview1);

        listHistorial = new ArrayList<>();

        // Cambiarlo refProductos a consultaOrdenada para ordenar lista
        ordenada.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Iniciamos firebase auth
                firebaseAuth = FirebaseAuth.getInstance();
                //Iniciamos firebase usuario
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                listHistorial.removeAll(listHistorial);
                for (DataSnapshot dato : dataSnapshot.getChildren()) {
                    DatosFarmacia hist = dato.getValue(DatosFarmacia.class);
                    if(hist.getCorreo().equals(firebaseUser.getEmail())){
                        bandera = true;
                        hist.setKey(dato.getKey());
                        listHistorial.add(hist);
                    }
                }

                AdaptadorHistorial adapter = new AdaptadorHistorial(historial.this,
                        listHistorial );
                myListView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });



    }
}