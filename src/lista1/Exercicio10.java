package lista1;
import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        float valor;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        valor = sc.nextFloat();
        for(int i = 1; i<=10; i++){
            System.out.printf("\n%d X %.2f = %.2f",i, valor, valor*i);
        }
        sc.close();
    }
}
