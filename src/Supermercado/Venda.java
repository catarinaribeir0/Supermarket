package Supermercado;

import java.util.ArrayList;
import java.util.Collection;

public class Venda {

    private final int idVenda;
    private static int totalIDVenda;
    private final Collection produtosCompra = new ArrayList();
    private float valorTotal = 0;
    private float troco;
    private String formaPagamento;
    private final int idCaixa;
    private final String loginFuncionario;

    public Venda(int idCaixa, String loginFuncionario) {
        Venda.totalIDVenda++;
        this.idVenda = totalIDVenda;
        this.idCaixa = idCaixa;
        this.loginFuncionario = loginFuncionario;
    }
    
    public Collection getProdutosCompra(){
        return this.produtosCompra;
    }
    
    public String getLoginFuncionario(){
        return this.loginFuncionario;
    }
    
    public int getIdCaixa(){
        return this.idCaixa;
    }

    public void adicionarProdutoVenda(Item item) {
        produtosCompra.add(item);
        valorTotal += item.getValorTotal();
    }

    public void removerProdutoVenda(Item item) {
        produtosCompra.remove(item);
        valorTotal -= item.getValorTotal();
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public float getTroco() {
        return this.troco;
    }
    
    public float getIdVenda() {
        return this.idVenda;
    }
    
    public String getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public boolean finalizarVenda(int senha){
        Cartao cartao = new Cartao();
        if (cartao.validarCartao(senha)){ 
            this.troco = 0;
            this.formaPagamento = "Cartao";
            return true;
        }        
        return false;
    }
    
    public float calcularTroco(float valor){
        troco = valor - this.valorTotal;
        if(troco >= 0){
            this.formaPagamento = "Dinheiro";
            return troco;            
        }
        return -1;
    }
  

}
