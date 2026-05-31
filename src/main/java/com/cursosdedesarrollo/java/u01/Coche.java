package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Composición: Coche crea y controla su Motor
public class Coche {
    private final Motor motor; // Motor no existe sin Coche

    public Coche(int cc) { this.motor = new Motor(cc); }

    public void arrancar() { motor.encender(); }
    public void parar()    { motor.apagar(); }
    public boolean estaArrancado() { return motor.isEncendido(); }
}
