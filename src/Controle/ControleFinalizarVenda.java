package Controle;

import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleFinalizarVenda implements ActionListener {

    private final JButton adicionar;
    private final JButton consultar;
    private final JButton remover;
    private final JButton finalizarVenda;
    private final JButton novaVenda;
    private final JButton pagamento;
    private final JButton desconectar;
    private final JButton balanca;
    private final Caixa caixa;
    private final DefaultListModel itens;
    private final JTextField nomeProduto;
    private final JTextField valorProduto;
    private final JTextField valorTotal;
    private final JTextField digitarCodigo;
    private final JTextField quantidade;

    public ControleFinalizarVenda(Caixa caixa, JButton adicionar, JButton consultar, JButton remover, JButton pagamento, JButton finalizarVenda, JButton novaVenda, JButton desconectar, JButton balanca, DefaultListModel itens, JTextField nomeProduto, JTextField valorProduto, JTextField valorTotal, JTextField digitarCodigo, JTextField quantidade) {
        this.adicionar = adicionar;
        this.consultar = consultar;
        this.remover = remover;
        this.finalizarVenda = finalizarVenda;
        this.novaVenda = novaVenda;
        this.pagamento = pagamento;
        this.caixa = caixa;
        this.itens = itens;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.valorTotal = valorTotal;
        this.digitarCodigo = digitarCodigo;
        this.desconectar = desconectar;
        this.balanca = balanca;
        this.quantidade = quantidade;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        caixa.finalizarVenda();
        JOptionPane.showMessageDialog(null, "Nota Fiscal Gerada");
        itens.clear();
        nomeProduto.setText("");
        valorProduto.setText("");
        valorTotal.setText("");
        digitarCodigo.setText("");
        digitarCodigo.setEnabled(false);
        adicionar.setEnabled(false);
        consultar.setEnabled(false);
        finalizarVenda.setEnabled(false);
        remover.setEnabled(false);
        pagamento.setEnabled(false);
        novaVenda.setEnabled(true);
        balanca.setEnabled(false);
        desconectar.setEnabled(true);
        quantidade.setEnabled(false);
    }

}
