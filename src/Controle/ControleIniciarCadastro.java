
package Controle;

import Supermercado.BD;
import Telas.TelaCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleIniciarCadastro implements ActionListener{
    private BD bd;
    
    public ControleIniciarCadastro(BD bd){
        this.bd = bd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaCadastro telacadastro = new TelaCadastro();
        telacadastro.montarTelaCadastro(bd);
    }
}
