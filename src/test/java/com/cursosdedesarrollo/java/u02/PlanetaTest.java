package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlanetaTest {

    @Test
    public void nombrePlanetaCoincide() {
        assertEquals("TIERRA", Planeta.TIERRA.name());
    }

    @Test
    public void gravitacionTerrestraAproximada() {
        // g ≈ 9.8 m/s²
        assertEquals(9.8, Planeta.TIERRA.gravedad(), 0.1);
    }

    @Test
    public void gravitacionMarteMenorQueTierra() {
        assertTrue(Planeta.MARTE.gravedad() < Planeta.TIERRA.gravedad());
    }

    @Test
    public void valuesDevuelveTresPlanetas() {
        assertEquals(3, Planeta.values().length);
    }
}
