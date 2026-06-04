package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaProxyTest {

    @BeforeEach
    void setUp() {
        BD.addConta(new ContaBancaria(1, "João", "0042", "Depósito R$500", "Saque R$100"));
        BD.addConta(new ContaBancaria(2, "Maria", "0042", "Depósito R$1000", "Pix R$200"));
    }

    @Test
    void deveRetornarDadosConta() {
        ContaBancariaProxy conta = new ContaBancariaProxy(1);

        assertEquals(Arrays.asList("João", "0042"), conta.obterDadosConta());
    }

    @Test
    void deveRetornarExtrato() {
        Usuario gerente = new Usuario("Ana", true);
        ContaBancariaProxy conta = new ContaBancariaProxy(2);

        assertEquals(Arrays.asList("Depósito R$1000", "Pix R$200"), conta.obterExtrato(gerente));
    }

    @Test
    void deveLancarExcecaoUsuarioNaoAutorizado() {
        try {
            Usuario cliente = new Usuario("Carlos", false);
            ContaBancariaProxy conta = new ContaBancariaProxy(2);

            conta.obterExtrato(cliente);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}