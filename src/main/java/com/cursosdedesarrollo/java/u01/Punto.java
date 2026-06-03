package com.cursosdedesarrollo.java.u01;

import java.util.Objects;

// Unidad 01 — equals, hashCode y toString
// Dos Punto son iguales si tienen las mismas coordenadas x e y.
public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    // equals debe cumplir: reflexivo, simétrico, transitivo y consistente.
    // Primero descarta null y tipos distintos; luego compara los campos.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto otro = (Punto) obj;
        return Double.compare(x, otro.x) == 0
            && Double.compare(y, otro.y) == 0;
    }

    // hashCode debe devolver el mismo valor para objetos que equals considera iguales.
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Punto{x=" + x + ", y=" + y + "}";
    }
}
