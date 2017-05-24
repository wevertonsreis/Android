package br.com.comprex.modelo;

import java.io.Serializable;

public class Modelo implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modelo modelo = (Modelo) o;

        return id != null ? id.equals(modelo.id) : modelo.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
