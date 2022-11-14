
package br.com.projetoredatec.model;

public class Turma{
    
    
    private Integer idTurma;
    private String nomeTurma;
    
    
    public Turma() {
    }

    public Turma(Integer idTurma, String nomeTurma) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
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

    
    
}
