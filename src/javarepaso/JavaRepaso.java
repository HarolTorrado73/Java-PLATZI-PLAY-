
package javarepaso;

import javarepaso.contenido.Pelicula;
import javarepaso.plataforma.Plataforma;
import javarepaso.plataforma.Usuario;
import javarepaso.util.ScannerUtils;

public class JavaRepaso {

    public static final String VERSION = "1.0.0"; //constante deben nombrarse en mayusculas
    public static final int SALIR = 5;
    public static final int AGREGAR_PELICULA = 1;
    public static final int MOSTRAR_PELICULAS = 2;
    public static final int BUSCAR_PELICULA = 3;
    public static final int ELIMINAR_PELICULA = 4;

    public static void main(String[] args) {  
        Plataforma plataforma = new Plataforma("Platzi Play");
        System.out.println("PLATZI PLAY 😵‍💫 v" + VERSION);

        //1. Agregar peliculas al catalogo
        //2. Mostrar peliculas
        //3. Buscar por titulo
        //4. Eliminar pelicula
        //5. salir

        while (true) {
            System.out.println("1. Agregar peliculas al catalogo");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Buscar por titulo");
            System.out.println("4. Eliminar pelicula");
            System.out.println("5. salir");

            int opcion = ScannerUtils.capturarEntero("Seleccione una opcion");
            System.out.println("Usted selecciono la opcion: " + opcion);

            if (opcion == SALIR) { //se podria usar un switch tambien
                System.out.println("Gracias por usar Platzi Play 😵‍💫");
                break; //o system.exit(0);
            } else if (opcion == AGREGAR_PELICULA) {
                //Agregar peliculas al catalogo
                System.out.println("Agregar peliculas al catalogo");
                String nombre = ScannerUtils.captrarTExto("nombre del contenido");
                String genero = ScannerUtils.captrarTExto("Genero del contenido");
                int duracion = ScannerUtils.capturarEntero("Duracion del contenido");
                double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");
                 plataforma.agregarPelicula(new Pelicula(nombre, genero, duracion, calificacion));

            } else if (opcion == MOSTRAR_PELICULAS) {
                //Mostrar peliculas
                plataforma.mostrarTitulos();

            } else if (opcion == BUSCAR_PELICULA) {
                //Buscar por titulo
                System.out.println("Buscar por titulo");
                //Falta implementar
            } else if (opcion ==  ELIMINAR_PELICULA) {
                //Eliminar pelicula
            } else {
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

        Usuario usuario = new Usuario("juan", "j@j.com"); //instancia de la clase Usuario
        usuario.nombre = "Juan Perez";
         usuario.ver(pelicula);
    }
}
