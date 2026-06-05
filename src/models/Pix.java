package models;

public class Pix extends FormaPagamento {
	 
    private String chave;
    private TipoChave tipo;
 
    public Pix() {
    }
 
    public String getChave() {
        return chave;
    }
 
    public void setChave(String chave) {
        this.chave = chave;
    }
 
    public TipoChave getTipo() {
        return tipo;
    }
 
    public void setTipo(TipoChave tipo) {
        this.tipo = tipo;
    }
 
    public boolean pagar() {
        // Falta implementar lógica de pagamento via Pix
        return false;
    }
}