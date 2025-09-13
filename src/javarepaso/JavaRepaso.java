
package javarepaso;

import java.util.List;
import javarepaso.contenido.Pelicula;
import javarepaso.contenido.Genero;
import javarepaso.contenido.Idioma;
import javarepaso.plataforma.Plataforma;
import javarepaso.util.ScannerUtils;

public class JavaRepaso {

    public static final String VERSION = "1.0.0"; //constante deben nombrarse en mayusculas
    public static final int SALIR = 9;
    public static final int AGREGAR_PELICULA = 1;
    public static final int MOSTRAR_PELICULAS = 2;
    public static final int BUSCAR_PELICULA = 3;
    public static final int BUSCAR_GENERO = 4;
    public static final int BUSCAR_IDIOMA = 5;
    public static final int ELIMINAR_PELICULA = 8;

    public static void main(String[] args) {  
    Plataforma plataforma = new Plataforma("Platzi Play");
        System.out.println("PLATZI PLAY 😵‍💫 v" + VERSION);

        //1. Agregar peliculas al catalogo
        //2. Mostrar peliculas
        //3. Buscar por titulo
        //4. Eliminar pelicula
        //5. salir
    cargarPeliculas(plataforma);

        while (true) {
            System.out.println("1. Agregar peliculas al catalogo");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Buscar por titulo");
            System.out.println("4. Buscar por genero");
            System.out.println("5. Buscar por idioma");
            System.out.println("8. Eliminar pelicula");
            System.out.println("9. salir");

            int opcion = ScannerUtils.capturarEntero("Seleccione una opcion");
            System.out.println("Usted selecciono la opcion: " + opcion);

            if (opcion == SALIR) { //se podria usar un switch tambien
                System.out.println("Gracias por usar Platzi Play 😵‍💫");
                break; //o system.exit(0);


            } else if (opcion == AGREGAR_PELICULA) {
                //Agregar peliculas al catalogo
                System.out.println("Agregar peliculas al catalogo");
                String nombre = ScannerUtils.captrarTExto("nombre del contenido");
                Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                int duracion = ScannerUtils.capturarEntero("Duracion del contenido");
                double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");
                Idioma idioma = ScannerUtils.capturarIdioma("Idioma del contenido");
                plataforma.agregarPelicula(new Pelicula(nombre, genero, duracion, calificacion, idioma));

            } else if (opcion == MOSTRAR_PELICULAS) {   
                //Mostrar peliculas
                plataforma.mostrarTitulos();

            } else if (opcion == BUSCAR_PELICULA) {
                //Buscar por titulo
                String nombreBuscado = ScannerUtils.captrarTExto("Ingrese el titulo de la pelicula a buscar");
                Pelicula peliculaEncontrada = plataforma.buscarPorTitulo(nombreBuscado);
                if (peliculaEncontrada != null) {
                    System.out.println("Pelicula encontrada: " + peliculaEncontrada.getTitulo());
                } else {
                    System.out.println(nombreBuscado + " - Pelicula no encontrada");
                }
            } else if (opcion ==  ELIMINAR_PELICULA) {
                //Eliminar pelicula
                String nombreAEliminar = ScannerUtils.captrarTExto("Ingrese el titulo de la pelicula a eliminar");
                Pelicula peliculaAEliminar = plataforma.buscarPorTitulo(nombreAEliminar);
                if (peliculaAEliminar != null) {
                    plataforma.eliminar(peliculaAEliminar);
                    System.out.println("Pelicula eliminada: " + peliculaAEliminar.getTitulo());
                } else {
                    System.out.println("Pelicula no encontrada");
                }

            } else if (opcion ==  BUSCAR_GENERO) {
                Genero generoBuscado = ScannerUtils.capturarGenero("Ingrese el genero de la pelicula a buscar");
                List<Pelicula> peliculasPorGenero = plataforma.buscarPorGenero(generoBuscado);
                System.out.println(peliculasPorGenero.size() + " Peliculas encontradas del genero " + generoBuscado + ":");
                peliculasPorGenero.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTEcnica()));
            }else if (opcion ==  BUSCAR_IDIOMA) {
                Idioma idiomaBuscado = ScannerUtils.capturarIdioma("Ingrese el idioma de la pelicula a buscar");
                List<Pelicula> peliculasPorIdioma = plataforma.buscarPorIdioma(idiomaBuscado);
                System.out.println(peliculasPorIdioma.size() + " Peliculas encontradas en el idioma " + idiomaBuscado + ":");
                peliculasPorIdioma.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTEcnica()));
            }
            
            else {
                System.out.println("Opcion no valida");
            }
            
        }

       


        //Pelicula pelicula = new Pelicula(nombre, genero, duracion, calificacion); //instancia de la clase Pelicula
        //Pelicula pelicula2 = new Pelicula("Avatar", "Ciencia Ficcion", 162, 4.5); //instancia de la clase Pelicula


        //plataforma.agregarPelicula(pelicula);
        //plataforma.agregarPelicula(pelicula2);
        //System.out.println("Numeros de elementos en el catalogo: " + plataforma.getCatalogo().size()); //importante hacer el getCatalogo
        //pelicula.eliminar(pelicula2);

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

        //plataforma.mostrarTitulos();

        //Usuario usuario = new Usuario("juan", "j@j.com"); //instancia de la clase Usuario
        //usuario.nombre = "Juan Perez";
         //usuario.ver(pelicula);
    }
    private static void cargarPeliculas(Plataforma plataforma){
        plataforma.agregarPelicula(new Pelicula("El Señor de los Anillos", Genero.FANTASIA, 120, 4.8, Idioma.ESPANOL));
        plataforma.agregarPelicula(new Pelicula("Avatar", Genero.ACCION, 162, 4.5, Idioma.ESPANOL));
        plataforma.agregarPelicula(new Pelicula("Titanic", Genero.DRAMA, 194, 4.1, Idioma.INGLES));
        plataforma.agregarPelicula(new Pelicula("Interestelar", Genero.ACCION, 169, 4.6, Idioma.INGLES));
        plataforma.agregarPelicula(new Pelicula("Matrix", Genero.ACCION, 136, 4.7, Idioma.INGLES));
    }   
    }