package com.cursosdedesarrollo.java.ejercicios.u01;

import java.util.ArrayList;
import java.util.List;

// Ejercicio u01-4: composición — Biblioteca "tiene" Libros.
// Libro no tiene sentido como entidad independiente fuera de este modelo.
public class EjBiblioteca {

    public static class Libro {
        private final String titulo;
        private final String autor;
        private final int    anyo;

        public Libro(String titulo, String autor, int anyo) {
            this.titulo = titulo;
            this.autor  = autor;
            this.anyo   = anyo;
        }

        public String getTitulo() { return titulo; }
        public String getAutor()  { return autor; }
        public int    getAnyo()   { return anyo; }

        @Override
        public String toString() { return "\"" + titulo + "\" (" + autor + ", " + anyo + ")"; }
    }

    private final String      nombre;
    private final List<Libro> libros = new ArrayList<>();

    public EjBiblioteca(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }

    // Ignora null silenciosamente
    public void agregar(Libro libro) {
        if (libro != null) libros.add(libro);
    }

    // Bucle explícito: removeIf con lambda se verá en u05
    public boolean eliminar(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    // Devuelve null si no se encuentra — Optional se verá en u05
    public Libro buscarPorTitulo(String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) return l;
        }
        return null;
    }

    // Devuelve una copia para no exponer la lista interna — Collections.unmodifiableList se verá en u02
    public List<Libro> getLibros() { return new ArrayList<>(libros); }

    public int totalLibros() { return libros.size(); }
}
