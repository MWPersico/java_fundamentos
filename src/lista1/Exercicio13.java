package lista1;
import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
    float kWpreco, kWconsumido, debito;
    Scanner sc = new Scanner(System.in);
    System.out.printf("Digite o valor de referência do kW(R$): ");
    kWpreco = sc.nextFloat()/10;
    System.out.printf("Quantidade de energia consumida (kW): ");
    kWconsumido = sc.nextFloat();
    debito = kWpreco*kWconsumido;
    System.out.printf("\nValor do kW: R$%.2f", kWpreco);
    System.out.printf("\nValor a ser pago: R$%.2f", debito);
    System.out.printf("\nValor a ser pago com bonus de 17%%: R$%.2f", debito-(0.17*debito));
    System.out.printf("\nValor a ser pago com acréssimo de 0,5%% por dia (10 dias de atraso): R$%.2f", debito+10*(0.005*debito));
    sc.close();
    }
}