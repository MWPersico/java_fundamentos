package lista1;
import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        float cateto1, cateto2, hipotenusa;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro cateto: ");
        cateto1 = sc.nextFloat();
        System.out.print("Digite o segundo cateto: ");
        cateto2 = sc.nextFloat();
        hipotenusa = (float) Math.hypot(cateto1, cateto2);
        System.out.printf("A hipotenusa do triângulo é: %.4f", hipotenusa);
        sc.close();
    }
}
