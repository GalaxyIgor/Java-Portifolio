public class JogoDaForca {
    private PalavraSecreta palavraSecreta;
    private Jogador jogador;
    private ForcaUI ui;

    public JogoDaForca() {
        this.palavraSecreta = new PalavraSecreta();
        this.jogador = new Jogador(6); // 6 tentativas
        this.ui = new ForcaUI();
    }

    public void iniciar() {
        ui.mostrarMensagem("Bem-vindo ao Jogo da Forca!");
        ui.mostrarMensagem("A palavra tem " + palavraSecreta.getTamanho() + " letras.");

        while (jogador.podeTentar() && !palavraSecreta.foiCompletada()) {
            ui.mostrarStatus(
                    palavraSecreta.getLetrasReveladas(),
                    jogador.getTentativasRestantes(),
                    jogador.getLetrasTentadas()
            );

            char palpite = ui.obterPalpite();
            boolean acertou = palavraSecreta.revelarLetra(palpite);
            jogador.registrarTentativa(palpite, acertou);

            if (acertou) {
                ui.mostrarMensagem("Boa! Você acertou uma letra.");
            } else {
                ui.mostrarMensagem("Letra errada! Você perdeu uma tentativa.");
            }
        }

        finalizarJogo();
        ui.fechar();
    }

    private void finalizarJogo() {
        if (palavraSecreta.foiCompletada()) {
            ui.mostrarMensagem("\nParabéns! Você acertou a palavra: " + palavraSecreta.getPalavra());
        } else {
            ui.mostrarMensagem("\nGame Over! Você perdeu.");
            ui.mostrarMensagem("A palavra era: " + palavraSecreta.getPalavra());
        }
    }
}
