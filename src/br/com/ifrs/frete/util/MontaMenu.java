package br.com.ifrs.frete.util;

public enum MontaMenu {
    CAD_FRETE(1, "Cadastrar Frete"),
    PES_FRETE_NOME(2, "Pesquisar Frete usando o nome do cliente"),
    PESQ_FRETE_CPF(3, "Pesquisar Frete usando CPF do Cliente"),
    PESQ_FRETE_ORI_DEST(4, "Pesquisar Frete usando cidade de origem e destino"),
    LISTA_TODOS_FRETES(5, "Listar todos os Fretes"),
    LISTA_TODOS_CLIENTE(6, "Listar todos os Clientes cadastrados"),
    SAIR(7,"Sair");

    private final String descricao;
    private final int codigo;

    private MontaMenu(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }
}
