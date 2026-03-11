package STRINGDos;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una fecha (dd/mm/yyyy): ");
        String fecha = sc.nextLine();

        // Extraer subcadenas manualmente por posición
        // dd/mm/yyyy -> 0123456789 (índices)
        String diaStr = fecha.substring(0, 2);
        String mesStr = fecha.substring(3, 5);
        String anioStr = fecha.substring(6, 10);

        int dia = Integer.parseInt(diaStr);
        
        System.out.println("Día: " + diaStr);
        System.out.println("Mes: " + mesStr);
        System.out.println("Año: " + anioStr);

        if (dia > 15) {
            System.out.println("El día es mayor que 15.");
        } else {
            System.out.println("El día no es mayor que 15.");
        }
    }
}
