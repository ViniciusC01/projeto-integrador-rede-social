package br.com.projetopi.redesocial.model;

import java.util.Objects;

public class Curso {

    private Integer id;
    private String nome;
    private String tipo;

    private String area;

    private Instituicao instituicao;
    private Integer instituicao_id;

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", area='" + area + '\'' +
                ", instituicao=" + instituicao +
                ", instituicao_id=" + instituicao_id +
                '}';
    }

    public Curso(String nome, String tipo, String area, Instituicao instituicao, Integer instituicao_id) {
        this.nome = nome;
        this.tipo = tipo;
        this.area = area;
        this.instituicao = instituicao;
        this.instituicao_id = instituicao_id;
    }

    public Curso(Integer id, String nome, String tipo, String area, Instituicao instituicao, Integer instituicao_id) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.area = area;
        this.instituicao = instituicao;
        this.instituicao_id = instituicao_id;
    }

    public Curso(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Integer getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(Integer instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id.equals(curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
