package dao;

import models.PlanoTreino;

public class PlanoTreinoDAO {
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
	
}
