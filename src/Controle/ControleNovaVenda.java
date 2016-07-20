
package Controle;

import Supermercado.Caixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleNovaVenda implements ActionListener{
    private final JButton adicionar;
    private final JButton visualizar;
    private final JButton remover;
    private final JButton finalizarVenda;
    private final JButton novaVenda;
    private final JButton pagamento;
    private final JButton balanca;
    private final JTextField digitarCodigo;
    private final JTextField quantidade;
    private final Caixa caixa;
    
    public ControleNovaVenda(Caixa caixa, JButton adicionar, JButton visualizar, JButton remover, JButton pagamento, JButton finalizarVenda, JButton novaVenda, JButton balanca, JTextField digitarCodigo, JTextField quantidade){
        this.adicionar = adicionar;
        this.visualizar = visualizar;
        this.remover = remover;
        this.finalizarVenda = finalizarVenda;
        this.novaVenda = novaVenda;
        this.pagamento = pagamento;
        this.balanca = balanca;
        this.digitarCodigo = digitarCodigo;
        this.quantidade = quantidade;
        this.caixa = caixa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        caixa.novaVenda();
        JOptionPane.showMessageDialog(null, "Nova venda iniciada");
        quantidade.setEnabled(true);
        adicionar.setEnabled(true);
        visualizar.setEnabled(true);
        finalizarVenda.setEnabled(false);
        remover.setEnabled(true);
        pagamento.setEnabled(true);
        balanca.setEnabled(true);
        novaVenda.setEnabled(false);
        digitarCodigo.setEnabled(true);        
    }
    
}
