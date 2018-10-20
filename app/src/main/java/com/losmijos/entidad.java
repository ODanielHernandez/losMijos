package com.losmijos;

public class entidad {

    private int imgFoto;
    private String titulo;
    private String contenido;
    private Integer id_desastre;

    public entidad(int imgFoto, String titulo, String contenido, Integer id_desastre) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
        this.id_desastre = id_desastre;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public Integer getId_desastre() {
        return id_desastre;
    }
}
