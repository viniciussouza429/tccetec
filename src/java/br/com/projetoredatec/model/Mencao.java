
package br.com.projetoredatec.model;

public class Mencao {
   
    private Integer idMencao;
    private String nomeMencao;
    private String descMencao;
    private Redacao idRedacao;
    private Aluno idAluno;

    public Mencao() {
    }

    public Mencao(Integer idMencao, String nomeMencao, String descMencao, Redacao idRedacao, Aluno idAluno) {
        this.idMencao = idMencao;
        this.nomeMencao = nomeMencao;
        this.descMencao = descMencao;
        this.idRedacao = idRedacao;
        this.idAluno = idAluno;
    }

    public Mencao(Redacao idRedacao) {
        this.idRedacao = idRedacao;
    }

    public Mencao(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdMencao() {
        return idMencao;
    }

    public void setIdMencao(Integer idMencao) {
        this.idMencao = idMencao;
    }

    public String getNomeMencao() {
        return nomeMencao;
    }

    public void setNomeMencao(String nomeMencao) {
        this.nomeMencao = nomeMencao;
    }

    public String getDescMencao() {
        return descMencao;
    }

    public void setDescMencao(String descMencao) {
        this.descMencao = descMencao;
    }

    public Redacao getIdRedacao() {
        return idRedacao;
    }

    public void setIdRedacao(Redacao idRedacao) {
        this.idRedacao = idRedacao;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    
    
}
