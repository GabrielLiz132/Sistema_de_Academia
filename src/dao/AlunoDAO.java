package dao;

import models.Aluno;

public class AlunoDAO implements OperacaoBD {
	 
    private BD bd;
    private Aluno aluno;
 
    public AlunoDAO() {
    }
 
    public void setBD(BD bd) {
        this.bd = bd;
    }
 
    public Aluno getAluno() {
        return aluno;
    }
 
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
