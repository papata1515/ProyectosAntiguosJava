package UsosdelStringenCadean;

public class StringUsosCinco {
    public int contarPalabras(String frase) {
        if (frase == null || frase.isEmpty()) return 0;
        String[] palabras = frase.trim().split("\\s+");
        return palabras.length;
    }
}
