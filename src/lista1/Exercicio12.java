package lista1;
import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
    float a, b, c, delta, x1, x2;
    Scanner sc = new Scanner(System.in);
    System.out.print("Insira o valor de a: ");
    a = sc.nextFloat();
    System.out.print("Insira o valor de b: ");
    b = sc.nextFloat();
    System.out.print("Insira o valor de c: ");
    c = sc.nextFloat();
    delta = (float) (Math.pow(b, 2)-4*a*c);
    if(delta>0){
        x1 = (float) (-b+Math.sqrt(delta))/(2*a);
        x2 = (float) (-b-Math.sqrt(delta))/(2*a);
        System.out.printf("x1 = %.2f\nx2 = %.2f", x1, x2);
    }else{
        System.out.println("A equação não tem raizes reais");
    }
    sc.close();
    }
}