package models;

public abstract class Cartao extends FormaPagamento {
	 
    private BandeiraCartao bandeira;
 
    public Cartao() {
        super();
        this.bandeira = null;
    }
 
    public BandeiraCartao getBandeira() {
        return bandeira;
    }
 
    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }
}