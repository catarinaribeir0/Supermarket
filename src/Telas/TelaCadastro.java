/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controle.ControleTelaCadastro;
import Supermercado.BD;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaCadastro {

    public void montarTelaCadastro(BD bd) {
        
        final JFrame frame = new JFrame();
        JPanel painelPrincipal = new JPanel();
        
        JLabel nomeL = new JLabel("Nome: ");
        JTextField nome = new JTextField(10);
        JLabel loginL = new JLabel("Login: ");
        JTextField login = new JTextField(10);
        JLabel senhaL = new JLabel("Senha: ");
        JPasswordField senha = new JPasswordField(10);
        

        JButton confirmar = new JButton("Confirma");
        JButton cancelar = new JButton("Cancelar");
        
        JLabel funcaoL = new JLabel("Informe qual função será exercida");
        JLabel funcionarioL = new JLabel("Funcionario");
        JRadioButton funcionario = new JRadioButton();
        JLabel gerenteL = new JLabel("Gerente");
        JRadioButton gerente = new JRadioButton();
        ButtonGroup escolha = new ButtonGroup();
        escolha.add(gerente);
        escolha.add(funcionario);

        painelPrincipal.add(nomeL);
        painelPrincipal.add(nome);
        painelPrincipal.add(loginL);
        painelPrincipal.add(login);
        painelPrincipal.add(senhaL);
        painelPrincipal.add(senha);
        painelPrincipal.add(funcaoL);
        painelPrincipal.add(funcionarioL);
        painelPrincipal.add(funcionario);
        painelPrincipal.add(gerenteL);
        painelPrincipal.add(gerente);
        painelPrincipal.add(confirmar);
        painelPrincipal.add(cancelar);
        frame.add(painelPrincipal);
        
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        /*BotaoEscolha escolha = new BotaoEscolha();
    funcionario.addItemListenter(escolha);
    gerente.addItemListener(escolha);*/
        confirmar.addActionListener(new ControleTelaCadastro(nome, funcionario, gerente, bd, frame, login, senha));
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        
    }

}
