package com.cursosdedesarrollo.java.u01;

import java.util.Objects;

public class ClaseEquals extends Object{
    String valor;
    String otroValor;

    public ClaseEquals(String valor, String otroValor) {
        this.valor = valor;
        this.otroValor = otroValor;
    }

    public ClaseEquals() {
        this.valor = "";
        this.otroValor = "";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getOtroValor() {
        return otroValor;
    }

    public void setOtroValor(String otroValor) {
        this.otroValor = otroValor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClaseEquals that = (ClaseEquals) o;
        return Objects.equals(valor, that.valor) && Objects.equals(otroValor, that.otroValor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, otroValor);
    }

    @Override
    public String toString() {
        return "ClaseEquals{" +
                "valor='" + valor + '\'' +
                ", otroValor='" + otroValor + '\'' +
                '}';
    }
}
