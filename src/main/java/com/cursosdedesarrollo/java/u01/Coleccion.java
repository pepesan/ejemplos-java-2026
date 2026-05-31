package com.cursosdedesarrollo.java.u01;

import java.util.List;

// Unidad 01 — Default methods (Java 8)
public interface Coleccion<T> {
    void agregar(T elemento);

    // default: añade comportamiento sin romper implementaciones existentes
    default void agregarTodos(List<T> elementos) {
        elementos.forEach(this::agregar);
    }
}
