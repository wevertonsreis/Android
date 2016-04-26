package br.com.guiapgcity.model;

/**
 * Created by Weverton on 10/04/2016.
 */
public class FormaPagamentoEmpresa {

    private Empresa empresa;
    private FormaPagamento formaPagamento;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormaPagamentoEmpresa that = (FormaPagamentoEmpresa) o;

        if (!empresa.equals(that.empresa)) return false;
        return formaPagamento.equals(that.formaPagamento);

    }

    @Override
    public int hashCode() {
        int result = empresa.hashCode();
        result = 31 * result + formaPagamento.hashCode();
        return result;
    }

}
