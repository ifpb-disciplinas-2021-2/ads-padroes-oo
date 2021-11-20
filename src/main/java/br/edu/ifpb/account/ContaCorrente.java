package br.edu.ifpb.account;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/10/2021, 10:11:07
 */
// classes e tipos
//CBO>15, 90% isso gera um bug, falta ou falha
public class ContaCorrente implements Conta{  //Abstração

    //caracteristicas -> atributos
    private String cliente;
    private Dinheiro saldo;

    public ContaCorrente(String cliente) {
        this(cliente,0.0);
    }
    // construtor principal
    public ContaCorrente(String cliente, double valor) {
        //pré-condições
//        if(valor<0)
//            throw new IllegalArgumentException("não podemos abrir conta com valor negativo");
        this.cliente = cliente;
        this.saldo = new Dinheiro(valor);
    }
    @Override
    public void depositar(Dinheiro valor) { // double -> Dinheiro
        verificarValor(valor, "não podemos depositar valores negativos ou zerados");
        this.saldo = this.saldo.somar(valor);
    }
    @Override
    public void saque(Dinheiro valor) {
        //pré-condições
        verificarValor(valor,"não podemos sacar valores negativos ou zerados");
        this.saldo = this.saldo.diminuir(valor);
    }

    Dinheiro verificarSaldo() {
        return this.saldo;
    }
    private void verificarValor(Dinheiro valor, String mensagem) throws IllegalArgumentException {
        if(valor.zerado())
            throw new IllegalArgumentException(mensagem);
    }
}