package com.example.crono_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Usuarios extends SQLiteOpenHelper {

    private static final String BD="Cronoudec.bd";
    private static final int version=1;
    private static final String tablaUser="CREATE TABLE Usuarios (" +
            "CODIGO TEXT PRIMARY KEY, " +
            "DOCUMENTO TEXT, " +
            "NOMBRE TEXT," +
            "CORREO TEXT," +
            "CONTRASENA TEXT )";

    public Usuarios(Context context){
        super(context, BD,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(tablaUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tablaUser);
        sqLiteDatabase.execSQL(tablaUser);
    }

    public void agregarUsuarios(String documento, String nombre, String correo, String contrasena){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO Usuarios VALUES ('"+documento+"','"+nombre+"','"+correo+"','"+contrasena+"')");
            bd.close();
        }
    }

}
