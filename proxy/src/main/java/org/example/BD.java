package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<Integer, ContaBancaria> contas = new HashMap<>();

    public static ContaBancaria getConta(Integer numeroConta) {
        return contas.get(numeroConta);
    }

    public static void addConta(ContaBancaria conta) {
        contas.put(conta.getNumeroConta(), conta);
    }
}

