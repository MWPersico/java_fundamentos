package lista1;
import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        float salario, conta1, conta2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu salário (R$): ");
        salario = sc.nextFloat();
        System.out.print("Digite o valor da 1ª conta (R$): ");
        conta1 = (float) (sc.nextFloat()*1.02);
        System.out.print("Digite o valor da 2ª conta (R$): ");
        conta2 = (float) (sc.nextFloat()*1.035);
        System.out.printf("Após o pagamento das contas com juros, restará do seu salário: %.2f", salario-(conta1+conta2));
        sc.close();
    }
}