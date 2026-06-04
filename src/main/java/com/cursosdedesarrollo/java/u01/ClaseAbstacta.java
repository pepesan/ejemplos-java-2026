package com.cursosdedesarrollo.java.u01;

public abstract class ClaseAbstacta {
     private double salarioBase;

    public ClaseAbstacta(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    ClaseAbstacta() {
         this.salarioBase = 0.0;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Método abstacto no implementado
    public abstract String getSalarioCompleto();
}
