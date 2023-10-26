package lista1;
import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        float valorSaque;
        int[] notas = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.printf("Insira o valor para saque (multiplo de 5): ");
        valorSaque = sc.nextFloat();
        while(valorSaque>0){
            if(valorSaque-100>0){
            notas[0]++;
            valorSaque-=100;
            }else if(valorSaque-50>0){
            notas[1]++;
            valorSaque-=50;
            }else if(valorSaque-20>0){
            notas[2]++;
            valorSaque-=20;
            }else if(valorSaque-10>0){
            notas[3]++;
            valorSaque-=10;
            }else{
            notas[4]++;
            valorSaque-=5;
            }
        }
        
        //Muitas condicionais, mas não precisei usar módulo %;
        System.out.printf("Serão necessárias:\n%d notas de R$100;\n%d notas de R$50;\n%d notas de R$20;\n%d notas de R$10;\n%d notas de R$5;", notas[0],notas[1],notas[2],notas[3],notas[4]);
        sc.close();
    }
}