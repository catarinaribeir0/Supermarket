package Supermercado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Estoque {

    private Map<Integer, Produto> identificador = new HashMap();
    private Map<Produto, Float> prateleiras = new HashMap();

    public Produto buscarProduto(Integer codProd) {
        return identificador.get(codProd);
    }


    public void gerarRelatorioEstoque() {
        FileWriter estoqueFinalDia;
        FileReader arquivo;
        DateFormat dat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));
        try {
            estoqueFinalDia = new FileWriter(new File("RelatorioEstoque " + dat.format(new Date()) + ".txt"));
            arquivo = new FileReader("Produtos.txt");
            BufferedReader estoqueInicioDia = new BufferedReader(arquivo);
            PrintWriter escreverArquivo = new PrintWriter(estoqueFinalDia);
            escreverArquivo.write("|----------------- CDL SUPERMERCADOS ---------------|\n");
            escreverArquivo.write("|---------------------------------------------------|\n");
            escreverArquivo.write("|---------------- RELATORIO DE ESTOQUE -------------|\n");
            escreverArquivo.write("| DATA: " + dat.format(new Date()) + "                         |\n");
            escreverArquivo.write("|        ESTOQUE DISPONIVEL - INICIO DO DIA         |\n");
            escreverArquivo.write(" PRODUTO                               QUANTIDADE\n");
            String linha = estoqueInicioDia.readLine();
            DecimalFormat df = new DecimalFormat("0.###");
            do {
                escreverArquivo.write(" " + linha);
                for (int i = 0; i < 2; i++) {
                    linha = estoqueInicioDia.readLine();
                }
                escreverArquivo.write("       "+ df.format(new Float(linha))+"\n");
                for (int i = 0; i < 2; i++) {
                    linha = estoqueInicioDia.readLine();
                }
            } while (linha != null);
            escreverArquivo.write("|                                                   |\n");
            escreverArquivo.write("|          ESTOQUE DISPONIVEL - FIM DO DIA          |\n");
            escreverArquivo.write(" PRODUTO                               QUANTIDADE\n");
            Set<Map.Entry<Produto, Float>> entrySet = prateleiras.entrySet();
            for(Map.Entry<Produto,Float> entrada : entrySet){
                escreverArquivo.write(" " + entrada.getKey() + "       " + df.format(entrada.getValue().floatValue()) + "\n");
            }
            escreverArquivo.write("|                                                   |\n");
            escreverArquivo.write("|---------------------------------------------------|\n");

            estoqueFinalDia.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Calculos com unidades
    public float quantidadeEstoque(Produto produto) {
        return prateleiras.get(produto);
    }

    public void inserirProduto(float valor, String nome, Float quantidade, int tipo) {
        Produto produto = new Produto(valor, nome, tipo);
        this.identificador.put(produto.getCodigo(), produto);
        this.prateleiras.put(produto, quantidade);
    }

    public void inserirPrateleira(Produto produto, Float quantidade) {
        Float quant = prateleiras.get(produto);
        quant += quantidade;
        prateleiras.put(produto, quant);
    }

    public boolean retirarPrateleira(Produto produto, Float quantidade) {
        Float quant = prateleiras.get(produto);
        quant -= quantidade;
        if (quant < 0) {
            return false;
        }
        prateleiras.put(produto, quant);
        return true;
    }

}
