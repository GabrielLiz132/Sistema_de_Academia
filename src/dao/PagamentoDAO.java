package dao;

import models.Pagamento;

public class PagamentoDAO implements OperacaoBD {
	 
    private BD bd;
    private Pagamento pagamento;
 
    public PagamentoDAO() {
    }
 
    public void setBD(BD bd) {
        this.bd = bd;
    }
 
    public Pagamento getPagamento() {
        return pagamento;
    }
 
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

	@Override
	public boolean localizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String atualizar(TipoOperacaoBD operacao) {
		// TODO Auto-generated method stub
		return null;
	}
}