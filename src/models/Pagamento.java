package models;

public class Pagamento {
	 
    private FormaPagamento[] formaPagamento;
    private float valor;
    private int id;

 
    public Pagamento() {
    	formaPagamento = null;
    	valor = 0;
    	id = 0;
    }
 
    public FormaPagamento[] getFormaPagamento() {
        return formaPagamento;
    }
 
    public void setFormaPagamento(FormaPagamento[] formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
 
    public float getValor() {
        return valor;
    }
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setValor(float valor) {
        this.valor = valor;
    }
    
    public boolean efetuarPagamento() {
    	 if (this.formaPagamento == null || this.valor <= 0) return false;
    	 for (FormaPagamento fp : formaPagamento ) {
    		 if (!fp.pagar()) return false;
    	 }
		 return true;
    	 // Pg 84 figura 5.5
    }
}