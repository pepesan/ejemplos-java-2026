package com.cursosdedesarrollo.java.u02;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FicherosTest {

    @Rule
    public TemporaryFolder tmp = new TemporaryFolder();

    @Test
    public void escribirYLeerDevuelveMismasLineas() throws IOException {
        Path ruta = tmp.newFile("test.txt").toPath();
        List<String> lineas = Arrays.asList("Línea 1", "Línea 2", "Línea 3");
        FicherosDemo.escribir(ruta, lineas);
        List<String> leidas = FicherosDemo.leer(ruta);
        assertEquals(lineas, leidas);
    }

    @Test
    public void leerConBufferDevuelveMismoResultado() throws IOException {
        Path ruta = tmp.newFile("buf.txt").toPath();
        List<String> lineas = Arrays.asList("A", "B");
        FicherosDemo.escribir(ruta, lineas);
        assertEquals(lineas, FicherosDemo.leerConBuffer(ruta));
    }
}
