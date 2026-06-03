package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-1: clase Rectangulo con atributos, constructores y métodos derivados.
// Demuestra: atributos privados, constructor con validación, getters, toString.
public class EjRectangulo {

    private final Long ancho;
    private final Long alto;

    // Si se pasa un valor negativo se usa su valor absoluto (sin excepciones en esta fase)
    public EjRectangulo(Long ancho, Long alto) {
        this.ancho = Math.abs(ancho);
        this.alto  = Math.abs(alto);
    }

    public Long    getAncho()    { return ancho; }
    public Long    getAlto()     { return alto; }
    public Long    area()        { return ancho * alto; }
    public Long    perimetro()   { return 2 * (ancho + alto); }
    public boolean esCuadrado()  { return ancho.equals(alto); }

    @Override
    public String toString() {
        return "Rectangulo{ancho=" + ancho + ", alto=" + alto + ", area=" + area() + "}";
    }
}
