package models;

import java.time.Duration;

public abstract class ExercicioSemRepeticao extends Exercicios {
	
	private Duration tempoExercicio;
	private String intensidade;
	
	public ExercicioSemRepeticao() {
		super();
		this.tempoExercicio = null;
		this.intensidade = "";
	}

	public Duration getTempoExercicio() {
		return tempoExercicio;
	}

	public void setTempoExercicio(Duration tempoExercicio) {
		this.tempoExercicio = tempoExercicio;
	}

	public String getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}
	
	
}
