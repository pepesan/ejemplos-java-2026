package com.cursosdedesarrollo.java.u01;

public class ClaseImplementacion extends ClaseAbstacta{

    @Override
    public String getSalarioCompleto() {
        return this.getSalarioBase() + " €";
    }
}
