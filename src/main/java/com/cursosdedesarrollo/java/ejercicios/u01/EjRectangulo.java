package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-1: clase, atributos Long, constructores, getters, setters y toString
public class EjRectangulo {

    private Long ancho;
    private Long alto;

    public EjRectangulo(Long ancho, Long alto) {
        this.ancho = ancho;
        this.alto  = alto;
    }

    public Long getAncho() { return ancho; }
    public Long getAlto()  { return alto; }

    public void setAncho(Long ancho) { this.ancho = ancho; }
    public void setAlto(Long alto)   { this.alto  = alto; }

    @Override
    public String toString() {
        return "Rectangulo{ancho=" + ancho + ", alto=" + alto + "}";
    }
}
