package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjFiguraGeometricaTest {

    // ── Figura base ──────────────────────────────────────────────────────────

    @Test
    public void figuraBaseDevuelveCeroPorDefecto() {
        EjFigura f = new EjFigura("Base");
        assertEquals(0.0, f.area(),      0.0);
        assertEquals(0.0, f.perimetro(), 0.0);
    }

    // ── Circulo ──────────────────────────────────────────────────────────────

    @Test
    public void circuloAreaCorrecta() {
        assertEquals(Math.PI * 25, new EjCirculo(5).area(), 0.001);
    }

    @Test
    public void circuloPerimetroCorecto() {
        assertEquals(2 * Math.PI * 5, new EjCirculo(5).perimetro(), 0.001);
    }

    @Test
    public void circuloRadioNegativoSeConvierteEnAbsoluto() {
        assertEquals(Math.PI * 25, new EjCirculo(-5).area(), 0.001);
    }

    // ── Triangulo ────────────────────────────────────────────────────────────

    @Test
    public void trianguloAreaCorrecta() {
        assertEquals(12.0, new EjTriangulo(6, 4, 5, 5, 6).area(), 0.001);
    }

    @Test
    public void trianguloPerimetroCorecto() {
        assertEquals(16.0, new EjTriangulo(6, 4, 5, 5, 6).perimetro(), 0.001);
    }

    // ── Dynamic dispatch ─────────────────────────────────────────────────────

    @Test
    public void dynamicDispatch_variableFiguraEjecutaMetodoDelTipoReal() {
        // La variable es de tipo EjFigura, pero el objeto es un EjCirculo.
        // Java ejecuta EjCirculo.area(), no EjFigura.area() — eso es el dynamic dispatch.
        EjFigura f = new EjCirculo(5);
        assertEquals(Math.PI * 25, f.area(), 0.001);
    }

    @Test
    public void areaTotalSumaFigurasDeDistintoTipo() {
        double total = EjFigura.areaTotal(
            new EjCirculo(1),                        // π
            new EjTriangulo(4, 3, 3, 4, 5)           // 6.0
        );
        assertEquals(Math.PI + 6.0, total, 0.001);
    }

    // ── Herencia ─────────────────────────────────────────────────────────────

    @Test
    public void circuloEsSubtipoDeFigura() {
        assertTrue(new EjCirculo(3) instanceof EjFigura);
    }

    @Test
    public void trianguloEsSubtipoDeFigura() {
        assertTrue(new EjTriangulo(3, 4, 3, 4, 5) instanceof EjFigura);
    }
}
