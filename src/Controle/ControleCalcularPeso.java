
package Controle;

import Supermercado.Balanca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleCalcularPeso implements ActionListener{
    private final JTextField peso;
    private final JTextField quantidade;
    private final JFrame frame;
    
    public ControleCalcularPeso(JTextField quantidade, JTextField peso, JFrame frame){
        this.quantidade = quantidade;
        this.peso = peso;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Balanca balanca = new Balanca();
        String pesoTotal = balanca.calcularPeso(peso);
        quantidade.setText(pesoTotal);
        frame.dispose();
        JOptionPane.showMessageDialog(null, "O Peso é: " +pesoTotal+"Kg");
    }
    
}
