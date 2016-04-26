package br.com.guiapgcity.model;

/**
 * Created by Weverton on 10/04/2016.
 */
public class TelefoneEmpresa {

    private Empresa empresa;
    private Telefone telefone;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
