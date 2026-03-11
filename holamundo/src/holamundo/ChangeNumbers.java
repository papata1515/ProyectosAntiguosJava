package holamundo;

import java.util.Random;
import java.util.Scanner;

public class ChangeNumbers {

	private int[] numeros;
	private Random random;
	private Scanner scanner;
	private boolean[] cambiados;

	public ChangeNumbers() {
		numeros = new int[30];
		cambiados = new boolean[30]; // variante del ejercicio guardando registro de los valores cambiados

		random = new Random();
		scanner = new Scanner(System.in);
	}

	// Método para generar los números aleatorios y mostrarlos
	public void generarNumeros() {
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(21); // 0 a 20 inclusive
			System.out.print(numeros[i] + " ");
			cambiados[i] = false; // inicializamos todos a no cambiados

		}
		System.out.println();
	}

	// Método para mostrar array
	public void mostrararray() {
		for (int i = 0; i < numeros.length; i++) {

			System.out.print(numeros[i] + " ");
		}
		System.out.println();
	}

	// Método para mostrar array teniendo en cuenta que los cambiados deben ir
	// entrecomillados
	public void mostrararrayComillas() {
		for (int i = 0; i < numeros.length; i++) {
			if (cambiados[i])
				System.out.print("\"");
			System.out.print(numeros[i]);
			if (cambiados[i])
				System.out.print("\"");
			System.out.print(" ");
		}
		System.out.println();
	}

	// Método para leer los valores y realizar la sustitución mostrando el resultado
	public void reemplazarNumeros() {
		System.out.print("Introduce el número a reemplazar: ");
		int a = scanner.nextInt();
		System.out.print("Introduce el número nuevo: ");
		int b = scanner.nextInt();

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == a) {
				System.out.print("\"" + b + "\" ");
				numeros[i] = b;
				cambiados[i] = true;
			} else {
				System.out.print(numeros[i] + " ");
			}
		}
		System.out.println();
	}

	public void cerrarScanner() {
		scanner.close();
	}

	public static void main(String[] args) {
		ChangeNumbers programa = new ChangeNumbers();
		programa.generarNumeros();
		programa.reemplazarNumeros();
		programa.mostrararray();
		programa.mostrararrayComillas();
		programa.cerrarScanner();
	}
}
