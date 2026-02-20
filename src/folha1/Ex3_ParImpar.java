import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.print("Introduza um numero inteiro: ");
        num = sc.nextInt();

        // Operador % (resto da divisão): 0 = par, resto 1 = ímpar
        // Funciona para negativos também (ex: -4 % 2 == 0)
        if (num % 2 == 0) {
            System.out.println(num + " é par");
        } else {
            System.out.println(num + " é impar");
        }

        sc.close();
    }
}
