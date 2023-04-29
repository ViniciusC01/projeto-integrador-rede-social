package br.com.projetopi.redesocial.model.dto;

import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Turma;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class ContaEditarDto {
    private String cpf;
    private String nome;
    private Date nascimento;
    private String genero;
    private Instituicao instituicao;
    private Curso curso;
    private Turma turma;

    public ContaEditarDto() {
    }

    @Override
    public String toString() {
        return "ContaEditarDto{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", genero='" + genero + '\'' +
                ", instituicao=" + instituicao +
                ", curso=" + curso +
                ", turma=" + turma +
                '}';
    }

    public ContaEditarDto(String cpf, String nome, Date nascimento, String genero, Instituicao instituicao, Curso curso, Turma turma) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.genero = genero;
        this.instituicao = instituicao;
        this.curso = curso;
        this.turma = turma;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
