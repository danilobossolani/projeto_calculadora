package calculadora;

/**
 * <p>Testes unitários da classe {@link Calculadora}.</p>
 *
 * <p>Cada caso de teste mostra no console a entrada utilizada, o resultado
 * esperado, o resultado obtido e se o teste passou ou falhou. Ao final é
 * exibido um resumo com o total de testes aprovados e reprovados.</p>
 *
 * @author Danilo Bossolani
 * @version 1.0
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

        System.out.println("===== TESTES DA CALCULADORA =====");

        // Operações válidas
        verificar("Soma", calc, 2, 3, "+", 5);
        verificar("Subtração", calc, 10, 4, "-", 6);
        verificar("Multiplicação", calc, 3, 5, "*", 15);
        verificar("Divisão", calc, 8, 2, "/", 4);

        // Casos de erro: devem retornar 0 sem interromper o programa
        verificar("Divisão por zero", calc, 8, 0, "/", 0);
        verificar("Operação inválida", calc, 5, 5, "x", 0);

        System.out.println();
        System.out.println("Total: " + (aprovados + reprovados)
                + " | Aprovados: " + aprovados
                + " | Reprovados: " + reprovados);
    }

    /**
     * Executa um caso de teste e compara o resultado obtido com o esperado.
     *
     * @param nome     nome do caso de teste
     * @param calc     instância da calculadora testada
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param op       operador da operação
     * @param esperado resultado esperado
     */
    static void verificar(String nome, Calculadora calc, int a, int b, String op, int esperado) {
        System.out.println();
        System.out.println("[" + nome + "]");
        System.out.println("Entrada: a = " + a + ", b = " + b + ", op = \"" + op + "\"");

        int obtido = calc.calc(a, b, op);

        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido: " + obtido);

        if (obtido == esperado) {
            System.out.println("Status: PASSOU");
            aprovados++;
        } else {
            System.out.println("Status: FALHOU");
            reprovados++;
        }
    }
}
