package Supermercado;

import java.text.DecimalFormat;

public class Produto {

    protected static int codProd = 0;
    protected float valorProd;
    private String nome;
    private int tipo;

    Produto(float valor, String nome, int tipo) {
        Produto.codProd++;
        this.valorProd = valor;
        this.nome = nome;
        this.tipo = tipo;
    }

    public float getValorProd() {
        return this.valorProd;
    }
    
    public int getTipo(){
        return this.tipo;
    }

    public void setValorProd(float valor) {
        this.valorProd = valor;
    }

    public String getNome() {
        return this.nome;
    }
   
    public int getCodigo(){
        return this.codProd;
    }
    
    public String toString(){
        return this.nome;
    }
}
