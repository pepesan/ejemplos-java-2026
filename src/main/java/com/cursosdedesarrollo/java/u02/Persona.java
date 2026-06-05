package com.cursosdedesarrollo.java.u02;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

    private String nombre;

    public Persona() {
        this.nombre = "";
    }
}
