package Ejercicio4;

public class Punto {

	/**
	 * Crea una clase Punto que represente un punto en un plano 2D. Requisitos:
	 * Atributos privados x e y (enteros). Constructor por defecto que coloque el
	 * punto en el origen (0,0). (0, 0) Constructor con parámetros Punto(int x, int
	 * y). Constructor de copia Punto(Punto p). Métodos get y set para x e y usando
	 * this cuando sea necesario. Método mover(int dx, int dy) que desplace el
	 * punto. Método distanciaOrigen() que devuelva la distancia al origen (como
	 * double). (La distancia se calcula con el Teorema de Pitágoras (distancia
	 * euclidiana): d = x + y 2 2 Sobrecarga de un método mover con la firma
	 * mover(Punto p) que mueva el punto hasta la posición de otro punto.
	 */

	/**
	 * atributo privado de coordenada x
	 */
	private int x;

	/**
	 * atributo privado de coordenada y
	 */
	private int y;

	/**
	 * Constructor por defecto
	 */
	public Punto() {

		this.x = 0;
		this.y = 0;

	}

	/**
	 * contructor por parametros
	 */
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;

	}

	/**
	 * contructor de copia
	 */
	public Punto(Punto p) {
		this.x = p.x;
		this.y = p.y;

	}

	/**
	 * getter de x
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * setters de x
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getter de y
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * setters de y
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * metodo que desplace un punto
	 * @param dx
	 * @param dy
	 */
	public void mover(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		
	}
	
	/**
	 * sobrecarga 
	 */
	public void mover (Punto p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	
	/**
	 * devuelve la distancia al origen (como double).
	 */
	public double distanciaOrigen() {
		/**
		 * d = sqrt(x² + y²)
		 */
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
		
	}

}
