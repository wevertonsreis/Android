package br.com.guiapgcity.model;

/**
 * Created by Weverton on 10/04/2016.
 */
public class Cidade {

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        return id.equals(cidade.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
