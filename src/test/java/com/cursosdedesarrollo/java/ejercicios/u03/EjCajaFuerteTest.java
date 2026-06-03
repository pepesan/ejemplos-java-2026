package com.cursosdedesarrollo.java.ejercicios.u03;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjCajaFuerteTest {

    @Test
    public void retirarImporteValidoReduceSaldo() throws EjSaldoInsuficienteException {
        EjCajaFuerte caja = new EjCajaFuerte(100.0);
        caja.retirar(40.0);
        assertEquals(60.0, caja.getSaldo(), 0.001);
    }

    @Test
    public void retirarMasQueSaldoLanzaSaldoInsuficiente() {
        EjCajaFuerte caja = new EjCajaFuerte(50.0);
        try {
            caja.retirar(100.0);
            fail("Debería lanzar EjSaldoInsuficienteException");
        } catch (EjSaldoInsuficienteException e) {
            assertEquals(50.0,  e.getSaldoActual(),       0.001);
            assertEquals(100.0, e.getImporteSolicitado(), 0.001);
        }
    }

    @Test
    public void tresIntentosFallidosBloqueanLaCaja() {
        EjCajaFuerte caja = new EjCajaFuerte(10.0);
        for (int i = 0; i < 3; i++) {
            try { caja.retirar(100.0); } catch (EjSaldoInsuficienteException ignored) {}
        }
        assertTrue(caja.estaBloqueada());
    }

    @Test
    public void exitoReiniciaContadorDeIntentos() throws EjSaldoInsuficienteException {
        EjCajaFuerte caja = new EjCajaFuerte(100.0);
        try { caja.retirar(200.0); } catch (EjSaldoInsuficienteException ignored) {}
        try { caja.retirar(200.0); } catch (EjSaldoInsuficienteException ignored) {}
        caja.retirar(10.0); // éxito: reinicia contador
        assertFalse(caja.estaBloqueada());
    }

    @Test(expected = IllegalArgumentException.class)
    public void importeNegativoLanzaIllegalArgument() throws EjSaldoInsuficienteException {
        new EjCajaFuerte(100.0).retirar(-10.0);
    }
}
