package calculadora;

/**
 * <p>Testes unitários da classe {@link Calculadora} (versão refatorada).</p>
 *
 * <p>Os testes estão divididos em duas partes:</p>
 * <ul>
 *     <li><strong>Regressão:</strong> os mesmos casos da versão inicial,
 *     executados pelo método {@link Calculadora#calc(int, int, String)},
 *     para garantir que o comportamento não mudou após a refatoração;</li>
 *     <li><strong>Novo método:</strong> casos para
 *     {@link Calculadora#calcular(int, int, String)}, que lança exceção em
 *     caso de erro.</li>
 * </ul>
 *
 * <p>Cada caso mostra a entrada utilizada, o resultado esperado, o resultado
 * obtido e o status.</p>
 *
 * @author Danilo Bossolani
 * @version 2.0
 */
public class TesteCalculadora {

    /** Quantidade de testes que passaram. */
    static int aprovados = 0;

    /** Quantidade de testes que falharam. */
    static int reprovados = 0;

    /**
     * Construtor padrão. A classe é usada apenas pelo método {@link #main(String[])}.
     */
    public TesteCalculadora() {
    }

    /**
     * Executa todos os casos de teste da calculadora.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("===== TESTES DE REGRESSÃO: calc() =====");

        verificarCalc("Soma", calc, 2, 3, "+", 5);
        verificarCalc("Subtração", calc, 10, 4, "-", 6);
        verificarCalc("Multiplicação", calc, 3, 5, "*", 15);
        verificarCalc("Divisão", calc, 8, 2, "/", 4);
        verificarCalc("Divisão por zero", calc, 8, 0, "/", 0);
        verificarCalc("Operação inválida", calc, 5, 5, "x", 0);

        System.out.println();
        System.out.println("===== TESTES DO MÉTODO REFATORADO: calcular() =====");

        verificarCalcular("Soma", calc, 2, 3, "+", 5);
        verificarCalcular("Subtração", calc, 10, 4, "-", 6);
        verificarCalcular("Multiplicação", calc, 3, 5, "*", 15);
        verificarCalcular("Divisão", calc, 8, 2, "/", 4);
        verificarExcecao("Divisão por zero", calc, 8, 0, "/",
                Calculadora.MSG_DIVISAO_POR_ZERO);
        verificarExcecao("Operação inválida", calc, 5, 5, "x",
                Calculadora.MSG_OPERACAO_INVALIDA + "x");
        verificarExcecao("Operador nulo", calc, 5, 5, null,
                Calculadora.MSG_OPERACAO_INVALIDA + "null");

        System.out.println();
        System.out.println("Total: " + (aprovados + reprovados)
                + " | Aprovados: " + aprovados
                + " | Reprovados: " + reprovados);
    }

    /**
     * Testa o método {@link Calculadora#calc(int, int, String)}.
     *
     * @param nome     nome do caso de teste
     * @param calc     instância da calculadora testada
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param op       operador da operação
     * @param esperado resultado esperado
     */
    static void verificarCalc(String nome, Calculadora calc, int a, int b, String op, int esperado) {
        imprimirEntrada(nome, a, b, op);
        int obtido = calc.calc(a, b, op);
        registrar(String.valueOf(esperado), String.valueOf(obtido));
    }

    /**
     * Testa o método {@link Calculadora#calcular(int, int, String)} com uma
     * operação válida.
     *
     * @param nome     nome do caso de teste
     * @param calc     instância da calculadora testada
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param op       operador da operação
     * @param esperado resultado esperado
     */
    static void verificarCalcular(String nome, Calculadora calc, int a, int b, String op, int esperado) {
        imprimirEntrada(nome, a, b, op);
        String obtido;
        try {
            obtido = String.valueOf(calc.calcular(a, b, op));
        } catch (IllegalArgumentException e) {
            obtido = "exceção: " + e.getMessage();
        }
        registrar(String.valueOf(esperado), obtido);
    }

    /**
     * Testa se {@link Calculadora#calcular(int, int, String)} lança
     * {@link IllegalArgumentException} com a mensagem esperada.
     *
     * @param nome             nome do caso de teste
     * @param calc             instância da calculadora testada
     * @param a                primeiro operando
     * @param b                segundo operando
     * @param op               operador da operação
     * @param mensagemEsperada mensagem esperada na exceção
     */
    static void verificarExcecao(String nome, Calculadora calc, int a, int b, String op,
                                 String mensagemEsperada) {
        imprimirEntrada(nome, a, b, op);
        String esperado = "IllegalArgumentException: " + mensagemEsperada;
        String obtido;
        try {
            obtido = "retornou " + calc.calcular(a, b, op) + " (sem exceção)";
        } catch (IllegalArgumentException e) {
            obtido = "IllegalArgumentException: " + e.getMessage();
        }
        registrar(esperado, obtido);
    }

    /**
     * Exibe o nome do caso de teste e os valores de entrada.
     *
     * @param nome nome do caso de teste
     * @param a    primeiro operando
     * @param b    segundo operando
     * @param op   operador da operação
     */
    static void imprimirEntrada(String nome, int a, int b, String op) {
        System.out.println();
        System.out.println("[" + nome + "]");
        String operador = (op == null) ? "null" : "\"" + op + "\"";
        System.out.println("Entrada: a = " + a + ", b = " + b + ", op = " + operador);
    }

    /**
     * Compara o resultado esperado com o obtido, exibe o status e atualiza
     * os contadores.
     *
     * @param esperado resultado esperado
     * @param obtido   resultado obtido
     */
    static void registrar(String esperado, String obtido) {
        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido: " + obtido);

        if (esperado.equals(obtido)) {
            System.out.println("Status: PASSOU");
            aprovados++;
        } else {
            System.out.println("Status: FALHOU");
            reprovados++;
        }
    }
}
