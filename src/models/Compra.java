package models;

public class Compra {
	 
    private PlanoTreino[] planoTreino;
    private Pagamento pagamento;
 
    public Compra() {
    	planoTreino = null;
    	pagamento = null;
    }
 
    public PlanoTreino[] getPlanoTreino() {
        return planoTreino;
    }
    public void setPlanoTreino(PlanoTreino[] planoTreino) {
        this.planoTreino = planoTreino;
    }
 
    public Pagamento getPagamento() {
        return pagamento;
    }
 
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
 
    public float SomaTotal(PlanoTreino[] planoTreino) {
    	if (planoTreino == null || pagamento == null) return 0;
    	float somaTotal = 0.0f;
    	for (PlanoTreino pt: planoTreino) {
    		somaTotal += pt.calcularValorTotal();
    	}
        return somaTotal;
    }
}
