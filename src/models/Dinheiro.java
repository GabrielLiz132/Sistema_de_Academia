package models;

public class Dinheiro extends FormaPagamento {
	 
    public Dinheiro() {
        super();
        setDescricao("Dinheiro");
    }
 
    public double darTroco(float valorPago, float valorCompra) {
        return valorPago - valorCompra;
    }
 
    public boolean pagar() {
        return true;
    }
}