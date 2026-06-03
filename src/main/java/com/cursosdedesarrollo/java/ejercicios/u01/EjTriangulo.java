package com.cursosdedesarrollo.java.ejercicios.u01;

public class EjTriangulo extends EjFigura {

    private final double base;
    private final double altura;
    private final double ladoA;
    private final double ladoB;
    private final double ladoC;

    public EjTriangulo(double base, double altura, double ladoA, double ladoB, double ladoC) {
        super("Triangulo");
        this.base   = base;
        this.altura = altura;
        this.ladoA  = ladoA;
        this.ladoB  = ladoB;
        this.ladoC  = ladoC;
    }

    @Override public double area()      { return (base * altura) / 2; }
    @Override public double perimetro() { return ladoA + ladoB + ladoC; }
}
