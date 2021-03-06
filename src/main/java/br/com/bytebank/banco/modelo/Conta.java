package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta
 * @author krodrigues
 */
public abstract class Conta {
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    /**
     * Contrutor para inicializar o objeto Conta a partir da agencia e numero
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero){
        Conta.total ++;
        //System.out.println("O total de contas é: " + modelo.Conta.total);
        this.agencia = agencia;
        this.numero = numero;
       // System.out.println(this.agencia);
    }

    public void deposita(double valor){
        this.saldo += valor;

    }

    /**
     * Valor precisa ser maior que o saldo
     * @param valor
     * @throws SaldoInsuficienteException
     */
    public void saca(double valor) throws SaldoInsuficienteException{
        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo: " + this.saldo + " , " + "Valor a sacar: "
                    + valor);
        }
        this.saldo -= valor;
    }

    public void tranfere (double valor, Conta destino) throws SaldoInsuficienteException{
        this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }


    public int getAgencia() {
        return this.agencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public static int getTotal() {
        return Conta.total;
    }

    @Override
    public String toString() {
        return "Número: " + this.getNumero();
    }
}