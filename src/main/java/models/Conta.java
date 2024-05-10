package models;

public abstract class Conta implements IConta {
    private final int agencia;
    private final int numero;
    private double saldo;

    public Conta(int agencia, int numero, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("O valor de depósito deve ser positivo");
        this.saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor > saldo) throw new IllegalArgumentException("Valor superior ao saldo disponível");
        this.saldo -= valor;
        contaDestino.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) throw new IllegalArgumentException("Valor superior ao saldo disponível");
        this.saldo -= valor;
    }
}
