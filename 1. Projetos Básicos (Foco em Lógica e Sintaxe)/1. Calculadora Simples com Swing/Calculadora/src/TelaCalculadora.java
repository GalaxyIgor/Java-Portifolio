// Interface com Swing
// Bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Classe
public class TelaCalculadora extends JFrame implements ActionListener {
    private JTextField campoTexto;
    private Calculadora calculadora;
    private boolean novoNumero = true;

    // Construtor da Tela
    public TelaCalculadora() {
        calculadora = new Calculadora();

        // Titulo da Aplicaçao
        setTitle("Calculadora POO");
        // Tamanho
        setSize(300, 400);
        // Quando a janela for fechada, o programa deve encerrar a aplicação completamente.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Dividir a tela em partes bem definidas,
        setLayout(new BorderLayout());

        // Campo de texto
        campoTexto = new JTextField();
        campoTexto.setPreferredSize(new Dimension(300, 60)); // largura, altura
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 50));
        campoTexto.setEditable(false);
        add(campoTexto, BorderLayout.NORTH);

        // Grid e Botoes
        JPanel painel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        // Personalizando Botoes com loop
        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));

            // Diferencia operações e números
            if ("+-*/".contains(texto)) {
                botao.setBackground(new Color(30, 144, 255)); // operadores (uso de rgb)
                botao.setForeground(Color.WHITE);
            } else if (texto.equals("=")) {
                botao.setBackground(Color.GREEN);
                botao.setForeground(Color.BLACK);
            } else if (texto.equals("C")) {
                botao.setBackground(Color.RED);
                botao.setForeground(Color.WHITE);
            } else {
                botao.setBackground(Color.DARK_GRAY); // números
                botao.setForeground(Color.WHITE);
            }

            botao.addActionListener(this);
            painel.add(botao);
        }

        add(painel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]")) {
            if (novoNumero) {
                campoTexto.setText(comando);
                novoNumero = false;
            } else {
                campoTexto.setText(campoTexto.getText() + comando);
            }
        } else if ("+-*/".contains(comando)) {
            calculadora.setNum1(Double.parseDouble(campoTexto.getText()));
            calculadora.setOperador(comando.charAt(0));
            novoNumero = true;
        } else if (comando.equals("=")) {
            try {
                calculadora.setNum2(Double.parseDouble(campoTexto.getText()));
                double resultado = calculadora.calcular();
                campoTexto.setText(String.valueOf(resultado));
                novoNumero = true;
            } catch (ArithmeticException ex) {
                campoTexto.setText("Erro");
            }
        } else if (comando.equals("C")) {
            campoTexto.setText("");
            novoNumero = true;
        }
    }
}
