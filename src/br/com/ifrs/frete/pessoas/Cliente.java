package br.com.ifrs.frete.pessoas;

public class Cliente extends Pessoa {
    private String endereco, telefone, cpf;
    private static int NUMERO_CLIENTES = 0;
    private int numero = 1;

    public Cliente(String nome) {
        super(nome);
    }

    public Cliente(String nome, String endereco, String telefone, String cpf) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.numero += NUMERO_CLIENTES;
        NUMERO_CLIENTES++;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static int getTotal() {
        return NUMERO_CLIENTES;
    }

    @Override
    public String toString() {
        return "\nNome: " + super.toString() +
                "\nEndereço: " + getEndereco() +
                "\nTelefone: " + getTelefone() +
                "\nCPF: " + getCpf() +
                "\nNumero: " + getNumero() + "\n";
    }
}
