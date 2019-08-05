package br.com.caelum.contas.modelo;

import br.com.caelum.contas.excecoes.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel {
    @Override
    public String getTipo()
    {
        return "Conta Corrente";
    }

    @Override
    public void saca(double valor)
    {
        if(valor < 0)
        {
            throw new IllegalArgumentException("Valor negativo, tente novamente.");
        }
        if(this.saldo < valor)
        {
            throw new SaldoInsuficienteException(valor);
        }
        this.saldo -= (valor + 0.10);
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }
}
