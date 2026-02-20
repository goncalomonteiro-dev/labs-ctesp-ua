import java.util.Scanner;

public class GestaoStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays fixos simulam "base de dados" simples (até 100 artigos)
        final int MAX = 100;  // Constante para limite de stock
        String[] referencia = new String[MAX];
        String[] descricao = new String[MAX];
        double[] preco = new double[MAX];
        int tamanho = 0;  // Contador real de artigos (0 = stock vazio)

        char opcao;

        // Menu principal em DO-WHILE: repete até 's'
        do {
            // Print do menu (claro e conciso)
            System.out.println("Gestao de stock:");
            System.out.println("N - novo artigo");
            System.out.println("P - preco de um artigo");
            System.out.println("V - venda de artigo");
            System.out.println("L - listar todo o stock");
            System.out.println("S - sair");
            System.out.print("Escolha uma opcao: ");

            // toLowerCase() aceita maiúsculas/minúsculas
            opcao = sc.next().toLowerCase().charAt(0);

            switch (opcao) {
                case 'n':  // Novo artigo com validações
                    if (tamanho >= MAX) {
                        System.out.println("Stock cheio, nao é possivel adicionar mais artigos.");
                    } else {
                        sc.nextLine();  // Limpa buffer após next() (importante!)
                        System.out.print("Referencia: ");
                        String ref = sc.nextLine();  // nextLine() para strings com espaços

                        System.out.print("Descricao: ");
                        String desc = sc.nextLine();

                        double p;
                        // Validação: preço > 0 (loop até válido)
                        do {
                            System.out.print("Preco (positivo): ");
                            p = sc.nextDouble();
                            if (p <= 0) {
                                System.out.println("Preco invalido. Tem de ser positivo.");
                            }
                        } while (p <= 0);

                        // Adiciona no fim do array
                        referencia[tamanho] = ref;
                        descricao[tamanho] = desc;
                        preco[tamanho] = p;
                        tamanho++;  // Incrementa contador
                        System.out.println("Artigo adicionado com sucesso.");
                    }
                    break;

                case 'p':  // Preço por referência
                    sc.nextLine();  // Limpa buffer
                    System.out.print("Referencia do artigo: ");
                    String refPreco = sc.nextLine();

                    int indicePreco = procurarReferencia(referencia, tamanho, refPreco);
                    if (indicePreco == -1) {
                        System.out.println("Artigo nao encontrado. Preco: 1.00");  // Default 1.00
                    } else {
                        System.out.println("Preco do artigo: " + preco[indicePreco]);
                    }
                    break;

                case 'v':  // Venda: remove artigo (shift array)
                    sc.nextLine();
                    System.out.print("Referencia do artigo: ");
                    String refVenda = sc.nextLine();

                    int indiceVenda = procurarReferencia(referencia, tamanho, refVenda);
                    if (indiceVenda == -1) {
                        System.out.println("artigo nao encontrado");
                    } else {
                        // Remove "encolhendo" array (move elementos à direita)
                        for (int i = indiceVenda; i < tamanho - 1; i++) {
                            referencia[i] = referencia[i + 1];
                            descricao[i] = descricao[i + 1];
                            preco[i] = preco[i + 1];
                        }
                        tamanho--;  // Reduz contador
                        System.out.println("Artigo vendido/removido do stock.");
                    }
                    break;

                case 'l':  // Listar tudo
                    if (tamanho == 0) {
                        System.out.println("Nao ha artigos em stock.");
                    } else {
                        System.out.println("Artigos em stock:");
                        for (int i = 0; i < tamanho; i++) {
                            System.out.println("Ref: " + referencia[i]
                                    + " | Desc: " + descricao[i]
                                    + " | Preco: " + preco[i]);
                        }
                    }
                    break;

                case 's':
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opcao invalida.");  // Captura inputs errados
            }

            System.out.println();  // Linha em branco para separar iterações

        } while (opcao != 's');  // Continua até sair

        sc.close();
    }

    // Função auxiliar: procura referência e retorna índice (-1 se não existe)
    // Evita código repetido nas opções 'p' e 'v'
    public static int procurarReferencia(String[] referencia, int tamanho, String ref) {
        for (int i = 0; i < tamanho; i++) {
            if (referencia[i].equals(ref)) {  // equals() para strings (case-sensitive)
                return i;
            }
        }
        return -1;  // Não encontrado
    }
}
