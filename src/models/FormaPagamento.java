package models;

public abstract class FormaPagamento {
	 
    private String descricao;
    private int id;
    

	public FormaPagamento() {
        descricao = null;
        id = 0;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public abstract boolean pagar();
}
