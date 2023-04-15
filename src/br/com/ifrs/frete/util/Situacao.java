package br.com.ifrs.frete.util;

public enum Situacao {
    EM_ANDAMENTO(1, "Em andamento"),
    CANCELADO(2, "Cancelado"),
    ENCERRADO(3, "Encerrado");

    private final String nome;
    private final int id;

    private Situacao(int id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
