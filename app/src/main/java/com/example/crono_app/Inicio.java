package com.example.crono_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class Inicio extends AppCompatActivity {

    EditText Fecha,Horas,Ingreso,Salida,Entidad;
    Button Registro;
    Button RE;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        RE = findViewById(R.id.re);

        RE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Inicio.this, RegistroExtendido.class);
                startActivity(intent);
            }
        });

        Fecha = (EditText) findViewById(R.id.fecha);
        Horas = (EditText) findViewById(R.id.horas);
        Ingreso = (EditText) findViewById(R.id.ingreso);
        Salida = (EditText) findViewById(R.id.salida);
        Entidad = (EditText) findViewById(R.id.entidad);
        Registro = (Button) findViewById(R.id.registro);

        final Actividades Actividades = new Actividades(getApplicationContext());

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Actividades.agregarActividades(Fecha.getText().toString(), Horas.getText().toString(), Ingreso.getText().toString(), Salida.getText().toString(),Entidad.getText().toString());
                Toast.makeText(getApplicationContext(), "Nueva actividad añadida", Toast.LENGTH_SHORT).show();
            }
        });
    }

}