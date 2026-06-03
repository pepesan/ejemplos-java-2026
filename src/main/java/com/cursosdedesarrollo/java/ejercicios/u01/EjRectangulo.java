package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-1: clase Rectangulo con atributos, constructores y métodos derivados.
// Demuestra: atributos privados, constructor con validación, getters, toString.
public class EjRectangulo {

    private final double ancho;
    private final double alto;

    // Si se pasa un valor negativo se usa su valor absoluto (sin excepciones en esta fase)
    public EjRectangulo(double ancho, double alto) {
        this.ancho = Math.abs(ancho);
        this.alto  = Math.abs(alto);
    }

    public double getAncho()    { return ancho; }
    public double getAlto()     { return alto; }
    public double area()        { return ancho * alto; }
    public double perimetro()   { return 2 * (ancho + alto); }
    public boolean esCuadrado() { return Double.compare(ancho, alto) == 0; }

    @Override
    public String toString() {
        return "Rectangulo{ancho=" + ancho + ", alto=" + alto + ", area=" + area() + "}";
    }
}
