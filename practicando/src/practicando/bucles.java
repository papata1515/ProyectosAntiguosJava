package practicando;

public class bucles {

	public static void main(String[] args) {

		int dia = 1;
		while (dia <= 20) {
			System.out.println("el numero es :" + dia);
			dia++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("numero :" + i);
		}

		int[] array = new int[10];

		int numeroactual = 1;

		for (int i = 0; i < 10; i++) {
			array[i] = numeroactual;
			numeroactual++;
			System.out.println("el nuevo array es " + array[i] + "");

		}

		int[][] matriz = new int[3][3];
		int numero = 1;
		for (int f = 0; f < 3; f++) {
			for (int c = 0; c < 3; c++) {

				matriz[f][c] = numero;
				numero++;
				System.out.print(matriz[f][c] + " ");

			}
			System.out.println("");
		}

		int[][] hola = new int[2][2];
		for (int f = 0; f < 2; f++) {
			for (int c = 0; c < 2; c++) {
				hola[0][0] = 1;
				hola[0][1] = 2*100;
				hola[1][0] = 3;
				hola[1][1] = 4;
				System.out.print(hola[f][c] + " ");
			}
			System.out.println("");
		}
		System.out.println("----------------------------------");

		
		int[][] queso = new int[2][2];
		for (int f = 0; f < 2; f++) {
			for (int c = 0; c < 2; c++) {
				queso[0][0] = 1;
				queso[0][1] = 2;
				queso[1][0] = 3;
				queso[1][1] = 4;
				System.out.print(queso[f][0] + " ");
			}
			System.out.println("");
		}
	}
}
