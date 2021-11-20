package br.edu.ifpb.account;

import java.util.List;

// Target Class
class A{
    private List<A> elements;
    public List<A> getElements(){
        return this.elements;
    }
    public void add(A a){
        this.elements.add(a);
    }
}
// Client Class
public class C{
    private A a;
    public void m(){
        a.getElements().add(new A());
    }
    public void m1(){
        a.add(new A());
    }

    public static void main(String[] args) {
        C c = new C();
        c.m(); //alterando o estado do objeto definido na classe A
        c.m1(); //quem altera o estado do objeto A é o próprio A
        System.out.println(c.a.getElements().size());

    }
}

