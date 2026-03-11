package STRINGDos;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine().trim();

        if (frase.isEmpty()) {
            System.out.println("La frase está vacía.");
        } else {
            // Contar palabras (separadas por uno o más espacios)
            String[] palabras = frase.split("\\s+");
            int numPalabras = palabras.length;

            // Sustituir 'a' por 'e'
            String fraseModificada = frase.replace('a', 'e').replace('A', 'E');

            System.out.println("Número de palabras: " + numPalabras);
            System.out.println("Frase modificada: " + fraseModificada);
        }
    }
}
