package br.edu.ifpb.account;

import java.util.Objects;

//WMC=3
public class Dinheiro { // imutabilidade
    private final double valor;
    public Dinheiro(double valor) {
        //pré-condição
        if(valor<0)
            throw new IllegalArgumentException("não podemos ter dinheiro com valor negativo");
        this.valor = valor;
    }
    public Dinheiro somar(Dinheiro dinheiro) {
        return new Dinheiro(
                this.valor + dinheiro.valor
        );
    }

    public Dinheiro diminuir(Dinheiro dinheiro) { //0
        return new Dinheiro(
                this.valor - dinheiro.valor //simples de compreender esse código?
        );
    }

    public boolean zerado() {
        return this.valor <=0 ;
    }

    @Override
    public boolean equals(Object o) { //2
        //medir a complexidade deste método. Se tem if adicionar 1
        if (this == o) return true; //1
        if (o == null || getClass() != o.getClass()) return false; //2
        Dinheiro dinheiro = (Dinheiro) o;
        return Double.compare(dinheiro.valor, valor) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}