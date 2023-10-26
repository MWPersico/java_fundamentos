package lista1;
import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        float deposito, rendimento, montante;
        Scanner sc = new Scanner(System.in);
        System.out.print("Valor a ser depositado (R$): ");
        deposito = sc.nextFloat();
        System.out.print("Taxa de juros ao mês (%): ");
        rendimento = (sc.nextFloat()/100)*deposito;
        montante = deposito+rendimento;
        System.out.printf("O rendimento será de R$%.2f ao mês.\n", rendimento);
        System.out.printf("Após o periodo de um mês você terá R$%.2f", montante);
        sc.close();
    }
}