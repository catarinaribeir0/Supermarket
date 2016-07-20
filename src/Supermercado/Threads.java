package Supermercado;

import Telas.TelaLogin;

public class Threads implements Runnable {

    private final BD bd;
    private final Estoque estoqueLocal;

    public Threads(BD bd, Estoque estoqueLocal) {
        this.bd = bd;
        this.estoqueLocal = estoqueLocal;
    }

    @Override
    public void run() {
        Caixa caixa = new Caixa(bd);
        TelaLogin telalogin = new TelaLogin();
        telalogin.montarTelaLogin(bd, estoqueLocal, caixa);
    }

}
