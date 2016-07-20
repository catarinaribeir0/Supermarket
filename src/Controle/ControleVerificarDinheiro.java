package Controle;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleVerificarDinheiro implements ActionListener {

    private final Venda venda;
    private final JTextField valor;
    private final JButton finalizarVenda;
    private final JButton pagamento;
    private final JFrame janela;

    public ControleVerificarDinheiro(Venda venda, JTextField valor, JButton finalizarVenda, JButton pagamento, JFrame janela) {
        this.venda = venda;
        this.valor = valor;
        this.finalizarVenda = finalizarVenda;
        this.pagamento = pagamento;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janela.dispose();
        try {
        float valorF = Float.parseFloat(valor.getText());
        float troco = venda.calcularTroco(valorF);
        if (troco == -1) {
            JOptionPane.showMessageDialog(null, "Valor insuficiente");
        } else {
            finalizarVenda.setEnabled(true);            
            pagamento.setEnabled(false);
            DecimalFormat df = new DecimalFormat("0.00");
            JOptionPane.showMessageDialog(null, "Troco: R$" + df.format(troco));
            finalizarVenda.doClick();
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido");
        }
    }

}
