package dao;

import models.Exercicios;

public class ExerciciosDAO {
	private BD bd;
	private Exercicios exercicios;

	public ExerciciosDAO() {
		this.bd = null;
		this.exercicios = null;
	}

	public void setBd(BD bd) {
		this.bd = bd;
	}

	public Exercicios getExercicios() {
		return exercicios;
	}

	public void setExercicios(Exercicios exercicios) {
		this.exercicios = exercicios;
	}
	
}
	