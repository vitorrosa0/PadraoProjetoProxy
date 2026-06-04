package org.example;

import java.util.Arrays;
import java.util.List;

public class ContaBancaria implements IContaBancaria {

    private Integer numeroConta;
    private String titular;
    private String agencia;
    private String transacao1;
    private String transacao2;

    public ContaBancaria(Integer numeroConta, String titular, String agencia,
                         String transacao1, String transacao2) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.agencia = agencia;
        this.transacao1 = transacao1;
        this.transacao2 = transacao2;
    }

    public ContaBancaria(Integer numeroConta) {
        this.numeroConta = numeroConta;
        ContaBancaria objeto = BD.getConta(numeroConta);
        this.titular = objeto.titular;
        this.agencia = objeto.agencia;
        this.transacao1 = objeto.transacao1;
        this.transacao2 = objeto.transacao2;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    @Override
    public List<String> obterDadosConta() {
        return Arrays.asList(this.titular, this.agencia);
    }

    @Override
    public List<String> obterExtrato(Usuario usuario) {
        return Arrays.asList(this.transacao1, this.transacao2);
    }
}
