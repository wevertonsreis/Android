package br.com.comprex.comprex.modelo;

public enum Bandeira {
    VISA(1L, "Visa"),
    MASTERCARD(2L,"MasterCard");

    private Long id;
    private String descricao;

    Bandeira(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
