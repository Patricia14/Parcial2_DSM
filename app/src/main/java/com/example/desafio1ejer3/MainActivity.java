package com.example.desafio1ejer3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    //Iniciamos variables
    ImageView ivImage;
    TextView tvNombre;
    Button btnLogout;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImage = findViewById(R.id.iv_image);
        tvNombre = findViewById(R.id.tv_nombre);
        btnLogout = findViewById(R.id.btn_logout);

        //Iniciamos firebase auth
        firebaseAuth = FirebaseAuth.getInstance();
        //Iniciamos firebase usuario
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        //Verificamos condicion
        if(firebaseUser != null){
            //Cuando el usuario de firebase es diferente de null
            //colocamos la img
            Glide.with(MainActivity.this)
                    .load(firebaseUser.getPhotoUrl())
                    .into(ivImage);
            //Colocamos el nombre
            tvNombre.setText(firebaseUser.getDisplayName());
        }
        googleSignInClient = GoogleSignIn.getClient(MainActivity.this
                , GoogleSignInOptions.DEFAULT_SIGN_IN);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                //Sign out de google
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            //Si el task es exitoso
                            //sign out de firebase
                            firebaseAuth.signOut();
                            //Mostramos msj en toast
                            Toast.makeText(getApplicationContext()
                            ,"Logout exitoso",Toast.LENGTH_SHORT).show();
                            //Finalizamos la activity
                            startActivity(i);
                        }
                    }
                });
            }
        });

    }

    public void Ingresar(View in){
        Intent calculos = new Intent(this, MedicineActivity.class);
        startActivity(calculos);
    }

    public void historial(View in){
        Intent histo = new Intent(this, historial.class);
        startActivity(histo);
    }
}