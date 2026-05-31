package com.cursosdedesarrollo.java.u02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Unidad 02 — Lectura y escritura de ficheros con NIO.2 y try-with-resources
public class FicherosDemo {

    public static void escribir(Path ruta, List<String> lineas) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }

    public static List<String> leer(Path ruta) throws IOException {
        return Files.readAllLines(ruta, StandardCharsets.UTF_8);
    }

    public static List<String> leerConBuffer(Path ruta) throws IOException {
        List<String> resultado = new java.util.ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                resultado.add(linea);
            }
        }
        return resultado;
    }
}
