package models;

public class CartaoCredito extends Cartao {
    private byte quantidadeParcela;
 
    public CartaoCredito() {
        super();
        setDescricao("Cartão de Crédito");
        quantidadeParcela = 1;
    }
 
    public byte getQuantidadeParcela() {
        return quantidadeParcela;
    }
 
    public void setQuantidadeParcela(byte quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }
 
    public boolean pagar() {
        return getBandeira() != null && quantidadeParcela > 0;
    }
}