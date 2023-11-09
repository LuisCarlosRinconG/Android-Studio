package com.example.crono_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class Actividades extends SQLiteOpenHelper {
    
    private static final String BDD = "Trabajo.bd";
    private static final int versionN = 1;

    public Actividades(Context context) {
        super(context, BDD, null, versionN);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tablaUser = "CREATE TABLE Actividades (" +
                "CODIGO TEXT PRIMARY KEY, " +
                "FECHA TEXT, " +
                "HORAS TEXT," +
                "INGRESO TEXT," +
                "SALIDA TEXT," +
                "ENTIDAD TEXT)";
        sqLiteDatabase.execSQL(tablaUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Actividades");
        onCreate(sqLiteDatabase);
    }

    public void agregarActividades(String fecha, String horas, String ingreso, String salida, String entidad) {
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FECHA", fecha);
        values.put("HORAS", horas);
        values.put("INGRESO", ingreso);
        values.put("SALIDA", salida);
        values.put("ENTIDAD", entidad);
        bdd.insert("Actividades", null, values);
        bdd.close();
    }

    public List<Actividad> obtenerTodasActividades() {
        List<Actividad> actividades = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Actividades", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String fecha = cursor.getString(cursor.getColumnIndex("FECHA"));
                @SuppressLint("Range") String horas = cursor.getString(cursor.getColumnIndex("HORAS"));
                @SuppressLint("Range") String ingreso = cursor.getString(cursor.getColumnIndex("INGRESO"));
                @SuppressLint("Range") String salida = cursor.getString(cursor.getColumnIndex("SALIDA"));
                @SuppressLint("Range") String entidad = cursor.getString(cursor.getColumnIndex("ENTIDAD"));
                actividades.add(new Actividad(fecha, horas, ingreso, salida, entidad));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return actividades;
    }

    public class Actividad {
        private String fecha;
        private String horas;
        private String ingreso;
        private String salida;
        private String entidad;

        public Actividad(String fecha, String horas, String ingreso, String salida, String entidad) {
            this.fecha=fecha;
            this.horas=horas;
            this.ingreso=ingreso;
            this.salida=salida;
            this.entidad=entidad;
        }


        public String getFecha(){
            return fecha;
        }
        public String getHoras(){
            return horas;
        }
        public String getIngreso(){
            return ingreso;
        }
        public String getSalida(){
            return salida;
        }
        public String getEntidad(){
            return entidad;
        }
    }
}