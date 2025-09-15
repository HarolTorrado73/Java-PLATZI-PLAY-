package javarepaso.plataforma;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javarepaso.contenido.Genero;
import javarepaso.contenido.Idioma;
import javarepaso.contenido.Pelicula;
import javarepaso.contenido.ResumenContenido;

public class Plataforma {
    private String nombre;
    private List<Pelicula> catalogo;
    private Map<Pelicula, Integer> visualizaciones; //mapa que guarda la pelicula y la cantidad de veces que se ha visto

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.catalogo = new java.util.ArrayList<>(); //inicializo el catalogo como una lista vacia
        this.visualizaciones = new java.util.HashMap<>(); //inicializo el mapa de visualizaciones como un mapa vacio HaspMap es hija de Map linea 14
    }

    public void agregarPelicula(Pelicula elemento) {
        Pelicula contenido = this.buscarPorTitulo(elemento.getTitulo());
        if (contenido != null) {
            throw new javarepaso.excepcion.PeliculaExistenteException(elemento.getTitulo());  //throw lanza una excepcion
        }

        this.catalogo.add(elemento);
    }

    public void reproducir(Pelicula catalogo){
        int conteoActual = visualizaciones.getOrDefault(catalogo, 0); //obtengo el conteo actual de visualizaciones o 0 si no existe
        System.out.println("Reproduciendo la película: " + catalogo.titulo + ". Ha sido vista " + (conteoActual + 1) + " veces.");

        //visualizaciones.put(catalogo, conteoActual + 1); //actualizo el conteo de visualizaciones
        //catalogo.reproducir();
        this.contenidoVisualizaciones(catalogo);
    }

    private void contenidoVisualizaciones(Pelicula catalogo) {
        int conteoActual = visualizaciones.getOrDefault(catalogo, 0); //obtengo el conteo actual de visualizaciones o 0 si no existe
        visualizaciones.put(catalogo, conteoActual + 1); //actualizo el conteo de visualizaciones
        catalogo.reproducir();

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
    public List<Pelicula> buscarPorGenero(Genero genero) {
        return catalogo.stream()
                .filter(pelicula -> pelicula.getGenero().equals(genero))
                .toList();
    }

    public List<ResumenContenido> getResumen() {
        return catalogo.stream()
                .filter(pelicula -> !(pelicula instanceof javarepaso.contenido.Documental))
                .map(pelicula -> new ResumenContenido(
                        pelicula.getTitulo(),
                        pelicula.getGenero(),
                        pelicula.getDuracion()
                ))
                .toList(); //map para mapear y toList para convertir el stream en una lista ya que llamamos List<>
    }

    public List<ResumenContenido> getResumenDocumentales() {
        return catalogo.stream()
                .filter(pelicula -> pelicula instanceof javarepaso.contenido.Documental)
                .map(pelicula -> new ResumenContenido(
                        pelicula.getTitulo(),
                        pelicula.getGenero(),
                        pelicula.getDuracion()
                ))
                .toList();
    }

    public List<Pelicula> buscarPorIdioma(Idioma idioma) {
        return catalogo.stream()
                .filter(pelicula -> pelicula.getIdioma().equals(idioma))  //
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
