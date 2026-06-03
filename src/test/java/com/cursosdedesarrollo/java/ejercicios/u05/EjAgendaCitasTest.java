package com.cursosdedesarrollo.java.ejercicios.u05;

import org.junit.Before;
import org.junit.Test;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class EjAgendaCitasTest {

    private static final ZoneId MADRID = ZoneId.of("Europe/Madrid");

    private EjAgendaCitas.Cita citaMañana;
    private EjAgendaCitas.Cita citaTarde;

    @Before
    public void setUp() {
        ZonedDateTime hoy9h  = ZonedDateTime.of(2026, 6, 10,  9, 0, 0, 0, MADRID);
        ZonedDateTime hoy10h = ZonedDateTime.of(2026, 6, 10, 10, 0, 0, 0, MADRID);
        ZonedDateTime hoy15h = ZonedDateTime.of(2026, 6, 10, 15, 0, 0, 0, MADRID);
        ZonedDateTime hoy16h = ZonedDateTime.of(2026, 6, 10, 16, 0, 0, 0, MADRID);

        citaMañana = new EjAgendaCitas.Cita("Reunión", hoy9h, hoy10h);
        citaTarde  = new EjAgendaCitas.Cita("Demo",    hoy15h, hoy16h);
    }

    @Test
    public void duracionEnMinutosEsCorrecta() {
        assertEquals(60L, citaMañana.duracionMinutos());
    }

    @Test
    public void citasDelDiaFiltraCorrectamente() {
        List<EjAgendaCitas.Cita> agenda  = Arrays.asList(citaMañana, citaTarde);
        List<EjAgendaCitas.Cita> delDia  = EjAgendaCitas.citasDelDia(
            agenda, LocalDate.of(2026, 6, 10), MADRID);
        assertEquals(2, delDia.size());
    }

    @Test
    public void citasDelDia_otroDiaDevuelveListaVacia() {
        List<EjAgendaCitas.Cita> agenda = Arrays.asList(citaMañana, citaTarde);
        List<EjAgendaCitas.Cita> otros  = EjAgendaCitas.citasDelDia(
            agenda, LocalDate.of(2026, 6, 11), MADRID);
        assertTrue(otros.isEmpty());
    }

    @Test
    public void enZonaConservaElMismoInstante() {
        ZoneId utc       = ZoneId.of("UTC");
        EjAgendaCitas.Cita enUtc = citaMañana.enZona(utc);
        assertEquals(citaMañana.getInicio().toInstant(), enUtc.getInicio().toInstant());
    }

    @Test
    public void diasHastaProximaCitaCalculaBien() {
        ZonedDateTime ahora    = ZonedDateTime.of(2026, 6, 1, 0, 0, 0, 0, MADRID);
        List<EjAgendaCitas.Cita> agenda = Arrays.asList(citaMañana, citaTarde);
        long dias = EjAgendaCitas.diasHastaProximaCita(agenda, ahora);
        assertEquals(9L, dias); // del 1 al 10 son 9 días
    }

    @Test(expected = IllegalArgumentException.class)
    public void finAntesDeInicioLanzaExcepcion() {
        ZonedDateTime t1 = ZonedDateTime.of(2026, 6, 10, 10, 0, 0, 0, MADRID);
        ZonedDateTime t2 = ZonedDateTime.of(2026, 6, 10,  9, 0, 0, 0, MADRID);
        new EjAgendaCitas.Cita("Mal", t1, t2);
    }
}
