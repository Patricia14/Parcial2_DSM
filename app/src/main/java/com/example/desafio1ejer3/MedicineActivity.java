package com.example.desafio1ejer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MedicineActivity extends AppCompatActivity {
    TextView tv1, tv2,tv3,tv4, tv5, tv6,tv7,tv8,tv9, tv10;
    int contar1 =0;
    int contar2 =0;
    int contar3 =0;
    int contar4 =0;
    int contar5 =0;
    int contar6 =0;
    int contar7 =0;
    int contar8 =0;
    int contar9 =0;
    int contar10 =0;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);


          tv1=(TextView) findViewById(R.id.tv1);
          tv2=(TextView) findViewById(R.id.tv2);
          tv3=(TextView) findViewById(R.id.tv3);
          tv4=(TextView) findViewById(R.id.tv4);
          tv5=(TextView) findViewById(R.id.tv5);
          tv6=(TextView) findViewById(R.id.tv6);
          tv7=(TextView) findViewById(R.id.tv7);
          tv8=(TextView) findViewById(R.id.tv8);
          tv9=(TextView) findViewById(R.id.tv9);
          tv10=(TextView) findViewById(R.id.tv10);


      }
    public void contador1 (View view){
        contar1++;
        tv1.setText(Integer.toString(contar1));
    }
    public void contador2 (View view){
        contar2++;
        tv2.setText(Integer.toString(contar2));
    }
    public void contador3 (View view){
        contar3++;
        tv3.setText(Integer.toString(contar3));
    }
    public void contador4 (View view){
        contar4++;
        tv4.setText(Integer.toString(contar4));
    }
    public void contador5 (View view){
        contar5++;
        tv5.setText(Integer.toString(contar5));
    }
    public void contador6 (View view){
        contar6++;
        tv6.setText(Integer.toString(contar6));
    }
    public void contador7 (View view){
        contar7++;
        tv7.setText(Integer.toString(contar7));
    }
    public void contador8 (View view){
        contar8++;
        tv8.setText(Integer.toString(contar8));
    }
    public void contador9 (View view){
        contar9++;
        tv9.setText(Integer.toString(contar9));
    }
    public void contador10 (View view){
        contar10++;
        tv10.setText(Integer.toString(contar10));
    }





    public void Atras(View in){
        Intent antes = new Intent(this, MainActivity.class);
        startActivity(antes);
    }
}