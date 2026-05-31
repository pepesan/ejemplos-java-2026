package com.cursosdedesarrollo.java.u05;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// Unidad 05 — java.time: clases inmutables para fechas, horas y zonas horarias
public class FechasDemo {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // ChronoUnit.DAYS.between: diferencia en días entre dos fechas
    public static long diasEntre(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.DAYS.between(inicio, fin);
    }

    // format: convertir LocalDateTime a texto con un patrón
    public static String formatear(LocalDateTime dt) {
        return dt.format(FMT);
    }

    // parse: reconstruir LocalDateTime desde texto (inverso de formatear)
    public static LocalDateTime parsear(String texto) {
        return LocalDateTime.parse(texto, FMT);
    }

    // withZoneSameInstant: mismo instante expresado en otra zona horaria
    public static ZonedDateTime convertirZona(ZonedDateTime origen, ZoneId destino) {
        return origen.withZoneSameInstant(destino);
    }
}
