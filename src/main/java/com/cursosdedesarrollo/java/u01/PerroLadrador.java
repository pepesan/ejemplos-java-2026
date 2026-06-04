package com.cursosdedesarrollo.java.u01;

public class PerroLadrador extends Perro implements Ladrador {

    public PerroLadrador(String nombre, String raza) {
        super(nombre, raza);
    }

    @Override
    public void ladrar() {
        System.out.println("Guau!!!");
    }
}
