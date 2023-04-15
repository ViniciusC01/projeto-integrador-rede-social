package br.com.projetopi.redesocial.model;

import java.util.Objects;

public class Usuario {
    private String email;
    private String senha;
    private String papel;

    public Usuario(String email, String senha, String papel) {
        this.email = email;
        this.senha = senha;
        this.papel = papel;
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

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(papel, usuario.papel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha, papel);
    }
}
