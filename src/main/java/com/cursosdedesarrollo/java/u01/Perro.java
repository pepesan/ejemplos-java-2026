package com.cursosdedesarrollo.java.u01;

public class Perro extends Animal {

    String raza;

    public Perro(String nombre,  String raza) {
        super(nombre);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String getNombre() {
        return this.getNombre();
    }

    @Override
    public String hacerSonido() { return "Guau!"; }
}
