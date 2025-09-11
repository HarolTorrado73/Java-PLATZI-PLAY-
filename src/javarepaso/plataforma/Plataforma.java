package javarepaso.plataforma;

import java.util.Comparator;
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

    public List<String> mostrarTitulos() {
        return catalogo.stream().map(Pelicula::getTitulo).toList();//map para mapear y toList para convertir el stream en una lista
        

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

    public List<Pelicula> getPopulare(int cantidad) {
        return catalogo.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed()) //ordeno de mayor a menor
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getPeliculaLarga (int cantidad) {
        return catalogo.stream()
                .sorted(Comparator.comparingInt(Pelicula::getDuracion).reversed()) //ordeno de mayor a menor
                .limit(cantidad)
                .toList();
    }
    

    public int getDuracionTotal() {
        return catalogo.stream()
                .mapToInt(Pelicula::getDuracion) //mapToInt para convertir a int
                .sum(); //sum para sumar todos los elementos
    }
    
    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getCatalogo() {
        return catalogo;
    }



}
