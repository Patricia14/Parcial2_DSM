package com.example.desafio1ejer3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.desafio1ejer3.Datos.DatosFarmacia;

import java.util.List;


public class AdaptadorHistorial extends ArrayAdapter<DatosFarmacia> {

    List<DatosFarmacia> personas;
    private Activity context;

    public AdaptadorHistorial(@NonNull Activity context, @NonNull List<DatosFarmacia> personas) {
        super(context, R.layout.historial_layout, personas);
        this.context = context;
        this.personas = personas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        // Método invocado tantas veces como elementos tenga la coleccion personas
        // para formar a cada item que se visualizara en la lista personalizada
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowview=null;
        // optimizando las diversas llamadas que se realizan a este método
        // pues a partir de la segunda llamada el objeto view ya viene formado
        // y no sera necesario hacer el proceso de "inflado" que conlleva tiempo y
        // desgaste de bateria del dispositivo
        if (view == null)
             rowview = layoutInflater.inflate(R.layout.historial_layout,null);
        else rowview = view;

        TextView tvNombre = rowview.findViewById(R.id.tvNombre);
        TextView tvCorreo = rowview.findViewById(R.id.tvCorreo);
        TextView tvFecha = rowview.findViewById(R.id.tvFecha);
        TextView tvTotal = rowview.findViewById(R.id.tvTotal);


        tvNombre.setText("Nombre : "+personas.get(position).getNombre());
        tvCorreo.setText("Correo : " + personas.get(position).getCorreo());
        tvFecha.setText("Fecha : " + personas.get(position).getFecha());
        tvTotal.setText("Total pagado : " + personas.get(position).getTotal());

        return rowview;
    }
}
