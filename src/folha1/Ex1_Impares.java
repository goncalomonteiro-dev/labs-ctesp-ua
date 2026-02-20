import java.util.Scanner;  // Scanner para ler input do utilizador

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Cria Scanner para ler do teclado
        int n;

        // Ciclo DO-WHILE garante que lê pelo menos uma vez E valida N > 0
        // Evita loop infinito se input inválido (ex: letras causam exceção)
        do {
            System.out.print("Introduza N (positivo): ");
            n = sc.nextInt();  // Lê inteiro; nextLine() ignora espaços

            if (n <= 0) {
                System.out.println("entrada inválida");  // Feedback imediato
            } else {
                System.out.println("entrada válida");  // Confirma input correto
            }
        } while (n <= 0);  // Repete só se N <= 0 (positivo obrigatório)

        // Ajuste crucial: se N par, vai para próximo ímpar (ex: 26 -> 27)
        if (n % 2 == 0) {
            n = n + 1;
        }

        // Ciclo WHILE imprime ímpares de N até 30 (incremento +2 salta pares)
        // Condição n <= 30 garante parar exatamente em 29 (último ímpar)
        while (n <= 30) {
            System.out.println(n + " -> saída");
            n = n + 2;  // +2 mantém sempre ímpares
        }

        sc.close();  // Boa prática: fecha Scanner para liberar recursos
    }
}
