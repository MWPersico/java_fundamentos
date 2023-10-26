package lista1;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        float[] notas = new float[3];
        float[] pesos = new float[3];
        float media;
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++){
            System.out.printf("Insira a %dª nota: ", (i+1));
            notas[i] = sc.nextFloat();
            System.out.printf("Insira o peso da %dª nota: ", (i+1));
            pesos[i] = sc.nextFloat();
        }
        media = (notas[0]*pesos[0]+notas[1]*pesos[1]+notas[2]*pesos[2])/(pesos[0]+pesos[1]+pesos[2]);
        System.out.printf("\nA média ponderada entre suas notas é: %.2f", media);
        sc.close();
    }
}