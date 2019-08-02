package br.com.caelum.contas.modelo;

public abstract class Conta {
    protected double saldo;
    private int numero;
    private String titular;
    private String agencia;
    private String dataAbertura;

    public Conta(String titular){
        this.titular = titular;
    }
    public Conta(){}

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    protected boolean isValido(double valor) {
        if(this.saldo > valor) return true;
        return false;
    }

    public void saca(double valor ){
        if(isValido(valor)){
//            if(tipo.equals("Contas Corrente")) this.saldo -= valor + 0.10;
  //          else this.saldo -= valor;
            this.saldo -= valor;
            System.out.println("Operação realizada com sucesso");
        }
        else System.out.println ("Operaocao nao realizada");
    }
    public void deposita(double valor){
        this.saldo += valor;
    }
    double getRendimento(){
        return this.saldo*0.1;
    }

    public String recuparDadosDeImpressao(){
        String dados = "Titular: "+ this.titular;
        dados += "\nNúmero: " + this.numero;
        dados += "\nSaldo: " + this.saldo;
        dados += "\nRednimento: " + this.getRendimento();
        return dados;
    }
    public String getTipo()
    {
        return "Conta";
    }

    public void transfere(double valor, Conta conta)
    {
        this.saca(valor);
        conta.deposita(valor);
    }
}
