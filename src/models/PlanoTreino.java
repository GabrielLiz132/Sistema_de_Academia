package models;

import java.util.Date;

 //Classe que representa um plano de treino da academia
 //Associa um aluno, um professor responsável e uma lista de exercícios com suas quantidades

	public class PlanoTreino {

		private int idPlanoTreino;
		private Aluno aluno; 
	    private Professor professorResponsavel;
	    private Date dataDeCriacao;
	    private Exercicios[] exercicios;
	    private int[] quantidadeExercicios;

	    public PlanoTreino() {
	    	
	    }
	    
	    // Construtor completo da classe PlanoTreino.
	    
	    public PlanoTreino(Aluno aluno, Professor professorResponsavel, Date dataDeCriacao, Exercicios[] exercicios, int[] quantidadeExercicios) {
	    	this.aluno = aluno;
	        this.professorResponsavel = professorResponsavel;
	        this.dataDeCriacao = dataDeCriacao;
	        this.exercicios = exercicios;
	        this.quantidadeExercicios = quantidadeExercicios;
	    }
	    
		public int getIdPlanoTreino() {
			return idPlanoTreino;
		}

		public void setIdPlanoTreino(int idPlanoTreino) {
			this.idPlanoTreino = idPlanoTreino;
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

	    //Calcula o valor total do plano de treino com base no valor unitário e na quantidade de cada exercício
		
		public float calcularValorTotal() {
			  float total = 0;
		        for (int i = 0; i < exercicios.length; i++) {
		            total += exercicios[i].getValorUnitario() * quantidadeExercicios[i];
		        }
		        return total;
	    }
	}
