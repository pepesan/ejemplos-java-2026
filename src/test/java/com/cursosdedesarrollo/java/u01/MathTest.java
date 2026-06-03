package com.cursosdedesarrollo.java.u01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
// No es necesario importarlo porque se auto importa
// import java.lang.Math;

public class MathTest {
    @Test
    public void testMath(){
        assertEquals(2,Math.sqrt(4), 0.001);
    }
}
