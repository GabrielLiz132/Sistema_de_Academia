package models;

public abstract class FormaPagamento {
	 
    private String descricao;
    private int id;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FormaPagamento() {
        this.descricao = null;
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public abstract boolean pagar();
}
