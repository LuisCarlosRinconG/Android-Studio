package com.example.crono_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText Documento,Nombre,Correo,Contrasena;
    Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Documento = (EditText) findViewById(R.id.documento);
        Nombre = (EditText) findViewById(R.id.nombre);
        Correo = (EditText) findViewById(R.id.correo);
        Contrasena = (EditText) findViewById(R.id.contrasena);
        Enviar = (Button) findViewById(R.id.enviar);

        final Usuarios Usuarios = new Usuarios(getApplicationContext());

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios.agregarUsuarios(Documento.getText().toString(), Nombre.getText().toString(), Correo.getText().toString(), Contrasena.getText().toString());
                Toast.makeText(getApplicationContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

}