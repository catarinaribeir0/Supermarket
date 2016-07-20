package Controle;

import Supermercado.Estoque;
import Telas.TelaInserirProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleInserirProduto implements ActionListener{

    private Estoque estoque;

    public ControleInserirProduto(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaInserirProduto telainserirproduto = new TelaInserirProduto();
        telainserirproduto.montarTelaInserirProduto(this.estoque);
    }
    
}
