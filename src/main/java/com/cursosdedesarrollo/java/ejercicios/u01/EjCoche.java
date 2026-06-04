package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjCoche extends EjVehiculo {

    public EjCoche(String marca) {
        super(marca);
    }

    @Override
    public String moverme() { return "Con motor"; }
}
