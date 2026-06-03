package com.cursosdedesarrollo.java.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class PilaresPooTest {

    // Herencia
    @Test
    public void perroesTipoPerro() {
        Perro a = new Perro("Rex", "Podenco");
        assertNotNull(a);
        assertTrue(a instanceof Perro);
    }
    // Herencia
    @Test
    public void perroEsSubtipoDeAnimal() {
        Animal a = new Perro("Rex", "Podenco");
        assertNotNull(a);
        assertTrue(a instanceof Animal);
    }

    // Polimorfismo — dynamic dispatch
    @Test
    public void dinamicDispatchEjecutaMetodoDelTipoReal() {
        Animal perro = new Perro("Rex", "Podenco");
        Animal gato  = new Gato("Misi", 2L);
        assertEquals("Guau!", perro.hacerSonido());
        assertEquals("Miau!", gato.hacerSonido());
    }

    // Abstracción — el llamador trabaja con la interfaz
    @Test
    public void pedidoServicioUsaNotificadorPorAbstraccion() {
        NotificadorEmail email = new NotificadorEmail();
        PedidoServicio   svc   = new PedidoServicio(email);
        svc.confirmar("P-001");
        assertEquals(1, email.getMensajesEnviados().size());
        assertTrue(email.getMensajesEnviados().get(0).contains("P-001"));
    }

    // Composición
    @Test
    public void cocheArrancarEnciendeSuMotor() {
        Coche c = new Coche(1600);
        assertFalse(c.estaArrancado());
        c.arrancar();
        assertTrue(c.estaArrancado());
        c.parar();
        assertFalse(c.estaArrancado());
    }

    // Interfaces vs abstractas
    @Test
    public void empleadoFijoCalculaPagoIgualASalarioBase() {
        EmpleadoFijo e = new EmpleadoFijo("Ana", 2000.0);
        assertEquals(2000.0, e.calcularPago(), 0.001);
    }

    @Test
    public void empleadoPorHorasCalculaPagoPorHoras() {
        EmpleadoPorHoras e = new EmpleadoPorHoras("Bob", 15.0, 160);
        assertEquals(2400.0, e.calcularPago(), 0.001);
    }

    @Test
    public void resumenDefaultMethodDevuelveTextoLegible() {
        Pagable e = new EmpleadoFijo("Eva", 1800.0);
        assertTrue(e.resumen().contains("1800"));
    }
}
