package br.com.projetoredatec.model;

public class Aluno extends Usuario{

    private Integer idAluno;
    private String raAluno;

    public Aluno() {
    }

    public Aluno(Integer idAluno, String raAluno) {
        this.idAluno = idAluno;
        this.raAluno = raAluno;
    }

    public Aluno(Integer idAluno, String raAluno, int idUsuario, String nomeUsuario, String emailUsuario, String telefoneUsuario, String loginUsuario, String senhaUsuario) {
        super(idUsuario, nomeUsuario, emailUsuario, telefoneUsuario, loginUsuario, senhaUsuario);
        this.idAluno = idAluno;
        this.raAluno = raAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

 
    
}
