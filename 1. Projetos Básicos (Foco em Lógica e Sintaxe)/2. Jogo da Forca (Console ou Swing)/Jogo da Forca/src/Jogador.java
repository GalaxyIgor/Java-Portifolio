// Classe que representa o jogador e seus dados
import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int tentativasRestantes;
    private List<Character> letrasTentadas;

    public Jogador(int tentativasIniciais) {
        this.tentativasRestantes = tentativasIniciais;
        this.letrasTentadas = new ArrayList<>();
    }

    public void registrarTentativa(char letra, boolean acertou) {
        letrasTentadas.add(Character.toUpperCase(letra));
        if (!acertou) {
            tentativasRestantes--;
        }
    }

    public boolean podeTentar() {
        return tentativasRestantes > 0;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public String getLetrasTentadas() {
        return letrasTentadas.toString();
    }
}
