package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjServicio implements EjDescribible {

    private final String nombre;
    private final int    duracionHoras;

    public EjServicio(String nombre, int duracionHoras) {
        this.nombre        = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre()        { return nombre; }
    public int    getDuracionHoras() { return duracionHoras; }

    @Override
    public String getDescripcion() {
        return nombre + " (" + duracionHoras + "h)";
    }
}
