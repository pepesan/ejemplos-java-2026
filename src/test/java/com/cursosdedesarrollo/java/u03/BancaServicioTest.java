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

    // ── PedidoInvalidoException ──────────────────────────────────────────────

    @Test(expected = PedidoInvalidoException.class)
    public void procesarPedidoIdNuloLanzaPedidoInvalido() {
        new BancaServicio(100.0).procesarPedido(null, 10.0);
    }

    @Test(expected = PedidoInvalidoException.class)
    public void procesarPedidoImporteNegativoLanzaPedidoInvalido() {
        new BancaServicio(100.0).procesarPedido("P-001", -5.0);
    }

    @Test(expected = PedidoInvalidoException.class)
    public void procesarPedidoSaldoInsuficienteLanzaPedidoInvalido() {
        new BancaServicio(10.0).procesarPedido("P-002", 50.0);
    }

    @Test
    public void procesarPedidoValidoReduceSaldo() {
        BancaServicio b = new BancaServicio(100.0);
        b.procesarPedido("P-003", 40.0);
        assertEquals(60.0, b.getSaldo(), 0.001);
    }

    @Test
    public void procesarPedidoGuardaPedidoIdEnExcepcion() {
        try {
            new BancaServicio(10.0).procesarPedido("P-999", 50.0);
            fail("Se esperaba PedidoInvalidoException");
        } catch (PedidoInvalidoException e) {
            assertEquals("P-999", e.getPedidoId());
        }
    }

    // ── try-catch-finally ────────────────────────────────────────────────────

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
