import java.util.*;

public class provaNatacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ler número de nadadores (1 a 100)
        int n;
        do {
            System.out.print("Número de nadadores: ");
            n = sc.nextInt();
        } while (n < 1 || n > 100);

        // Ler a ronda (1, 2 ou 4)
        int r;
        do {
            System.out.print("Ronda (1-final, 2-meias, 4-quartos): ");
            r = sc.nextInt();
        } while (r != 1 && r != 2 && r != 4);

        sc.nextLine(); // limpar buffer do teclado

        // Lista para guardar os nadadores
        List<nadador> lista = new ArrayList<>();

        // Ler dados dos nadadores
        for (int i = 0; i < n; i++) {

            // Ler nome (máx 10 caracteres)
            String nome;
            do {
                System.out.print("Nome (máx 10 chars): ");
                nome = sc.next();
            } while (nome.length() > 10);

            // Ler tempo (1 a 1000)
            int tempo;
            do {
                System.out.print("Tempo (1-1000): ");
                tempo = sc.nextInt();
            } while (tempo < 1 || tempo > 1000);

            // Criar nadador e adicionar à lista
            lista.add(new nadador(nome, tempo));
        }

        // Ordenar nadadores usando compareTo()
        Collections.sort(lista);

        // Calcular quantos passam à próxima fase
        int qualificados = 8 * r; // final=8, meias=16, quartos=32

        // Imprimir os qualificados (ou todos se houver menos)
        for (int i = 0; i < qualificados && i < lista.size(); i++) {
            System.out.println(lista.get(i).getNome());
        }
    }
}
