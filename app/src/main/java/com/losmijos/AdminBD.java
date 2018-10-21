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
                "articulo TEXT, importancia INTEGER, verificado BOOLEAN);";
        return CREARTABLA;
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(crearTablas("inundaciones"));
        insertarRegistro(bd,"Agua potable", 5, "inundaciones");
        insertarRegistro(bd,"Alimentos no perecederos", 5, "inundaciones");
        insertarRegistro(bd,"Iluminación portátil", 5, "inundaciones");

        bd.execSQL(crearTablas("terremotos"));
        insertarRegistro(bd,"Cubre bocas", 5, "terremotos");
        insertarRegistro(bd,"Agua potable", 5, "terremotos");
        insertarRegistro(bd,"Herramienta múltiple", 5, "terremotos");

        bd.execSQL(crearTablas("huracanes"));
        insertarRegistro(bd,"Comida enlatada", 5, "huracanes");
        insertarRegistro(bd,"Articulos de primeros auxilios", 5, "huracanes");
        insertarRegistro(bd,"Agua potable", 5, "huracanes");

        //bd.execSQL(crearTablas("incendiosForestales"));
        bd.execSQL(crearTablas("tornados"));
        insertarRegistro(bd,"Comida enlatada", 5, "tornados");
        insertarRegistro(bd,"Articulos de primeros auxilios", 5, "tornados");
        insertarRegistro(bd,"Agua potable", 5, "tornados");


        bd.execSQL(crearTablas("tsunamis"));
        insertarRegistro(bd,"Mapas locales", 5, "tsunamis");
        insertarRegistro(bd,"Botiquín de primeros auxilios", 5, "tsunamis");
        insertarRegistro(bd,"Agua potable", 5, "tsunamis");

        bd.execSQL(crearTablas("temperaturasExtremas"));
        insertarRegistro(bd,"Agua potable", 5, "temperaturasExtremas");
        insertarRegistro(bd,"Compresas frías", 5, "temperaturasExtremas");

        //bd.execSQL(crearTablas("deslizamientoDeTierra"));

        bd.execSQL(crearTablas("sequias"));
        insertarRegistro(bd,"Agua potable", 5, "sequias");
        insertarRegistro(bd,"Alimento no perecedero", 5, "sequias");

        bd.execSQL(crearTablas("erupcionVolcanica"));
        insertarRegistro(bd,"Máscara para polvo", 5, "erupcionVolcanica");
        insertarRegistro(bd,"Ropa de repuesto", 5, "erupcionVolcanica");
        insertarRegistro(bd,"Gafas desechables", 5, "erupcionVolcanica");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarRegistro(SQLiteDatabase bd, String BDarticulo, int BDimportancia, String nombreTabla){
        final String insertar = "INSERT INTO "+nombreTabla+"(articulo, importancia, verificado) VALUES('"+BDarticulo+"','"+BDimportancia+"',False);";
        bd.execSQL(insertar);
    }

    public void eliminarRegistro(SQLiteDatabase bd, String id, String nombreTabla){
        final String eliminar = "DELETE FROM "+nombreTabla+" WHERE id='"+id+"';";
        bd.execSQL(eliminar);
    }
}
