package calculadora;

public class TesteCalculadora {

    static int aprovados = 0;
    static int reprovados = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("===== TESTES DA CALCULADORA =====");

        verificar("Soma", calc, 2, 3, "+", 5);
        verificar("Subtração", calc, 10, 4, "-", 6);
        verificar("Multiplicação", calc, 3, 5, "*", 15);
        verificar("Divisão", calc, 8, 2, "/", 4);
        verificar("Divisão por zero", calc, 8, 0, "/", 0);
        verificar("Operação inválida", calc, 5, 5, "x", 0);

        System.out.println();
        System.out.println("Total: " + (aprovados + reprovados)
                + " | Aprovados: " + aprovados
                + " | Reprovados: " + reprovados);
    }

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
