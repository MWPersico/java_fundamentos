package lista1;
import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
    float alturaDegrau, alturaDesejada;
    Scanner sc = new Scanner(System.in);
    System.out.print("Insira o tamanho de um degrau (metros): ");
    alturaDegrau = sc.nextFloat();
    System.out.print("Que altura desejas alcançar? (metros): ");
    alturaDesejada = sc.nextFloat();
    System.out.printf("Para alcançar %.2f metros você deve subir %.2f degraus;", alturaDesejada, alturaDesejada/alturaDegrau);
    sc.close();
    }
}