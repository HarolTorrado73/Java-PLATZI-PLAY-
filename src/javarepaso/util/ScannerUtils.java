package javarepaso.util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in); //no depende de la instancia de la clase
    public static String captrarTExto(String mensaje) {  //si se coloca static seria el unico al que se podria acceder del el main
            System.out.println(mensaje + ":");
            return scanner.nextLine();
    }


    public static int capturarEntero(String mensaje) {
        System.out.println(mensaje);

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
}