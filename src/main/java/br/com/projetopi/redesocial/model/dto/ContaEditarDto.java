package br.com.projetopi.redesocial.model.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class ContaEditarDto {
    private String cpf;
    private String nome;
    private Date nascimento;
    private String genero;
    private String instituicao;
    private String curso;
    private String turma;

    public ContaEditarDto() {
    }

    public ContaEditarDto(String cpf, String nome, Date nascimento, String genero, String instituicao, String curso, String turma) {
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

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
