package orientacionObjetos;

public class Bicicleta {

	// Variables de instancia para guardar el estado de cada bicicleta
	private int velocidadActual;
	private int platoActual;
	private int pinonActual;

	// ---CONSTRUCTOR ---
	// Inicializa los atributos con los valores que le pasemos al crear el objeto
	public Bicicleta(int velocidadActua, int platoActual, int pinonActual) {
		this.velocidadActual = velocidadActua;
		this.platoActual = platoActual;
		this.pinonActual = pinonActual;
	}

	// Dobla la velocidad actual (x2)
	public void acelerar() {
		this.velocidadActual = this.velocidadActual * 2;
	}

	// Reduce la velocidad a la mitad (/2)
	public void frenar() {
		this.velocidadActual = this.velocidadActual / 2;
	}

	// Cambia el plato al valor recibido
	public void cambiarPlato(int plato) {
		this.platoActual = plato;
	}

	// Cambia el piñón al valor recibido
	public void cambiarPinon(int pinon) {
		this.pinonActual = pinon;
	}

	// ver los datos de la bici por consola
	public void imprimirEstado() {
		System.out.println(
				"Bici -> Velocidad: " + velocidadActual + " | Plato: " + platoActual + " | Piñón: " + pinonActual);
	}

	public static void configurarBici(Bicicleta bici, int velo, int plat, int pino) {

		while (bici.velocidadActual < velo) {
			bici.acelerar();
		}

		bici.cambiarPlato(plat);
		bici.cambiarPinon(pino);

		bici.imprimirEstado(); // Verificamos
	}

	public static void main(String[] args) {

		System.out.println(" 1. OBJETOS INDIVIDUALES ");
		// Crea dos objetos de la clase bicicleta: miBicicleta y tuBicicleta
		Bicicleta miBicicleta = new Bicicleta(10, 2, 4);
		Bicicleta tuBicicleta = new Bicicleta(20, 3, 1);
		miBicicleta.imprimirEstado();
		tuBicicleta.imprimirEstado();

		System.out.println("\n=== 2. ARRAY DE 5 BICICLETAS ===");
		// Creamos un array de 5 bicicletas (huecos vacíos por ahora)
		Bicicleta[] bicicletas = new Bicicleta[5];

		// BICICLETA 1
		System.out.println("\n--- Bicicleta 1 ---");
		// Datos iniciales: velocidad 14, plato 2, piñón 5
		bicicletas[0] = new Bicicleta(14, 2, 5);

		configurarBici(bicicletas[0], 28, 1, 1);

		// ------------------------------------------------------

		// BICICLETA 2
		System.out.println("\n--- Bicicleta 2 ---");
		// Datos iniciales: velocidad 14, plato 2, piñón 5
		bicicletas[1] = new Bicicleta(14, 2, 5);

		configurarBici(bicicletas[1], 28, 1, 1);

		// ------------------------------------------------------

		// BICICLETA 1
		System.out.println("\n--- Bicicleta 3 ---");
		// Datos iniciales: velocidad 14, plato 2, piñón 5
		bicicletas[2] = new Bicicleta(14, 2, 5);

		configurarBici(bicicletas[2], 28, 1, 1);

		// ------------------------------------------------------

		// BICICLETA 1
		System.out.println("\n--- Bicicleta 4 ---");
		// Datos iniciales: velocidad 14, plato 2, piñón 5
		bicicletas[3] = new Bicicleta(14, 2, 5);

		configurarBici(bicicletas[3], 28, 1, 1);

		// ------------------------------------------------------

		// BICICLETA 1
		System.out.println("\n--- Bicicleta 5 ---");
		// Datos iniciales: velocidad 14, plato 2, piñón 5
		bicicletas[4] = new Bicicleta(14, 2, 5);

		configurarBici(bicicletas[4], 28, 1, 1);

		// ------------------------------------------------------

		/*
		 * BICICLETA 2 System.out.println("\n--- Bicicleta 2 ---"); // Datos iniciales:
		 * velocidad 10, plato 3, piñón 3 bicicletas[1] = new Bicicleta(10, 3, 3);
		 * 
		 * // haceer: Velocidad 40. (10 * 2 = 20 * 2 = 40 Dos veces acelerar) while
		 * (bicicletas[1].velocidadActual < 40) { bicicletas[1].acelerar(); } //
		 * Objetivo: Plato 1, Piñón 1 bicicletas[1].cambiarPlato(1);
		 * bicicletas[1].cambiarPinon(1);
		 * 
		 * bicicletas[1].imprimirEstado();
		 * 
		 * // BICICLETA 3 System.out.println("\n--- Bicicleta 3 ---"); // Datos
		 * iniciales: velocidad 14, plato 1, piñón 2 bicicletas[2] = new Bicicleta(14,
		 * 1, 2);
		 * 
		 * // hacerr: Velocidad 28 while (bicicletas[2].velocidadActual < 28) {
		 * bicicletas[2].acelerar(); } // hacr: Plato 2, Piñón 1
		 * bicicletas[2].cambiarPlato(2); bicicletas[2].cambiarPinon(1);
		 * 
		 * bicicletas[2].imprimirEstado();
		 * 
		 * // BICICLETA 4 System.out.println("\n--- Bicicleta 4 ---"); // Datos
		 * iniciales: velocidad 14, plato 2, piñón 4 bicicletas[3] = new Bicicleta(14,
		 * 2, 4);
		 * 
		 * // hacer: Velocidad 28 while (bicicletas[3].velocidadActual < 28) {
		 * bicicletas[3].acelerar(); } // hacer: Plato 3, Piñón 3
		 * bicicletas[3].cambiarPlato(3); bicicletas[3].cambiarPinon(3);
		 * 
		 * bicicletas[3].imprimirEstado();
		 * 
		 * //BICICLETA 5 System.out.println("\n--- Bicicleta 5 ---"); // Datos
		 * iniciales: velocidad 14, plato 1, piñón 1 bicicletas[4] = new Bicicleta(14,
		 * 1, 1);
		 * 
		 * // hacer: Velocidad 28 while (bicicletas[4].velocidadActual < 28) {
		 * bicicletas[4].acelerar(); } // lograrr: Plato 3, Piñón 2
		 * bicicletas[4].cambiarPlato(3); bicicletas[4].cambiarPinon(2);
		 * 
		 * bicicletas[4].imprimirEstado();
		 */
		//

		/*
		 * // hacer: Velocidad 28. (14 * 2 = 28 Una vez acelerar) //while
		 * (bicicletas[0].velocidadActual < 28) { // bicicletas[0].acelerar(); //} //
		 * hacer: Plato 1, Piñón 1 //bicicletas[0].cambiarPlato(1);
		 * //bicicletas[0].cambiarPinon(1);
		 * 
		 * //bicicletas[0].imprimirEstado(); // Verificamos
		 */
	}
}
