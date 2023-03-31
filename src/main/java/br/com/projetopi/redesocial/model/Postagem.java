package br.com.projetopi.redesocial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "postagem")
public class Postagem {
    @Id
    private Integer id;
    private String conteudo;
    private Integer foto_id;
    private Foto foto;

    public Postagem(String conteudo, Integer foto_id, Foto foto) {
        this.conteudo = conteudo;
        this.foto_id = foto_id;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(Integer foto_id) {
        this.foto_id = foto_id;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return id.equals(postagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Postagem{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", foto_id=" + foto_id +
                ", foto=" + foto +
                '}';
    }
}
