package com.cursosdedesarrollo.java.u01;

public class NotificadorEmail implements Notificador {
    private final java.util.List<String> mensajesEnviados = new java.util.ArrayList<>();

    public void diHola(){
        System.out.println("Hola");
    }
    @Override
    public void enviar(String mensaje) {
        mensajesEnviados.add(mensaje);
    }

    public java.util.List<String> getMensajesEnviados() {
        return java.util.Collections.unmodifiableList(mensajesEnviados);
    }
}
