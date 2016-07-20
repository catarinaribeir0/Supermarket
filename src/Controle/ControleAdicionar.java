package Controle;

import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Item;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleAdicionar implements ActionListener {

    private final DefaultListModel<Item> itens;
    private Caixa caixa;
    private final Estoque estoque;
    private final JTextField digitarCodigo;
    private final JTextField valorTotal;
    private final JTextField quantidade;

    public ControleAdicionar(Estoque estoque, Caixa caixa, DefaultListModel<Item> itens, JTextField digitarCodigo, JTextField valorTotal, JTextField quantidade) {
        this.itens = itens;
        this.estoque = estoque;
        this.digitarCodigo = digitarCodigo;
        this.caixa = caixa;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Produto produto = estoque.buscarProduto(Integer.parseInt(digitarCodigo.getText()));
            if (Float.parseFloat(quantidade.getText()) == 0) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida");
            } else if (produto == null) {
                //Tratamento efetuado em controleVisualizar
            } else {
                Item item;
                if (produto.getTipo() == 0) {
                    item = new Item(produto, Float.parseFloat(quantidade.getText()));
                } else {
                    item = new Item(produto, Integer.parseInt(quantidade.getText()));
                }
                itens.addElement(item);
                caixa.getVenda().adicionarProdutoVenda(item);
                estoque.retirarPrateleira(produto, Float.parseFloat(quantidade.getText()));
                DecimalFormat df = new DecimalFormat("0.00");
                valorTotal.setText(String.valueOf(df.format(caixa.getVenda().getValorTotal())));
            }

        } catch (NumberFormatException ex) {
            //Tratamento efetuado em controleVisualizar
        }
    }

}
