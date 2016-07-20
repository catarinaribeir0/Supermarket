package Telas;

import Controle.ControleLogin;
import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Estoque;
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

public class TelaLogin {

    private JFrame frame;
    private JPanel painelLogin;
    private JPasswordField senha;
    private JTextField login;

    public void montarTelaLogin(BD bd, Estoque estoque, Caixa caixa) {


        frame = new JFrame("Sistema Supermercado Caixa " + caixa.getIdCaixa());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painelLogin = new JPanel(new GridLayout(3, 2));
        frame.add(painelLogin);
        JLabel labelLogin = new JLabel("Login:");
        login = new JTextField();
        painelLogin.add(labelLogin);
        painelLogin.add(login);    
        JLabel labelSenha = new JLabel("Senha:");
        senha = new JPasswordField();
        painelLogin.add(labelSenha);
        painelLogin.add(senha);    
        JButton confirma = new JButton("Confirma");
        JButton sair = new JButton("Sair");
        painelLogin.add(confirma);
        painelLogin.add(sair);
        
        confirma.addActionListener(new ControleLogin(login, senha, bd, estoque, caixa,frame));
        confirma.addKeyListener(new ControleLogin(login, senha, bd, estoque, caixa,frame));
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(200, 120);
        frame.setVisible(true);
    }
}
