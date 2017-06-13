package br.com.comprex.comprex.modelo;

public class ProdutoLista extends Modelo {

    private Lista lista;
    private ProdutoMercado produtoMercado;
    private Integer quantidade;

    /**
     * Valor do produtoMercado * quantidade
     *
     * @return
     */
    public double getValor() {
        return produtoMercado.getPreco() * quantidade;
    }

    /*
     * Getters e Setters
     */

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public ProdutoMercado getProdutoMercado() {
        return produtoMercado;
    }

    public void setProdutoMercado(ProdutoMercado produtoMercado) {
        this.produtoMercado = produtoMercado;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return produtoMercado.getProduto().getNome();
    }

}
