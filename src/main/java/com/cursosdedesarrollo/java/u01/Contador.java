package com.cursosdedesarrollo.java.u01;

import lombok.NoArgsConstructor;

// Unidad 01 — atributos y métodos estáticos
//
// Un atributo  static pertenece a la CLASE: existe uno solo, compartido por
// todas las instancias.
//
// Un atributo de instancia pertenece al OBJETO: cada new crea su propia copia.
//
// Lo mismo aplica a los métodos:
//   - static  → se llama con el nombre de la clase; no tiene acceso a "this".
//   - instancia → necesita un objeto; puede leer y modificar sus campos.
@NoArgsConstructor(force = true)
public class Contador {

    // Atributo estático público
    public static int valorEstatico = 0;

    // Atributo constante
    public static final int VALOR_CONSTANTE=2;

    // ── Atributo ESTÁTICO ────────────────────────────────────────────────────
    // totalCreados es de la clase: cuando llega a 0 objetos es 0,
    // al crear el primero es 1, al crear el segundo es 2, etc.
    private static int totalCreados = 0;

    // ── Atributo DE INSTANCIA ────────────────────────────────────────────────
    // id es de cada objeto: el primer Contador tiene id=1, el segundo id=2...
    private final int id;
    private String nombre;

    public Contador(String nombre) {
        totalCreados++;          // actualiza el contador compartido
        this.id     = totalCreados;
        this.nombre = nombre;
    }

    // ── Método ESTÁTICO ──────────────────────────────────────────────────────
    // No necesita ningún objeto para funcionar; se llama como Contador.getTotalCreados()
    public static int getTotalCreados() {
        return totalCreados;
    }

    // Útil en tests: resetea el estado de clase entre pruebas
    public static void resetear() {
        totalCreados = 0;
    }

    // ── Métodos DE INSTANCIA ─────────────────────────────────────────────────
    public int    getId()     { return id; }
    public String getNombre() { return nombre; }
    public void   setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Contador{id=" + id + ", nombre='" + nombre + "'}";
    }
}
