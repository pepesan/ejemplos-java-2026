package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjFiguraGeometricaTest {

    @Test
    public void circuloAreaCorrecta() {
        EjFiguraGeometrica.Circulo c = new EjFiguraGeometrica.Circulo(5);
        assertEquals(Math.PI * 25, c.area(), 0.001);
    }

    @Test
    public void trianguloAreaCorrecta() {
        EjFiguraGeometrica.Triangulo t = new EjFiguraGeometrica.Triangulo(6, 4, 5, 5, 6);
        assertEquals(12.0, t.area(), 0.001);
    }

    @Test
    public void polimorfismo_areaTotalSumaTodasLasFiguras() {
        // Varargs: no se necesita List (que se ve en u02)
        double total = EjFiguraGeometrica.areaTotal(
            new EjFiguraGeometrica.Circulo(1),              // π
            new EjFiguraGeometrica.Triangulo(4, 3, 3, 4, 5) // 6.0
        );
        assertEquals(Math.PI + 6.0, total, 0.001);
    }

    @Test
    public void herencia_circuloEsSubtipoDeFigura() {
        EjFiguraGeometrica.Figura f = new EjFiguraGeometrica.Circulo(3);
        assertNotNull(f);
        assertTrue(f instanceof EjFiguraGeometrica.Figura);
    }
}
