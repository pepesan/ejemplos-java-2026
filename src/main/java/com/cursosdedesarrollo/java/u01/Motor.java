package com.cursosdedesarrollo.java.u01;

public class Motor {
    private final int cc;
    private boolean encendido = false;

    public Motor(int cc) { this.cc = cc; }

    public void encender()  { encendido = true; }
    public void apagar()    { encendido = false; }
    public boolean isEncendido() { return encendido; }
    public int getCc()      { return cc; }
}
