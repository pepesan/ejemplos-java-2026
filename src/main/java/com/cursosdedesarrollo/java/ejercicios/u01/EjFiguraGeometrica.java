package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-3: herencia + polimorfismo.
// Figura abstracta con subclases concretas. areaTotal() demuestra el dynamic dispatch:
// no sabe qué tipo concreto hay en el array, pero cada figura calcula su área correctamente.
public class EjFiguraGeometrica {

    public static abstract class Figura {
        private final String nombre;

        protected Figura(String nombre) { this.nombre = nombre; }

        public String getNombre() { return nombre; }
        public abstract double area();
        public abstract double perimetro();

        @Override
        public String toString() {
            return nombre + "{area=" + String.format("%.2f", area()) + "}";
        }
    }

    public static class Circulo extends Figura {
        private final double radio;

        public Circulo(double radio) {
            super("Circulo");
            this.radio = Math.abs(radio);
        }

        public double getRadio() { return radio; }

        @Override public double area()      { return Math.PI * radio * radio; }
        @Override public double perimetro() { return 2 * Math.PI * radio; }
    }

    public static class Triangulo extends Figura {
        private final double base;
        private final double altura;
        private final double ladoA;
        private final double ladoB;
        private final double ladoC;

        public Triangulo(double base, double altura, double ladoA, double ladoB, double ladoC) {
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

    // Varargs: acepta cualquier número de figuras sin necesitar List (que se ve en u02)
    public static double areaTotal(Figura... figuras) {
        double total = 0;
        for (Figura f : figuras) total += f.area();
        return total;
    }
}
