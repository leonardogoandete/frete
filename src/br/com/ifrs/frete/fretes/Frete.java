package br.com.ifrs.frete.fretes;

import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.util.Situacao;
import br.com.ifrs.frete.util.Validator;

import java.util.List;
import java.util.TreeSet;

public class Frete implements Validator {
    private double valor, pesoTotal;
    private String cidadeOrigem, cidadeDestino;
    private TreeSet<ItemFrete> listaItens = new TreeSet<>();
    private Cliente cliente;
    private Situacao situacao;

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
        if (listaItens != null && !listaItens.isEmpty()){
            for (ItemFrete itemFrete: listaItens) {
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
    public boolean validaPeso(double peso){
        return peso >= 1 && peso <= 100;
    }

    @Override
    public String toString(){
        return "====== Fretes Goandete ltda ====== "+
               "\nCliente: "+ getCliente().getNome()+
               "\nvalor: " + getValor()+
               "\nPeso total: " + getPesoTotal()+
               "\nOrigem: " + getCidadeOrigem()+
               "\nDestino: " + getCidadeDestino()+
               "\nItens: " + getListaItens()+
               "\nSituação: " + getSituacao().getNome()+"\n";
    }
}
