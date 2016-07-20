package Supermercado;

public class Funcionario extends Pessoa {

    private static int totalID;
    private final int idFunc;
    private int cargo;

    Funcionario (String nome, String login, String senha, int cargo) {
        super(nome,login,senha);
        Funcionario.totalID++;
        this.idFunc = totalID;
        this.cargo = cargo;
    }

    public int getIDFunc() {
        return this.idFunc;
    }
    
    public int getCargo(){
        return this.cargo;
    }

}
