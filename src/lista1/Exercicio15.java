package lista1;
import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        float racao, consumo;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de ração no saco (kilograma): ");
        racao = sc.nextFloat();
        System.out.print("Digite o consumo diário dos gatos (grama): ");
        consumo = sc.nextFloat()/1000*2;
        System.out.printf("Após 5 dias vão restar %.2fkg de ração.", racao-(consumo*5));
        sc.close();
    }
}