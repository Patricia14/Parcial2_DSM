package com.example.desafio1ejer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MedicineActivity extends AppCompatActivity {
    TextView tv1, tv2,tv3,tv4, tv5, tv6,tv7,tv8,tv9, tv10, textView7;
    TextView tvs1,tvs2, tvs3, tvs4, tvs5, tvs6, tvs7, tvs8, tvs9, tvs10;
    double contar1 =0;
    double contar2 =0;
    double contar3 =0;
    double contar4 =0;
    double contar5 =0;
    double contar6 =0;
    double contar7 =0;
    double contar8 =0;
    double contar9 =0;
    double contar10 =0;
    double total=0;
    double costo;
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
          textView7=(TextView) findViewById(R.id.textView7);


      }
    public void contador1 (View view){
        contar1++;
        int val=(int) contar1;
        tv1.setText(Integer.toString(val));
    }
    public void contador2 (View view){
        contar2++;
        int val=(int) contar2;
        tv2.setText(Integer.toString(val));
    }
    public void contador3 (View view){
        contar3++;
        int val=(int) contar3;
        tv3.setText(Integer.toString(val));
    }
    public void contador4 (View view){
        contar4++;
        int val=(int) contar4;
        tv4.setText(Integer.toString(val));
    }
    public void contador5 (View view){
        contar5++;
        int val=(int) contar5;
        tv5.setText(Integer.toString(val));
    }
    public void contador6 (View view){
        contar6++;
        int val=(int) contar6;
        tv6.setText(Integer.toString(val));
    }
    public void contador7 (View view){
        contar7++;
        int val=(int) contar7;
        tv7.setText(Integer.toString(val));
    }
    public void contador8 (View view){
        contar8++;
        int val=(int) contar8;
        tv8.setText(Integer.toString(val));
    }
    public void contador9 (View view){
        contar9++;
        int val=(int) contar9;
        tv9.setText(Integer.toString(val));
    }
    public void contador10 (View view){
        contar10++;
        int val=(int) contar10;
        tv10.setText(Integer.toString(val));
    }

    public void Total(View view){
       costo = (contar1*2.00)+(contar2*8.30)+(contar3*1.00)+(contar4*4.20)+(contar5*3.50)+(contar6*3.40)+(contar7*9.70)+(contar8*2.50)+(contar9*6.40)+(contar10*0.50);
  textView7.setText(Double.toString(costo));
    }




    public void Factura(View in){
        Intent f = new Intent(this, FacturaActivity.class);
        startActivity(f);
    }
}