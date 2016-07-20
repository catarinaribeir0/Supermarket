package Supermercado;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

public class BD {

    private Map<String, Funcionario> listaFuncionarios = new HashMap();
    private Collection<Venda> listaVendas = new ArrayList();
    private Estoque estoque;
    
    BD(Estoque estoque){
        this.estoque = estoque;
    }
    
    public void salvarVenda(Venda venda) {
        listaVendas.add(venda);
    }

    //métodos para Pessoas
    public void cadastrarFuncionario(String nome, String login, String senha, int cargo) {
        Funcionario funcionario = new Funcionario(nome, login, senha, cargo);
        this.listaFuncionarios.put(login, funcionario);
    }

    public Funcionario getFuncionario(String login) {
        return listaFuncionarios.get(login);
    }

    public boolean confirmarLoginFuncionario(String login) {
        if (listaFuncionarios.containsKey(login)) {
            return true;
        }
        return false;
    }

    public boolean loginFuncionario(String login, String senha) {
        Pessoa pessoa;
        if (listaFuncionarios.containsKey(login)) {
            pessoa = listaFuncionarios.get(login);
        } else {
            JOptionPane.showMessageDialog(null, "Login inexistente");
            return false;
        }
        if (pessoa.senha.equals(senha)) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Senha incorreta");
        return false;
    }
    
    public void setFuncionarios (){
        FileWriter arquivo;
        try {
            arquivo = new FileWriter(new File("Login.txt"));
            PrintWriter escreverArquivo = new PrintWriter(arquivo);
            Set<Map.Entry<String, Funcionario>> entrySet = this.listaFuncionarios.entrySet();
            for(Map.Entry<String, Funcionario> entrada : entrySet){
                escreverArquivo.write(entrada.getValue().getNome() + "\n" + entrada.getKey() + "\n" +  entrada.getValue().getSenha() + "\n" + entrada.getValue().getCargo() + "\n");
            }
            arquivo.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void gerarRelatorioVendas() {
        FileWriter relatorio;
        DateFormat dat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            relatorio = new FileWriter(new File("RelatorioVendas " + dat.format(new Date()) + ".txt"));
            PrintWriter escreverArquivo = new PrintWriter(relatorio);
            escreverArquivo.write("|----------------- CDL SUPERMERCADOS ---------------|\n");
            escreverArquivo.write("|---------------------------------------------------|\n");
            escreverArquivo.write("|---------------- RELATORIO DE VENDAS --------------|\n");
            escreverArquivo.write("| DATA: " + dat.format(new Date()) + "                         |\n");
            escreverArquivo.write(" CAIXA            FUNCIONARIO                  VALOR\n");
            for (Venda venda : listaVendas) {
                escreverArquivo.write(" " + venda.getIdCaixa() + "                " + venda.getLoginFuncionario() + "                  " + df.format(venda.getValorTotal()) + "\n");
            }
            escreverArquivo.write("|---------------------------------------------------|\n");
            
            relatorio.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
