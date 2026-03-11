package Valorant_games;

import java.util.Random;
import java.util.Scanner;

public class IniciarSeccion {
	 //inicializamos el Scanner
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * array para guardar las partidas (20)
	 */
	int[] Game;
	/**
	 * array para guardar el numero de jugadores (5)
	 */
	int[] players;
	/**
	 * total de partidas 
	 */
	public static final int NPARTIDAS = 20;
	/**
	 * Total de jugadores 
	 */
	public static final int NJUGADORES = 5;
	 /**
	  * Maxima puntuacion.
	  */
	public static final int MAXPUNTUACION = 100;
	/**
	 * Minima puntuacion.
	 */
	public static final int MINPUNTUACION = 0;
	
	
	/**
	 * creamos un strig para verificar si se esta cargando bien los datos
	 */
	public static final String JUGADORES[] = { "Manuel", "Carlos", "Marcos", "Deivis",
	"Jorgue" };
	/**
	 * Crear los array en un contructor
	 */
	public IniciarSeccion() {
		Game = new int[NPARTIDAS];
		players = new int[NJUGADORES];
		RellenarArray();
	}
	/**
	 * Rellenamos los array
	 */
	public void RellenarArray(){
		Random ram = new Random(); // inicializamos el random
		for (int i = 0; i < Game.length; i++) {
			Game[i] = ram.nextInt(MINPUNTUACION, MAXPUNTUACION);
		}
		for (int i = 0; i < NJUGADORES; i++) {
			players[i] = ram.nextInt(0,JUGADORES.length);
		}
	}
	
	public void ImprimirArrays() {
		for (int i = 0; i < players.length ; i++) {
			System.out.printf("El jugador :%s  Puntuacion: [+ %03d ]%n ", JUGADORES[players[i]],Game[i] );
		}
		System.out.print("-------------------------------------------------------------");
		System.out.println("");
	}
	
	
	
	//public String ValidacionJugadores (String jugadores) {
	//	int Nombre;
		
		
		
		
		
		
	//	return Nombre;
	//}
	
	
	
	
	
	
	

}
