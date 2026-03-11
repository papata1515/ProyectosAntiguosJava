package STRINGDos;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine().trim();

        String[] palabras = frase.split("\\s+");
        String resultado = "";

        // Recorrer el array desde el final hasta el principio
        for (int i = palabras.length - 1; i >= 0; i--) {
            resultado += palabras[i] + (i == 0 ? "" : " ");
        }

        System.out.println("Salida: " + resultado);
    }
}
