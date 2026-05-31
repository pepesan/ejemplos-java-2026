package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class AutoboxingTest {

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
