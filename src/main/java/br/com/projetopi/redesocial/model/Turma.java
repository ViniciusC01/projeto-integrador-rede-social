package br.com.projetopi.redesocial.model;

import java.sql.Date;
import java.util.Objects;

public class Turma {

    private int id;
    private int curso_id;
    private Date data_inicio;
    private String turno;
    private String semestre;
    private String letra;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma)) return false;
        Turma turma = (Turma) o;
        return id == turma.id && curso_id == turma.curso_id && Objects.equals(data_inicio, turma.data_inicio) && Objects.equals(turno, turma.turno) && Objects.equals(semestre, turma.semestre) && Objects.equals(letra, turma.letra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso_id, data_inicio, turno, semestre, letra);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", curso_id=" + curso_id +
                ", data_inicio=" + data_inicio +
                ", turno='" + turno + '\'' +
                ", semestre='" + semestre + '\'' +
                ", letra='" + letra + '\'' +
                '}';
    }
}
