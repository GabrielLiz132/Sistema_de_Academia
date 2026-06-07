package models;

public abstract class FormaPagamento {
	 
    private String descricao;
 
    public FormaPagamento() {
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public abstract boolean pagar();
}
