package com.example.crono_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RegistroExtendido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_extendido);

        Actividades actividadesDb = new Actividades(getApplicationContext());

        List<Actividades.Actividad> actividades = actividadesDb.obtenerTodasActividades();
        



        List<String> datosActividades = new ArrayList<>();

        for(Actividades.Actividad actividad : actividades){

            String datos = "Fecha: " + actividad.getFecha() + "\n" +
                            "Horas: " + actividad.getHoras() + "\n" +
                            "Ingreso: " + actividad.getIngreso()+ "\n" +
                            "Salida: " + actividad.getSalida() + "\n" +
                            "Entrada: " + actividad.getEntidad() + "\n" ;
            datosActividades.add(datos);
        }

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datosActividades);
        listView.setAdapter(adapter);
    }
}