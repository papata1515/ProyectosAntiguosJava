package Ejercicio4;

public class PruebaClasesPOO {

	/**
	 * Crea una clase PruebaClasesPOO con un método main que instancie objetos de
	 * todas las clases, llame a sus constructores sobrecargados, métodos
	 * encapsulados y demuestre sobrecarga. El programa debe mostrar por consola
	 * resultados que verifiquen el comportamiento correcto (sin errores de
	 * compilación ni runtime). Incluye manejo básico de casos límite (ej. valores
	 * negativos).
	 */

	public static void main(String[] args) {

		// --- Prueba Punto ---
		System.out.println("--- Prueba Punto ---");
		Punto pOrigen = new Punto();
		System.out.println("Punto origen: (" + pOrigen.getX() + "," + pOrigen.getY() + "), distancia: "
				+ pOrigen.distanciaOrigen());

		Punto p1 = new Punto(3, 4);
		System.out.println("Punto (3,4): distancia " + p1.distanciaOrigen());

		p1.mover(2, 1);
		System.out.println("Tras mover(2,1): (" + p1.getX() + "," + p1.getY() + ")");
		System.out.println();

		// --- Prueba Rectángulo ---
		System.out.println("--- Prueba Rectángulo ---");
		Rectangulo r1 = new Rectangulo(10, 5);
		System.out.println("Rectángulo (10x5): área " + r1.area() + ", perímetro " + r1.perimetro());

		r1.redimensionar(2.0);
		System.out.println("Tras redimensionar(2.0): área " + r1.area());
		System.out.println();

		// --- Prueba CuentaBancaria ---
		System.out.println("--- Prueba CuentaBancaria ---");
		CuentaBancaria cuenta = new CuentaBancaria("Juan", 1000.0);
		System.out.println("Cuenta de " + cuenta.getTitular() + ": saldo " + cuenta.getSaldo());

		cuenta.ingresar(500);
		System.out.println("Tras ingresar 500: " + cuenta.getSaldo());

		cuenta.retirar(200);
		System.out.println("Tras retirar 200: " + cuenta.getSaldo());
		System.out.println();

		// --- Prueba NIF ---
		System.out.println("--- Prueba NIF ---");
		NIF miNif = new NIF(12345678);
		System.out.println("NIF 12345678: " + miNif.getNIFCompleto());

		char letraCalculada = NIF.calcularLetra(87654321);
		System.out.println("Letra calculada para 87654321: " + letraCalculada);
	}
}
