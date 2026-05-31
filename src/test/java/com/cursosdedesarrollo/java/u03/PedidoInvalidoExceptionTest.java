package com.cursosdedesarrollo.java.u03;

import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoInvalidoExceptionTest {

    @Test
    public void mensajeContieneIdYMotivo() {
        PedidoInvalidoException ex = new PedidoInvalidoException("P-001", "sin stock");
        assertTrue(ex.getMessage().contains("P-001"));
        assertTrue(ex.getMessage().contains("sin stock"));
    }

    @Test
    public void getPedidoIdDevuelveId() {
        assertEquals("P-42", new PedidoInvalidoException("P-42", "x").getPedidoId());
    }

    @Test
    public void esRuntimeException() {
        assertTrue(new PedidoInvalidoException("X", "y") instanceof RuntimeException);
    }
}
