package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Módulo de cálculos básicos da FinançApp, aplicativo de controle de
 * finanças pessoais. Será usado em funcionalidades como orçamento mensal,
 * divisão de despesas e projeção de economia.</p>
 *
 * @author Danilo Bossolani
 * @version 1.1
 */
public class Calculadora {

    /**
     * Resultado da última operação executada.
     */
    private int ultimoResultado = 0;

    /**
     * Cria uma calculadora com o resultado inicial igual a zero.
     */
    public Calculadora() {
    }

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return a soma de {@code a} e {@code b}
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return a diferença entre {@code a} e {@code b}
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o produto de {@code a} e {@code b}
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número pelo segundo.
     *
     * @param a dividendo
     * @param b divisor
     * @return o quociente de {@code a} por {@code b}, ou {@code 0} se {@code b} for zero
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            System.out.println("Erro: divisão por zero não é permitida.");
            return 0;
        }
        return a / b;
    }

    /**
     * Executa a operação indicada pelo operador.
     *
     * @param a  primeiro operando
     * @param b  segundo operando
     * @param op símbolo da operação desejada
     * @return o resultado da operação, ou {@code 0} em caso de erro
     */
    public int calc(int a, int b, String op) {
        if ("+".equals(op)) {
            ultimoResultado = somar(a, b);
        } else if ("-".equals(op)) {
            ultimoResultado = subtrair(a, b);
        } else if ("*".equals(op)) {
            ultimoResultado = multiplicar(a, b);
        } else if ("/".equals(op)) {
            ultimoResultado = dividir(a, b);
        } else {
            System.out.println("Erro: operação inválida: " + op);
            ultimoResultado = 0;
        }

        System.out.println("Resultado = " + ultimoResultado);
        return ultimoResultado;
    }
}
