package com.cursosdedesarrollo.java.ejercicios.u03;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjSaldoInsuficienteExceptionTest {

    @Test
    public void mensajeContieneLosDatosRelevantes() {
        EjSaldoInsuficienteException ex = new EjSaldoInsuficienteException(50.0, 120.0);
        assertTrue(ex.getMessage().contains("50"));
        assertTrue(ex.getMessage().contains("120"));
    }

    @Test
    public void gettersDevuelvenLosValoresCorrectamente() {
        EjSaldoInsuficienteException ex = new EjSaldoInsuficienteException(30.0, 100.0);
        assertEquals(30.0,  ex.getSaldoActual(),       0.001);
        assertEquals(100.0, ex.getImporteSolicitado(), 0.001);
    }

    @Test
    public void esChecked_extiendException() {
        // Checked: hereda directamente de Exception (no de RuntimeException)
        EjSaldoInsuficienteException ex = new EjSaldoInsuficienteException(0, 1);
        assertTrue(ex instanceof Exception);
        // La clase padre directa es Exception, no RuntimeException
        assertEquals(Exception.class, ex.getClass().getSuperclass());
    }
}
