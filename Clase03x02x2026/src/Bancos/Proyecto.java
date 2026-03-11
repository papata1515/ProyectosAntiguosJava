package Bancos;

import java.io.*;
import java.util.Scanner;

public class Proyecto {

	static Scanner sc = new Scanner(System.in);
	static final String NOMBRE_FICHERO = "empleados.txt";

	// Muestra el menú principal
	public static void SalidaPorPantalla() {
		System.out.println("\n-------- GESTIÓN DE EMPLEADOS --------");
		System.out.println("1. Añadir empleado");
		System.out.println("2. Listar empleados");
		System.out.println("3. Buscar empleado por DNI");
		System.out.println("4. Calcular sueldo medio");
		System.out.println("5. Listar Empleados por Salarios");
		System.out.println("6. Búsqueda por nombre y apellidos");
		System.out.println("7. Salir");
	}

	// Valida que la entrada sea un número del 1 al 5
	public static int Verificar() {
		int realizar = 0;
		boolean entradaValida = false;
		do {
			System.out.print("Selecciona una opción: ");
			String entrada = sc.nextLine();
			try {
				realizar = Integer.parseInt(entrada);
				if (realizar >= 1 && realizar <= 7) {
					entradaValida = true;
				} else {
					System.out.println("Error: Introduce un valor entre 1 y 7.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: ¡Debes introducir un número!");
			}
		} while (!entradaValida);
		return realizar;
	}

	// Opción 1: Pide datos y los guarda al final del archivo
	public static void aniadirEmpleado() {

		// Usamos los nuevos métodos
		String dni = leerDni();

		String nombre = leerTextoSeguro("Nombre");
	    String apellidos = leerTextoSeguro("Apellidos");

		int edad = leerEdad();
		double sueldo = leerSueldo();

		// El true en FileWriter es para activar el modo 'append' (añadir al final)
		// new FileWriter(NOMBRE_FICHERO, true) ejemplo
		try (PrintWriter pw = new PrintWriter(new FileWriter(NOMBRE_FICHERO, true))) {
			pw.println(dni + ";" + nombre + ";" + apellidos + ";" + edad + ";" + sueldo);
			System.out.println("Empleado guardado correctamente.");
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero: " + e.getMessage());
		}
	}
	
	//
	/**
	 * <html>
<body>
    <h2>El desglose de <b>^[0-9]{8}[A-Z]$</b></h2>
    <table border="0" cellpadding="5">
        <tr>
            <td><b>!</b></td>
            <td>Es el operador "NOT". La condición se cumple si el texto NO coincide con el patrón.</td>
        </tr>
        <tr>
            <td><b>^</b></td>
            <td>Indica el inicio de la cadena. Nada puede haber antes.</td>
        </tr>
        <tr>
            <td><b>[0-9]</b></td>
            <td>Significa que el carácter debe ser un dígito del 0 al 9.</td>
        </tr>
        <tr>
            <td><b>{8}</b></td>
            <td>Indica que el elemento anterior se repite exactamente 8 veces.</td>
        </tr>
        <tr>
            <td><b>[A-Z]</b></td>
            <td>El último carácter debe ser una letra mayúscula (A-Z).</td>
        </tr>
        <tr>
            <td><b>$</b></td>
            <td>Indica el final de la cadena. Nada puede haber después.</td>
        </tr>
    </table>
</body>
</html>
	 * @return
	 */
	public static String leerDni() {
		String dni;
		while (true) {
			System.out.print("DNI (8 números y 1 letra): ");
			dni = sc.nextLine().trim().toUpperCase();
			
			
			if (!dni.matches("^[0-9]{8}[A-Z]$")) {
				System.out.println("Error: Formato inválido (ej: 12345678Z).");
			} else if (existeDni(dni)) {
				System.out.println("Error: Este DNI ya está registrado.");
			} else {
				return dni; // DNI válido y no repetido
			}
		}
	}
	
	public static boolean existeDni(String dni) {
	    File f = new File(NOMBRE_FICHERO);
	    if (!f.exists()) return false;

	    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            if (linea.trim().isEmpty()) continue; // Salta líneas vacías
	            String[] datos = linea.split(";");
	            if (datos[0].equalsIgnoreCase(dni)) {
	                return true; // Encontrado
	            }
	        }
	    } catch (IOException e) {
	        return false;
	    }
	    return false;
	}
	
	// Método para validar la edad
	public static int leerEdad() {
		while (true) {
			try {
				System.out.print("Edad: ");
				int edad = Integer.parseInt(sc.nextLine());
				if (edad >= 18 && edad <= 99)
					return edad;
				System.out.println("Error: La edad debe estar entre 18 y 99.");
			} catch (NumberFormatException e) {
				System.out.println("Error: Introduce un número entero.");
			}
		}
	}

	// Método para validar el sueldo
	public static double leerSueldo() {
		while (true) {
			try {
				System.out.print("Sueldo: ");
				double sueldo = Double.parseDouble(sc.nextLine().replace(',', '.'));
				if (sueldo >= 0)
					return sueldo;
				System.out.println("Error: El sueldo no puede ser negativo.");
			} catch (NumberFormatException e) {
				System.out.println("Error: Formato de sueldo no válido.");
			}
		}
	}

	// Opción 2: Lee el archivo línea por línea y lo muestra
	public static void listarEmpleados() {
		File f = new File(NOMBRE_FICHERO);
		if (!f.exists()) {
			System.out.println("El fichero no existe todavía.");
			return;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String linea;
			System.out.println("\n--- LISTA DE EMPLEADOS ---");
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero.");
		}
	}

	// Opción 3: Busca una línea que empiece por el DNI indicado
	public static void buscarPorDni() {
		System.out.print("Introduce el DNI a buscar: ");
	    String dniBusqueda = sc.nextLine().trim();
	    boolean encontrado = false;

	    File f = new File(NOMBRE_FICHERO);
	    if (!f.exists()) {
	        System.out.println("El fichero no existe.");
	        return;
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            if (linea.trim().isEmpty()) continue;
	            
	            String[] datos = linea.split(";");
	            
	            // PROTECCIÓN: Verificar que al menos existe el campo DNI (índice 0)
	            if (datos.length > 0 && datos[0].equalsIgnoreCase(dniBusqueda)) {
	                System.out.println("Empleado encontrado: " + linea.replace(";", " | "));
	                encontrado = true;
	                break;
	            }
	        }
	        if (!encontrado) System.out.println("DNI no encontrado.");
	    } catch (IOException e) {
	        System.out.println("Error al leer el archivo.");
	    }
	}
	

	public static void calcularSueldoMedio() {
    double sumaSueldos = 0;
    int contador = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;

            String[] datos = linea.split(";");
            
            // PROTECCIÓN: Si la línea no tiene 5 partes, la ignora en vez de romperse
            if (datos.length < 5) {
                System.err.println("Advertencia: Línea corrupta ignorada -> " + linea);
                continue;
            }

            try {
                // El sueldo es la posición 4
                sumaSueldos += Double.parseDouble(datos[4]);
                contador++;
            } catch (NumberFormatException e) {
                System.err.println("Error: Formato de sueldo inválido en línea -> " + linea);
            }
        }

        if (contador > 0) {
            double media = sumaSueldos / contador;
            System.out.printf("El sueldo medio de los %d empleados es: %.2f\n", contador, media);
        } else {
            System.out.println("No hay datos válidos para calcular la media.");
        }
    } catch (IOException e) {
        System.out.println("Error: No se pudo acceder al fichero.");
    }
}
	
	// Método para limpiar el texto de caracteres que rompen el CSV
	public static String leerTextoSeguro(String etiqueta) {
	    String texto;
	    while (true) {
	        System.out.print(etiqueta + ": ");
	        texto = sc.nextLine().trim();
	        if (texto.contains(";")) {
	            System.out.println("Error: No se permite el uso del carácter ';' (punto y coma).");
	        } else if (texto.isEmpty()) {
	            System.out.println("Error: El campo no puede estar vacío.");
	        } else {
	            return texto;
	        }
	    }
	}
	//terminar
	public static void ListaPorSueldo() {
		// Quiero ver toda la lista por el sueldo que tiene el fichero (leer)
		// necesito pedir por escaner dos cantidad 
		//   -validar que no sea un numero negativo
		//   -validar que el suedo A y el sueldo B no sean iguales
		//   -validar que el sueldo A y B no tenga fallas por ; o por ,
		//   -validar que sueldo A sea mamenor que sueldo B
		// Necesito hacer una funcion que contenga si entre sueldo A y B
		// Mostrar por pantalla que los sueldos que contengan entre A y B
		//Nota: Nose si se necesaria lanzar todos los datos completos pero por siacaso si 	
	}
	//terminar
	public static void BusquedaPorNombreyApelldio() {
		//Quiero ver toda la lista por el sueldo que tiene el fichero (leer)
		//Pedir por patantalla los nombre y apellidos (creo que seria mejor separarlos)
		//verificar que sea carater de nombre y no sea numero o algo raro  junto con un try(do-whiles)
		//necesito validar 2 cosas 
		//  -validar nombre (tiene que ser con los mismo caracteres con mayuscula y minuscula)
		// 	-Validar que si en caso no lo haga separado hay una separacion de por medio como un ";"
		//  -creo que necesito almacenar los nombres para luego llamarlos tipo en un array (duda)
		//  -Mostrar por pantalla que los nombres que contenga a pesar que tengas otros apelldidos
		//  -Mostrar de igual manera los apellidos  
		//NOTA:considero mejor que podria trasformar toda la palabra en minuscula para que no hay aproblemas grande 
		
	}
	
	
	/**
	 * Main de toda la vida
	 * @param GAAAAA
	 */
	public static void main(String[] args) {
		int opcion;
		do {
			SalidaPorPantalla();
			opcion = Verificar(); // Obtenemos la opción (1-5)

			switch (opcion) {
			case 1:
				aniadirEmpleado();
				break;
			case 2:
				listarEmpleados();
				break;
			case 3:
				buscarPorDni();
				break;
			case 4:
				calcularSueldoMedio();
				break;
			case 5:
				ListaPorSueldo();
				break;
			case 6:
				BusquedaPorNombreyApelldio();
				break;
			case 7:
				System.out.println("Cerrando la aplicación :C ");
				break;
			}
		} while (opcion != 7);
	}
}
