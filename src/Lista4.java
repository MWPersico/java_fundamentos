import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Lista4 {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Lista4 lista = new Lista4();
        lista.clear();
        System.out.print("Bem vindo a lista 4 de exercícios Java! Laços de repetição.");
        lista.menu();
        lista.sc.close();
    }


    //Exercicios:
    public void Exercicio1(){
        clear();
        System.out.println("Números divisíveis por três entre 50 e 9500:");
        for(int i = 51; i<=9500; i+=3){
            System.out.print(i+",");
        }
    }

    public void Exercicio2(){
        clear();
        System.out.println("Multiplos de 10 de 1 a 250: ");
        for(int i = 10; i<=250; i++){
            System.out.print(i);
            if(i%10==0){
                System.out.print("(multiplo de 10)");
            }
            System.out.println("");
        }
    }

    public void Exercicio3(){
        clear();
        int soma = 0;
        System.out.println("Soma dos números de 0 a 100:");
        System.out.print("0");
        for(int i = 1; i<=100; i++){
            soma+=i;
            System.out.print("+"+i);
        }
        System.out.print("="+soma);
    }

    public void Exercicio4(){
        clear();
        int soma, inicio, fim;
        soma = inicio = fim = 0;
        try{
            System.out.println("Qual é o intervalo que gostaria de somar (positivo inteiro):");
            System.out.print("Inicio: ");
            inicio = sc.nextInt();
            System.out.print("Fim: ");
            fim = sc.nextInt();
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
        clear();
        System.out.printf("Soma de %d a %d:%n", inicio, fim);
        System.out.print("0");
        for(int i = inicio; i<= fim; i++){
            soma+=i;
            System.out.print("+"+i);
        }
        System.out.print("="+soma);
    }

    public void Exercicio5(){
        clear();
        int soma = 0;
        System.out.println("Soma dos 15 primeiros termos da sequência {5, 10, 15...}:");
        System.out.print("0");
        for(int i=5; i<=15*5;i+=5){
            soma+=i;
            System.out.print("+"+i);
        }
        System.out.print("="+soma);
    }

    public void Exercicio6(){
        clear();
        int soma, inicio, passo, limite, delimitador;
        soma = inicio = passo = limite = delimitador = 0;
        System.out.println("Qual é o intervalo que gostaria de somar (positivo inteiro):");
        try{
            System.out.print("Primeiro termo: ");
            inicio = sc.nextInt();
            System.out.print("Razão da progressão: ");
            passo = sc.nextInt();
            System.out.print("Quantos termos gostaria de somar: ");
            limite = sc.nextInt();
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
        System.out.printf("Soma dos %d primeiros termos da sequência {%d, %d, %d...}:%n",limite, inicio, inicio+passo, inicio+passo*2);
        System.out.print("0");
        int i = inicio;
        while(delimitador<limite){
            soma+=i;
            System.out.print("+"+i);
            i+=passo;
            delimitador++;
        }
        System.out.print("="+soma);
    }

    public void Exercicio7(){
        //Criado trabalhando com juros simples, aumento baseado no salaário inicial (falta de informações)
        clear();
        Double initialSalary, salary, increase;
        initialSalary = salary = 1000.00;
        increase = 1.5/100;
        System.out.println("- Aumento salarial de um funcionario -");
        System.out.println("Ano de contratação: 2010");
        System.out.println("Salário inicial: R$ 1.000,00");
        System.out.println("- Aumento -\nPrimeiro ano: 1,5%\nDemais anos: Dobro do ano anterior");
        System.out.println("\n- Salário durante os anos -");
        salary+=initialSalary*increase;
        for(int year = 2011; year<=2023 ; year++){
            System.out.printf("Salário em %d (%.3f%%): R$ %.2f\n", year, increase, salary);
            increase*=2;
            salary+=initialSalary*increase;
        }
    }

    public void Exercicio8(){
        Double joaoBaseSalary, carlosBaseSalary, joaoSalary, carlosSalary;
        joaoBaseSalary = carlosBaseSalary =joaoSalary = carlosSalary = 0.;
        int month = 0;
        System.out.print("Digite o salário de Carlos (R$): ");
        try{carlosSalary = carlosBaseSalary = sc.nextDouble();}catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
        joaoSalary = joaoBaseSalary= carlosBaseSalary/3;
        System.out.println("-- Salários durante os meses --\nMês | Carlos  |  João");
        while(joaoSalary<carlosSalary){
            joaoSalary = joaoSalary+joaoSalary*0.05 + joaoBaseSalary;
            carlosSalary = carlosSalary+carlosSalary*0.02 + carlosBaseSalary;
            month++; 
            System.out.printf("%d | R$ %.2f  |  R$ %.2f\n", month, carlosSalary, joaoSalary);
        }
        System.out.printf("\n\nApós %d meses investindo, a capital de João se igualou ou ultrapassou a de Carlos", month);
    }

    public void Exercicio9(){
        clear();
        int soma, contador, input;
        soma = contador = input = 0;
        List<Integer> negativos = new ArrayList<Integer>();
        System.out.println("Insira valores inteiro (0 para encerrar):");
        try{
            while(true){
                contador++;
                System.out.print(contador+"º valor: ");
                input = sc.nextInt();
                if(input==0)break;
                if(input<0){
                    negativos.add(input);
                    continue;
                }else{
                    soma+=input;
                };
            }
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
        clear();
        System.out.println("Soma dos números positivos: "+soma);
        System.out.printf("Você digitou %d números negativos: %s", negativos.size(), negativos.toString());
    }

    public void Exercicio10(){
        clear();
        Float nota = 0f;
        System.out.print("Digite a nota do aluno (0-10): ");
        try{
            nota = sc.nextFloat();
            if(nota<0 || nota>10){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
        if(nota>=6){
            System.out.println("Aluno aprovado!!");
        }else if(nota>=5){
            System.out.println("Aluno de recuperação!!");
        }else{
            System.out.println("Aluno reprovado!!");
        }
    }

    // Métodos para fucnionamento do programa:
    public void menu(){
        String input;
        String methodName = "Exercicio";
        java.lang.reflect.Method method;
        System.out.print("\n\nDigite o exercício que deseja testar [1-17] (0 para encerrar): ");
        input = sc.next();
        if(!input.equals("0")){
            methodName+=input;
            try {
              method = this.getClass().getMethod(methodName);
              method.invoke(this);
              menu();
            }catch (Exception ex) {
                clear();
                System.out.println("Selecione um exercício válido!");
                menu();
            }
        }else{System.exit(0);}
    }

    public void recallMethod(String methodName){
        clear();
        java.lang.reflect.Method method;
        System.out.println("Valor errado digitado, vamos tentar de novo!");
        try{
            Thread.sleep(1000);
            method = this.getClass().getMethod(methodName);
            sc.nextLine();
            method.invoke(this);
        }catch(Exception ex2){ex2.printStackTrace();} 
    }

    public void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}

//catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName());}
