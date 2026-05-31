package com.cursosdedesarrollo.java.u05;

import org.junit.Test;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static org.junit.Assert.*;

public class FechasTest {

    @Test
    public void localDateOfCreaFechaCorrecta() {
        LocalDate navidad = LocalDate.of(2025, Month.DECEMBER, 25);
        assertEquals(12, navidad.getMonthValue());
        assertEquals(25, navidad.getDayOfMonth());
    }

    @Test
    public void daysBetweenCalcula() {
        LocalDate inicio = LocalDate.of(2025, 1, 1);
        LocalDate fin    = LocalDate.of(2025, 1, 11);
        assertEquals(10, ChronoUnit.DAYS.between(inicio, fin));
    }

    @Test
    public void formatYParseSonInversos() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dt      = LocalDateTime.of(2025, 6, 15, 10, 30);
        String texto          = dt.format(fmt);
        LocalDateTime parsed  = LocalDateTime.parse(texto, fmt);
        assertEquals(dt, parsed);
    }

    @Test
    public void zonedDateTimeConvierteZonas() {
        ZonedDateTime utc    = ZonedDateTime.of(2025, 6, 1, 12, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime madrid = utc.withZoneSameInstant(ZoneId.of("Europe/Madrid"));
        // Madrid está al menos UTC+1
        assertTrue(madrid.getHour() >= 13);
    }
}
