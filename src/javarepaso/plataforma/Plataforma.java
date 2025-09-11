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

        //contenido.foreach(pelicula -> System.out.println(pelicula.getTitulo()));//usando lambda igual que el for de arriba
    }

    public void eliminar(Pelicula elemento) {
        this.catalogo.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo) {
    //    for (Pelicula pelicula : catalogo) {
    //        if (pelicula.getTitulo().equalsIgnoreCase(titulo)) { //comparo el titulo ignorando mayusculas y minusculas
    //            return pelicula; //retorno la pelicula si la encuentro
    //        }
    //    }
            return catalogo.stream().filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(titulo))
            .findFirst()
            .orElse(null);
            
            //usando stream y lambda para buscar la pelicula
        //findFirst me busca el primero que encuentre y devuelve un optional por eso uso orElse para devolver null si no la encuentra
    //    return null; //retorno null si no la encuentro
    }
    public List<Pelicula> buscarPorGenero(String genero) {
        return catalogo.stream()
                .filter(pelicula -> pelicula.getGenero().equalsIgnoreCase(genero))
                .toList();
    }
    
    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getCatalogo() {
        return catalogo;
    }



}
