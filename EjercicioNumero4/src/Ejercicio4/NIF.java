package Ejercicio4;

public class NIF {

	/**
	 * Diseña una clase NIF que gestione un DNI con su letra. Requisitos: Atributos
	 * privados: numero (int, 8 dígitos máximo). letra (char). Constructores:
	 * NIF(int numero) que calcule automáticamente la letra. Constructor de copia
	 * NIF(NIF otro). Encapsulación: getters getNumero(), getLetra() y un método
	 * getNIFCompleto() que devuelva algo como "12345678Z". Métodos estáticos
	 * auxiliares: static char calcularLetra(int numero) con el algoritmo típico.
	 * Usa this para diferenciar parámetros de atributos en los constructores y
	 * setters.
	 */

	/**
	 * atributos privados
	 */
	private int numero;
	private char letra;

	/**
	 * constructor que recibe el numero y calcula la letra
	 */
	public NIF(int numero) {
		this.numero = numero;
		this.letra = calcularLetra(numero);
	}

	/**
	 * constructor de copia
	 */
	public NIF(NIF otro) {
		this.numero = otro.numero;
		this.letra = otro.letra;
	}

	/**
	 * getter del numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * getter de la letra
	 */
	public char getLetra() {
		return letra;
	}

	/**
	 * devuelve el nif con el formato completo
	 */
	public String getNIFCompleto() {
		return this.numero + "" + this.letra;
	}

	/**
	 * metodo estatico que calcula la letra segun el numero
	 */
	public static char calcularLetra(int numero) {
		String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
		int indice = numero % 23;
		return letrasValidas.charAt(indice);
	}
}
