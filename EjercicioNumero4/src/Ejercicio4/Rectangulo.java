package Ejercicio4;

public class Rectangulo {

	/**
	 * Crea una clase Rectangulo definida por su base y su altura. 

Requisitos: 
Atributos privados base y altura (double).
Tres constructores:
Constructor por defecto (base 1, altura 1).
Constructor con parámetros Rectangulo(double base, double altura).
Constructor de copia Rectangulo(Rectangulo r).
Métodos get y set con validación: no se permite base ni altura negativa (si se intenta, se deja el valor anterior o se 
pone 1).
Método double area() que devuelva el área.
Método double perimetro() que devuelva el perímetro.
Sobrecarga de un método redimensionar:
redimensionar(double factor) multiplica base y altura por un factor.
redimensionar(double nuevaBase, double nuevaAltura) asigna nuevas dimensiones con validación.

	 */
	
	/**
	 * atributo privado de base
	 */
	private double base;
	/**
	 * atributo privado de altura 
	 */
	private double altura;
	
	
	/**
	 * Constructor por defecto
	 */
	public Rectangulo(){
		this.base =  1;
		this.altura = 1;
	}
	
	/**
	 * Constructor con parámetros
	 */
	public Rectangulo(double base, double altura) {
		setBase(base); //colocamos para que no se pueda crear con un negativo
        setAltura(altura); 
	}
	/**
	 * Constructor de copia 
	 * @param r
	 */
	public Rectangulo(Rectangulo r) {
		this.base =  r.base;
		this.altura = r.altura;
	}

	public double getBase() {
		return base;
	}
	/**
	 * verificamos que no sea negativo
	 * @param base
	 */
	public void setBase(double base) {
		if (base > 0) {
            this.base = base;
        } else {
            this.base = 1; // Requisito: si es negativa, se pone 1
        }
	}

	public double getAltura() {
			return altura;
		
	}
	/**
	 * verificamos que no sea negativo
	 * @param altura
	 */
	public void setAltura(double altura) {
		if (altura > 0) {
            this.altura = altura;
        } else {
            this.altura = 1; // Requisito: si es negativa, se pone 1
        }
	}
	
	public double area() {
		return altura*base;
	}
	
	public double perimetro() {
		return 2*(altura+base);
	}
	/**
	 * sobre carga
	 * @param factor
	 */
	public void  redimensionar(double factor) {
		if (factor > 0) {
            this.base *= factor;
            this.altura *= factor;
        } else {
            System.out.println("Error: El factor debe ser mayor que cero.");
        }
    }
	
	public void redimensionar(double nuevaBase, double nuevaAltura) {
        if (nuevaBase > 0 && nuevaAltura > 0) {
            this.base = nuevaBase;
            this.altura = nuevaAltura;
        } else {
            System.out.println("Error: Las dimensiones deben ser positivas.");
        }
    }
	
	
}

