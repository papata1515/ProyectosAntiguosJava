package UsosdelStringenCadean;



public class StringUsosTres {
    public boolean esPalindromo(String frase) {
        String limpia = frase.replace(" ", "").toLowerCase();
        StringUsosDos inversor = new StringUsosDos();
        return limpia.equals(inversor.invertirFrase(limpia));
    }
}
