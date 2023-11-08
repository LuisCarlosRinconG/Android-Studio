package com.example.crono_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

        import com.example.crono_app.Inicio;

public class Login extends AppCompatActivity {
    EditText Password, Email;
    Button Entrar;

    // Agrega una referencia a tu base de datos SQLite
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Entrar = findViewById(R.id.entrar);

        // Inicializa tu base de datos aquí, por ejemplo:
        database = openOrCreateDatabase("Cronoudec.bd", MODE_PRIVATE, null);

        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                // Realiza la consulta en la base de datos
                Cursor cursor = database.rawQuery("SELECT * FROM Usuarios WHERE CORREO = ? AND CONTRASENA = ?",
                        new String[]{email, password});

                if (cursor.moveToFirst()) {
                    // Los datos del usuario existen en la base de datos, navega a la actividad "Inicio"
                    Intent intent = new Intent(Login.this, Inicio.class);
                    startActivity(intent);
                } else {
                    // Los datos no coinciden o no existen en la base de datos
                    Toast.makeText(Login.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }

                cursor.close();
            }
        });
    }
}