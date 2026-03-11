package STRINGDos;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce (formato 'altura:1.75 peso:70.5'): ");
        String entrada = sc.nextLine();

        try {
            // Localizar las posiciones de los datos
            int idxAltura = entrada.indexOf("altura:") + 7;
            int espacio = entrada.indexOf(" ", idxAltura);
            int idxPeso = entrada.indexOf("peso:") + 5;

            // Extraer subcadenas
            String sAltura = entrada.substring(idxAltura, espacio);
            String sPeso = entrada.substring(idxPeso);

            // Convertir a double
            double altura = Double.parseDouble(sAltura);
            double peso = Double.parseDouble(sPeso);

            // Calcular IMC
            double imc = peso / (altura * altura);
            String clasificacion = "";

            if (imc < 18.5) clasificacion = "Bajo";
            else if (imc < 25) clasificacion = "Normal";
            else if (imc < 30) clasificacion = "Sobrepeso";
            else clasificacion = "Obeso";

            System.out.printf("Su IMC es: %.2f - Clasificación: %s%n", imc, clasificacion);

        } catch (Exception e) {
            System.out.println("Error: El formato de entrada es incorrecto o los valores no son numéricos.");
        }
    }
}
