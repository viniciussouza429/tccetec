package br.com.projetoredatec.model;

public class Professor extends Usuario{

    private Integer idProfessor;
    private String rmProfessor;

    public Professor() {
    }

    public Professor(Integer idProfessor, String rmProfessor) {
        this.idProfessor = idProfessor;
        this.rmProfessor = rmProfessor;
    }

    public Professor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }
    
    

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getRmProfessor() {
        return rmProfessor;
    }

    public void setRmProfessor(String rmProfessor) {
        this.rmProfessor = rmProfessor;
    }

 

    
    
}
