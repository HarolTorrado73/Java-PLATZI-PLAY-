package javarepaso.plataforma;

import java.util.List;
import javarepaso.contenido.Pelicula; 

public class Plataforma {
    private String nombre;
    private List<Pelicula> catalogo;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.catalogo = new java.util.ArrayList<>(); //inicializo el catalogo como una lista vacia
    }

    public void agregarPelicula(Pelicula elemento) {
        this.catalogo.add(elemento);
    }

    public void mostrarTitulos() {
        for (Pelicula pelicula : catalogo) { //mejor implementar un foreach
            System.out.println(pelicula.getTitulo()); //uso el metodo getTitulo de la clase Pelicula4
            System.out.println(pelicula.obtenerFichaTEcnica());
        }
    }

    public void eliminar(Pelicula elemento) {
        this.catalogo.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo) {
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) { //comparo el titulo ignorando mayusculas y minusculas
                return pelicula; //retorno la pelicula si la encuentro
            }
        }
        return null; //retorno null si no la encuentro
    }
    
    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getCatalogo() {
        return catalogo;
    }



}
