// Classe com a lógica das operações.
public class Calculadora {
    private double num1;
    private double num2;
    private char operador;

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double calcular() {
        // Switch basico para retornar as operaçoes
        switch (operador) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) throw new ArithmeticException("Divisão por zero");
                return num1 / num2;
            default: return 0;
        }
    }
}
