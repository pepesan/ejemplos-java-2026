package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuentaBancariaTest {

    @Test
    public void saldoInicialEsCero() {
        assertEquals(0.0, new CuentaBancaria().getSaldo(), 0.001);
    }

    @Test
    public void depositarAumentaSaldo() {
        CuentaBancaria c = new CuentaBancaria();
        c.depositar(100);
        assertEquals(100.0, c.getSaldo(), 0.001);
    }

    @Test
    public void depositarImporteNegativoNoActualiza() {
        CuentaBancaria c = new CuentaBancaria();
        c.depositar(-50);
        assertEquals(0.0, c.getSaldo(), 0.001);
    }

    @Test
    public void retirarConSaldoSuficienteDevuelveTrue() {
        CuentaBancaria c = new CuentaBancaria();
        c.depositar(200);
        assertTrue(c.retirar(100));
        assertEquals(100.0, c.getSaldo(), 0.001);
    }

    @Test
    public void retirarMasQueSaldoDevuelveFalseYMantieneSaldo() {
        CuentaBancaria c = new CuentaBancaria();
        c.depositar(50);
        assertFalse(c.retirar(100));
        assertEquals(50.0, c.getSaldo(), 0.001);
    }

    @Test
    public void retirarImporteNegativoDevuelveFalseYNoAlteraSaldo() {
        CuentaBancaria c = new CuentaBancaria();
        c.depositar(100);
        assertFalse(c.retirar(-50));
        assertEquals(100.0, c.getSaldo(), 0.001);
    }

    @Test
    public void retirarCeroDevuelveFalse() {
        CuentaBancaria c = new CuentaBancaria();
        c.depositar(100);
        assertFalse(c.retirar(0));
        assertEquals(100.0, c.getSaldo(), 0.001);
    }
}
