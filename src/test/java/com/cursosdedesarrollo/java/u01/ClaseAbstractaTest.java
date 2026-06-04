package com.cursosdedesarrollo.java.u01;

import org.junit.Test;

public class ClaseAbstractaTest {
    @Test
    public void testClaseImplementacion() {
        // Esto no puedo hacerlo
        // ClaseAbstacta claseAbstactaObjeto = new ClaseAbstacta();
        // Pero puedo si implemento el método que falta
        ClaseAbstacta claseAbstactaObjeto = new ClaseAbstacta() {
            @Override
            public String getSalarioCompleto() {
                return "";
            }
        };
        // También puedo crear un objeto usando al función constructora de
        // la clase que hereda de la clase Abstracta
        // Usando de base un objeto definido como si fuera la clase abstracta
        ClaseAbstacta claseAbstacta = new ClaseImplementacion();
        // puedo acceder al método definido dento del clase abstracta
        // porque la implementación debería estar en clase de implementación
        String salarioBase = claseAbstacta.getSalarioCompleto();
        // También puedo crear el objeto como si fuera la misma clase de Implementación
        ClaseImplementacion claseImplementacion = new ClaseImplementacion();
        String salarioBase2 = claseImplementacion.getSalarioCompleto();
    }
}
