package dao;

import models.Professor;

public class ProfessorDAO implements OperacaoBD {
	private BD bd;
	private Professor professor;
	
	public ProfessorDAO() {
		this.bd = null;
		this.professor = null;
	}
	
	public void setBd(BD bd) {
		this.bd = bd;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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
