package BancoDeContas;

public class Conta {
private  static  int contadorConta=1;
private  int numeroConta;
private PessoaConta pessoa;
private double saldo=0.0;

public Conta(PessoaConta pessoa){
    this.numeroConta=Conta.contadorConta;
    this.pessoa=pessoa;
    this.atualziarSaldo();
    Conta.contadorConta +=1;
}

    public int getNumeroConta() {
        return numeroConta;
    }


    public PessoaConta getCliente() {
        return pessoa;
    }

    public void setCliente(PessoaConta pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void atualziarSaldo(){
    this.saldo=this.getSaldo();
    }
public  String toString(){
    return     "\nConta do banco: " +this.getNumeroConta()+
                "\nCliente: "+this.pessoa.getNome()+
                "\nCpf: "+this.pessoa.getCpf()+
                "\nEmail: " +Utils.doubleToString(this.getSaldo())+
                "\n";
}
public void Depositar(Double valor){
    if(valor > 0){
            setSaldo(getSaldo()+valor);
            System.out.println("Seu depósito foi realizado com sucesso");
    }
    else {
            System.out.println("Não foi possivel fazer o depósito");
    }
}

public void  Sacar(Double valor){
    if(valor > 0 && this.getSaldo() >= valor){
                setSaldo(getSaldo() - valor);
             System.out.println("Saqua realizado com sucesso");
    }else {
            System.out.println("Não foi possivel realziar o saque");
    }
}
public  void  Transferencia(Conta ContaDeposito, Double valor){
    if(valor > 0 && this.getSaldo() >= valor){
             setSaldo(getSaldo()- valor);
             ContaDeposito.saldo=ContaDeposito.getSaldo()+valor;
            System.out.println("Transferencia realizada com sucesso");
    }
    else {
            System.out.println("Não foi possivel realizar a transferencia ");
    }
}
}
