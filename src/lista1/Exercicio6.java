package lista1;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        float salario;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o salário bruto (R$): ");
        salario = sc.nextFloat()*1.1f;
        salario -= salario*.15f;
        System.out.printf("O salário líquido do funcionário é: R$%.2f", salario);
        sc.close();
    }
}
