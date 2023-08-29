package br.com.ifrs.frete.fretes;

import java.util.Objects;

public final class ItemFrete implements Comparable<ItemFrete> {
    private String descricao;
    private double peso;

    public ItemFrete(){}
    public ItemFrete(String descricao, double peso) {
        this.descricao = descricao;
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "\nDescrição: " + getDescricao() +
                "\npeso: " + getPeso();
    }

    @Override
    public int compareTo(ItemFrete obj) {
        return this.descricao.compareTo(obj.descricao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemFrete itemFrete = (ItemFrete) o;
        return Double.compare(peso, itemFrete.peso) == 0 && Objects.equals(descricao, itemFrete.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, peso);
    }
}
