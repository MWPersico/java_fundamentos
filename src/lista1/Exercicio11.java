package lista1;

public class Exercicio11 {
    public static void main(String[] args) {
        float a, b, x;
        String equacao = "2x-5x+6=0";
        String[] membros;
        membros = equacao.split("[x=]");
        a = Float.parseFloat(membros[0])+(Float.parseFloat(membros[1]));
        b = Float.parseFloat(membros[2]);
        x = (0-b)/a;
        System.out.println("Equação: 2x-5x+6=0");
        System.out.printf("Resultado: x = %.2f",x);
        //A ideia seria o código servir para qualquer equação de 1º grau, mas não consegui montar a regex;
    }
}
