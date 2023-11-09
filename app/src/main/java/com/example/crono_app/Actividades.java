package com.example.crono_app;

import android.content.ContentValues;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Actividades {

    private static final String BDD="Trabajo.bd";
    private static final int versionN=1;
    private static final String tablaUser="CREATE TABLE Actividades (" +
            "CODIGO TEXT PRIMARY KEY, " +
            "FECHA TEXT, " +
            "HORAS TEXT," +
            "INGRESO TEXT," +
            "SALIDA TEXT," +
            "ENTIDAD TEXT)";

    public Actividades(Context context){
        super(context, BDD,null,versionN);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(tablaUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tablaUser);
    }

    public void agregarActividades(String fecha, String horas, String ingreso, String salida, String entidad) {
        SQLiteDatabase bdd = getWritableDatabase();
        if (bdd != null) {
            ContentValues values = new ContentValues();
            values.put("CODIGO", fecha);
            values.put("FECHA", horas);
            values.put("INGRESO", ingreso);
            values.put("SALIDA", salida);
            values.put("ENTIDAD", entidad);
            bdd.insert("Actividades", null, values);
            bdd.close();
        }
    }

}

