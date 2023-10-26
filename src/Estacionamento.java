import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Estacionamento{
    private Scanner sc = new Scanner(System.in);
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    public static void main(String[] args) {
        Estacionamento app = new Estacionamento();
        app.clear();
        System.out.println("Algoritmos e programação - Avaliação 1. ~ Marcos Pérsico");
        app.menu();
        app.sc.close();
    }

    public void menu(){
        int input;
        System.out.print("\nDeseja testar o exercício (1 para testar)? (0 para encerrar): ");
        try {
            input = sc.nextInt();
            if(input == 0){
                System.exit(0);
            }else{
                exercicio2();
            }
        }catch (Exception ex) {
            System.out.println("Valor errado digitado, vamos tentar de novo!");
            try{Thread.sleep(1000); }catch(Exception ex2){ex2.printStackTrace();}sc.next();
            this.menu();
            return;
        }
    }

    public void exercicio2(){
        clear();
        String input, placa, cpf;
        LocalTime entrada, saida;
        System.out.println("Bem vindo ao estacionamento Pare Bem!");
        try{
            cpf = "";
            System.out.print("Deseja informar o CPF (sim | nao)? ");
            input = sc.next();
            if(input.toLowerCase().equals("sim")){
                System.out.print("Digite seu CPF (apenas numeros): ");
                cpf = sc.next();
            }
            System.out.print("Digite a placa do veículo (ABC-1234): ");
            placa = sc.next();
            System.out.print("Digite a hora da entrada do veículo (HH:mm): ");
            input = sc.next();
            entrada = LocalTime.parse(input, formatter);
            System.out.print("Digite a hora da saída do veículo (HH:mm): ");
            input = sc.next();
            saida = LocalTime.parse(input, formatter);            
        }catch(Exception ex){
            System.out.println("Obedeça o formato indicado para entrada!");
            try{Thread.sleep(2000);}catch(Exception ex2){ex2.printStackTrace();}
            this.exercicio2();
            return;
        }
        clear();
        new RegistroEstacionamento(entrada, saida, placa, cpf);
        menu();
    }

    public void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public class RegistroEstacionamento{
        private String placa, cpf;
        private LocalTime entrada, saida, permanencia;
        private Float valor;

        public RegistroEstacionamento(LocalTime entrada, LocalTime saida, String placa, String cpf){
            this.entrada = entrada;
            this.saida = saida;
            this.placa = placa;
            this.cpf = cpf;
            calcularPermanencia();
            calcularValor();
            System.out.println(this.print());
        }

        public void calcularPermanencia(){
            LocalTime difference;
            if(this.entrada.getHour()>this.saida.getHour()){
                int hdiff = 24-entrada.getHour()+saida.getHour();
                int mdiff = entrada.getMinute()-saida.getMinute();
                difference = LocalTime.parse(String.format("%02d", hdiff)+":00", formatter);
                if(mdiff<0){
                    this.permanencia = difference.plusMinutes(Math.abs(mdiff));
                }else{
                    this.permanencia = difference.minusMinutes(mdiff);
                }
            }else{
                int dur = (int) java.time.temporal.ChronoUnit.MINUTES.between(entrada, saida);
                int h, m;
                String text;
                h = dur/60;
                m = dur%60;
                text = String.format("%02d", h);
                text += ":"+String.format("%02d", m);
                this.permanencia = LocalTime.parse(text, formatter);
            }
        }

        public void calcularValor(){
            LocalTime time1, time2, time3, time4, time5, perm;
            time1 = LocalTime.parse("00:15", formatter);
            time2 = LocalTime.parse("01:00", formatter);
            time3 = LocalTime.parse("02:00", formatter);
            time4 = LocalTime.parse("04:00", formatter);
            time5 = LocalTime.parse("06:00", formatter);
            perm = this.permanencia;
            if(perm.isBefore(time1)){
                this.valor = 0.0f;
            }else if(perm.isBefore(time2)){
                this.valor = 9.0f;
            }else if(perm.isBefore(time3)){
                this.valor = 13.0f;
            }else if(perm.isBefore(time4)){
                this.valor = 18.0f;
            }else if(perm.isBefore(time5)){
                this.valor = 21.0f;
            }else if(perm.isAfter(time5)){
                this.valor = 32.0f;
            }else{
                this.valor = null;
            }
        }

        public String print(){
            StringBuilder texto = new StringBuilder();
            texto.append("\n|---RECIBO DE ESTACIONAMENTO---|\n");
            texto.append("|Rede Pare Bem - Shop Gaste Bem|\n");
            texto.append("|Saída: "+this.saida+" -----------------|\n");
            texto.append("|Entrada: "+this.entrada+" ---------------|\n");
            texto.append("|Placa: "+this.placa+" --------------|\n");
            texto.append("|Permanência: "+this.permanencia+" -----------|\n");
            texto.append("|Valor: "+this.valor+" ------------------|\n");
            if(this.cpf!=""){
                texto.append("|CPF: "+this.cpf+" -------------|\n");
            }
            texto.append("|---------VOLTE SEMPRE---------|");
            return texto.toString();
        }
    }
}