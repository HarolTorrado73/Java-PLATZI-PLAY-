package javarepaso.contenido;

public class Documental extends Subdiviccion implements Promocionable { //hereda de Subdiviccion
    private String narrador;

    public Documental(String titulo, Genero genero, int duracion, double calificacion) {
        super(titulo, genero, duracion, calificacion);
    }

    public Documental(String titulo, Genero genero, int duracion, double calificacion, Idioma idioma, String narrador) {
        super(titulo, genero, duracion, calificacion, idioma); //herencia del constructor de la clase padre
        this.narrador = narrador; //muy importante despues de super
    }
    @Override
    public String promocionar() {
        return "No te pierdas el documental " + this.getTitulo() + " narrado por " + narrador + ". ¡Una experiencia educativa y fascinante!";
    }

    public String getNarrador() {
        return narrador;
    }

}
