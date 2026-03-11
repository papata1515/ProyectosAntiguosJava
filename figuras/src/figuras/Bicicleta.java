package figuras;

public class Bicicleta {

	int velocidadActual;
	int platoActual;
	int piñonActual;

	// aginamos los contructores

	public Bicicleta (int velocidad, int plato, int piñon) {
		this.piñonActual = piñon;
		this.platoActual = plato;
		this.velocidadActual = velocidad;
	}

	/**
	 * debemos duplicar la velocidad actual
	 */
	public void acelerar() {
		if (velocidadActual == 0) {
			velocidadActual = 1;
		} else {
			velocidadActual = velocidadActual * 2;
		}

	}

	/**
	 * reducir la velocidad actual a la mitad
	 */
	public void frenar() {

		velocidadActual = velocidadActual / 2;

	}

	/**
	 * ajutar el plato
	 * 
	 * @param plato actual
	 */
	public void cambiarPlato(int plato) {

		platoActual = plato;

	}

	/**
	 * ajustar el plato
	 * 
	 * @param piñon actual
	 */
	public void cambiarPiñon(int piñon) {

		piñonActual = piñon;
	}

	/**
	 * mostraremos lo que necesitamos ,velocidad
	 */
	public void imprimirEstado() {
		System.out.println("Velocidad: " + velocidadActual + " | Plato: " + platoActual + " | Piñon: " + piñonActual);
	}

	public static void main(String[] args) {
		// aginamos valores iniciales
		int plato = 2;
		int piñon = 3;

		Bicicleta miBicicleta = new Bicicleta(1,2,3);
		Bicicleta tuBicicleta = new Bicicleta(10,3,5);

		miBicicleta.cambiarPiñon(piñon);
		miBicicleta.cambiarPlato(plato);
		miBicicleta.acelerar();

		tuBicicleta.cambiarPiñon(5);
		tuBicicleta.acelerar();

		System.out.println("-----Mi bicicleta----");
		miBicicleta.imprimirEstado();
		System.out.println("-----Tu bicicleta----");
		tuBicicleta.imprimirEstado();

	}

}
