package Ejercicio4;

public class CuentaBancaria {

	/**
	 * Implementa una clase CuentaBancaria que simule una cuenta sencilla.
	 * Requisitos: Atributos privados: titular (String). saldo (double).
	 * Constructores: CuentaBancaria(String titular) con saldo inicial 0.
	 * CuentaBancaria(String titular, double saldoInicial) (si el saldo inicial es
	 * negativo, se pone a 0). Métodos públicos: getTitular(), getSaldo() (no hay
	 * setSaldo, se controla con métodos). ingresar(double cantidad): solo admite
	 * cantidades positivas. retirar(double cantidad): solo si hay saldo suficiente
	 * y la cantidad es positiva. Añade un método toString() que devuelva una
	 * descripción básica de la cuenta.
	 */
	/**
	 * atributo titular
	 * 
	 */
	private String titular;
	/**
	 * atributo saldo
	 */
	private double saldo;

	public CuentaBancaria(String titular) {
		this.titular = titular;
		this.saldo = 0.0;
	}

	public CuentaBancaria(String titular, double saldoInicial) {
		this.titular = titular;
		// Si el saldo inicial es negativo, se pone a 0
		if (saldoInicial > 0) {
			this.saldo = saldoInicial;
		} else {
			this.saldo = 0.0;
		}

	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void ingresar(double cantidad) {
		if (cantidad > 0) {
			this.saldo += cantidad;
			System.out.println("Ingreso realizado: +" + cantidad);
		} else {
			System.out.println("Error: La cantidad a ingresar debe ser positiva.");
		}
	}

	public void retirar(double cantidad) {
		if (cantidad <= 0) {
			System.out.println("Error: La cantidad a retirar debe ser positiva.");
		} else if (this.saldo >= cantidad) {
			this.saldo -= cantidad;
			System.out.println("Retiro realizado: -" + cantidad);
		} else {
			System.out.println("Error: Fondos insuficientes.");
		}
	}
	@Override //indicar si esta correcto
	public String toString() {
		return "CuentaBancaria [Titular: " + titular + " | Saldo actual: " + saldo + "€]";
	}

}
