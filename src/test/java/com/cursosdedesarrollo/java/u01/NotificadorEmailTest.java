package com.cursosdedesarrollo.java.u01;

import org.junit.Test;

public class NotificadorEmailTest {
    @Test
    public void enviarEmail() {
        Notificador notificador = new NotificadorEmail();
        notificador.enviar("Mensaje enviada");
        // no puede ejecutar métodos que no están definidos en el interfaz
        // notificadorEmail.diHola();
        NotificadorEmail notificadorEmail = new NotificadorEmail();
        notificadorEmail.enviar("Mensaje enviada");
        // Sí podemos ejecutar métodos definidos en la clase fuera del interfaz
        notificadorEmail.diHola();
    }
}
