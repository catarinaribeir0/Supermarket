package Controle;


import Supermercado.Estoque;
import Telas.TelaBalanca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ControleIniciarBalanca implements ActionListener {

    private final JTextField quantidade;

    public ControleIniciarBalanca(JTextField quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaBalanca balanca = new TelaBalanca();
        balanca.montarBalanca(quantidade);
    }
}
