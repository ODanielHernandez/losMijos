package com.losmijos;

public class entidad_mochila {

    private String nombre;
    private String prioridad;
    private Boolean obtenido ;

    public entidad_mochila(String nombre, String prioridad, Boolean obtenido) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.obtenido = obtenido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public boolean getObtenido() {
        return obtenido;
    }
}
