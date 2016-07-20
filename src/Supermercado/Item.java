package Supermercado;

import java.text.DecimalFormat;

public class Item {

    private final Produto produto;
    private final float quantidade;
    private float valorTotal;

    public Item(Produto produto, float quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = this.quantidade * this.produto.getValorProd();
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    public float getQuantidade() {
        return this.quantidade;
    }
    
    public String getNomeProduto() {
        return this.produto.getNome();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.produto.getNome() + " ......................................... " + "  x" + this.quantidade+ " R$ " +df.format(this.valorTotal) ;
    }
}
