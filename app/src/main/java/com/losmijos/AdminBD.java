package com.losmijos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminBD extends SQLiteOpenHelper {

    final static String NOMBREBD = "BDdesastres.db";
    final static Integer VERSIONBBD = 1;
    final static String NOMBRETABLAPELICULAS = "tblPeliculas";
    final static String NOMBRECAMPOIDPELICULA = "idpelicula";
    final static String NOMBRECAMPOTITULO = "titulo";
    final static String NOMBRECAMPODURACION = "duracion";
    final static String NOMBRECAMPOANIO = "anio";
    final static String CREARTABLAPELICULAS = "CREATE TABLE "+NOMBRETABLAPELICULAS+" ("+NOMBRECAMPOIDPELICULA+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +NOMBRECAMPOTITULO+" TEXT,"+NOMBRECAMPODURACION+" INTEGER,"+NOMBRECAMPOANIO+" INTEGER);";

    public AdminBD(Context context) {
        super(context, NOMBREBD, null, VERSIONBBD);

    }

    public String crearTablas(String nombreTabla){
        String CREARTABLA= "CREATE TABLE "+nombreTabla+" (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "articulo TEXT, cantidad INTEGER, importancia INTEGER);";
        return CREARTABLA;
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(crearTablas("incendios"));
        bd.execSQL(crearTablas("terremotos"));
        bd.execSQL(crearTablas("huracanes"));
        bd.execSQL(crearTablas("incendiosForestales"));
        bd.execSQL(crearTablas("tornados"));
        bd.execSQL(crearTablas("tsunamis"));
        bd.execSQL(crearTablas("temperaturasExtremas"));
        bd.execSQL(crearTablas("deslizamientoDeTierra"));
        bd.execSQL(crearTablas("sequias"));
        bd.execSQL(crearTablas("erupcionVolcanica"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarRegistro(SQLiteDatabase bd, String articulo, int cantidad, int importancia, String nombreTabla){
        final String insertar = "INSERT INTO "+nombreTabla+"(articulo, cantidad, importancia) VALUES('"+articulo+"','"+cantidad+"','"+importancia+"');";
        bd.execSQL(insertar);
    }

    public void eliminarRegistro(SQLiteDatabase bd, String id, String nombreTabla){
        final String eliminar = "DELETE FROM "+nombreTabla+" WHERE id='"+id+"';";
        bd.execSQL(eliminar);
    }
}
