import java.util.Scanner;

/**
 * Exercício 2 Ficha 2 - Puzzle chinês: galinhas (2 pernas) + coelhos (4 pernas) = X cabeças, Y pernas.
 * Resolve sistema: C + G = X; 4C + 2G = Y. Valida X>0 inteiro, Y par.
 * Saída: G C (ex: 35 94 → 23 12)
 */
public class puzzleGalinhaseCoelhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X, Y;

        // Validação X > 0 inteiro
        do {
            System.out.print("Número de cabeças X (>0): ");
            X = sc.nextInt();
            if (X <= 0) System.out.println("X deve ser inteiro > 0!");
        } while (X <= 0);

        // Validação Y par inteiro
        do {
            System.out.print("Número de pernas Y (par): ");
            Y = sc.nextInt();
            if (Y % 2 != 0) System.out.println("Y deve ser par!");
        } while (Y % 2 != 0);

        // Resolve sistema: G = (2X - Y/2); C = X - G
        int G = 2 * X - (Y / 2);
        int C = X - G;

        // Verifica solução não-negativa (lógica implícita na ficha)
        if (G < 0 || C < 0) {
            System.out.println("Sem solução possível!");
        } else {
            System.out.printf("%d %d%n", G, C);  // Formato exato da ficha
        }
        sc.close();
    }
}
