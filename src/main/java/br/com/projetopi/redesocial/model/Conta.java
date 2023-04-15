package br.com.projetopi.redesocial.model;

import java.sql.Date;
import java.time.LocalDate;


public class Conta {
    private int id;
    private String cpf;
    private String nome;
    private Date data_nascimento;
    private String sobre;
    private int usuario_id;
    private int instituiacao_id;
    private int curso_id;
    private int foto_id;
    private int turma_id;

    public Conta(){

    }

    public Conta(String cpf, String nome, Date data_nascimento, String sobre, int usuario_id, int instituiacao_id, int curso_id, int foto_id, int turma_id) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sobre = sobre;
        this.usuario_id = usuario_id;
        this.instituiacao_id = instituiacao_id;
        this.curso_id = curso_id;
        this.foto_id = foto_id;
        this.turma_id = turma_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getInstituiacao_id() {
        return instituiacao_id;
    }

    public void setInstituiacao_id(int instituiacao_id) {
        this.instituiacao_id = instituiacao_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;
    }

    public int getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(int turma_id) {
        this.turma_id = turma_id;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", sobre='" + sobre + '\'' +
                ", usuario_id=" + usuario_id +
                ", instituiacao_id=" + instituiacao_id +
                ", curso_id=" + curso_id +
                ", foto_id=" + foto_id +
                ", turma_id=" + turma_id +
                '}';
    }
}
