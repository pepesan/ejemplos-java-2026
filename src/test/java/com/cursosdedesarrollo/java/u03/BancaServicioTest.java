package com.cursosdedesarrollo.java.u03;

import org.junit.Test;
import static org.junit.Assert.*;

public class BancaServicioTest {

    @Test
    public void retirarImporteValidoReduceSaldo() {
        BancaServicio b = new BancaServicio(100.0);
        b.retirar(30.0);
        assertEquals(70.0, b.getSaldo(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void retirarImporteNegativoLanzaIllegalArgument() {
        new BancaServicio(100.0).retirar(-10.0);
    }

    @Test(expected = IllegalStateException.class)
    public void retirarMasQueSaldoLanzaIllegalState() {
        new BancaServicio(10.0).retirar(50.0);
    }

    @Test
    public void tryCatchFinallyCapturaNFE() {
        String resultado = "";
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            resultado = "capturado";
        } finally {
            resultado += "-finally";
        }
        assertEquals("capturado-finally", resultado);
    }
}
