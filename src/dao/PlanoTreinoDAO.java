package dao;

import models.PlanoTreino;

public class PlanoTreinoDAO implements OperacaoBD {
	private BD bd;
	private PlanoTreino planoTreino;
	
	public PlanoTreinoDAO() {
		this.bd = null;
		this.planoTreino = null;
	}

	public void setBd(BD bd) {
		this.bd = bd;
	}

	public PlanoTreino getPlanoTreino() {
		return planoTreino;
	}

	public void setPlanoTreino(PlanoTreino planoTreino) {
		this.planoTreino = planoTreino;
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
