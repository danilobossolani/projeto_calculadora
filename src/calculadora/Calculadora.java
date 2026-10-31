package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Módulo de cálculos básicos da FinançApp, aplicativo de controle de
 * finanças pessoais. Será usado em funcionalidades como orçamento mensal,
 * divisão de despesas e projeção de economia.</p>
 *
 * <p>Esta é a <strong>versão inicial</strong> da classe, antes da
 * refatoração. Todas as operações ficam concentradas no método
 * {@link #calc(int, int, String)}.</p>
 *
 * @author Danilo Bossolani
 * @version 1.0
 */
public class Calculadora {

    /**
     * Resultado da última operação executada.
     * Começa em {@code 0} e é atualizado a cada chamada de
     * {@link #calc(int, int, String)}.
     */
    public int r = 0;

    /**
     * Cria uma calculadora com o resultado inicial igual a zero.
     */
    public Calculadora() {
    }

    /**
     * Executa a operação matemática indicada pelo operador.
     *
     * <p>Operadores aceitos:</p>
     * <ul>
     *     <li>{@code "+"}: soma</li>
     *     <li>{@code "-"}: subtração</li>
     *     <li>{@code "*"}: multiplicação</li>
     *     <li>{@code "/"}: divisão inteira</li>
     * </ul>
     *
     * <p>Em caso de divisão por zero ou operador inválido, uma mensagem de
     * erro é exibida no console e o método retorna {@code 0}, sem
     * interromper a execução do programa.</p>
     *
     * @param a  primeiro operando
     * @param b  segundo operando
     * @param op símbolo da operação desejada
     * @return o resultado da operação, ou {@code 0} em caso de erro
     */
    public int calc(int a, int b, String op) {

        // "+".equals(op) evita NullPointerException caso op seja null
        if ("+".equals(op)) {
            r = a + b;
        } else if ("-".equals(op)) {
            r = a - b;
        } else if ("*".equals(op)) {
            r = a * b;
        } else if ("/".equals(op)) {
            // Divisão só é feita quando o divisor é diferente de zero
            if (b != 0) {
                r = a / b;
            } else {
                System.out.println("Erro: divisão por zero não é permitida.");
                r = 0;
            }
        } else {
            // Qualquer símbolo diferente dos quatro aceitos cai aqui
            System.out.println("Erro: operação inválida: " + op);
            r = 0;
        }

        System.out.println("Resultado = " + r);
        return r;
    }
}
