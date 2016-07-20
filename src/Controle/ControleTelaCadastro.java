package Controle;

import Supermercado.BD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControleTelaCadastro implements ActionListener {

    private final BD bd;
    private final JRadioButton funcionario;
    private final JRadioButton gerente;
    private final JTextField nome;
    private final JFrame frame;
    private final JTextField login;
    private final JPasswordField senha;

    public ControleTelaCadastro(JTextField nome, JRadioButton funcionario, JRadioButton gerente, BD bd, JFrame frame, JTextField login, JPasswordField senha) {
        this.frame = frame;
        this.funcionario = funcionario;
        this.gerente = gerente;
        this.nome = nome;
        this.bd = bd;
        this.senha = senha;
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selecao = 0;
        if (funcionario.isSelected()) {
            selecao = 1;
        }
        if (gerente.isSelected()) {
            selecao = 0;
        }
        if (bd.confirmarLoginFuncionario(login.getText())) {
            JOptionPane.showMessageDialog(null, "Login ja existente");
        } else {
            bd.cadastrarFuncionario(nome.getText(), login.getText(), senha.getText(), selecao);
            bd.setFuncionarios();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado");
        }
        login.setText("");
        senha.setText("");
        nome.setText("");
    }

}
