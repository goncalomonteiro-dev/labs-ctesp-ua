import java.util.*;

public class operadoraTEL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ler o número de registos, garantindo que é positivo
        int n;
        do {
            System.out.print("Número de registos: ");
            n = sc.nextInt();
        } while (n <= 0);

        // HashMap para guardar: número → total de segundos
        Map<Integer, Integer> chamadas = new HashMap<>();

        // Ler cada registo
        for (int i = 0; i < n; i++) {

            // Validar número de telefone (tem de ter 9 dígitos)
            int numTel;
            do {
                System.out.print("Número de telefone (9 dígitos): ");
                numTel = sc.nextInt();
            } while (numTel < 100000000 || numTel > 999999999);

            // Validar duração da chamada
            int duracao;
            do {
                System.out.print("Duração da chamada (segundos): ");
                duracao = sc.nextInt();
            } while (duracao <= 0);

            // Somar a duração ao número (se já existir, acumula)
            chamadas.put(numTel, chamadas.getOrDefault(numTel, 0) + duracao);
        }

        // Obter os números e ordená‑los
        List<Integer> numeros = new ArrayList<>(chamadas.keySet());
        Collections.sort(numeros);

        // Calcular e imprimir o custo para cada número
        for (int num : numeros) {
            double minutos = chamadas.get(num) / 60.0; // converter segundos para minutos
            double custo = minutos * 0.342;            // custo por minuto
            System.out.printf("%d %.2f%n", num, custo);
        }
    }
}
