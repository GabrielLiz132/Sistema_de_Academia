package models;

public abstract class Cartao extends FormaPagamento {
	 
    private BandeiraCartao bandeira;
 
    public Cartao() {
    }
 
    public BandeiraCartao getBandeira() {
        return bandeira;
    }
 
    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }
}