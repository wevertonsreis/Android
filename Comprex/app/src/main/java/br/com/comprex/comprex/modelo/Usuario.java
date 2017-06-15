package br.com.comprex.comprex.modelo;

public class Usuario extends Modelo {

    private String nome;
    private String email;
    private String senha;
    private String bandeiraCartaoDeCredito;
    private String numeroCartaoDeCredito;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBandeiraCartaoDeCredito() {
        return bandeiraCartaoDeCredito;
    }

    public void setBandeiraCartaoDeCredito(String bandeiraCartaoDeCredito) {
        this.bandeiraCartaoDeCredito = bandeiraCartaoDeCredito;
    }

    public String getNumeroCartaoDeCredito() {
        return numeroCartaoDeCredito;
    }

    public void setNumeroCartaoDeCredito(String numeroCartaoDeCredito) {
        this.numeroCartaoDeCredito = numeroCartaoDeCredito;
    }

}
