package Estudiante;

public class mainEstudiantes {
	public static void main(String[] args) {

		System.out.println("Inicio del programa. Estudiantes actuales: " + Estudiante.obtenerTotal());

		// 1. Creamos objetos
		Estudiante e1 = new Estudiante("Ana", 20);
		Estudiante e2 = new Estudiante("Luis", 22);

		// 2. Probamos el método static público
		System.out.println("Total tras crear 2 estudiantes: " + Estudiante.obtenerTotal());

		Estudiante.resetContador();

	}
}
