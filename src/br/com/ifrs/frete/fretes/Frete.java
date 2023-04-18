package br.com.ifrs.frete.fretes;

import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.util.Situacao;
import br.com.ifrs.frete.util.Validator;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Frete implements Validator, Comparable<Frete> {
    private static final double PESO_MINIMO = 0, PESO_MAXIMO = 100;
    private double valor, pesoTotal;
    private String cidadeOrigem, cidadeDestino;
    private TreeSet<ItemFrete> listaItens = new TreeSet<>();
    private Cliente cliente;
    private Situacao situacao;

    public Frete() {}
    public Frete(Cliente cliente, double valor, String cidadeOrigem, String cidadeDestino, List<ItemFrete> listaItens) {
        this.valor = valor;
        this.pesoTotal = 0;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        setListaItens(listaItens);
        setPesoTotal();
        this.cliente = cliente;
        this.situacao = Situacao.EM_ANDAMENTO;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal() {
        if (listaItens != null && !listaItens.isEmpty()) {
            for (ItemFrete itemFrete : listaItens) {
                pesoTotal += itemFrete.getPeso();
            }
        }
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public TreeSet<ItemFrete> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemFrete> item) {
        listaItens.addAll(item);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean validaPeso(double peso) {
        return peso > PESO_MINIMO && peso <= PESO_MAXIMO;
    }

    @Override
    public int compareTo(Frete obj) {
        if (obj.getValor() > this.valor) return 1;
        if (obj.getValor() < this.valor) return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Frete frete = (Frete) obj;
        return Double.compare(frete.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        StringBuilder itens = new StringBuilder();
        for (ItemFrete item : listaItens) {
            if (item != null) itens.append(item.toString());
        }

        return "\nCliente: " + getCliente().getNome() +
                "\nValor: " + getValor() +
                "\nPeso total: " + getPesoTotal() +
                "\nOrigem: " + getCidadeOrigem() +
                "\nDestino: " + getCidadeDestino() +
                "\nItens: " + itens +
                "\nSituação: " + getSituacao().getNome() + "\n";
    }

}
