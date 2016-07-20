/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controle.ControleCalcularPeso;
import Supermercado.Estoque;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaBalanca {

    public void montarBalanca(JTextField quantidade) {
        final JFrame frame = new JFrame();
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Balança"));
        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");

        JLabel pesoL = new JLabel("Digite o peso");
        JTextField peso = new JTextField(10);
        painel.add(pesoL);
        painel.add(peso);
        painel.add(confirmar);
        painel.add(cancelar);
        frame.add(painel);
        
        confirmar.addActionListener(new ControleCalcularPeso(quantidade, peso, frame));
        cancelar.addActionListener(new ActionListener(){
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
