package models;

public class Compra {
	 
    private PlanoTreino[] planoTreino;
    private Pagamento pagamento;
 
    public Compra() {
    }
 
    public PlanoTreino[] getPlanoTreino() {
        return planoTreino;
    }
 
    public Pagamento getPagamento() {
        return pagamento;
    }
 
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
 
    public float SomaTotal(PlanoTreino[] planoTreino) {
        //Falta implementar soma total dos planos de treino
        return 0;
    }
}
