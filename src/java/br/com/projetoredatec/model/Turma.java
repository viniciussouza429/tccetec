
package br.com.projetoredatec.model;

public class Turma{
    
    
    private Integer idTurma;
    private String nomeTurma;
    private Professor idProfessor;
    
    
    public Turma() {
    }

    public Turma(Integer idTurma, String nomeTurma, Professor idProfessor) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.idProfessor = idProfessor;
    }

    public Turma(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }
    
    

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Professor getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }


    
    
}
