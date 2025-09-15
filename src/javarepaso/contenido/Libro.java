package javarepaso.contenido;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private String idioma;

    public Libro(String titulo, String autor, String genero, int anio, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.idioma = idioma;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public String getIdioma() { return idioma; }

    @Override
    public String toString() {
        return titulo + " | " + autor + " | " + genero + " | " + anio + " | " + idioma;
    }
}
