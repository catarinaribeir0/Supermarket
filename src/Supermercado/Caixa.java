
package Supermercado;

import Telas.TelaLogin;
import java.util.ArrayList;
import java.util.Collection;

public class Caixa{
    private final BD bd;
    private static int totalCaixa;
    private final int idCaixa;
    private Venda venda;
    private String loginFuncionario;
    
    public Caixa(BD bd){        
        Caixa.totalCaixa++;
        idCaixa = totalCaixa;
        this.bd = bd;
    }
    
    public void setLogin(String login){
        this.loginFuncionario = login;
    }
    
    public void novaVenda(){
        this.venda = new Venda(this.idCaixa, this.loginFuncionario);        
    }
    
    public Venda getVenda(){
        return this.venda;
    }

    public int getIdCaixa(){
        return this.idCaixa;
    }
    
    public void finalizarVenda(){
        NotaFiscal nota = new NotaFiscal(this.idCaixa, this.loginFuncionario, this.venda);
        nota.gerarNota();
        bd.salvarVenda(venda);
    }

    
}
