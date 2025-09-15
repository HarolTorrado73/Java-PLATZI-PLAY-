package javarepaso.contenido;

public class Subdiviccion extends Pelicula {
    public Subdiviccion(String titulo, Genero genero, int duracion, double calificacion, Idioma idioma) {
        super(titulo, genero, duracion, calificacion, idioma); //herencia del constructor de la clase padre
    }

    public Subdiviccion(String titulo, Genero genero, int duracion, double calificacion) {
        super(titulo, genero, duracion, calificacion); // usa default idioma
    }

}
