package Controle;

import Supermercado.Estoque;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleVisualizar implements ActionListener {

    private final Estoque estoque;
    private final JTextField nomeProduto;
    private final JTextField valorProduto;
    private final JTextField digitarCodigo;

    public ControleVisualizar(Estoque estoque, JTextField nome, JTextField valor, JTextField digitarCodigo) {

        this.nomeProduto = nome;
        this.valorProduto = valor;
        this.estoque = estoque;
        this.digitarCodigo = digitarCodigo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Integer codigoI = Integer.parseInt(digitarCodigo.getText());
            Produto produto = estoque.buscarProduto(codigoI);
            if (produto == null) {
                JOptionPane.showMessageDialog(null, "Código não cadastrado");
            } else {
                DecimalFormat df = new DecimalFormat("0.00");
                valorProduto.setText(String.valueOf(df.format(produto.getValorProd())));
                nomeProduto.setText(produto.getNome());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Codigo não válido");
        }
    }
}
