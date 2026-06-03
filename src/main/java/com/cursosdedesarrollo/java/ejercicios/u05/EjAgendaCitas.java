package com.cursosdedesarrollo.java.ejercicios.u05;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Ejercicio u05-3: java.time — gestionar citas con fechas inmutables y zonas horarias.
// ZonedDateTime para citas con zona; ChronoUnit para duración; withZoneSameInstant para conversión.
public class EjAgendaCitas {

    private static final DateTimeFormatter FMT =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static class Cita {
        private final String        titulo;
        private final ZonedDateTime inicio;
        private final ZonedDateTime fin;

        public Cita(String titulo, ZonedDateTime inicio, ZonedDateTime fin) {
            if (!fin.isAfter(inicio))
                throw new IllegalArgumentException("El fin debe ser posterior al inicio");
            this.titulo = titulo;
            this.inicio = inicio;
            this.fin    = fin;
        }

        public String        getTitulo() { return titulo; }
        public ZonedDateTime getInicio() { return inicio; }
        public ZonedDateTime getFin()    { return fin; }

        public long duracionMinutos() {
            return ChronoUnit.MINUTES.between(inicio, fin);
        }

        // Inmutabilidad: devuelve una nueva Cita con la zona cambiada
        public Cita enZona(ZoneId zona) {
            return new Cita(titulo,
                inicio.withZoneSameInstant(zona),
                fin.withZoneSameInstant(zona));
        }

        @Override
        public String toString() {
            return titulo + " [" + inicio.format(FMT) + " → " + fin.format(FMT) + "]";
        }
    }

    // Filtra las citas de un día concreto en la zona indicada, ordenadas por inicio
    public static List<Cita> citasDelDia(List<Cita> agenda, LocalDate dia, ZoneId zona) {
        return agenda.stream()
            .filter(c -> c.getInicio().withZoneSameInstant(zona).toLocalDate().equals(dia))
            .sorted(Comparator.comparing(Cita::getInicio))
            .collect(Collectors.toList());
    }

    // Días enteros que faltan hasta la próxima cita futura; -1 si no hay ninguna
    public static long diasHastaProximaCita(List<Cita> agenda, ZonedDateTime ahora) {
        return agenda.stream()
            .filter(c -> c.getInicio().isAfter(ahora))
            .mapToLong(c -> ChronoUnit.DAYS.between(ahora, c.getInicio()))
            .min()
            .orElse(-1L);
    }
}
