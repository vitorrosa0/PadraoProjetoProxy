package org.example;

import java.util.List;

public class ContaBancariaProxy implements IContaBancaria {

    private ContaBancaria conta;
    private Integer numeroConta;

    public ContaBancariaProxy(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public List<String> obterDadosConta() {
        if (this.conta == null) {
            this.conta = new ContaBancaria(this.numeroConta);
        }
        return this.conta.obterDadosConta();
    }

    @Override
    public List<String> obterExtrato(Usuario usuario) {
        if (!usuario.isGerente()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.conta == null) {
            this.conta = new ContaBancaria(this.numeroConta);
        }
        return this.conta.obterExtrato(usuario);
    }
}