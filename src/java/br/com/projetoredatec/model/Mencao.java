
package br.com.projetoredatec.model;

public class Mencao {
   
    private Integer idMencao;
    private String nomeMencao;
    private String descMencao;

    public Mencao() {
    }

    public Mencao(Integer idMencao, String nomeMencao, String descMencao) {
        this.idMencao = idMencao;
        this.nomeMencao = nomeMencao;
        this.descMencao = descMencao;
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


  
    
    
}
