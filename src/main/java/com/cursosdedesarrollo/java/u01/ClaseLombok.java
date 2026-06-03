package com.cursosdedesarrollo.java.u01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class ClaseLombok {

    private Long id;

    private String nombre;

    private String apellido;

    public ClaseLombok() {
        this.id = 0L;
        this.nombre = "";
        this.apellido = "";
    }


}
