package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjCirculo extends EjFigura {

    private final double radio;

    public EjCirculo(double radio) {
        super("Circulo");
        this.radio = Math.abs(radio);
    }

    public double getRadio() { return radio; }

    @Override public double area()      { return Math.PI * radio * radio; }
    @Override public double perimetro() { return 2 * Math.PI * radio; }
}
