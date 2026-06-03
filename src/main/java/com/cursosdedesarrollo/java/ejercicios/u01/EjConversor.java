package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-5: sobrecarga — mismo nombre de método, distintas firmas.
// El compilador elige la versión correcta en tiempo de compilación según los argumentos.
public class EjConversor {

    // km → millas
    public double convertir(double km) {
        return km * 0.621371;
    }

    // litros + precio por litro → coste total
    public double convertir(double litros, double precioPorLitro) {
        return litros * precioPorLitro;
    }

    // euros + tasa de cambio → moneda destino
    public double convertir(double euros, double tasaCambio, String monedaDestino) {
        return euros * tasaCambio;
    }
}
