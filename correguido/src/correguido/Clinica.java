package correguido;

import java.util.Scanner;
import java.util.Random;

public class Clinica {
    static Scanner sc = new Scanner(System.in);

    // Atributos de instancia
    int[] Dni;
    int[] Empresa;
    int[] Colesterol;

    // Constantes
    public static final int NUM_PACIENTES = 100;
    public static final int MAXCOLES = 330;
    public static final int MINCOLES = 120;
    public static final int MINDNI = 10000000; // Un DNI suele tener 8 dígitos
    public static final int MAXDNI = 99999999;
    public static final String[] NUMERODEEMPRESAS = { "EmpresaUno", "EmpresaDos", "EmpresaTres", "EmpresaCuatro", "EmpresaCinco" };

    public Clinica() {
        Dni = new int[NUM_PACIENTES];
        Empresa = new int[NUM_PACIENTES];
        Colesterol = new int[NUM_PACIENTES];
        rellenarArray();
    }

    public void rellenarArray() {
        Random ram = new Random();
        for (int i = 0; i < NUM_PACIENTES; i++) {
            Dni[i] = ram.nextInt(MINDNI, MAXDNI);
            Empresa[i] = ram.nextInt(0, NUMERODEEMPRESAS.length);
            Colesterol[i] = ram.nextInt(MINCOLES, MAXCOLES);
        }
    }

    public static int pedirPorPantalla() {
        int numeroPedido;
        do {
            System.out.print("Introduce el número de la empresa (1–5): ");
            numeroPedido = sc.nextInt();
            if (numeroPedido > 5 || numeroPedido < 1) {
                System.out.println("Error: Debes introducir un valor entre 1 y 5.");
            }
        } while (numeroPedido > 5 || numeroPedido < 1);
        return numeroPedido - 1; 
    }

    public double analizarMediaDeEmpresa(int indexEmpresa) {
        double sumaColes = 0;
        int contador = 0;

        for (int i = 0; i < NUM_PACIENTES; i++) {
            if (Empresa[i] == indexEmpresa) {
                sumaColes += Colesterol[i];
                contador++;
            }
        }
        // Evitamos división por cero si una empresa no tiene pacientes asignados
        return (contador == 0) ? 0 : sumaColes / contador;
    }

    /**
     * Buscamos el índice del paciente con el máximo colesterol de una empresa
     */
    public int buscarIndiceMaxColesterol(int indexEmpresa) {
        int maxVal = -1;
        int indiceEncontrado = -1;

        for (int i = 0; i < NUM_PACIENTES; i++) {
            if (Empresa[i] == indexEmpresa) {
                if (Colesterol[i] > maxVal) {
                    maxVal = Colesterol[i];
                    indiceEncontrado = i;
                }
            }
        }
        return indiceEncontrado;
    }

    public void imprimirMediaMaximo(int indexEmpresa) {
        double media = analizarMediaDeEmpresa(indexEmpresa);
        int indiceMax = buscarIndiceMaxColesterol(indexEmpresa);

        System.out.printf("Colesterol medio de la empresa %s: %.2f mg/dL %n", NUMERODEEMPRESAS[indexEmpresa], media);
        
        if (indiceMax != -1) {
            System.out.printf("Colesterol máximo: %d mg/dL (DNI: %08d)%n", Colesterol[indiceMax], Dni[indiceMax]);
        } else {
            System.out.println("No hay datos para esta empresa.");
        }
    }

    public void imprimirCondicionDeSaludGlobal() {
        int opt = 0, norm = 0, pelig = 0;

        for (int i = 0; i < NUM_PACIENTES; i++) {
            if (Colesterol[i] < 200) opt++;
            else if (Colesterol[i] <= 239) norm++;
            else pelig++;
        }
        System.out.println("--- Distribución Global ---");
        System.out.println("Óptimo (<200): " + opt);
        System.out.println("Normal (200-239): " + norm);
        System.out.println("Peligroso (>=240): " + pelig);
    }

    public void imprimirCondicionDeSaludPorEmpresa(int indexEmpresa) {
        int opt = 0, norm = 0, pelig = 0;

        for (int i = 0; i < NUM_PACIENTES; i++) {
            if (Empresa[i] == indexEmpresa) {
                if (Colesterol[i] < 200) opt++;
                else if (Colesterol[i] <= 239) norm++;
                else pelig++;
            }
        }
        System.out.println("=== INFORME PARA: " + NUMERODEEMPRESAS[indexEmpresa] + " ===");
        System.out.println("Óptimo: " + opt + " | Normal: " + norm + " | Peligroso: " + pelig);
    }

    public void imprimirPacientesEnPeligro(int indexEmpresa) {
        System.out.println("Lista de DNI con nivel Peligroso en esta empresa:");
        boolean hayPeligrosos = false;
        for (int i = 0; i < NUM_PACIENTES; i++) {
            if (Empresa[i] == indexEmpresa && Colesterol[i] >= 240) {
                System.out.println("- DNI: " + Dni[i] + " (" + Colesterol[i] + " mg/dL)");
                hayPeligrosos = true;
            }
        }
        if (!hayPeligrosos) System.out.println("Ninguno.");
    }

    public static void main(String[] args) {
        Clinica essalud = new Clinica();
        
        int empresaSeleccionada = pedirPorPantalla();

        System.out.println("\n=== PROCESAMIENTO DE LECTURAS DE COLESTEROL ===");
        essalud.imprimirMediaMaximo(empresaSeleccionada);
        System.out.println();
        
        essalud.imprimirCondicionDeSaludGlobal();
        System.out.println();
        
        essalud.imprimirCondicionDeSaludPorEmpresa(empresaSeleccionada);
        essalud.imprimirPacientesEnPeligro(empresaSeleccionada);
        
        System.out.println("\n=== FIN DEL INFORME ===");
    }
}
