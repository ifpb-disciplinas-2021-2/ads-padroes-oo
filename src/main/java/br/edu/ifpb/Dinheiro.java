package br.edu.ifpb;

import java.util.Objects;

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

    public Dinheiro diminuir(Dinheiro dinheiro) {
        return new Dinheiro(
                this.valor - dinheiro.valor
        );
    }

    public boolean zerado() {
        return this.valor <=0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return Double.compare(dinheiro.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
