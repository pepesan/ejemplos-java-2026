package com.cursosdedesarrollo.java.u01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void testAccesoAtributoPrivado(){
        Animal a = new Animal("Minu");
        a.setNombre("Nyska");
        assertEquals("Nyska", a.getNombre());
    }
}
