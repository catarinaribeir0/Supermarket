
package Controle;

import Supermercado.Estoque;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleAtualizarProduto implements ActionListener{
    private final Estoque estoque;
    private final JTextField nome;
    private final JTextField valor;
    private final JTextField codigo;
    private final JTextField quantidade;
    private final JTextField tipo;
    
    public ControleAtualizarProduto(Estoque estoque, JTextField nome, JTextField quantidade, JTextField codigo, JTextField valor, JTextField tipo){
        this.estoque = estoque;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(codigo.getText().equals("")){
            estoque.inserirProduto(Float.parseFloat(valor.getText()), nome.getText(), Float.parseFloat(quantidade.getText()), Integer.parseInt(tipo.getText()));            
        }else{
            Produto produto = estoque.buscarProduto(Integer.parseInt(codigo.getText()));
            estoque.inserirPrateleira(produto, Float.parseFloat(quantidade.getText()));            
        }
        JOptionPane.showMessageDialog(null, "Produto inserido.");
    }
    
}
