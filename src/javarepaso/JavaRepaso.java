
package javarepaso;

import javarepaso.contenido.Pelicula;
import javarepaso.plataforma.Plataforma;
import javarepaso.plataforma.Usuario;
import javarepaso.util.ScannerUtils;

public class JavaRepaso {

    public static final String VERSION = "1.0.0"; //constante deben nombrarse en mayusculas

    public static void main(String[] args) {  
        Plataforma plataforma = new Plataforma("Platzi Play");
        System.out.println("PLATZI PLAY 😵‍💫 v" + VERSION);

        String nombre = ScannerUtils.captrarTExto("nombre del contenido");
        String genero = ScannerUtils.captrarTExto("Genero del contenido");
        int duracion = ScannerUtils.capturarEntero("Duracion del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");


        Pelicula pelicula = new Pelicula(nombre, genero, duracion, calificacion); //instancia de la clase Pelicula


        plataforma.agregarPelicula(pelicula);
        System.out.println("Numeros de elementos en el catalogo: " + plataforma.getCatalogo().size()); //importante hacer el getCatalogo

        //pelicula.titulo = "El Señor de los Anillos";
        //pelicula.titulo = nombre ;
        //pelicula.anioEstreno = 2001;
        //pelicula.genero = genero ;
        //pelicula.genero = "Fantasía";
        //pelicula.duracion = duracion ;
        //pelicula.calificacion = calificacion ;
        //pelicula.calificacion = 4.8;
        //pelicula.duracion = 120;
        //System.out.println(pelicula.obtenerFichaTEcnica());

        //long duracion = pelicula.duracion; //o = (int) pelicula.duracion; casteo
        //long numeroDePremios = long.parseLong("12345"); casteo
        //double calificacion = Double.parseDouble("4.5"); casteo si o si double de un lado y del otro


        Usuario usuario = new Usuario("juan", "j@j.com"); //instancia de la clase Usuario
        usuario.nombre = "Juan Perez";
         usuario.ver(pelicula);
    }
}
