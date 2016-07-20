package Telas;

import Controle.ControleAtualizarProduto;
import Supermercado.Estoque;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaInserirProduto {
   
    public void montarTelaInserirProduto(Estoque estoque) {
        
        final JFrame frame = new JFrame();
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        final JButton inserirNovoProduto = new JButton("Inserir novo produto ao estoque");
        final JButton inserirQuantProduto = new JButton("Atualizar estoque");
        final JButton inserir = new JButton("Inserir");
        final JButton voltar = new JButton("Voltar");
        JButton cancelar = new JButton("Cancelar");
        JPanel painelBotoes = new JPanel(new GridLayout(5, 1));

        JLabel codProdutoL = new JLabel("Codigo do produto: ");
        final JTextField codProduto = new JTextField(10);
        JLabel valorL = new JLabel("Valor: ");
        final JTextField valor = new JTextField(10);
        JLabel quantidadeL = new JLabel("Quantidade: ");
        final JTextField quantidade = new JTextField(10);
        JLabel nomeL = new JLabel("Nome: ");
        final JTextField nome = new JTextField(10);
        JLabel tipoL = new JLabel("TIpo: ");
        final JTextField tipo = new JTextField(10);
        JPanel painelPreencher = new JPanel(new GridLayout(5, 2));

        painelPreencher.add(nomeL);
        painelPreencher.add(nome);
        painelPreencher.add(valorL);
        painelPreencher.add(valor);
        painelPreencher.add(codProdutoL);
        painelPreencher.add(codProduto);
        painelPreencher.add(quantidadeL);
        painelPreencher.add(quantidade);
        painelPreencher.add(tipoL);
        painelPreencher.add(tipo);
        painelPrincipal.add(painelPreencher, BorderLayout.WEST);

        painelBotoes.add(inserirNovoProduto);
        painelBotoes.add(inserirQuantProduto);
        painelBotoes.add(inserir);
        painelBotoes.add(voltar);
        painelBotoes.add(cancelar);
        painelPrincipal.add(painelBotoes, BorderLayout.EAST);
        frame.add(painelPrincipal);

        tipo.setEnabled(false);
        valor.setEnabled(false);
        codProduto.setEnabled(false);
        voltar.setEnabled(false);
        nome.setEnabled(false);
        quantidade.setEnabled(false);
        inserir.setEnabled(false);

        inserirNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome.setEnabled(true);
                tipo.setEnabled(true);
                quantidade.setEnabled(true);
                inserir.setEnabled(true);
                voltar.setEnabled(true);
                valor.setEnabled(true);
                inserirNovoProduto.setEnabled(false);
                inserirQuantProduto.setEnabled(false);                  
            }
        });

        inserirQuantProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codProduto.setEnabled(true);
                quantidade.setEnabled(true);
                inserir.setEnabled(true);
                voltar.setEnabled(true);
                inserirNovoProduto.setEnabled(false);
                inserirQuantProduto.setEnabled(false);                
            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codProduto.setEnabled(false);
                voltar.setEnabled(false);
                valor.setEnabled(false);
                nome.setEnabled(false);
                quantidade.setEnabled(false);
                inserir.setEnabled(false);
                tipo.setEnabled(false);
                inserirNovoProduto.setEnabled(true);
                inserirQuantProduto.setEnabled(true);
            }
        });
        
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }            
        });
        
        inserir.addActionListener(new ControleAtualizarProduto(estoque, nome, quantidade, codProduto, valor, tipo));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
