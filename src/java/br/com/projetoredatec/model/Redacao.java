
package br.com.projetoredatec.model;

import java.sql.Date;

public class Redacao {

    private Integer idRedacao;
    private String descRedacao;
    private Date dataentregaRedacao;

    public Redacao() {
    }

    public Redacao(Integer idRedacao, String descRedacao, Date dataentregaRedacao) {
        this.idRedacao = idRedacao;
        this.descRedacao = descRedacao;
        this.dataentregaRedacao = dataentregaRedacao;
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

    public Date getDataentregaRedacao() {
        return dataentregaRedacao;
    }

    public void setDataentregaRedacao(Date dataentregaRedacao) {
        this.dataentregaRedacao = dataentregaRedacao;
    }


        
    
    
    
    
}
