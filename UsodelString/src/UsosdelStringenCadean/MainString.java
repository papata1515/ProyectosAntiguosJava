package UsosdelStringenCadean;

import java.util.Scanner;

public class MainString {

    static Scanner sc = new Scanner(System.in);

    public static String pedirFrase() {
        System.out.print("Escribe algo: ");
        return sc.nextLine();
    }

    public static void main(String[] args) {
        // Instanciamos las clases
        StringUsosUno ejer1 = new StringUsosUno();
        StringUsosDos ejer2 = new StringUsosDos();
        StringUsosTres ejer3 = new StringUsosTres();
        StringUsosCuatro ejer4 = new StringUsosCuatro();
        StringUsosCinco ejer5 = new StringUsosCinco();

        //  Longitud y Vocales
        System.out.println("--- Ejercicio #1 (Análisis) ---");
        String f1 = pedirFrase();
        System.out.println("Letras: " + ejer1.contarLetras(f1));
        System.out.println("Vocales: " + ejer1.contarVocales(f1));

        //  Invertir
        System.out.println("\n--- Ejercicio #2 (Invertir) ---");
        String f2 = pedirFrase();
        System.out.println("Invertida: " + ejer2.invertirFrase(f2));

        //  Palíndromo
        System.out.println("\n--- Ejercicio #3 (Palíndromo) ---");
        String f3 = pedirFrase();
        System.out.println("¿Es palíndromo?: " + (ejer3.esPalindromo(f3) ? "Sí" : "No"));

        // Reemplazo
        System.out.println("\n--- Ejercicio #4 (Reemplazo) ---");
        String f4 = pedirFrase();
        System.out.println("Sin vocales: " + ejer4.cambiarVocales(f4, '*'));

        // Contador de palabras
        System.out.println("\n--- Ejercicio #5 (Palabras) ---");
        String f5 = pedirFrase();
        System.out.println("Total de palabras: " + ejer5.contarPalabras(f5));
        
        System.out.println("\n termino :p ");
    }
}