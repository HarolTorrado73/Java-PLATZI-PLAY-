package javarepaso.util;

import java.util.Scanner;
import javarepaso.contenido.Genero;
import javarepaso.contenido.Idioma;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in); //no depende de la instancia de la clase
    public static String captrarTExto(String mensaje) {  //si se coloca static seria el unico al que se podria acceder del el main
            System.out.println(mensaje + ":");
            return scanner.nextLine();
    }


    public static int capturarEntero(String mensaje) {
        System.out.println(mensaje);

        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            scanner.next(); // Limpiar la entrada inválida
        }

        int dato = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer por el enter que se presiona
        return dato;

    }

    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje);

        double dato = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer por el enter que se presiona
        return dato;

    }

    public static Genero capturarGenero(String mensaje) {
        while (true) {
            System.out.println(mensaje + " (Opciones: ACCION, AVENTURA, COMEDIA, DRAMA, FANTASIA, ROMANCE):");
            String input = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para comparación

            try {
                return Genero.valueOf(input); // Intentar convertir la entrada a un valor de enum
            } catch (IllegalArgumentException e) {
                System.out.println("Género inválido. Por favor, intente de nuevo.");
            } 
            
        }
    }

    public static Idioma capturarIdioma(String mensaje) {
        while (true) {
            System.out.println(mensaje + " (Opciones: ESPANOL, INGLES, FRANCES, ALEMAN, ITALIANO, PORTUGUES):");
            String input = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para comparación

            try {
                return Idioma.valueOf(input); // Intentar convertir la entrada a un valor de enum
            } catch (IllegalArgumentException e) {
                System.out.println("Idioma inválido. Por favor, intente de nuevo.");
            } 
            
        }
    }
}