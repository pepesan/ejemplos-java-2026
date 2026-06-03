package com.cursosdedesarrollo.java.ejercicios.u01;

import java.util.Objects;

// Ejercicio u01-6: equals, hashCode y toString por valor
public class EjCoordenada {

    private double latitud;
    private double longitud;

    public EjCoordenada(double latitud, double longitud) {
        this.latitud  = latitud;
        this.longitud = longitud;
    }

    public double getLatitud()  { return latitud; }
    public double getLongitud() { return longitud; }

    public void setLatitud(double latitud)   { this.latitud  = latitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EjCoordenada otra = (EjCoordenada) obj;
        return Double.compare(latitud,  otra.latitud)  == 0
            && Double.compare(longitud, otra.longitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }

    @Override
    public String toString() {
        return "Coordenada{lat=" + latitud + ", lon=" + longitud + "}";
    }
}
