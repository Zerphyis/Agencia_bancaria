package BancoDeContas;

import java.util.Date;


public class PessoaConta {
    private static int contador =1;
    private  int numeroPessoa;
    private String nome;
    private String cpf;
    private String Email;
    private Date CriadorDecontasData;


public  PessoaConta(){

}
public  PessoaConta(String nome,String cpf,String Email){
    this.numeroPessoa=PessoaConta.contador;
    this.nome=nome;
    this.cpf=cpf;
    this.Email=Email;
    this.CriadorDecontasData=new Date();
    PessoaConta.contador +=1;
}

    public int getNumeroPessoa() {
        return numeroPessoa;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return Email;
    }

    public Date getCriadorDecontasData() {
        return CriadorDecontasData;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public  String toString(){
    return "\nNome: "+this.getNome()+
            "\nCpf: "+this.getCpf()+
            "\nEmail: "+this.getEmail()+
            "\nCriador de contas: "+Utils.dateToString(this.getCriadorDecontasData());
    }
}
