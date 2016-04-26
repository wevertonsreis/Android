package br.com.guiapgcity.model;

/**
 * Created by Weverton on 10/04/2016.
 */
public class FormaPagamento {

    private Long id;
    private Long nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNome() {
        return nome;
    }

    public void setNome(Long nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "id=" + id +
                ", nome=" + nome +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormaPagamento that = (FormaPagamento) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
