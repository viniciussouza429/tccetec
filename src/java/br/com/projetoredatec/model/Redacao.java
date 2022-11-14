
package br.com.projetoredatec.model;

public class Redacao {

    private Integer idRedacao;
    private String descRedacao;
    private String dataentregaRedacao;
    private Turma idTurma;

    public Redacao() {
    }

    public Redacao(Integer idRedacao, String descRedacao, String dataentregaRedacao, Turma idTurma) {
        this.idRedacao = idRedacao;
        this.descRedacao = descRedacao;
        this.dataentregaRedacao = dataentregaRedacao;
        this.idTurma = idTurma;
    }

    public Redacao(Turma idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getIdRedacao() {
        return idRedacao;
    }

    public void setIdRedacao(Integer idRedacao) {
        this.idRedacao = idRedacao;
    }

    public String getDescRedacao() {
        return descRedacao;
    }

    public void setDescRedacao(String descRedacao) {
        this.descRedacao = descRedacao;
    }

    public String getDataentregaRedacao() {
        return dataentregaRedacao;
    }

    public void setDataentregaRedacao(String dataentregaRedacao) {
        this.dataentregaRedacao = dataentregaRedacao;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    
    
    
}
