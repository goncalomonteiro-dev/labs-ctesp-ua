import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal para gestão de carga de barcos porta-contentores.
 * Implementa menu interativo com opções c, a, r, t, s (case-insensitive).
 * Usa ArrayList<Contentor> para armazenar contentores e gerir carga.
 * Validações: capacidade > 500 toneladas, peso contentor >=1 tonelada.
 */
public class GestaoCargaBarcos {
    private static int capacidadeMaxima = 0; // Capacidade máxima em toneladas (inicial 0, indefinida)
    private static int cargaAtual = 0; // Peso total carregado atualmente
    private static ArrayList<Contentor> listContentor = new ArrayList<>(); // Lista de contentores (sugestão da ficha)
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método main: inicia o programa e loop do menu até sair.
     */
    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            mostrarMenu();
            String opcao = lerString("Escolha uma opcao: ").toLowerCase();
            switch (opcao) {
                case "c":
                    definirCapacidade();
                    break;
                case "a":
                    adicionarContentor();
                    break;
                case "r":
                    removerContentor();
                    break;
                case "t":
                    mostrarTotalCarga();
                    break;
                case "s":
                    sair = true;
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opcao nao valida!");
            }
        }
        scanner.close();
    }

    /**
     * Mostra o menu principal conforme especificado na ficha.
     */
    private static void mostrarMenu() {
        System.out.println("\nGestao de carga");
        System.out.println("c - capacidade maxima");
        System.out.println("a - adicionar contentor");
        System.out.println("r - remover contentor");
        System.out.println("t - total de carga e capacidade disponivel");
        System.out.println("s - sair");
    }

    /**
     * Define ou redefine capacidade máxima (>500 toneladas).
     * Se já definida, pede confirmação para reconfigurar.
     */
    private static void definirCapacidade() {
        if (capacidadeMaxima > 0) {
            System.out.print("Capacidade ja definida (" + capacidadeMaxima + "t).");
            if (!lerString("Reconfigurar? (s/n): ").toLowerCase().startsWith("s")) {  // <- Adiciona prompt aqui
                return;
            }
        }
        int novaCapacidade;
        do {
            System.out.print("Capacidade maxima (inteiro >500 toneladas): ");
            novaCapacidade = lerInt();
            if (novaCapacidade <= 500) {
                System.out.println("Capacidade deve ser superior a 500 toneladas!");
            }
        } while (novaCapacidade <= 500);
        // Ao redefinir, limpa carga anterior para consistência (não especificado, mas boa prática)
        capacidadeMaxima = novaCapacidade;
        cargaAtual = 0;
        listContentor.clear();
        System.out.println("Capacidade definida: " + capacidadeMaxima + " toneladas.");
    }

    /**
     * Adiciona contentor se houver espaço disponível.
     * Valida peso >=1t, verifica capacidade restante.
     */
    private static void adicionarContentor() {
        if (capacidadeMaxima == 0) {
            System.out.println("Defina primeiro a capacidade maxima (opcao c)!");
            return;
        }
        int peso;
        do {
            System.out.print("Peso do contentor (>=1 tonelada): ");
            peso = lerInt();
            if (peso < 1) {
                System.out.println("Peso deve ser igual ou superior a 1 tonelada!");
            }
        } while (peso < 1);

        if (cargaAtual + peso > capacidadeMaxima) {
            System.out.println("Sem capacidade disponivel para este contentor!");
            return;
        }

        String id = lerString("Identificacao do contentor: ");
        Contentor contentor = new Contentor(id, peso);
        listContentor.add(contentor);
        cargaAtual += peso;
        System.out.println("Contentor adicionado: " + contentor);
    }

    /**
     * Remove contentor por ID, se existir.
     * Mostra lista primeiro.
     */
    private static void removerContentor() {
        if (listContentor.isEmpty()) {
            System.out.println("Nenhum contentor para remover.");
            return;
        }
        mostrarListaContentores();
        String idARemover = lerString("Identificador a remover: ");
        boolean removido = false;
        for (Contentor c : listContentor) {
            if (c.getId().equalsIgnoreCase(idARemover)) {
                cargaAtual -= c.getPeso();
                listContentor.remove(c);
                System.out.println("Contentor removido: " + c);
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Contentor nao encontrado!");
        }
    }

    /**
     * Mostra lista de contentores, total carregado e capacidade disponível.
     */
    private static void mostrarTotalCarga() {
        if (capacidadeMaxima == 0) {
            System.out.println("Defina primeiro a capacidade maxima (opcao c)!");
            return;
        }
        mostrarListaContentores();
        int disponivel = capacidadeMaxima - cargaAtual;
        System.out.println("Total carregado: " + cargaAtual + "t / Disponivel: " + disponivel + "t");
    }

    /**
     * Mostra lista completa de contentores (ID e peso).
     */
    private static void mostrarListaContentores() {
        if (listContentor.isEmpty()) {
            System.out.println("Nenhum contentor carregado.");
            return;
        }
        System.out.println("Lista de contentores:");
        for (Contentor c : listContentor) {
            System.out.println("  " + c);
        }
    }

    /**
     * Lê string do utilizador (trim e não vazia).
     */
    private static String lerString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? lerString(prompt) : input; // Evita vazios
    }

    /**
     * Lê inteiro válido, com retry em erro.
     */
    private static int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Insira um numero inteiro valido: ");
            }
        }
    }

    /**
     * Classe Contentor: representa um contentor com ID e peso.
     * Imutável após criação, com toString para listagem.
     */
    private static class Contentor {
        private final String id;
        private final int peso;

        public Contentor(String id, int peso) {
            this.id = id;
            this.peso = peso;
        }

        public String getId() {
            return id;
        }

        public int getPeso() {
            return peso;
        }

        @Override
        public String toString() {
            return id + " (" + peso + "t)";
        }
    }
}
