package paquete;

import java.util.Scanner;
import java.util.Random;

/**
 * <h1>Crear objeto captura de radar con 4 atributos array de tamaño 100:</h1>
 * <ul>
 * <li>Lectura de velocidad - entero</li>
 * <li>Matrícula - entero</li>
 * <li>Día - entero</li>
 * <li>Color (Claro o osucro)</li>
 * <li>Crear constante NUM_COCHES para tomar 100 lecturas.</li>
 * </ul>
 * <p>
 * Rellenar con datos aleatorios:
 * <ul>
 * <li>Lecturas de 70 - 200</li>
 * <li>Matrícula de 1 a 1000</li>
 * <li>Día de 1 a 7</li>
 * <li>Color(Claro, Oscuro)</li>
 * </ul>
 * <p>
 * Si la velocidad supera 120 imprimir matricula y día de la multa.
 * <p>
 * Pedir día de la semana, para dicho día dar velocidad máxima, mínima, media y
 * mostrar matriculas de coches multados
 * <p>
 * Rango: 120 a 150. Restar 1 punto del carnet
 * <p>
 * Rango: 150 a 180. Restar 2 puntos del carnet
 * <p>
 * Rango: Mayor a 180. Restar 3 puntos del carnet
 * <p>
 * Mostrar: Día con más multas
 * <p>
 * Día con la velocidad media más alta
 * <p>
 * Decir que color tiene mayor velocidad media
 * <p>
 * Autor: Pablo Illescas
 */
public class RadarNuevo {

	Scanner sc = new Scanner(System.in);

	int[] Velocidad;
	int[] Semana;
	int[] Matriculas;
	int[] Colores;

	public static final int NUM_COCHES = 100;
	public static final int MAXVELO = 201;
	public static final int MINVELO = 70;
	public static final int MINMATRIX = 1;
	public static final int MAXMATRI = 1000;
	public static final String DIAS[] = { "lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
	public static final String COLOR[] = { "Claro", "Oscuro" };

	public RadarNuevo() {
		Velocidad = new int[NUM_COCHES];
		Semana = new int[NUM_COCHES];
		Matriculas = new int[NUM_COCHES];
		Colores = new int[NUM_COCHES];
		RellenarArray();
	}

	public void RellenarArray() {
		Random ram = new Random();
		for (int i = 0; i < Velocidad.length; i++) {
			Velocidad[i] = ram.nextInt(MINVELO, MAXVELO);
			Semana[i] = ram.nextInt(0, DIAS.length);
			Matriculas[i] = ram.nextInt(MINMATRIX, MAXMATRI);
			Colores[i] = ram.nextInt(0, COLOR.length);
		}

	}

	public void ImprimirArray() {

		for (int i = 0; i < Velocidad.length; i++) {
			if (this.Velocidad[i] > 120) {
				System.out.printf("%d km/h |%s |Matricula [%03d] |%s%n", Velocidad[i], DIAS[Semana[i]], Matriculas[i],
						COLOR[Colores[i]]);
			}
		}

		System.out.print("-------------------------------------------------------------");
		System.out.println("");

	}

	public int PedirPorPantalla() {
		int NumeroPedido;

		do {
			System.out.println("Coloque un numero (1-7):");
			NumeroPedido = sc.nextInt();
			if (NumeroPedido > 7 || NumeroPedido < 1) {
				System.out.println("Error: Debes introducir un valor entre 1 y 7.");
			}
		} while (NumeroPedido > 7 || NumeroPedido < 1);
		return NumeroPedido - 1;
	}

	public int AnalizarMax(int dia) {

		int maxVel = 0;

		for (int i = 0; i < Velocidad.length; i++) {
			if (Semana[i] == dia) {
				int velActual = Velocidad[i];
				if (velActual > maxVel) {
					maxVel = velActual;
				}

			}
		}
		return maxVel;
	}

	public int AnalizarMin(int dia) {

		int minVel = 300;

		for (int i = 0; i < Velocidad.length; i++) {
			if (Semana[i] == dia) {
				if (Velocidad[i] < minVel) {
					minVel = Velocidad[i];
				}

			}
		}
		return minVel;
	}

	public double AnalizarMedia(int dia) {

		double sumaVel = 0;
		int contadorCochesDia = 0;

		for (int i = 0; i < Velocidad.length; i++) {
			// Solo procesamos los datos si coinciden con el día seleccionado
			if (Semana[i] == dia) {

				int velActual = Velocidad[i];

				sumaVel += velActual;
				contadorCochesDia++;

			}
		}
		return sumaVel / contadorCochesDia;
	}

	public void ImprimirMaxMinMed() {
		int dia = PedirPorPantalla();
		int max = AnalizarMax(dia);
		int min = AnalizarMin(dia);
		double media = AnalizarMedia(dia);
		System.out.println("--- Multas del dia " + DIAS[dia] + " : ");
		System.out.println("");
		System.out.println("El maximo del dia  " + DIAS[dia] + " es: " + max);
		System.out.println("El minimo del dia  " + DIAS[dia] + " es: " + min);
		System.out.println("La media  del dia  " + DIAS[dia] + " es: " + media);
	}

	public void ImprimirPuntos() {

		int DiaBuscado = PedirPorPantalla();

		System.out.println("--- Multas del " + DIAS[DiaBuscado] + " ---");

		for (int i = 0; i < Velocidad.length; i++) {
			if (Semana[i] == DiaBuscado) {
				if (this.Velocidad[i] > 120) {
					if (this.Velocidad[i] > 180) {
						System.out.printf("| %s | Matricula [%03d] | %d km/h | Menos -3 puntos en el carnert %n ",
								DIAS[Semana[i]], Matriculas[i], Velocidad[i]);
					} else if (this.Velocidad[i] > 150) {
						System.out.printf("| %s | Matricula [%03d] | %d km/h | Menos -2 puntos en el carnert %n ",
								DIAS[Semana[i]], Matriculas[i], Velocidad[i]);
					} else {
						System.out.printf("| %s | Matricula [%03d] | %d km/h | Menos -1 puntos en el carnert %n ",
								DIAS[Semana[i]], Matriculas[i], Velocidad[i]);
					}
				}
			}
		}
	}

	public void DiaMasMultas() {
		int maxMultasRecord = 0;
		int diaGanador = -1;
		for (int d = 0; d < 7; d++) {
			int contadorMultasEsteDia = 0;
			for (int i = 0; i < Velocidad.length; i++) {
				if (Semana[i] == d && Velocidad[i] > 120) {
					contadorMultasEsteDia++;
				}

			}
			if (contadorMultasEsteDia > maxMultasRecord) {
				maxMultasRecord = contadorMultasEsteDia;
				diaGanador = d;
			}
		}
		System.out.println("El día con más multas es " + DIAS[diaGanador] + " con " + maxMultasRecord + " multas.");
	}
	
	public void DiaMenosMultas() {
		int minMultasRecord = 300;
		int diaGanador = -1;
		for (int d = 0; d < 7; d++) {
			int contadorMultasEsteDia = 0;
			for (int i = 0; i < Velocidad.length; i++) {
				if (Semana[i] == d && Velocidad[i] > 120) {
					contadorMultasEsteDia++;
				}

			}
			if (contadorMultasEsteDia < minMultasRecord) {
				minMultasRecord = contadorMultasEsteDia;
				diaGanador = d;
			}
		}
		System.out.println("El día con menos multas es " + DIAS[diaGanador] + " con " + minMultasRecord + " multas.");
	}

	public void ColorMayorMedia() {
		// 1. Preparamos variables para el equipo "Claro" (Índice 0)
		double sumaClaro = 0;
		int contadorClaro = 0;

		// 2. Preparamos variables para el equipo "Oscuro" (Índice 1)
		double sumaOscuro = 0;
		int contadorOscuro = 0;

		// 3. Recorremos TODOS los coches una sola vez
		for (int i = 0; i < Velocidad.length; i++) {

			if (Colores[i] == 0) {
				// Es Claro: sumamos su velocidad a la saca de los claros
				sumaClaro += Velocidad[i];
				contadorClaro++;

			} else {
				// Es Oscuro: sumamos su velocidad a la saca de los oscuros
				sumaOscuro += Velocidad[i];
				contadorOscuro++;
			}
		}

		// 4. Calculamos las medias (Cuidado con dividir por cero)
		double mediaClaro = 0;
		double mediaOscuro = 0;

		if (contadorClaro > 0)
			mediaClaro = sumaClaro / contadorClaro;
		if (contadorOscuro > 0)
			mediaOscuro = sumaOscuro / contadorOscuro;

		// 5. Imprimimos los resultados para verlos
		System.out.printf("Media Claro: %.2f km/h %n", mediaClaro);
		System.out.printf("Media Oscuro: %.2f km/h %n", mediaOscuro);

		// 6. Decidimos quién gana
		if (mediaClaro > mediaOscuro) {
			System.out.println("El color con mayor velocidad media es: " + COLOR[0]); // Claro
		} else if (mediaOscuro > mediaClaro) {
			System.out.println("El color con mayor velocidad media es: " + COLOR[1]); // Oscuro
		} else {
			System.out.println("Ambos colores tienen la misma velocidad media.");
		}
	}

	public void DiaMayorMedia() {
		// 1. Preparamos al CAMPEÓN (el récord a batir)
		double mejorMediaRecord = 0;
		int diaGanador = -1;

		// BUCLE 1: Vamos día por día (0=Lunes, 1=Martes...)
		for (int d = 0; d < DIAS.length; d++) {

			// Variables temporales SOLO para calcular la media de ESTE día 'd'
			double sumaVelocidadesDia = 0;
			int contadorCochesDia = 0;

			// BUCLE 2: Recorremos los 100 coches buscando los de este día
			for (int i = 0; i < Velocidad.length; i++) {
				if (Semana[i] == d) {
					sumaVelocidadesDia += Velocidad[i];
					contadorCochesDia++;
				}
			}

			// 2. Calculamos la media de ESTE día
			double mediaEsteDia = 0;
			if (contadorCochesDia > 0) {
				mediaEsteDia = sumaVelocidadesDia / contadorCochesDia;
			}

			// 3. ¿Es este día el nuevo campeón?
			if (mediaEsteDia > mejorMediaRecord) {
				mejorMediaRecord = mediaEsteDia;
				diaGanador = d;
			}
		}

		// 4. Imprimimos el resultado final
		if (diaGanador != -1) {
			System.out.printf("El día con la velocidad media más alta fue el %s con %.2f km/h %n", DIAS[diaGanador],
					mejorMediaRecord);
		} else {
			System.out.println("No hay datos suficientes.");
		}
	}

	public static void main(String[] args) {
		RadarNuevo Objeto = new RadarNuevo();
		System.out.print("-------------------- DATOS POR PANTALLA --------------------");
		System.out.println("");
		Objeto.ImprimirArray();
		System.out.println("");
		Objeto.ImprimirPuntos();
		System.out.println("");
		Objeto.ImprimirMaxMinMed();
		System.out.println("");
		Objeto.DiaMasMultas();
		Objeto.ColorMayorMedia();
		Objeto.DiaMayorMedia();
		Objeto.DiaMenosMultas();
	}
}
