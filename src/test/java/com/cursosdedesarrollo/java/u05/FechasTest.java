package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.time.*;
import static org.junit.Assert.*;

public class FechasTest {

    @Test
    public void diasEntreCalculaCorrectamente() {
        LocalDate inicio = LocalDate.of(2025, 1, 1);
        LocalDate fin    = LocalDate.of(2025, 1, 11);
        assertEquals(10, FechasDemo.diasEntre(inicio, fin));
    }

    @Test
    public void formatYParseSonInversos() {
        LocalDateTime dt     = LocalDateTime.of(2025, 6, 15, 10, 30);
        String texto         = FechasDemo.formatear(dt);
        LocalDateTime parsed = FechasDemo.parsear(texto);
        assertEquals(dt, parsed);
    }

    @Test
    public void formatearProduceTextoEsperado() {
        LocalDateTime dt = LocalDateTime.of(2025, 12, 25, 9, 0);
        assertEquals("25/12/2025 09:00", FechasDemo.formatear(dt));
    }

    @Test
    public void convertirZonaPreservaMismoInstante() {
        ZonedDateTime utc    = ZonedDateTime.of(2025, 6, 1, 12, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime madrid = FechasDemo.convertirZona(utc, ZoneId.of("Europe/Madrid"));
        // Madrid está al menos en UTC+1 en verano
        assertTrue(madrid.getHour() >= 13);
        // El instante absoluto es el mismo
        assertEquals(utc.toInstant(), madrid.toInstant());
    }
}
