import java.util.Scanner;

public class Ex2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num;

    System.out.print("Introduza um numero inteiro: ");
    num = sc.nextInt();

    // Evita output errado como no código C original (zero ia para "menor")
    
    if (num > 0) {
      System.out.println(num + " e' maior do que zero");
    } else if (num < 0) {
      System.out.println(num + " e' menor do que zero");
    } else {  // num == 0 (único caso restante)
      System.out.println("O valor introduzido é zero");
    }

    sc.close();
  }
}
