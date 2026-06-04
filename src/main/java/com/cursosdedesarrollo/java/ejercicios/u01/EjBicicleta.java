package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjBicicleta extends EjVehiculo {

    public EjBicicleta(String marca) {
        super(marca);
    }

    @Override
    public String moverme() { return "Con pedales"; }
}
