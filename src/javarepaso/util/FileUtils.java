package javarepaso.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javarepaso.contenido.Genero;
import javarepaso.contenido.Idioma;
import javarepaso.contenido.Pelicula;

public class FileUtils {
    public static final String PATH = "src/contenido.txt";

    public static String leerArchivo(String path) throws IOException {
        try {
            List<String> Lineas = Files.readAllLines(Path.of(PATH));

            Lineas.forEach(linea -> {
                if (!linea.trim().isEmpty()) { // Verifica que la línea no esté vacía
                    String[] partes = linea.split(","); // Suponiendo que los campos están separados por comas
                    if (partes.length == 5) { // Asegúrate de que haya suficientes partes
                        String titulo = partes[0].trim(); // Eliminar espacios en blanco alrededor
                        Genero genero = Genero.valueOf(partes[1].trim().toUpperCase()); // Convertir a mayúsculas para que coincida con el enum
                        int duracion = Integer.parseInt(partes[2].trim());  // Convertir a entero
                        double calificacion = Double.parseDouble(partes[3].trim());
                        Idioma idioma = Idioma.valueOf(partes[4].trim().toUpperCase());

                        try {
                            plataforma.agregarPelicula(new Pelicula(titulo, genero, duracion, calificacion, idioma));
                        } catch (javarepaso.excepcion.PeliculaExistenteException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Línea con formato incorrecto: " + linea);
                    }
                }
            });
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de contenido: " + e.getMessage());
            return; // Salir del método si hay un error al leer el archivo
        }

        return null;

    }

}
