import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Avaliacao2 {
    private static Random rd = new Random();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Avaliacao2 app = new Avaliacao2();
        app.clear();
        System.out.println("Avaliação 2 ~Marcos Pérsico");
        app.menu();
        sc.close();
    }

    public void Exercicio1(){
        clear();
        int alunosDiurno, alunosNoturno, alunosFormados, idadeMedia, acimaDeVinte;
        alunosDiurno = alunosNoturno = alunosFormados = idadeMedia = acimaDeVinte = 0;
        float percentualEmpregados = 0;
        System.out.println("Cadastrando alunos...");
        for(int i=1; i<=500; i++){
            // Instancia um novo aluno (classe abaixo), com dados aleatórios
            Aluno aluno = new Aluno(rd.nextInt(15, 80), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean());
            // Verificações do negócio
            if(aluno.getIdade()>20)acimaDeVinte++;
            if(aluno.isFormado())alunosFormados++;
            if(aluno.isEmpregado())percentualEmpregados++;
            if(aluno.isPeriodoDiurno())alunosDiurno++;
            else alunosNoturno++;
            idadeMedia+=aluno.getIdade();
        }
        idadeMedia /=500;
        percentualEmpregados = (percentualEmpregados/500)*100;
        System.out.println("\nAnálise dos dados de 500 alunos: ");
        System.out.printf("Período: %d noturno, %d diurno\n", alunosNoturno, alunosDiurno);
        System.out.println("Alunos acima de 20 anos: "+acimaDeVinte);
        System.out.println("Idade média dos alunos: "+idadeMedia);
        System.out.println("Alunos formados em nível superior: "+ alunosFormados);
        System.out.printf("Alunos empregados: %.2f%%", percentualEmpregados);
    }

    public void Exercicio2(){
        clear();
        int colunas, linhas;
        System.out.println("Gerando um retângulo com caracteres: ");
        try{
            System.out.print("Quantas colunas? ");
            colunas = sc.nextInt();
            System.out.print("Quantas linhas? ");
            linhas = sc.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000); }catch(Exception ex2){ex2.printStackTrace();}
            sc.next();
            this.Exercicio2();
            return;
        }
        char[][] retangulo = new char[linhas][colunas];
        for(linhas=0; linhas<retangulo.length;linhas++){
            for(colunas=0; colunas<retangulo[linhas].length;colunas++){
                // Adiciona os caracteres ao array com base na posição
                if((colunas==0 || colunas==retangulo[linhas].length-1) && (linhas==0 || linhas== retangulo.length-1)){
                    retangulo[linhas][colunas] = '+'; 
                }else if(linhas==0 || linhas== retangulo.length-1){
                    retangulo[linhas][colunas] = '-'; 
                }else if(colunas==0 || colunas==retangulo[linhas].length-1){
                    retangulo[linhas][colunas] = '|'; 
                }else{
                    retangulo[linhas][colunas] = ' ';
                }
                System.out.print(retangulo[linhas][colunas]);
            }
            System.out.println();
        }
    }

    public void menu() throws Exception{
        String input;
        String methodName = "Exercicio";
        java.lang.reflect.Method method;
        System.out.print("\nDigite o exercício que deseja testar {1-2} (0 para encerrar): ");
        input = sc.next();
        if(!input.equals("0")){
            methodName+=input;
            try {
              method = this.getClass().getMethod(methodName);
              method.invoke(this);
            }catch (Exception ex) {
                System.out.println("Este exercício não existe!");
                try{Thread.sleep(1000); }catch(Exception ex2){ex2.printStackTrace();}
                this.menu();
                return;
            }
        }else{System.exit(0);}
        this.menu();
    }

    public void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}

// Classe 'Aluno', primeiro exercício
class Aluno{
    private int idade;
    private boolean formado;
    private boolean empregado;
    private boolean periodoDiurno;
    public Aluno(int idade, boolean formado, boolean empregado, boolean periodoDiurno){
        this.idade = idade;
        this.formado = formado;
        this.empregado = empregado;
        this.periodoDiurno = periodoDiurno;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public boolean isFormado() {
        return formado;
    }
    public boolean isEmpregado() {
        return empregado;
    }
    public boolean isPeriodoDiurno(){
        return periodoDiurno;
    }
}