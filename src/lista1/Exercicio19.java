package lista1;
import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        String valor1, valor2, memoria;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor literal qualquer: ");
        valor1 = sc.nextLine();
        System.out.print("Digite outro valor literal qualquer: ");
        valor2 = sc.nextLine();
        memoria = valor2;
        valor2 = valor1;
        valor1 = memoria;
        System.out.printf("Conteúdos das variáveis:\nvalor1 = %s;\nvalor2 = %s;", valor1, valor2);
        sc.close();
    }
}