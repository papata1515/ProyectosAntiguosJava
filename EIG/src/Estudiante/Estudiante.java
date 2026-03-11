package Estudiante;

public class Estudiante {

	/**
	 * rea una clase Estudiante que lleve control global del número de estudiantes
	 * creados. Requisitos: Atributo static public int totalEstudiantes (compartido
	 * por todos los objetos). Atributo static private int maxEstudiantes = 100
	 * (solo accesible dentro de la clase). Atributos de instancia: private String
	 * nombre, private int edad. Constructor public Estudiante(String nombre, int
	 * edad): Incrementa totalEstudiantes automáticamente. Si totalEstudiantes >
	 * maxEstudiantes, lanza IllegalStateException. Método static public int
	 * obtenerTotal(): devuelve totalEstudiantes. Método private static void
	 * resetContador(): pone totalEstudiantes = 0 (solo interno). Getters public
	 * para nombre y edad.
	 */

	/**
	 * Atributo
	 */
	public static int totalEstudiantes;

	/**
	 * Atributo
	 */
	private static int maxEstudiantes = 100;

	/**
	 * atributo privado
	 */
	private String nombre;

	/**
	 * Atributo privado
	 */
	private int edad;

	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		totalEstudiantes++;
		if (totalEstudiantes > maxEstudiantes) {
			throw new IllegalStateException("Máximo de estudiantes alcanzado");
		}

	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	static public int obtenerTotal() {
		return totalEstudiantes;
	}

	public static void resetContador() {
		totalEstudiantes = 0;
	}

}
