import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double op1, op2, resultado;  // double para números reais/decimais
        char operacao;

        System.out.print("Operando 1? ");
        op1 = sc.nextDouble();

        System.out.print("Operacao? (+, -, *, /) ");
        operacao = sc.next().charAt(0);  // charAt(0) pega 1º char (ex: '+')

        System.out.print("Operando 2? ");
        op2 = sc.nextDouble();

        boolean erro = false;  // Flag para controlar erros e evitar prints duplicados

        // SWITCH é mais eficiente que múltiplos IF para chars/ops simples
        switch (operacao) {
            case '+':
                resultado = op1 + op2;
                System.out.println("Resultado: " + resultado);
                break;  // SAI do switch
            case '-':
                resultado = op1 - op2;
                System.out.println("Resultado: " + resultado);
                break;
            case '*':
                resultado = op1 * op2;
                System.out.println("Resultado: " + resultado);
                break;
            case '/':
                // Validação CRÍTICA: divisão por zero causa exceção (Infinity)
                if (op2 == 0) {
                    System.out.println("Erro: divisao por zero nao permitida");
                    erro = true;
                } else {
                    resultado = op1 / op2;
                    System.out.println("Resultado: " + resultado);
                }
                break;
            default:  // Captura ops inválidas (ex: '?')
                System.out.println("Operacao invalida");
                erro = true;
        }

        // Print final só se sem erro (melhora UX)
        if (!erro) {
            System.out.println("Operacao concluida com sucesso");
        }

        sc.close();
    }
}
