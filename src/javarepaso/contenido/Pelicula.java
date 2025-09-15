
package javarepaso.contenido;

public class Pelicula {
    public String titulo;  //los string si no se asignan son null
    public Genero genero;  //los enum se definen como un tipo de dato
    public int duracion; // duracion en minutos
    public String descripcion;
    public int anioEstreno;
    public double calificacion;
    public boolean disponible;
    public Idioma idioma; //agrego el atributo idioma de tipo enum


    //contructor
    public Pelicula(String titulo, Genero genero, int duracion, double calificacion, Idioma idioma) {
        //operaciones iniciales
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion; //a los atributos de mi clase le asigno los valores que me pasan por parametro
        this.disponible = true; //por defecto las peliculas estan disponibles
        this.calificar(calificacion);
        this.idioma = idioma;
    }

    public Pelicula(String titulo, Genero genero, int duracion, double calificacion) {
        this(titulo, genero, duracion, calificacion, Idioma.ESPANOL); // default idioma
    }
    
    // public boolean disponible = true; //por defecto las peliculas estan disponibles
    public void reproducir() {
        System.out.println("Reproduciendo la película: " + titulo);
    }

    public String obtenerFichaTEcnica (){
        return titulo + (" (" + anioEstreno + ")\n" +
        "Calificación: " + calificacion + "/5 \n"
        + "Genero: " + genero );
    }

    public void calificar(double calificacion) {
        if (calificacion >= 0 && calificacion <= 5) {
            this.calificacion = calificacion; // Actualiza la calificación si es válida
        } else {
            System.out.println("Calificación inválida. Debe estar entre 0 y 5.");
        }
    }

    public boolean esPopular () {
        return calificacion >= 4.0;
    }

    public String getTitulo() {
        System.out.println("la película: " + titulo);
        return titulo;

    }

    //public void setTitulo( String titulo) {
        //this.titulo = titulo; asi no por  que se puede cambiar el titulo de la pelicula
    //}

    public Genero getGenero() {
        return genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean isDisponible() { //los boolean se colocan is en los getter
        return disponible;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    //es mejor tener esto en la parte de abajo que son los getter y setters

}
