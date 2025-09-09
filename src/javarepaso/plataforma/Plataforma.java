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

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getCatalogo() {
        return catalogo;
    }



}
