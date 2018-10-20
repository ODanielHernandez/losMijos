package com.losmijos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminBD extends SQLiteOpenHelper {

    final static String NOMBREBD = "BDdesastres.db";
    final static Integer VERSIONBBD = 1;


    public AdminBD(Context context) {
        super(context, NOMBREBD, null, VERSIONBBD);

    }

    public String crearTablas(String nombreTabla){
        String CREARTABLA= "CREATE TABLE "+nombreTabla+" (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "articulo TEXT, importancia INTEGER, verificado INTEGER);";
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

    public void insertarRegistro(SQLiteDatabase bd, String BDarticulo, int BDimportancia, String nombreTabla){
        final String insertar = "INSERT INTO "+nombreTabla+"(articulo, importancia, verificado) VALUES('"+BDarticulo+"','"+BDimportancia+"',0);";
        bd.execSQL(insertar);
    }

    public void eliminarRegistro(SQLiteDatabase bd, String id, String nombreTabla){
        final String eliminar = "DELETE FROM "+nombreTabla+" WHERE id='"+id+"';";
        bd.execSQL(eliminar);
    }
}
