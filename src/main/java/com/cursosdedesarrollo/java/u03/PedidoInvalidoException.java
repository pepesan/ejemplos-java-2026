package com.cursosdedesarrollo.java.u03;

// Unidad 03 — Excepción personalizada de dominio (unchecked)
public class PedidoInvalidoException extends RuntimeException {

    private final String pedidoId;

    public PedidoInvalidoException(String pedidoId, String msg) {
        super("Pedido " + pedidoId + ": " + msg);
        this.pedidoId = pedidoId;
    }

    public String getPedidoId() { return pedidoId; }
}
