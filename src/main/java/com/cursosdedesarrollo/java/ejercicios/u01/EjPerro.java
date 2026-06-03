package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjPerro extends EjAnimal {

    public EjPerro(String nombre) {
        super(nombre);
    }

    @Override
    public String hacerSonido() { return "Guau"; }
}
