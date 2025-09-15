package javarepaso.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javarepaso.contenido.Documental;
import javarepaso.contenido.Genero;
import javarepaso.contenido.Idioma;
import javarepaso.contenido.Libro;
import javarepaso.contenido.Pelicula;

public class FileUtils {
    // lee una lista de libros desde un archivo de texto plano, separadas por '|' 
    public static List<Libro> leerLibros(String path) {
        List<Libro> libros = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Path.of(path)); //lee todas las lineas del archivo
            for (String linea : lineas) {
                String l = linea.trim();
                if (l.isEmpty() || l.startsWith("#")) continue;
                String[] partes = l.split("\\|");
                if (partes.length == 5) {
                    String titulo = partes[0].trim();
                    String autor = partes[1].trim();
                    String genero = partes[2].trim();
                    int anio = Integer.parseInt(partes[3].trim());
                    String idioma = partes[4].trim();
                    libros.add(new Libro(titulo, autor, genero, anio, idioma));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer libros: " + e.getMessage());
            return Collections.emptyList();
        }
        return libros;
    }

    // Guarda una lista de películas en un archivo de texto plano, separadas por '|'
    public static void guardarPeliculas(String path, List<Pelicula> peliculas) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (Pelicula p : peliculas) {
            String linea;
            if (p instanceof Documental) {
                Documental d = (Documental) p;
                linea = String.join("|",
                    "DOCUMENTAL",
                    d.getTitulo(),
                    String.valueOf(d.getDuracion()),
                    d.getGenero().name(),
                    String.valueOf(d.getCalificacion()),
                    d.getIdioma().name(),
                    d.getNarrador()
                );
            } else {
                linea = String.join("|",
                    "PELICULA",
                    p.getTitulo(),
                    p.getGenero().name(),
                    String.valueOf(p.getDuracion()),
                    String.valueOf(p.getCalificacion()),
                    p.getIdioma().name()
                );
            }
            lineas.add(linea);
        }
        Files.write(Path.of(path), lineas); //escribe todas las lineas en el archivo .txt
    }

    // se lee una lista de películas desde un archivo de texto plano, separadas por '|'
    public static List<Pelicula> leerPeliculas(String path) throws IOException {
        List<Pelicula> peliculas = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Path.of(path));
        for (String linea : lineas) {
            String l = linea.trim();
            if (l.isEmpty() || l.startsWith("#")) continue;
            String[] partes = l.split("\\|");  // \\| porque | es un caracter especial en expresiones regulares
            if (partes.length == 6 && partes[0].equals("PELICULA")) {
                String titulo = partes[1].trim();
                Genero genero = Genero.valueOf(partes[2].trim().toUpperCase());
                int duracion = Integer.parseInt(partes[3].trim());
                double calificacion = Double.parseDouble(partes[4].trim());
                Idioma idioma = Idioma.valueOf(partes[5].trim().toUpperCase());
                peliculas.add(new Pelicula(titulo, genero, duracion, calificacion, idioma));
            } else if (partes.length == 7 && partes[0].equals("DOCUMENTAL")) {
                String titulo = partes[1].trim();
                int duracion = Integer.parseInt(partes[2].trim());
                Genero genero = Genero.valueOf(partes[3].trim().toUpperCase());
                double calificacion = Double.parseDouble(partes[4].trim());
                Idioma idioma = Idioma.valueOf(partes[5].trim().toUpperCase());
                String narrador = partes[6].trim();
                peliculas.add(new Documental(titulo, genero, duracion, calificacion, idioma, narrador));
            }
        }
        return peliculas;
    }

    // Métodos genéricos para leer y escribir texto plano
    public static void escribirArchivo(String path, String contenido) throws IOException {
        Files.writeString(Path.of(path), contenido);
    }

    public static String leerArchivo(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
