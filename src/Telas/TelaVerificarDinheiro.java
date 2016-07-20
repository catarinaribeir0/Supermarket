
package Telas;

import Controle.ControleVerificarCartao;
import Controle.ControleVerificarDinheiro;
import Supermercado.Venda;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaVerificarDinheiro implements ActionListener{
    private Venda venda;
    private JFrame janela;
    private final JButton finalizarVenda;
    private final JButton pagamento;
    
    public TelaVerificarDinheiro(Venda venda, JFrame janela, JButton finalizarVenda, JButton pagamento){
        this.venda = venda;
        this.janela = janela;
        this.finalizarVenda = finalizarVenda; 
        this.pagamento = pagamento;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        janela.dispose();
        final JFrame frame = new JFrame();
        JPanel painel = new JPanel(new GridLayout(1,4));
        JLabel valorL = new JLabel("Valor recebido:");
        JTextField valor = new JTextField();
        JButton confirma = new JButton("Confirmar");
        JButton cancela = new JButton("Cancelar");
        
        frame.add(painel);
        painel.add(valorL);
        painel.add(valor);
        painel.add(confirma);
        painel.add(cancela);
        
        confirma.addActionListener(new ControleVerificarDinheiro(venda, valor, finalizarVenda, pagamento, frame));
      
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
