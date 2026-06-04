package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class AutoboxingTest {

    @Test
    public void defineObjetoDeClaseInteger() {
        Integer i = 17;
        i = new Integer(17);
        int i2 = 17;
        assertEquals((Integer) i2, i);
    }

    @Test
    public void defineObjetoDeClaseLong() {
        Long l = 17L;
        l = new Long(17L);
        long l2 = 17;
        assertEquals((Long) l2, l);
    }

    @Test
    public void defineObjetoDeClaseDouble() {
        Double d = 17.0;
        d = new Double(17.0);
        double d2 = 17.0;
        assertEquals((Double) d2, d);
    }
    @Test
    public void defineObjetoDeClaseFloat() {
        Float f = 17.0F;
        f = new Float(17.0F);
        float f2 = 17.0F;
        assertEquals((Float) f2, f);
    }

    // test de Boolean
    @Test
    public void defineObjetoDeClaseBoolean() {
        Boolean b = true;
        b = new Boolean(true);
        boolean b2 = true;
        assertEquals((Boolean) b2, b);
    }

    @Test
    public void autoboxingIntAInteger() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1); // autoboxing
        nums.add(2);
        int n = nums.get(0); // unboxing
        assertEquals(1, n);
    }

    @Test
    public void cacheIntegerHasta127CompateInstancia() {
        Integer a = 127, b = 127;
        assertTrue(a == b); // misma instancia del pool
    }

    @Test
    public void integerMayorDe127NoComparteInstancia() {
        Integer c = 128, d = 128;
        assertFalse(c == d);   // objetos distintos
        assertTrue(c.equals(d)); // mismo valor
    }

    @Test(expected = NullPointerException.class)
    public void unboxingDeNullLanzaNPE() {
        Integer x = null;
        int y = x; // NullPointerException
    }
}
