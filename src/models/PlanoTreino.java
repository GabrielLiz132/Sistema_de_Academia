package models;

import java.util.Date;

	public class PlanoTreino {

		private Aluno aluno; 
	    private Professor professorResponsavel;
	    private Date dataDeCriacao;
	    private Exercicios[] exercicios;
	    private int[] quantidadeExercicios;

	    public PlanoTreino() {
	    	this.aluno = null;
	    	this.professorResponsavel = null;
	    	this.dataDeCriacao = null;
	    	this.exercicios = null;
	    	this.quantidadeExercicios = null;
	    }

	    public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}

		public Professor getProfessorResponsavel() {
			return professorResponsavel;
		}

		public void setProfessorResponsavel(Professor professorResponsavel) {
			this.professorResponsavel = professorResponsavel;
		}

		public Date getDataDeCriacao() {
			return dataDeCriacao;
		}

		public void setDataDeCriacao(Date dataDeCriacao) {
			this.dataDeCriacao = dataDeCriacao;
		}

		public Exercicios[] getExercicios() {
			return exercicios;
		}

		public void setExercicios(Exercicios[] exercicios) {
			this.exercicios = exercicios;
		}

		public int[] getQuantidadeExercicios() {
			return quantidadeExercicios;
		}

		public void setQuantidadeExercicios(int[] quantidadeExercicios) {
			this.quantidadeExercicios = quantidadeExercicios;
		}

		public float calcularValorTotal() {
			return 0.0f;
	    }
	}
