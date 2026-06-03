package com.cursosdedesarrollo.java.ejercicios.u05;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Ejercicio u05-1: Stream API — pipeline completo sobre una lista de pedidos.
// filter, map, groupingBy, mapToDouble, sorted + limit demostrados en métodos separados.
public class EjProcesadorPedidos {

    public static class Pedido {
        private final String cliente;
        private final String categoria;
        private final double importe;

        public Pedido(String cliente, String categoria, double importe) {
            this.cliente   = cliente;
            this.categoria = categoria;
            this.importe   = importe;
        }

        public String getCliente()   { return cliente; }
        public String getCategoria() { return categoria; }
        public double getImporte()   { return importe; }
    }

    // filter + collect
    public static List<Pedido> filtrarPorImporteMinimo(List<Pedido> pedidos, double min) {
        return pedidos.stream()
            .filter(p -> p.getImporte() >= min)
            .collect(Collectors.toList());
    }

    // groupingBy → Map<categoría, lista de pedidos>
    public static Map<String, List<Pedido>> agruparPorCategoria(List<Pedido> pedidos) {
        return pedidos.stream()
            .collect(Collectors.groupingBy(Pedido::getCategoria));
    }

    // mapToDouble + sum → reducción sobre primitivos (sin boxing)
    public static double importeTotal(List<Pedido> pedidos) {
        return pedidos.stream()
            .mapToDouble(Pedido::getImporte)
            .sum();
    }

    // sorted (invertido) + limit → top N
    public static List<Pedido> topNPorImporte(List<Pedido> pedidos, int n) {
        return pedidos.stream()
            .sorted(Comparator.comparingDouble(Pedido::getImporte).reversed())
            .limit(n)
            .collect(Collectors.toList());
    }

    // map a nombre de cliente + distinct → clientes únicos
    public static List<String> clientesUnicos(List<Pedido> pedidos) {
        return pedidos.stream()
            .map(Pedido::getCliente)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }
}
