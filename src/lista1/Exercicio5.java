package lista1;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        String nome;
        float salario;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do funcionário: ");
        nome = sc.nextLine();
        System.out.print("Salário do funcionário (R$): ");
        salario = sc.nextFloat();
        System.out.printf("%s recebeu um aumento de 25%%, agora seu salário é de R$%.2f", nome, salario*1.25);
        sc.close();
    }
}
