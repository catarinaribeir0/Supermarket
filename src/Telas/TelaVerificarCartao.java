
package Telas;

import Controle.ControleVerificarCartao;
import Supermercado.Venda;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaVerificarCartao implements ActionListener{   
    
    private JPasswordField senha;
    private Venda venda;
    private JFrame janela;
    private final JButton finalizarVenda;
    private final JButton pagamento;
    
    public TelaVerificarCartao(Venda venda, JFrame janela, JButton finalizarVenda, JButton pagamento){
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
        JLabel senhaL = new JLabel("Digite a senha:");
        senha = new JPasswordField("");
        JButton confirma = new JButton("Confirmar");
        JButton cancela = new JButton("Cancelar");
        
        frame.add(painel);
        painel.add(senhaL);
        painel.add(senha);
        painel.add(confirma);
        painel.add(cancela);
        
        confirma.addActionListener(new ControleVerificarCartao(venda,senha,finalizarVenda, pagamento, frame));
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
