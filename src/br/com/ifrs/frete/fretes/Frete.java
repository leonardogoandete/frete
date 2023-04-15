package br.com.ifrs.frete.fretes;

import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.util.Situacao;
import br.com.ifrs.frete.util.Validator;

import java.util.TreeSet;

public class Frete implements Validator {
    private double valor, pesoTotal;
    private String cidadeOrigem, cidadeDestino;
    private TreeSet<ItemFrete> listaItens;
    private Cliente cliente;
    private Situacao situacao;

    public Frete(double valor, double pesoTotal, String cidadeOrigem, String cidadeDestino, TreeSet<ItemFrete> listaItens, Cliente cliente) {
        this.valor = valor;
        this.pesoTotal = pesoTotal;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.listaItens = listaItens;
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

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
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

    public void setListaItens(TreeSet<ItemFrete> listaItens) {
        this.listaItens = listaItens;
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
    public boolean validaPeso(double peso){
        return peso >= 1 && peso <= 100;
    }

    @Override
    public String toString(){
        return "====== Fretes Goandete ====== "+
               "\nCliente: "+ getCliente().getNome()+
               "\nvalor: " + getValor()+
               "\nPeso total: " + getPesoTotal()+
               "\nOrigem: " + getCidadeOrigem()+
               "\nDestino: " + getCidadeDestino()+
               "\nItens: " + getListaItens()+
               "\nSituação: " + getSituacao().getNome();
    }
}
