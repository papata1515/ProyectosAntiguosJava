package radar;

import java.util.Random;

public class radar2 {

	private final int FILA = 7;
	private final int COLUMNA = 100;
	private int[][] Matriz;


	public radar2() {

		this.Matriz = new int[FILA][COLUMNA];
	}

	public void CargarLaMatriz() {
		Random generador = new Random();
		for (int i = 0; i < FILA; i++) {

			for (int j = 0; j < COLUMNA; j++) {

				// Generamos una velocidad aleatoria entre 70 y 200.
				// La fórmula es: random.nextInt(max - min + 1) + min
				// (200 - 70 + 1) = 131. Así genera un núm ero entre 0 y 130, y le sumamos 70.
				int velocidadAleatoria = generador.nextInt(131) + 70;

				// Guardamos el valor en la posición correspondiente de la matriz.
				this.Matriz[i][j] = velocidadAleatoria;
			}
			System.out.println("");
		}
	}

	public void MostrarPorPantalla() {
		System.out.println("------------------------------------------------------");

		for (int i = 0; i < FILA; i++) {
			for (int j = 0; j < COLUMNA; j++) {
				System.out.print(Matriz[i][j] + "\t");

			}
			System.out.println("");
		}
		System.out.println("------------------------------------------------------");

	}

	public void Realizar() {

		int maxVelocidadSemanal = 0;
		double sumaVelocidadesSemanal = 0; // Usamos double para decimales
		int totalMultasSemanal = 0;
		int diaConMasMultas = 0;
		int maxMultasEnUnDia = 0; // Para comparar y encontrar el día con más multas
		int totalCochesSemana = FILA * COLUMNA;

		// Recorremos cada día (FILAS)
		for (int i = 0; i < FILA; i++) {

			// para reinciar el el dia
			int maxDia = 0;
			double sumaDia = 0;
			int multasDia = 0;

			// Recorremos los coches de ese día (COLUMNAS)
			for (int j = 0; j < COLUMNA; j++) {
				// Sacamos la velocidad actual de la matriz para trabajar con ella
				int velocidadActual = this.Matriz[i][j];

				// Buscamos el máximo del día
				if (velocidadActual > maxDia) {
					maxDia = velocidadActual;
				}

				// Sumamos para luego calcular la media
				sumaDia = sumaDia + velocidadActual;

				// Comprobamos si merece multa (mayor a 120 km/h)
				if (velocidadActual > 120) {
					multasDia++; // Incrementamos el contador de multas del día
				}
			} // Fin del bucle de coches

			// --- DÍA
			double mediaDia = sumaDia / COLUMNA;

			// imprimimos
			System.out.println("Día " + (i + 1) + ":");// podemos 1-7 pero como comipenza en ponemos + 1
			System.out.println(" Máx velocidad: " + maxDia + " km/h");
			System.out.println(" Velocidad media:" + mediaDia + " km/h");

			System.out.println("  Multas: " + multasDia);
			System.out.println("-----------------------------");

			// --- SEMANA--

			// Actualizamos la máxima semanal si la de hoy fue mayor
			if (maxDia > maxVelocidadSemanal) {
				maxVelocidadSemanal = maxDia;
			}
			
			// Sumamos el total de velocidades de hoy al total semanal
			sumaVelocidadesSemanal += sumaDia;

			// Sumamos las multas de hoy al total semanal
			totalMultasSemanal += multasDia;

			// Comprobamos si hoy fue el día con más multas de la semana
			if (multasDia > maxMultasEnUnDia) {
				maxMultasEnUnDia = multasDia;
				diaConMasMultas = (i + 1); // Guardamos qué día fue (1 al 7)
			}
		}

		// Semana-----
		// cambiamos un double para que no pete si es decimal
		double mediaSemanal = sumaVelocidadesSemanal / totalCochesSemana;

		System.out.println("\n--- SEMANAL ---");
		System.out.println("Máxima velocidad registrada: " + maxVelocidadSemanal + " km/h");
		System.out.println("Velocidad media: " + mediaSemanal);
		System.out.println("Total de multas a enviar: " + totalMultasSemanal);
		System.out.println("El día con más multas : " + diaConMasMultas + " [" + maxMultasEnUnDia + " multas]");
	}

	public void RealizarxDia (){

		for (int i = 0; i < FILA; i++) {
			for (int j = 0; j < COLUMNA; j++) {
				// Sacamos la velocidad actual de la matriz para trabajar con ella
				int velocidadActual = this.Matriz[i][j];

				// Buscamos el máximo del día
				if (velocidadActual > maxDia) {
					maxDia = velocidadActual;
				}

				// Sumamos para luego calcular la media
				sumaDia = sumaDia + velocidadActual;

				// Comprobamos si merece multa (mayor a 120 km/h)
				if (velocidadActual > 120) {
					multasDia++; // Incrementamos el contador de multas del día
				}
			} // Fin del bucle de coches

			// --- DÍA ---
			double mediaDia = sumaDia / COLUMNA;

			// imprimimos
			System.out.println("Día " + (i + 1) + ":");// podemos 1-7 pero como comipenza en ponemos + 1
			System.out.println(" Máx velocidad: " + maxDia + " km/h");
			System.out.println(" Velocidad media:" + mediaDia + " km/h");

			System.out.println("  Multas: " + multasDia);
			System.out.println("-----------------------------");

		}

	}

	public void realizarxSemana() {

		int maxVelocidadSemanal = 0;
		double sumaVelocidadesSemanal = 0; // Usamos double para decimales
		int totalMultasSemanal = 0;
		int diaConMasMultas = 0;
		int maxMultasEnUnDia = 0; // Para comparar y encontrar el día con más multas
		int totalCochesSemana = FILA * COLUMNA;

		for (int i = 0; i < FILA; i++) {
			for (int j = 0; j < COLUMNA; j++) {
				if (maxDia > maxVelocidadSemanal) {
					maxVelocidadSemanal = maxDia;
				}

				// Sumamos el total de velocidades de hoy al total semanal
				sumaVelocidadesSemanal += sumaDia;

				// Sumamos las multas de hoy al total semanal
				totalMultasSemanal += multasDia;

				// Comprobamos si hoy fue el día con más multas de la semana
				if (multasDia > maxMultasEnUnDia) {
					maxMultasEnUnDia = multasDia;
					diaConMasMultas = (i + 1); // Guardamos qué día fue (1 al 7)
				}
			}

			// Semana-----
			// cambiamos un double para que no pete si es decimal
			double mediaSemanal = sumaVelocidadesSemanal / totalCochesSemana;

			System.out.println("\n--- SEMANAL ---");
			System.out.println("Máxima velocidad registrada: " + maxVelocidadSemanal + " km/h");
			System.out.println("Velocidad media: " + mediaSemanal);
			System.out.println("Total de multas a enviar: " + totalMultasSemanal);
			System.out.println("El día con más multas : " + diaConMasMultas + " [" + maxMultasEnUnDia + " multas]");
		}

	}

	public static void main(String[] args) {
		radar2 MT = new radar2();
		MT.CargarLaMatriz();
		MT.MostrarPorPantalla();
		MT.Realizar();
		//MT.RealizarxDia();
		//MT.realizarxSemana();

	}
}
