import java.util.Scanner;

public class TrianguloPontos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1, y1, x2, y2, x3, y3;

        // Leitura das 6 coordenadas
        System.out.print("x1: ");
        x1 = sc.nextDouble();
        System.out.print("y1: ");
        y1 = sc.nextDouble();
        System.out.print("x2: ");
        x2 = sc.nextDouble();
        System.out.print("y2: ");
        y2 = sc.nextDouble();
        System.out.print("x3: ");
        x3 = sc.nextDouble();
        System.out.print("y3: ");
        y3 = sc.nextDouble();

        // Calcula os 3 lados usando função auxiliar (reutiliza código)
        double a = distancia(x1, y1, x2, y2);  // P1-P2
        double b = distancia(x2, y2, x3, y3);  // P2-P3
        double c = distancia(x1, y1, x3, y3);  // P1-P3

        // Teorema da desigualdade triangular: cada lado < soma dos outros
        // Todas 3 condições devem ser verdadeiras para formar triângulo
        if (a < b + c && b < a + c && c < a + b) {
            System.out.println("Os pontos formam um triangulo.");
        } else {
            System.out.println("Os pontos NAO formam um triangulo.");
        }

        sc.close();
    }

    // Função reutilizável para calcular qualquer distância (DRY principle)
    public static double distancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
