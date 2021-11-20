package br.edu.ifpb.account;

//tipo -> comportamento
interface Conta { //contrato
    void depositar(Dinheiro valor); //comportamento

    void saque(Dinheiro valor); //comportamento
}
