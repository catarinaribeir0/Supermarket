package Supermercado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class NotaFiscal {

    private final int idCaixa; 
    private final String login;
    private final Venda venda;

    public NotaFiscal(int idCaixa, String login, Venda venda) {
        this.idCaixa = idCaixa;
        this.login = login;
        this.venda = venda;
    }

    public void gerarNota() {
        DateFormat dat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));        
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.###");
        

        FileWriter notafiscal;
        try {
            notafiscal = new FileWriter(new File("notafiscal " +venda.getIdVenda()+ ".txt"));
            PrintWriter escreverArquivo = new PrintWriter(notafiscal);
            escreverArquivo.write("|----------------- CDL SUPERMERCADOS ---------------|\n");
            escreverArquivo.write("|---------------------------------------------------|\n");
            escreverArquivo.write("|-------------------- NOTA FISCAL ------------------|\n");
            escreverArquivo.write("| CAIXA: " +this.idCaixa + "              DATA: " + dat.format(new Date()) + "   |\n");
             escreverArquivo.write(" UNIDADE             PRODUTO                   R$\n");            
            Collection<Item> todosItens = venda.getProdutosCompra();
            for(Item item : todosItens){
                escreverArquivo.write("   " + df2.format(item.getQuantidade()) + "   " + item.getNomeProduto()+ "                    " + df.format(item.getValorTotal())+"\n");
            }
            escreverArquivo.write("                                                   \n");
            escreverArquivo.write("                                   TOTAL: R$ " + df.format(venda.getValorTotal()) + "\n");
            escreverArquivo.write("                                   TROCO: R$ " + df.format(venda.getTroco()) + "\n");
            escreverArquivo.write(" FORMA DE PAGAMENTO: " + venda.getFormaPagamento() + "\n");
            escreverArquivo.write(" ATENDENTE: " + this.login + "\n");            
            escreverArquivo.write("|---------------------------------------------------|\n");
            notafiscal.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

