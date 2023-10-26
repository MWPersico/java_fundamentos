package lista1;
import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        float valor;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um comprimento para conversão (pés): ");
        valor = sc.nextFloat();
        System.out.printf("Polegadas: %.2f;\nJardas: %.2f;\nMilhas: %.2f", valor*12, valor/3, valor*0.000189394);
        sc.close();
    }
}