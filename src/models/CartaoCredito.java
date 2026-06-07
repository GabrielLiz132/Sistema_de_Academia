package models;

public class CartaoCredito extends Cartao {
	 
    private byte quantidadeParcela;
 
    public CartaoCredito() {
    }
 
    public byte getQuantidadeParcela() {
        return quantidadeParcela;
    }
 
    public void setQuantidadeParcela(byte quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }
 

    public boolean pagar() {
        // Falta implementar lógica de pagamento com cartão de crédito
        return false;
    }
}