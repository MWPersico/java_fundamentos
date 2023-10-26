package lista1;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        float raio, area, perimetro;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o raio de um circulo: ");
        raio = sc.nextFloat();
        area=(float) (Math.pow(raio, 2)*Math.PI);
        System.out.println(area);
        perimetro=(float) (2*Math.PI*raio);
        System.out.printf("Este circulo tem area de %.2f e circunferência de %.2f.", area, perimetro);
        sc.close();
    }
}