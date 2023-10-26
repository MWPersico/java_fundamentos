package lista1;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        float base, altura, area;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a base do triângulo: ");
        base = sc.nextFloat();
        System.out.print("Insira a altura do triângulo: ");
        altura = sc.nextFloat();
        area = (base*altura)/2;
        System.out.print("A área deste triângulo mede: "+area);
        sc.close();
    }
}