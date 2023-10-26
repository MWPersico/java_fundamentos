import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Lista2 {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Lista2 lista = new Lista2();
        lista.clear();
        System.out.println("Bem vindo a lista 2 de exercícios Java! ~ Marcos Pérsico");
        lista.menu();
        lista.sc.close();
    }

    public void menu() throws Exception{
        String input;
        String methodName = "Exercicio";
        java.lang.reflect.Method method;
        System.out.print("\nDigite o exercício que deseja testar {1-15} (0 para encerrar): ");
        input = sc.next();
        if(!input.equals("0")){
            methodName+=input;
            try {
              method = this.getClass().getMethod(methodName);
              method.invoke(this);
            }catch (Exception ex) {
                System.out.println("Valor errado digitado, vamos tentar de novo! (não reinicie antes de encerrar execução)");
                try{Thread.sleep(1000); }catch(Exception ex2){ex2.printStackTrace();}
                this.menu();
                return;
            }
        }else{System.exit(0);}
        this.menu();
    }

    public void Exercicio1(){
        clear();
        float v1, v2;
        System.out.println("Insira dois valores para comparação");
        try{
            System.out.print("1º valor: ");
            v1 = sc.nextFloat();
            System.out.print("2º valor: ");
            v2 = sc.nextFloat();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000); }catch(Exception ex2){ex2.printStackTrace();}
            sc.next();
            this.Exercicio1();
            return;
        }
        if(v1==v2){System.out.println("O primeiro valor é igual ao segundo");}else if(v1>v2){
            System.out.printf("O valor %.2f é maior que %.2f", v1, v2);
        }else{
            System.out.printf("O valor %.2f é menor que %.2f", v1, v2);
        }

    }

    public void Exercicio2(){
        clear();
        float[] valores =  new float[3];
        float maior = 0;
        System.out.println("Insira três valores para comparação");
        try{
            for(int i=0;i<3;i++){
            System.out.printf("%dº valor: ", i+1);
            valores[i] = sc.nextFloat();
            }
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio2();
            return;
        }
        for(float valor : valores){
            maior = valor>maior?valor:maior;
        }
        System.out.printf("O maior valor é %.2f", maior);
    }

    public void Exercicio3(){
        clear();
        float[] notas = new float[4];
        float media;
        String nome;
        String classificacao = "";
        System.out.print("Digite o primeiro nome do aluno: ");
        try{
            nome = sc.next();
            System.out.println("Digite as notas do aluno (0-100):");
            for(int i=0; i<notas.length; i++){
                System.out.print((i+1)+"ª nota: ");
                notas[i] = sc.nextFloat();
            }
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio3();
            return;
        }
        media = (notas[0]+notas[1]+notas[2]+notas[3])/4;
        if(media>80){classificacao ="Ótimo";}
        if(media>60 && media<=80){classificacao = "Bom";}
        if(media>40 && media<=60){classificacao = "Regular";}
        if(media>20 && media<=40){classificacao = "Ruim";}
        if(media<=20){classificacao="Péssimo";}
        System.out.printf("%s com notas %s e média %.2f teve desempenho %s", nome, Arrays.toString(notas), media, classificacao);
    }

    public void Exercicio4(){
        clear();
        float valor;
        try{
            System.out.print("Digite um valor: ");
            valor = sc.nextFloat();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio4();
            return;
        }
        if(valor>0 && valor<100){System.out.printf("\nO valor %.2f está entre 0 e 100",valor);}else{System.out.printf("\nO valor %.2f não está entre 0 e 100",valor);}
    }

    public void Exercicio5(){
        clear();
        float[] valores = new float[3];
        try{
            System.out.println("Digite três valores: ");
            for(int i=0; i<3;i++){
                System.out.print((i+1)+": ");
                valores[i] = sc.nextFloat();
            }
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio5();
            return;
        }
        if(valores[0]<valores[1]){
            if(valores[2]>valores[0] && valores[2]<valores[1]){
                System.out.printf("%.2f está entre %.2f e %.2f", valores[2],valores[0],valores[1]);
            }else{
                System.out.printf("%.2f não está entre %.2f e %.2f", valores[2],valores[0],valores[1]);
            }
        }else{
            if(valores[2]<valores[0] && valores[2]>valores[1]){
                System.out.printf("%.2f está entre %.2f e %.2f", valores[2],valores[1],valores[0]);
            }else{
                System.out.printf("%.2f não está entre %.2f e %.2f", valores[2],valores[1],valores[0]);
            }
        }
    }

    public void Exercicio6(){
        clear();
        String sexo;
        float altura, peso;
        try{
            System.out.print("Digite seu sexo (M ou F): ");
            sexo = sc.next();
            System.out.print("Digite sua altura (cm): ");
            altura = sc.nextFloat();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio6();
            return;
        }
        sexo.toLowerCase();
        if(sexo=="m"){
            peso = (float) (52 + (0.75 * (altura - 152.4)));
        }else{
            peso = (float) (52 + (0.67 * (altura - 152.4)));
        }
        System.out.println("O seu peso ideal é: "+peso+"kg");
    }

    public void Exercicio7(){
        clear();
        float bruto, liquido;
        try{
            System.out.print("Digite seu salario base (R$): ");
            bruto = sc.nextFloat();
            System.out.print("Digite a gratificação (R$): ");
            bruto+= sc.nextFloat();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio7();
            return;
        }
        if(bruto<2500){liquido = (float) (bruto-0.10*bruto);}else{liquido = (float) (bruto-0.15*bruto);}
        System.out.printf("Seu salário liquido com desconto de imposto é de %.0fR$",liquido);
    }

    public void Exercicio8(){
        clear();
        float bruto, liquido;
        try{
            System.out.print("Digite seu salario base (R$): ");
            bruto = sc.nextFloat();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio8();
            return;
        }
        if(bruto<=2000){liquido=(float)(bruto+0.10*bruto);}else if(bruto<=3000){liquido=(float)(bruto+0.08*bruto);}else{liquido=(float)(bruto+0.05*bruto);}
        if(bruto<=2500){liquido+=350;}else{liquido+=300;}
        System.out.printf("Seu salário liquido é de %.0fR$ com bonificação e auxílio escola.",liquido);
    }

    public void Exercicio9(){
        clear();
        float altura, peso, imc;
        String estado;
        try{
            System.out.print("Digite seu peso (kg): ");
            peso = sc.nextFloat();
            System.out.print("Digite sua altura (cm): ");
            altura = sc.nextFloat()/100;
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio9();
            return;
        }
        imc = peso/(altura*altura);
        if(imc>40){estado = "Obesidade mórbida";}else
        if(imc>30 && imc<40){estado = "Obesidade severa";}else
        if(imc>25 && imc>30){estado = "Obesidade leve";}else
        if(imc>18.5 && imc<25){estado = "Normal";}else
        if(imc>17 && imc<18.5){estado = "Magreza leve";}else
        if(imc>16 && imc<17){estado = "Magreza moderada";}
        else{estado = "Magreza severa";}
        System.out.printf("Seu imc é %.2f que indica o estado: %s", imc, estado);
    }

    public void Exercicio10(){
        clear();
        float x, y, z;
        try{
            System.out.println("Indique três valores");
            System.out.printf("X: ");
            x = sc.nextFloat();
            System.out.printf("Y: ");
            y = sc.nextFloat();
            System.out.printf("Z: ");
            z = sc.nextFloat();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio10();
            return;
        }
        if(x<y+z && y<x+z && z<x+y){
            if(x==y && y==z){
                System.out.println("X, Y e Z formam um triângulo equilátero.");
            }else if(x==y || x==z || y==z){
                System.out.println("X, Y e Z formam um triângulo isóceles.");
            }else if(x!=y && y!=z){
                System.out.println("X, Y e Z formam um triângulo escaleno.");
            }
        }else{
            System.out.println("X, Y e Z não podem formar um triângulo");
        }
    }

    public void Exercicio11(){
        clear();
        int input;
        System.out.println("**** MENU DE OPÇÕES ****");
        System.out.printf("1. Somar dois números;\n2. Raiz quadrada de um número;\n3. Elevar um número a uma potência;\n");
        System.out.print("Escolha uma opção: ");
        try{
            input = sc.nextInt();
            switch(input){
            case 1:
                float v1, v2;
                System.out.println("Digite dois números para somar");
                System.out.print("Valor 1: ");
                v1 = sc.nextFloat();
                System.out.print("Valor 2: ");
                v2 = sc.nextFloat();
                System.out.println("O resultado da soma é: "+(v1+v2));
            break;
            case 2:
                float value;
                System.out.println("Raiz quadrada de um número");
                System.out.print("Digite um radicando: ");
                value = sc.nextFloat();
                System.out.printf("A raiz quadrada de %.2f é %.2f: ",value,Math.sqrt(value));
            break;
            case 3:
                float base, exponent;
                System.out.print("Digite uma base: ");
                base = sc.nextFloat();
                System.out.print("Digite um expoente: ");
                exponent = sc.nextFloat();
                System.out.printf("%.2f elevado a %.2f é igual a %.2f ",base, exponent, Math.pow(base, exponent));
            break;
            default: Exercicio11();
        }
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio11();
            return;
        }
    }

    public void Exercicio12(){
        LocalTime inicio, fim, difference;
        String input;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        clear();
        try{
            System.out.print("Digite a hora de início do jogo (HH:mm): ");
            input = sc.next();
            inicio = LocalTime.parse(input, formatter);
            System.out.print("Digite a hora de fim do jogo (HH:mm): ");
            input = sc.next();
            fim = LocalTime.parse(input, formatter);            
        }catch(Exception ex){
            System.out.println("Digite no formato (HH:mm) HH<=24 e mm<60");
            try{Thread.sleep(2000);}catch(Exception ex2){ex2.printStackTrace();}
            this.Exercicio12();
            return;
        }
        if(inicio.getHour()>fim.getHour()){
            int hdiff = 24-inicio.getHour()+fim.getHour();
            int mdiff = inicio.getMinute()-fim.getMinute();
            difference = LocalTime.parse(String.format("%02d", hdiff)+":00", formatter);
            if(mdiff<0){
                difference = difference.plusMinutes(Math.abs(mdiff));
            }else{
                difference = difference.minusMinutes(mdiff);
            }
        }else{
            int dur = (int) java.time.temporal.ChronoUnit.MINUTES.between(inicio, fim);
            int h, m;
            String text;
            h = dur/60;
            m = dur%60;
            text = String.format("%02d", h);
            text += ":"+String.format("%02d", m);
            difference = LocalTime.parse(text, formatter);
        }
        System.out.printf("A duração do jogo é de: "+difference);
    }

    public void Exercicio13(){
        clear();
        int year, nextYear;
        boolean nextFinded = false;
        System.out.print("Insira um ano: ");
        try{
            year = sc.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio13();
            return;
        }
        nextYear = year;
        while(!nextFinded){
            nextYear++;
            if(Year.isLeap(nextYear)){nextFinded = true;}
        }
        if(Year.isLeap(year)){System.out.printf("O ano %d é bissexto\n", year);}
        else{System.out.printf("O ano %d não é bissexto\n", year);}  
        System.out.printf("O próximo ano bissexto depois de %d é %d", year, nextYear);
    }

    public void Exercicio14(){
        clear();
        float[] notas = new float[3];
        float media = 0;
        System.out.println("Insira as notas do aluno");
        try{
            for(int i =0;i<notas.length; i++){
                System.out.print((i+1)+"ª nota: ");
                notas[i] = sc.nextFloat();
                media+=notas[i];
            }
            media = media/notas.length;
            if(media>=6){System.out.printf("Aluno aprovado com media %.2f", media);}
            else if(media<=5){System.out.printf("Aluno aprovado com media %.2f", media);}
            else if(media>5 && media<6){
                System.out.println("Aluno de recuperação...");
                System.out.print("Nota de recuperação: ");
                media = (media+sc.nextFloat())/2;
                if(media<6){System.out.printf("Aluno reprovado com media %.2f", media);}
                else{System.out.printf("Aluno aprovado por recuperação com media %.2f", media);}
            }
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio14();
            return;
        }
    }

    public void Exercicio15(){
        clear();
        float[] notas = new float[4];
        float media = 0;
        float presenca;
        String premio = "";
        System.out.println("Digite as notas do aluno (0-100):");
        try{
            for(int i =0;i<notas.length; i++){
                System.out.print((i+1)+"ª nota: ");
                notas[i] = sc.nextFloat();
                media+=notas[i];
            }
            media = media/notas.length;
            System.out.print("Quantas aulas foram dadas? ");
            presenca = sc.nextInt();
            System.out.print("Em quantas o aluno participou? ");
            presenca = (sc.nextInt()/presenca)*100;
            if(media>80 && presenca==100){premio = "excursão";}
            else if(media>80 | presenca==100){premio = "camiseta";}
            else if(media>=70 && media<=80 && presenca>=90){premio = "squeeze";}
            else if((media>=70 && media<=80) | presenca>=90){premio = "caneta personalizada";}
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000);}catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.Exercicio15();
            return;
        }
        if(premio!=""){
            System.out.printf("Com media %.2f e presença de %.0f o aluno ganha uma %s!", media, presenca, premio);
        }else{
            System.out.printf("Com media %.2f e presença de %.0f o aluno não ganha prêmios :(", media, presenca);
        }
    }

    public void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
