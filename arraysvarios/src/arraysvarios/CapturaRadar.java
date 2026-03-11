package arraysvarios;

import java.util.Scanner;

public class CapturaRadar {

	// Atributos :P
	int velocidad;
	int matricula;
	int dia;
	String color;
	public static final int NUM_COCHES = 100;

	// Constructor :D
	public CapturaRadar(int velocidad, int matricula, int dia, String color) {
		this.velocidad = velocidad;
		this.matricula = matricula;
		this.dia = dia;
		this.color = color;
	}

	/**
	 * Muestra la información si supera 120 :v
	 */
	public void verificarMulta() {
		if (this.velocidad > 120) {
			System.out.println(
					"MULTA >> Matrícula: " + matricula + " | Día: " + dia + " | Velocidad: " + velocidad + " km/h");
		}
	}

	/**
	 * AYUDAAAAAAAAAAAAAAAAAAAAAAAAA D:
	 */
	public static void analizarDia(CapturaRadar[] radar, int diaSeleccionado) {
		int maxVel = 0;
		int minVel = 300; // Iniciamos alto para encontrar el mínimo
		double sumaVel = 0;
		int contadorCochesDia = 0;
		int multasDia = 0;

		System.out.println("\n--- DIA " + diaSeleccionado + " ---");
		System.out.println("Matrículas multadas este día:");

		for (int i = 0; i < radar.length; i++) {
			// Solo procesamos los datos si coinciden con el día seleccionado
			if (radar[i].dia == diaSeleccionado) {

				int velActual = radar[i].velocidad;

				// Max y min
				if (velActual > maxVel)
					maxVel = velActual;
				if (velActual < minVel)
					minVel = velActual;

				sumaVel += velActual;
				contadorCochesDia++;

				// Verificar multa
				if (velActual > 120) {
					multasDia++;
					System.out.print("[" + radar[i].matricula + "] ");
				}
			}
		}
		System.out.println();

		// Si no hubo coches ese día, evitamos dividir por cero
		if (contadorCochesDia > 0) {
			double media = sumaVel / contadorCochesDia;

			System.out.println("------------------------------------------------------------------");
			System.out.println("Resultados Día " + diaSeleccionado + ":");
			System.out.println(" Velocidad Máxima: " + maxVel + " km/h");
			System.out.println(" Velocidad Mínima: " + minVel + " km/h");
			System.out.println(" Velocidad Media:  " + media + " km/h");
			System.out.println(" Total Multas:     " + multasDia);
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("No hubo registros de coches " + diaSeleccionado);
		}
	}

	public static void analizarelmax(CapturaRadar[] radar, int diaSeleccionado) {
		int maxVel = 0;
		int contadorCochesDia = 0;

		System.out.println("\n--- DIA " + diaSeleccionado + " ---");
		for (int i = 0; i < radar.length; i++) {
			// Solo procesamos los datos si coinciden con el día seleccionado
			if (radar[i].dia == diaSeleccionado) {
				int velActual = radar[i].velocidad;
				if (velActual > maxVel)
					maxVel = velActual;

				contadorCochesDia++;

			}
		}
		System.out.println();
		if (contadorCochesDia > 0) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("Resultados Día " + diaSeleccionado + ":");
			System.out.println(" Velocidad Máxima: " + maxVel + " km/h");
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("No hubo registros de coches " + diaSeleccionado);
		}

	}

	public static void analizarelmin(CapturaRadar[] radar, int diaSeleccionado) {
		int minVel = 300; // Iniciamos alto para encontrar el mínimo

		int contadorCochesDia = 0;

		System.out.println("\n--- DIA " + diaSeleccionado + " ---");
		for (int i = 0; i < radar.length; i++) {
			// Solo procesamos los datos si coinciden con el día seleccionado
			if (radar[i].dia == diaSeleccionado) {

				int velActual = radar[i].velocidad;
				if (velActual < minVel)
					minVel = velActual;

				contadorCochesDia++;
			}
		}
		System.out.println();
		if (contadorCochesDia > 0) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("Resultados Día " + diaSeleccionado + ":");
			System.out.println(" Velocidad Máxima: " + minVel + " km/h");
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("No hubo registros de coches " + diaSeleccionado);
		}
	}

	public static double analizarelmedia(CapturaRadar[] radar, int diaSeleccionado) {
		double sumaVel = 0;
		int contadorCochesDia = 0;

		System.out.println("\n--- DIA " + diaSeleccionado + " ---");
		for (int i = 0; i < radar.length; i++) {
			// Solo procesamos los datos si coinciden con el día seleccionado
			if (radar[i].dia == diaSeleccionado) {

				int velActual = radar[i].velocidad;

				sumaVel += velActual;
				contadorCochesDia++;

			}
		}
		return sumaVel/contadorCochesDia ;
	}
	
	public static void imprimirMedia(CapturaRadar[] radar, int diaSeleccionado) {
		double media = analizarelmedia(radar, diaSeleccionado);
		System.out.println();
		if (media > 0) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("Resultados Día " + diaSeleccionado + ":");
			System.out.println(" Velocidad Media:  " + media + " km/h");
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("No hubo registros de coches " + diaSeleccionado);
		}

	}

	public static void analizarelmatricula(CapturaRadar[] radar, int diaSeleccionado) {
		int multasDia = 0;

		System.out.println("\n--- DIA " + diaSeleccionado + " ---");
		System.out.println("");
		System.out.println("------------------------------------------------------------------");

		for (int i = 0; i < radar.length; i++) {
			// Solo procesamos los datos si coinciden con el día seleccionado
			if (radar[i].dia == diaSeleccionado) {

				int velActual = radar[i].velocidad;

				if (velActual > 120) {
					multasDia++;

					if (velActual > 181) {

						System.out.println("[" + radar[i].matricula + "] -" + radar[i].velocidad + " +3 ");
					} else if (velActual > 151) {
						System.out.println("[" + radar[i].matricula + "] -" + radar[i].velocidad + " +2 ");
					} else {
						System.out.println("[" + radar[i].matricula + "] -" + radar[i].velocidad + " +1 ");

					}
				}

			}
		}

		System.out.println();
		System.out.println();
		System.out.println("Resultados Día " + diaSeleccionado + ":");
		System.out.println("Total Multas:" + multasDia);
		System.out.println("------------------------------------------------------------------");

	}

	/*
	 * hacer el dia con mas multas de la semana
	 */
	public static void DiaMasMulta(CapturaRadar[] radar) {

		int diaGanador = 0;
		int maxMultasRecord = 0;

		// Vamos del día 1 al 7
		for (int dia = 1; dia <= 7; dia++) {

			int multasDeEsteDia = 0;

			// Recorremos TODA la lista de coches para buscar los de "dia"
			for (int i = 0; i < radar.length; i++) {

				// Si el coche es del día que estamos mirando Y iba rápido...
				if (radar[i].dia == dia && radar[i].velocidad > 120) {
					multasDeEsteDia++;
				}
			}

			// AL TERMINAR DE CONTAR ESE DÍA, COMPROBAMOS SI ES EL RÉCORD
			if (multasDeEsteDia > maxMultasRecord) {
				maxMultasRecord = multasDeEsteDia; // Nuevo récord
				diaGanador = dia; // Guardamos qué día fue
			}
		}

		// Imprimimos el resultado
		System.out.println("El día con más multas fue el: " + diaGanador + " con " + maxMultasRecord + " multas.");
	}

	/*
	 * la velocidad media mas alta de la semana
	 */
	public static void DiaconMedia(CapturaRadar[] radar) {

	    // 1. VARIABLES "HALL DE LA FAMA" (Para recordar al campeón)
		int diaGanador = 0;           
	    double mediaMasAltaRecord = 0.0; 

	    // BUCLE EXTERNO: Recorre los días de la semana (Lunes, Martes...)
	    for (int dia = 1; dia <= 7; dia++) {
	        
	        // 2. ZONA DE TRABAJO DIARIO (Variables temporales)
	        // ¡IMPORTANTE! Se crean AQUÍ DENTRO para que empiecen en 0 cada día nuevo.
	        // Si las pones fuera, sumarías el Martes encima del Lunes.
	        double sumaVelocidadesHoy = 0;
	        int contadorCochesHoy = 0;

	        // BUCLE INTERNO: Recorre los 100 coches buscando los de "hoy"
	        for (int i = 0; i < radar.length; i++) {
	            
	            // Si el coche 'i' pertenece al 'dia' que estamos analizando...
	            if (radar[i].dia == dia) {
	                // Acumulamos velocidad y contamos el coche
	                sumaVelocidadesHoy += radar[i].velocidad;
	                contadorCochesHoy++;
	            }
	        }
	        
	        // --- MOMENTO DE CALCULAR Y COMPARAR (Fin del día) ---
	        // Ya hemos revisado todos los coches de este día. Ahora calculamos.
	        
	        if (contadorCochesHoy > 0) { // Evitamos dividir por cero si nadie pasó ese día
	            
	            double mediaDeHoy = sumaVelocidadesHoy / contadorCochesHoy;
	            
	            // ¿Es la media de hoy mejor que el récord que teníamos?
	            if (mediaDeHoy > mediaMasAltaRecord) {
	                mediaMasAltaRecord = mediaDeHoy; // Guardamos el nuevo récord
	                diaGanador = dia;                // Guardamos qué día fue
	            }
	        }
	    } // Fin del bucle de días

	    System.out.println("El día con la media más alta fue " + diaGanador + " con " + mediaMasAltaRecord);
	}
	
	//ayuda----------------------
	
	public static void compararVelocidadPorColor(CapturaRadar[] radar) {
	    // 1. Variables para el equipo "CLARO"
	    double sumaVelClaro = 0;
	    int cuentaClaro = 0;

	    // 2. Variables para el equipo "OSCURO"
	    double sumaVelOscuro = 0;
	    int cuentaOscuro = 0;

	    // 3. Recorremos TODOS los coches de la semana
	    for (int i = 0; i < radar.length; i++) {
	        
	        // Si el coche es CLARO...
	        if (radar[i].color.equals("CLARO")) {
	            sumaVelClaro += radar[i].velocidad;
	            cuentaClaro++;
	        } 
	        // Si el coche es OSCURO...
	        else if (radar[i].color.equals("OSCURO")) {
	            sumaVelOscuro += radar[i].velocidad;
	            cuentaOscuro++;
	        }
	    }

	    // calculamos medias (¡Cuidado con dividir por cero!)
	    double mediaClaro = 0;
	    if (cuentaClaro > 0) {
	        mediaClaro = sumaVelClaro / cuentaClaro;
	    }

	    double mediaOscuro = 0;
	    if (cuentaOscuro > 0) {
	        mediaOscuro = sumaVelOscuro / cuentaOscuro;
	    }

	    // imprimimos resultados y veredicto
	    System.out.println("\n--- ANÁLISIS POR COLOR ---");
	    System.out.println("Coches CLAROS: " + cuentaClaro + " | Media: " + mediaClaro + " km/h");
	    System.out.println("Coches OSCUROS: " + cuentaOscuro + " | Media: " + mediaOscuro + " km/h");

	    System.out.print("VEREDICTO: ");
	    if (mediaClaro > mediaOscuro) {
	        System.out.println("Los coches CLAROS corren más.");
	    } else if (mediaOscuro > mediaClaro) {
	        System.out.println("Los coches OSCUROS corren más.");
	    } else {
	        System.out.println("Corren exactamente igual.");
	    }
	    System.out.println("--------------------------");
	}
	
	

	public static void main(String[] args) {

		// Creamos el array de objetos
		CapturaRadar[] radar = new CapturaRadar[NUM_COCHES];

		System.out.println("----- Iniciando Radar (Generando " + NUM_COCHES + " lecturas) -----");

		// rellenar con datos aleatorios
		for (int i = 0; i < radar.length; i++) {
			// velocidad entre 70 y 200
			int velAleatoria = (int) (Math.random() * (200 - 70 + 1)) + 70;
			// matrícula entre 1 y 1000
			int matAleatoria = (int) (Math.random() * 1000) + 1;
			// día entre 1 y 7
			int diaAleatorio = (int) (Math.random() * 7) + 1;
			
			String colorAleatorio;
		    if (Math.random() < 0.5) {
		        colorAleatorio = "CLARO";
		    } else {
		        colorAleatorio = "OSCURO";
		    }

			// Guardamos el objeto en el array
			radar[i] = new CapturaRadar(velAleatoria, matAleatoria, diaAleatorio,colorAleatorio);
		}

		System.out.println("Datos generados correctamente.");

		// Pedir día al usuario para mostrar estadísticas
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el día de la semana a consultar (1-7): ");
		int diaConsulta = scanner.nextInt();

		// validamos que el día sea correcto
		if (diaConsulta >= 1 && diaConsulta <= 7) {
			// llamamos al método estático pasando el array lleno y el día
			// analizarDia(radar, diaConsulta);
			analizarelmax(radar, diaConsulta);
			analizarelmin(radar, diaConsulta);
			
			imprimirMedia(radar, diaConsulta);
			analizarelmatricula(radar, diaConsulta);
			
			

		} else {
			System.out.println("introduce entre 1 y 7.");
		}

		DiaMasMulta(radar);
		compararVelocidadPorColor(radar);
		System.out.println("");
		System.out.println("");
		System.out.println("			 Fin del programa :D				");
	}
}



