package javarepaso.excepcion;

public class PeliculaExistenteException extends RuntimeException {
    public PeliculaExistenteException(String titulo) { //constructor que recibe un mensaje
        super("La pelicula " + titulo + " ya existe"); //super termino de herencia que llama al constructor de la clase padre (RuntimeException)
    }


}
