import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Lista3 {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Lista3 lista = new Lista3();
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
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
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
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
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
        try{carlosSalary = carlosBaseSalary = sc.nextDouble();}catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
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
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
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
            if(nota<0 || nota>10){throw new InputMismatchException();}
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
        if(nota>=6){
            System.out.println("Aluno aprovado!!");
        }else if(nota>=5){
            System.out.println("Aluno de recuperação!!");
        }else{
            System.out.println("Aluno reprovado!!");
        }
    }

    public void Exercicio11(){
        clear();
        Float salary;
        System.out.print("---- Menu de Opções ----\n1. Imposto\n2. Novo Salário\n3. Classificação\n4. Encerrar programa\nEscolha uma opção: ");
        try{
            int input = sc.nextInt();
            clear();
            switch(input){
                case 1:
                    int tax = 0;
                    System.out.print("Digite um salário (R$): ");
                    salary = sc.nextFloat();
                    if(salary<=1500)tax=5;
                    else if(salary<=3000)tax=10;
                    else tax=15;
                    System.out.printf("O imposto é de %d%%", tax);
                break;
                case 2:
                    int increase = 0;
                    System.out.print("Digite um salário (R$): ");
                    salary = sc.nextFloat();
                    if(salary>4500)increase = 250;
                    else if(salary>3000)increase = 200;
                    else if(salary>2000)increase = 150;
                    else increase = 130;
                    System.out.println("Salário com aumento: R$ "+(salary+increase));
                break;
                case 3:
                    System.out.print("Digite um salário (R$): ");
                    salary = sc.nextFloat();
                    if(salary>3000)System.out.println("Bem remunerado :D");
                    else if(salary<=3000)System.out.println("Mal Remunerado :(");
                break;
                case 4:menu();break;
                default:throw new InputMismatchException();
            }
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
    }

    public void Exercicio12(){
        // Classe Consumer no fim do arquivo...
        clear();
        List<Consumer> consumers = new ArrayList<Consumer>();
        Character consumerType;
        Character[] types = {'r', 'c', 'i'};
        List<Character> typesList = Arrays.asList(types);
        Double reference, billing, consumerConsumption;
        boolean nextConsumer = true;
        int specificConsumerCount =0;
        int consumerCount = 1;
        reference = billing = consumerConsumption = 0.;
        System.out.print("Entre com o valor de referência para kW/h: ");
        try{
            reference = sc.nextDouble()/10;
            System.out.println("-- Listando consumidores --");
            while(nextConsumer){
                System.out.printf("\nQuantos kW o consumidor %d consumiu? ", consumerCount);
                consumerConsumption = sc.nextDouble();
                System.out.print("Qual é o tipo de consumidor (r|c|i)? ");
                consumerType = sc.next().charAt(0);
                if(!typesList.contains(consumerType))throw new InputMismatchException();
                consumers.add(new Consumer(consumerCount, consumerConsumption, consumerType, reference));
                System.out.print("Gostaria de registrar outro consumidor (s|n)? ");
                Character again = sc.next().charAt(0);
                if(!again.equals('s'))nextConsumer = false;
                consumerCount++;
            }
            System.out.println("\n--- Resumo dos Consumidores ---");
            for(Consumer consumer : consumers){
                System.out.println(consumer);
                billing+=consumer.debt();
                if(consumer.debt()>500 && consumer.debt()<1000)specificConsumerCount++;
            }
            System.out.println("Valor do kW/h: R$"+reference);
            System.out.println("Consumidores que pagam entre R$500 e R$1.000: "+specificConsumerCount);
            System.out.printf("Lucro total da empresa: R$%.2f", billing);
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
    }

    public void Exercicio13(){
        // Já estou há meia hora debugando isso daqui... ;(
        clear();
        List<Integer> valores = new ArrayList<>();
        valores.addAll(Arrays.asList(new Integer[]{2, 7, 3}));
        int limit = 0;
        System.out.print("Quantos valores da sequência você gostaria de exibir? ");
        try{
            limit = sc.nextInt();
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
        System.out.printf("Os %d primeiros termos da sequência {2, 7, 3, 4, 21, 12...} são:\n", limit);
        for(int i=0; i<limit-3; i++){
            int currentValue = valores.get(i);
            if(i<=2)valores.add(currentValue*(i+2));
            else if((float)currentValue/2==valores.get(i-3))valores.add(currentValue*2);
            else if((float)currentValue/3==valores.get(i-3))valores.add(currentValue*3);
            else if((float)currentValue/4==valores.get(i-3))valores.add(currentValue*4);
        }
        System.out.println(valores);
        //Deselegante? Talvez, mas funciona...
    }

    public void Exercicio14(){
        for (int i=1;i<=10;i++) {
            System.out.println("\r\nTabuada do "+i+":");
            for (int j=1;j<=10;j++) {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
            }
        }
    }

    public void Exercicio15(){
        //Classes Team e Player no fim do arquivo...
        clear();
        List<Team> teams = new ArrayList<>();
        Double averageHeight = 0.;
        Integer youngerThanEighteen, heavierThanEighty;
        youngerThanEighteen = heavierThanEighty = 0;
        System.out.println("Bem vindo ao campeonato de futebol!! \n");
        System.out.println("-- Escolha os nome dos times -- ");
        try{
            for(int i =1; i<=5; i++){
                System.out.print("Nome do time "+i+":");
                String name = sc.next();
                teams.add(new Team(i, name));
            }
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
        for(Team team : teams){
            for(int i=1; i<=15; i++){
                Double height, weight;
                Integer age =(int) Math.floor(Math.random()*(50 - 14 + 1)+14);
                height = Math.floor(Math.random()*(210 - 150 + 1)+150);
                weight = Math.floor(Math.random()*(110 - 50 + 1)+50);
                team.addPlayer(new Player(i, age, weight, height));
            }
            heavierThanEighty+=team.heavierThanEighteenKilos();
            youngerThanEighteen+=team.youngerThanEighteen();
            averageHeight+=team.averageHeight();
        }
        heavierThanEighty = (heavierThanEighty*100)/75;
        clear();
        System.out.println("Preenchemos 75 jogadores automaticamente! ^-^\n");
        System.out.println("--- Exibindo times ---");
        for(Team team : teams){
            System.out.println("\n"+team);
            System.out.printf("Idade média do time: %.2f\n",team.averageAge());
        }
        System.out.println("\nJogadores com menos de 18 anos: "+youngerThanEighteen);
        System.out.printf("Altura média dos jogadores: %.2f\n",averageHeight/5);
        System.out.println("Taxa de jogadores com mais de 80 quilos: "+heavierThanEighty+"%");
    }

    public void Exercicio16(){
        clear();
        boolean stop = false;
        Double greater, lesser;
        greater = Double.NEGATIVE_INFINITY;
        lesser = Double.POSITIVE_INFINITY;
        System.out.println("Informe valores positivos (negativo para encerrar)!\n");
        try{
            while(!stop){
                System.out.print("Informe um valor: ");
                Double input = sc.nextDouble();
                if(input<0)break;
                if(input>greater)greater = input;
                if(input<lesser)lesser = input;
            }
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
        System.out.println("Menor valor informado: "+lesser);
        System.out.println("Maior valor informado: "+greater);
    }

    public void Exercicio17(){
        clear();
        Double greater, lesser, average;
        Integer even, divisibleByFive;
        average = 0.;
        lesser = Double.POSITIVE_INFINITY;
        greater = Double.NEGATIVE_INFINITY;
        even = divisibleByFive = 0;
        List<Double> inputs = new ArrayList<>();
        System.out.println("-- Informe uma série de valores --");
        try{
            for(int i=1; i<=15; i++){
                System.out.print("Valor "+i+": ");
                inputs.add(sc.nextDouble());
            }
        }catch(InputMismatchException ex){recallMethod(Thread.currentThread().getStackTrace()[1].getMethodName()); return;}
        for(Double value : inputs){
            if(value>greater)greater = value;
            if(value<lesser)lesser = value;
            if(value%5==0)divisibleByFive++;
            if(value%2==0)even++;
            average+=value;
        }
        clear();
        Collections.sort(inputs);
        System.out.println("-- Resumo --");
        System.out.println("Valores: "+inputs);
        System.out.println("Maior valor: "+greater);
        System.out.println("Menor valor: "+lesser);
        System.out.println("Valores pares: "+even);
        System.out.println("Múltiplos de 5: "+divisibleByFive);
        System.out.println("Média aritmética: "+average/15);
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
// Classe para o exercício 12
class Consumer{
    private int id;
    private Double consumption;
    private Character type;
    private Double reference;
    public Consumer(int id, Double consumption, Character type, Double reference) {
        this.consumption = consumption;
        this.type = type;
        this.id = id;
        this.reference = reference;
    }

    public Double debt(){
        Double tax = 0.0;
        Double debt = 0.0;
        if(this.type.equals('r')) tax = 5.0/100;
        if(this.type.equals('c')) tax = 10.0/100;
        if(this.type.equals('i')) tax = 15.0/100;
        debt = this.consumption*this.reference;
        debt += debt*tax;
        return debt;
    }

    @Override
    public String toString(){
        return String.format("[ID:%d, TYPE: %c, DEBT:%.2f]", this.id, this.type, this.debt());
    }
}

//Classes para exercício 15:
class Player{
    private Integer number;
    private Integer age;
    private Double weight;
    private Double height;

    public Player(Integer number, Integer age, Double weight, Double height) {
        this.number = number;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    
    @Override
    public String toString(){
        return String.format("[Camisa: %d, Idade: %d, Peso: %.2f, Altura: %.2f]", this.number, this.age, this.weight, this.height);
    }

    public Integer getAge() {
        return age;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }
}

class Team{
    private Integer number;
    String name;
    private List<Player> players;

    public Team(Integer number, String name){
        this.number = number;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: "+this.name+'\n');
        sb.append("Jogadores: ");
        for(Player player : this.players){
            sb.append('\n'+player.toString());
        }
        return sb.toString();
    }

    public Integer youngerThanEighteen(){
        int count = 0;
        for(Player player : this.players){if(player.getAge()<18)count++;}
        return count;
    }

    public Double averageAge(){
        Double avg = 0.;
        for(Player player : this.players){avg+=player.getAge();}
        return avg/this.players.size();
    }

    public Double averageHeight(){
        Double avg = 0.;
        for(Player player : this.players){avg+=player.getHeight();}
        return avg/this.players.size();
    }

    public Integer heavierThanEighteenKilos(){
        int count = 0;
        for(Player player : this.players){if(player.getWeight()>80)count++;}
        return count;
    }

    public Integer getNumber(){
        return this.number;
    }
}