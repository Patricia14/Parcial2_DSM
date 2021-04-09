package com.example.desafio1ejer3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class LoginActivity extends AppCompatActivity {

    //Iniciamos variables
    SignInButton btnSignIn;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Asignamos variables
        btnSignIn = findViewById(R.id.bt_sign_in);

        //Iniciamos opciones de sign in con google
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken("416241630216-cchh7lbvm2dieb054ciqrlp2pf396qcp.apps.googleusercontent.com")
                .requestEmail()
                .build();

        //Iniciamos en sign in cliente
        googleSignInClient = GoogleSignIn.getClient(LoginActivity.this
        ,googleSignInOptions);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Iniciando sing in intent
                Intent i = googleSignInClient.getSignInIntent();
                //Iniciamos actividad para resultados
                startActivityForResult(i, 100);
            }
        });

        //Iniciamos la auth de firebase
        firebaseAuth = FirebaseAuth.getInstance();
        //Iniciamos firebase usuario
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            //Cuando el usuario ya haya iniciado sesion
            //Redirigimos hacia el perfil
            startActivity(new Intent(LoginActivity.this
            ,MainActivity.class)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Verificamos las condiciones
        if(requestCode == 100){
            //Cuando es igual a 100 iniciamos la tarea (task)
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn
                    .getSignedInAccountFromIntent(data);
            //Verificamos condicion
            if(signInAccountTask.isSuccessful()){
                //Cuando el inicio es exitoso
                String s = "Inicio con Google fue exitoso";
                //Ventana Toast
                displayToast(s);
                try{
                    //Inicializamos el sign in de la cuenta
                    GoogleSignInAccount googleSignInAccount = signInAccountTask
                            .getResult(ApiException.class);
                    //Verificamos condicion
                    if(googleSignInAccount != null){
                        //Cuando el sign in de la cuenta es diferente de null
                        //iniciamos el auth
                        AuthCredential authCredential = GoogleAuthProvider
                                .getCredential(googleSignInAccount.getIdToken()
                                ,null);
                        //Verificamos credenciales
                        firebaseAuth.signInWithCredential(authCredential)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        //Verificamos condicion
                                        if(task.isSuccessful()){
                                            //Cuando el task sea exitoso
                                            //Redirigimos al perfil
                                            startActivity(new Intent(LoginActivity.this
                                            ,MainActivity.class)
                                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                            //Mensaje toast
                                            displayToast("Auntenticacion exitosa!");
                                        }else{
                                            displayToast("Auntenticacion fallida: " + task.getException()
                                            .getMessage());
                                        }
                                    }
                                });
                    }
                }catch (ApiException e){
                    e.printStackTrace();;
                }
            }
        }
    }

    private void displayToast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}