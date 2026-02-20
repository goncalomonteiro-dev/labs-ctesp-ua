import java.util.Scanner;

public class DistanciaPontos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1, y1, x2, y2;  // Coordenadas double para precisão

        // Leitura dos 4 valores
        System.out.print("x1: ");
        x1 = sc.nextDouble();
        System.out.print("y1: ");
        y1 = sc.nextDouble();
        System.out.print("x2: ");
        x2 = sc.nextDouble();
        System.out.print("y2: ");
        y2 = sc.nextDouble();

        // Verificação inicial: pontos iguais (otimização, evita sqrt desnecessário)
        if (x1 == x2 && y1 == y2) {
            System.out.println("Pontos Coincidentes");
        } else {
            // Fórmula euclidiana: sqrt(Δx² + Δy²)
            double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.println("Distancia entre os pontos: " + distancia);
        }

        sc.close();
    }
}
