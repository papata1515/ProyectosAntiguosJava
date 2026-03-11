package UsosdelStringenCadean;

public class StringUsosUno {
	
	//-------------------------------------------------------------------------------------------------------------
	/**
	 * Ejercicio numero 1
	 * @param frase
	 * @return
	 */
	public int contarLetras(String frase) {
        return frase.length();
    }

    // NUEVO MÉTODO: Contar vocales
    public int contarVocales(String frase) {
        int contador = 0;
        // 1. Convertimos a minúsculas para no tener que preguntar por 'A' y 'a'
        String fraseMinus = frase.toLowerCase();

        // 2. Recorremos la frase posición por posición
        for (int i = 0; i < fraseMinus.length(); i++) {
            char letra = fraseMinus.charAt(i); // Obtenemos el carácter en la posición i

            // 3. Comprobamos si es una vocal
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contador++;
            }
        }
        return contador;
    }
    //--------------------------------------------------------------------------------------------------------------

	public String minusculas(String frase) {
		return frase.toLowerCase();
	}

	public String mayusculas(String frase) {
		return frase.toUpperCase();
	}


}
