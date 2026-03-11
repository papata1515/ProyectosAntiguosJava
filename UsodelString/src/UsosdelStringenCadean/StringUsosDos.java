package UsosdelStringenCadean;

public class StringUsosDos {
	
	    public String invertirFrase(String frase) {
	        String invertida = "";
	        for (int i = frase.length() - 1; i >= 0; i--) {
	            invertida += frase.charAt(i);
	        }
	        return invertida;
	    }
	}


