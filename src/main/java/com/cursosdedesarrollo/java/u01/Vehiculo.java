package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Constructores y this()
public class Vehiculo {
    private String marca;
    private int    año;

    // Constructor principal
    public Vehiculo(String marca, int año) {
        this.marca = marca;
        this.año   = año;
    }

    // Constructor alternativo: delega con this()
    public Vehiculo(String marca) {
        this(marca, 2026);
    }

    // Constructor sin parametros
    public Vehiculo() {
        this("", 2026);
    }

    public String getMarca() {
        return marca;
    }
    public int    getAño()   {
        return año;
    }

    public void setMarca (String marca){
        this.marca = marca;
    }

    public void setAño(int año){
        this.año = año;
    }

    @Override
    public String toString() {
        return "Vehiculo{marca='" + marca + "', año=" + año + "}";
    }
}
