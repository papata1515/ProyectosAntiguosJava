package UsosdelStringenCadean;



public class StringUsosCuatro {
    public String cambiarVocales(String frase, char simbolo) {
        return frase.replaceAll("[aeiouAEIOU]", String.valueOf(simbolo));
    }
}
