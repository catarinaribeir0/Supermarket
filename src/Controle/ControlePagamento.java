package Controle;

import Supermercado.Caixa;
import Telas.TelaFormaPagamento;
import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControlePagamento implements ActionListener {

    private final JButton adicionar;
    private final JButton consultar;
    private final JButton remover;
    private final JButton finalizarVenda;
    private final JButton pagamento;
    private final JButton desconectar;
    private final JButton balanca;
    private final Caixa caixa;

    public ControlePagamento(Caixa caixa, JButton adicionar, JButton consultar, JButton remover, JButton pagamento, JButton finalizarVenda, JButton desconectar, JButton balanca) {
        this.caixa = caixa;
        this.adicionar = adicionar;
        this.consultar = consultar;
        this.remover = remover;
        this.finalizarVenda = finalizarVenda;
        this.pagamento = pagamento;
        this.desconectar = desconectar;
        this.balanca = balanca;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adicionar.setEnabled(false);
        consultar.setEnabled(false);
        finalizarVenda.setEnabled(false);
        remover.setEnabled(false);
        desconectar.setEnabled(false);
        balanca.setEnabled(false);
        TelaFormaPagamento telaFormaPagamento = new TelaFormaPagamento();
        telaFormaPagamento.montarPagamento(caixa.getVenda(), finalizarVenda, pagamento);
    }

}
