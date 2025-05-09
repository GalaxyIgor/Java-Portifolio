// Classe que gerencia a interface com o usuário (poderia ser substituída por uma versão Swing posteriormente)
import java.util.Scanner;

public class ForcaUI {
    private Scanner scanner;

    public ForcaUI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarStatus(String palavra, int tentativas, String letrasTentadas) {
        System.out.println("\nPalavra: " + palavra);
        System.out.println("Tentativas restantes: " + tentativas);
        System.out.println("Letras tentadas: " + letrasTentadas);
        desenharForca(tentativas);
    }

    public char obterPalpite() {
        System.out.print("Digite uma letra: ");
        String input = scanner.nextLine().toUpperCase();

        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.print("Por favor, digite apenas uma letra válida: ");
            input = scanner.nextLine().toUpperCase();
        }

        return input.charAt(0);
    }

    private void desenharForca(int tentativasRestantes) {
        int erros = 6 - tentativasRestantes;
        System.out.println("  _____");
        System.out.println("  |   |");

        if (erros > 0) {
            System.out.println("  O   |");
        } else {
            System.out.println("      |");
        }

        if (erros > 2) {
            System.out.print(" /|");
            if (erros > 3) {
                System.out.println("\\  |");
            } else {
                System.out.println("   |");
            }
        } else {
            System.out.println("      |");
        }

        if (erros > 4) {
            System.out.print(" / ");
            if (erros > 5) {
                System.out.println("\\  |");
            } else {
                System.out.println("   |");
            }
        } else {
            System.out.println("      |");
        }

        System.out.println("      |");
        System.out.println("______|___");
    }

    public void fechar() {
        scanner.close();
    }
}
