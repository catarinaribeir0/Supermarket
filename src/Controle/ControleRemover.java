package Controle;

import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleRemover implements ActionListener {

    private final JList<Item> listaItens;
    private final DefaultListModel<Item> itens;
    private final Caixa caixa;
    private final JTextField valorTotal;
    private final Estoque estoque;

    public ControleRemover(Estoque estoque, JList listaItens, DefaultListModel itens, Caixa caixa, JTextField valorTotal) {
        this.listaItens = listaItens;
        this.itens = itens;
        this.caixa = caixa;
        this.valorTotal = valorTotal;
        this.estoque = estoque;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Item itemSelecionado = listaItens.getSelectedValue();
            caixa.getVenda().removerProdutoVenda(itemSelecionado);
            itens.removeElement(itemSelecionado);
            estoque.inserirPrateleira(itemSelecionado.getProduto(), itemSelecionado.getValorTotal());
            DecimalFormat df = new DecimalFormat("0.00");
            valorTotal.setText(String.valueOf(df.format(caixa.getVenda().getValorTotal())));
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
        }

    }

}
