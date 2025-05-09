// Classe que encapsula a lógica da palavra a ser adivinhada
import java.util.Random;

public class PalavraSecreta {
    private static final String[] PALAVRAS = {
            "JAVA", "PROGRAMACAO", "COMPUTADOR", "ALGORITMO", "DESENVOLVIMENTO"
    };

    private String palavra;
    private char[] letrasReveladas;

    public PalavraSecreta() {
        Random random = new Random();
        this.palavra = PALAVRAS[random.nextInt(PALAVRAS.length)];
        this.letrasReveladas = new char[palavra.length()];

        for (int i = 0; i < letrasReveladas.length; i++) {
            letrasReveladas[i] = '_';
        }
    }

    public boolean revelarLetra(char letra) {
        boolean acertou = false;
        letra = Character.toUpperCase(letra);

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                letrasReveladas[i] = letra;
                acertou = true;
            }
        }

        return acertou;
    }

    public boolean foiCompletada() {
        return new String(letrasReveladas).equals(palavra);
    }

    public String getPalavra() {
        return palavra;
    }

    public String getLetrasReveladas() {
        return new String(letrasReveladas);
    }

    public int getTamanho() {
        return palavra.length();
    }
}
