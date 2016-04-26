package br.com.guiapgcity.model;

import java.util.List;

/**
 * Created by Weverton on 10/04/2016.
 */
public class Empresa {

    private Long id;
    private String nome;
    private String email;
    private String site;
    private String nomeDoResponsavel;
    private List<TelefoneEmpresa> telefones;
    private Endereco endereco;
    private List<FormaPagamentoEmpresa> formasDePagamento;
    private String detalhes;
    private List<String> imagens;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public List<TelefoneEmpresa> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneEmpresa> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<FormaPagamentoEmpresa> getFormasDePagamento() {
        return formasDePagamento;
    }

    public void setFormasDePagamento(List<FormaPagamentoEmpresa> formasDePagamento) {
        this.formasDePagamento = formasDePagamento;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return !(id != null ? !id.equals(empresa.id) : empresa.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
