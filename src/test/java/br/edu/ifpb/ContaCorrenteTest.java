package br.edu.ifpb;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContaCorrenteTest {
    
    @Test
    public void testSaldoNaAbertura() {
        ContaCorrente conta = new ContaCorrente(
            "Job"
        );
        Dinheiro saldo = conta.verificarSaldo();
        Dinheiro saldoEsperado = new Dinheiro(0.0);
        assertEquals(saldoEsperado, saldo);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAberturaSaldoNegativo() {
        ContaCorrente conta = new ContaCorrente(
            "Job", -1.0
        );
        Dinheiro saldo = conta.verificarSaldo();
        Dinheiro saldoEsperado = new Dinheiro(-1.0);
        assertEquals(saldoEsperado, saldo);
    }
    @Test
    public void testDepositoPositivo() {
        ContaCorrente conta = new ContaCorrente(
            "Job"
        );
        conta.depositar(
                new Dinheiro(50.0)
        );
//        double saldo = conta.verificarSaldo();
//        double saldoEsperado = 50.0;

        Dinheiro saldo = conta.verificarSaldo();
        Dinheiro saldoEsperado = new Dinheiro(50.0);
        assertEquals(saldoEsperado, saldo);
    }
    @Test
    public void testSaquePositivo() {
        ContaCorrente conta = new ContaCorrente(
            "Job", 50.0
        );
//        conta.depositar(50);
        conta.saque(
                new Dinheiro(10.0)
        );
        Dinheiro saldo = conta.verificarSaldo();
        Dinheiro saldoEsperado = new Dinheiro(40.0);
        //
        assertEquals(saldoEsperado, saldo);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSaqueNegativo() {
        ContaCorrente conta = new ContaCorrente(
            "Job", 50.0
        );
        //comportamento inexistente
        conta.saque(
                new Dinheiro(-10.0)
        ); // exception
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDepositoNegativo() {
        ContaCorrente conta = new ContaCorrente(
            "Job"
        );
        //comportamento inexistente
        conta.depositar(
                new Dinheiro(-10.0)
        ); // exception
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSaqueZerado() {
        ContaCorrente conta = new ContaCorrente(
            "Job", 50.0
        );
        //comportamento inexistente
        conta.saque(
                new Dinheiro(0.0)
        ); // exception
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDepositoZerado() {
        ContaCorrente conta = new ContaCorrente(
            "Job"
        );
        //comportamento inexistente
        conta.depositar(
                new Dinheiro(0.0)
        ); // exception
    }
    
}
