import java.util.Scanner;

/**
 * Exercício 1 Ficha 2 - Contador de caracteres (vogais, maiúsc/minúsc, dígitos, outros).
 * Lê letras uma a uma até 'z' ou 'Z'. Atualiza contadores em tempo real.
 */
public class contadorCaracteres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vogais = 0, minusculas = 0, maiusculas = 0, digitos = 0, outros = 0;

        System.out.println("Introduza letras (z/Z para sair):");

        while (true) {
            System.out.print("Letra: ");
            String input = sc.nextLine().trim();
            if (input.length() != 1) {
                System.out.println("Insira APENAS 1 caractere!");
                continue;
            }
            char c = input.charAt(0);

            if (c == 'z' || c == 'Z') {
                System.out.println("Programa terminado.");
                break;
            }

            // Contagens com condicionais
            if (Character.isDigit(c)) digitos++;
            else if (Character.isUpperCase(c)) maiusculas++;
            else if (Character.isLowerCase(c)) minusculas++;
            else if ("aeiouAEIOU".indexOf(c) != -1) vogais++;  // Vogal (loop implícito via indexOf)
            else outros++;

            // Output atualizado (como pedido: após cada letra)
            System.out.printf("Vogais: %d | Maiúsc: %d | Minúsc: %d | Dígitos: %d | Outros: %d%n",
                    vogais, maiusculas, minusculas, digitos, outros);
        }
        sc.close();
    }
}
