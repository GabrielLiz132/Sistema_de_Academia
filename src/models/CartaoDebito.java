package models;

public class CartaoDebito extends Cartao {
	 
    public CartaoDebito() {
        super();
        setDescricao("Cartão de Débito");
    }
 
    public boolean pagar() {
        return getBandeira() != null;
    }
}
