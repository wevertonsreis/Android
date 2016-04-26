package br.com.guiapgcity.model;

/**
 * Created by Weverton on 10/04/2016.
 */
public class RamoEmpresa {

    private Empresa empresa;
    private Ramo ramo;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Ramo getRamo() {
        return ramo;
    }

    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RamoEmpresa that = (RamoEmpresa) o;

        if (!empresa.equals(that.empresa)) return false;
        return ramo.equals(that.ramo);

    }

    @Override
    public int hashCode() {
        int result = empresa.hashCode();
        result = 31 * result + ramo.hashCode();
        return result;
    }
}
