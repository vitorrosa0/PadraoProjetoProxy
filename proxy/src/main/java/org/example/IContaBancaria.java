package org.example;

import java.util.List;

public interface IContaBancaria {
    List<String> obterDadosConta();
    List<String> obterExtrato(Usuario usuario);
}
