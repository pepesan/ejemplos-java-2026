package com.cursosdedesarrollo.java.u03;

import org.junit.Test;
import static org.junit.Assert.*;

public class NullPointerExceptionTest {

    @Test(expected = NullPointerException.class)
    public void llamarMetodoSobreNullLanzaNPE() {
        String texto = null;
        texto.length(); // NullPointerException: texto no apunta a ningún objeto
    }

    @Test
    public void comprobarNullEvitaNPE() {
        String texto = null;
        int longitud = (texto != null) ? texto.length() : 0;
        assertEquals(0, longitud);
    }
}
