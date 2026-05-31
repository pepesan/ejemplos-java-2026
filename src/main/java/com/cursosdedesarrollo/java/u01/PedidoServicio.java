package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Abstracción: el llamador depende de la abstracción
public class PedidoServicio {
    private final Notificador notificador;

    public PedidoServicio(Notificador notificador) {
        this.notificador = notificador;
    }

    public void confirmar(String referencia) {
        notificador.enviar("Pedido " + referencia + " confirmado");
    }
}
