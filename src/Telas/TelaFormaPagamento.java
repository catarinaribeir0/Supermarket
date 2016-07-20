package Telas;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaFormaPagamento {

    public void montarPagamento(Venda venda, JButton finalizarVenda, JButton pagamento) {
        final JFrame frame = new JFrame();
        JPanel painelEscolha = new JPanel();
        painelEscolha.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        JButton cartao = new JButton("Cartao");
        JButton dinheiro = new JButton("Dinheiro");
        JButton cancela = new JButton("Cancelar");
        painelEscolha.add(cartao);
        painelEscolha.add(dinheiro);
        painelEscolha.add(cancela);
        frame.add(painelEscolha);        

        cartao.addActionListener(new TelaVerificarCartao(venda, frame, finalizarVenda, pagamento));        
        dinheiro.addActionListener(new TelaVerificarDinheiro(venda, frame, finalizarVenda, pagamento));        
        cancela.addActionListener(new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }            
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
