package com.cursosdedesarrollo.java.ejercicios.u05;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class EjProcesadorPedidosTest {

    private List<EjProcesadorPedidos.Pedido> pedidos;

    @Before
    public void setUp() {
        pedidos = Arrays.asList(
            new EjProcesadorPedidos.Pedido("Ana",   "Electrónica", 300.0),
            new EjProcesadorPedidos.Pedido("Bob",   "Ropa",         50.0),
            new EjProcesadorPedidos.Pedido("Ana",   "Ropa",         80.0),
            new EjProcesadorPedidos.Pedido("Carlos","Electrónica", 150.0)
        );
    }

    @Test
    public void filtrarPorImporteMinimoDevuelveSoloLosMayores() {
        List<EjProcesadorPedidos.Pedido> resultado =
            EjProcesadorPedidos.filtrarPorImporteMinimo(pedidos, 100.0);
        assertEquals(2, resultado.size());
    }

    @Test
    public void agruparPorCategoriaAgrupaBien() {
        Map<String, List<EjProcesadorPedidos.Pedido>> grupos =
            EjProcesadorPedidos.agruparPorCategoria(pedidos);
        assertEquals(2, grupos.get("Electrónica").size());
        assertEquals(2, grupos.get("Ropa").size());
    }

    @Test
    public void importeTotalSumaCorrectamente() {
        assertEquals(580.0, EjProcesadorPedidos.importeTotal(pedidos), 0.001);
    }

    @Test
    public void topNDevuelveLosNMayores() {
        List<EjProcesadorPedidos.Pedido> top2 =
            EjProcesadorPedidos.topNPorImporte(pedidos, 2);
        assertEquals(2, top2.size());
        assertEquals(300.0, top2.get(0).getImporte(), 0.001);
    }

    @Test
    public void clientesUnicosOrdenados() {
        List<String> clientes = EjProcesadorPedidos.clientesUnicos(pedidos);
        assertEquals(Arrays.asList("Ana", "Bob", "Carlos"), clientes);
    }
}
