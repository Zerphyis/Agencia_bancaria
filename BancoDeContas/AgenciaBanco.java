package BancoDeContas;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBanco {
     static  Scanner leitor= new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    public  static void operacoes(){
        System.out.println("-----------------------------------------------");
        System.out.println("-------Bem-Vindos a Agência------");
        System.out.println("---Selecione a operação que desaja realizar---");
        System.out.println("-----------------------------------------------");
        System.out.println("| Opção 1- Criar conta |");
        System.out.println("| Opção 2-Depositar |");
        System.out.println("| Opção 3- Sacar  |");
        System.out.println("| Opção 4- Transferir |");
        System.out.println("| Opção 5- Listar |");
        System.out.println("| Opção 6- Sair |");

        int operacao= leitor.nextInt();

        switch (operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listaDeContas();
                break;
            case 6:
                System.out.println("Saindo do sistema...");
                System.exit(0);
                default:
                    System.out.println("Operação inválida");
                    operacoes();
                    break;
        }

    }
    public static  void criarConta(){
        System.out.println("n/Nome: ");
        String nome=leitor.next();

        System.out.println("n/Cpf: ");
        String cpf=leitor.next();

        System.out.println("n/EmaiL: ");
        String email=leitor.next();

        PessoaConta cliente= new PessoaConta(nome,cpf,email);
        Conta conta= new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso!");
        operacoes();
    }
     public static Conta encontarConta(int numeroConta){
        Conta conta=null;
        if (contasBancarias.size() > 0){
            for (Conta contas:contasBancarias) {
                if(contas.getNumeroConta() == numeroConta){
                    conta = contas;
                }

                
            }
        }
        return conta;
     }

     public  static  void depositar(){
         System.out.println("Número da conta: ");
         int NumeroConta=leitor.nextInt();
         Conta conta=encontarConta(NumeroConta);
         if(conta != null) {
             System.out.println("Qual valor deseja depositar ?");
             Double valorDeposito =leitor.nextDouble();

             conta.Depositar(valorDeposito);
         }
         else {
             System.out.println("Conta não encontrada");
         }
         operacoes();

     }
     public  static  void sacar(){
         System.out.println("Número da conta: ");
         int numeroConta= leitor.nextInt();
         Conta conta= encontarConta(numeroConta);
         if( conta != null){
             System.out.println("Qual valor deseja sacar ?");
             Double valorSaque= leitor.nextDouble();
             conta.Sacar(valorSaque);
             System.out.println("Saque realizado com sucesso");
         }else {
             System.out.println("Conta não encontrada ");
         }
         operacoes();

     }

     public  static  void transferir(){
         System.out.println("Número da conta que deseja transferir");
         int numcontaRemetente= leitor.nextInt();

         Conta contaRementente=encontarConta(numcontaRemetente);
         if(contaRementente!= null){
             System.out.println("Número da conta do destinatario");
             int numContaDestinatario= leitor.nextInt();

             Conta contaDestinatario=encontarConta(numContaDestinatario);

             if(contaDestinatario !=null ){
                 System.out.println("Valor da transferencia");
                 Double valor= leitor.nextDouble();
                 contaRementente.Transferencia(contaDestinatario,valor);
             }else {
                 System.out.println("Conta para depósito não encontrada");
             }
         }
         else{
             System.out.println("Conta para transferencia não encontrada");
         }
         operacoes();
    }
    public  static void listaDeContas(){
        if(contasBancarias.size() > 0){
            for (Conta conta:contasBancarias ) {
                System.out.println(conta);
                
            }
        }
        else {
            System.out.println("Não há contas cadastradas");
        }
        operacoes();
    }




}
