package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-3: clase base de la jerarquía de figuras.
// area() y perimetro() devuelven 0.0 por defecto; las subclases los sobreescriben.
public class EjFigura {

    private final String nombre;

    public EjFigura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public double area()      { return 0.0; }
    public double perimetro() { return 0.0; }

    // Varargs: recibe cualquier número de figuras sin necesitar List (que se ve en u02).
    // Demuestra el dynamic dispatch: no sabe qué subtipo hay, pero cada figura
    // calcula su área correctamente según su tipo real.
    public static double areaTotal(EjFigura... figuras) {
        double total = 0;
        for (EjFigura f : figuras) total += f.area();
        return total;
    }

    @Override
    public String toString() {
        return nombre + "{area=" + String.format("%.2f", area()) + "}";
    }
}
