package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Módulo de cálculos básicos da FinançApp, aplicativo de controle de
 * finanças pessoais. Será usado em funcionalidades como orçamento mensal,
 * divisão de despesas e projeção de economia.</p>
 *
 * <p>Esta é a <strong>versão refatorada</strong> da classe. As mudanças em
 * relação à versão inicial foram:</p>
 * <ul>
 *     <li>extração de um método para cada operação;</li>
 *     <li>troca da cadeia de {@code if/else} por {@code switch};</li>
 *     <li>uso de {@link IllegalArgumentException} para sinalizar erros;</li>
 *     <li>nomes mais descritivos para atributos e parâmetros;</li>
 *     <li>mensagens de erro centralizadas em constantes.</li>
 * </ul>
 *
 * <p>O método {@link #calc(int, int, String)} foi mantido com o mesmo
 * comportamento da versão inicial: em caso de erro ele exibe a mensagem e
 * retorna {@code 0}, sem interromper o programa.</p>
 *
 * @author Danilo Bossolani
 * @version 2.0
 */
public class Calculadora {

    /** Mensagem exibida quando há tentativa de divisão por zero. */
    public static final String MSG_DIVISAO_POR_ZERO = "Erro: divisão por zero não é permitida.";

    /** Prefixo da mensagem exibida quando o operador não é reconhecido. */
    public static final String MSG_OPERACAO_INVALIDA = "Erro: operação inválida: ";

    /** Resultado da última operação executada por {@link #calc(int, int, String)}. */
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
     * Divide o primeiro número pelo segundo (divisão inteira).
     *
     * @param dividendo número a ser dividido
     * @param divisor   número pelo qual o dividendo será dividido
     * @return o quociente da divisão
     * @throws IllegalArgumentException se o divisor for zero
     */
    public int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException(MSG_DIVISAO_POR_ZERO);
        }
        return dividendo / divisor;
    }

    /**
     * <p>Executa a operação matemática solicitada com base no operador informado.</p>
     *
     * <p>Operadores aceitos:</p>
     * <ul>
     *     <li>{@code "+"}: soma</li>
     *     <li>{@code "-"}: subtração</li>
     *     <li>{@code "*"}: multiplicação</li>
     *     <li>{@code "/"}: divisão</li>
     * </ul>
     *
     * <p>Qualquer operador inválido resulta em exceção.</p>
     *
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param operador símbolo da operação desejada
     * @return o resultado da operação correspondente ao operador informado
     * @throws IllegalArgumentException se o operador for inválido ou nulo,
     *                                  ou se houver divisão por zero
     */
    public int calcular(int a, int b, String operador) {
        // switch não aceita null, então o caso é tratado antes
        if (operador == null) {
            throw new IllegalArgumentException(MSG_OPERACAO_INVALIDA + operador);
        }

        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException(MSG_OPERACAO_INVALIDA + operador);
        };
    }

    /**
     * Executa a operação e exibe o resultado no console, sem lançar exceções.
     *
     * <p>Método principal exigido pela atividade. Mantém o comportamento da
     * versão inicial: em caso de erro, exibe a mensagem e retorna {@code 0}.</p>
     *
     * @param a  primeiro operando
     * @param b  segundo operando
     * @param op símbolo da operação desejada
     * @return o resultado da operação, ou {@code 0} em caso de erro
     */
    public int calc(int a, int b, String op) {
        try {
            ultimoResultado = calcular(a, b, op);
        } catch (IllegalArgumentException e) {
            // O erro é exibido e tratado aqui para não interromper o programa
            System.out.println(e.getMessage());
            ultimoResultado = 0;
        }

        System.out.println("Resultado = " + ultimoResultado);
        return ultimoResultado;
    }

    /**
     * Retorna o resultado da última operação feita por {@link #calc(int, int, String)}.
     *
     * @return o último resultado calculado
     */
    public int getUltimoResultado() {
        return ultimoResultado;
    }
}
