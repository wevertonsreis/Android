package br.com.comprex.comprex.modelo;

public class Lista extends Modelo {

    private String nome;
    private String situacao;
    private Mercado mercado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
