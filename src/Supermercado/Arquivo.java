package Supermercado;

import java.io.BufferedReader;
import java.io.FileReader;

public class Arquivo {

    private String nome;
    private float valor;
    private Float quantidade;
    private int cargo;
    private String login;
    private String senha;
    private int tipo;    

    public Estoque getProdutos(Estoque estoque) {
        try {
            FileReader arquivo = new FileReader("Produtos.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            String linha = lerArquivo.readLine();
            do {
                nome = linha;
                linha = lerArquivo.readLine();
                valor = new Float(linha);
                linha = lerArquivo.readLine();
                quantidade = new Float(linha);
                linha = lerArquivo.readLine();
                tipo = new Integer(linha);
                linha = lerArquivo.readLine();
                estoque.inserirProduto(valor, nome, quantidade, tipo);
            } while (linha != null);
            arquivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estoque;
    }
    
    public BD getFuncionarios(BD bd){
        try{
            FileReader arquivo = new FileReader("Login.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            
            String linha = lerArquivo.readLine();
            do {
                nome = linha;
                linha = lerArquivo.readLine();
                login = linha;
                linha = lerArquivo.readLine();
                senha = linha;
                linha = lerArquivo.readLine();
                cargo = new Integer(linha);
                linha = lerArquivo.readLine();
                bd.cadastrarFuncionario(nome, login, senha, cargo);
            } while (linha != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bd;
    }
}
