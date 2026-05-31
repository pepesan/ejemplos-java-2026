package com.cursosdedesarrollo.java.u02;

// Unidad 02 — Enum con campos y comportamiento
public enum Planeta {
    MERCURIO(3.303e+23, 2.4397e6),
    TIERRA  (5.976e+24, 6.37814e6),
    MARTE   (6.421e+23, 3.3972e6);

    private static final double G = 6.674e-11;

    private final double masa;   // kg
    private final double radio;  // metros

    Planeta(double masa, double radio) {
        this.masa  = masa;
        this.radio = radio;
    }

    public double getMasa()   { return masa; }
    public double getRadio()  { return radio; }

    public double gravedad() {
        return G * masa / (radio * radio);
    }
}
