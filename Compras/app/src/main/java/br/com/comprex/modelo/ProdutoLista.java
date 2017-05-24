package br.com.comprex.modelo;

public class ProdutoLista extends Modelo {

    private Lista lista;
    private Produto produto;

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return produto.getNome();
    }
}
