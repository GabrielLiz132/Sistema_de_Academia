package models;

// Classe abstrata que representa exercícios cuja cobrança é baseada no tempo de execução em segundos

public abstract class ExercicioComTempo extends Exercicios {
	
	private float valorPorSegundo;
	
	public ExercicioComTempo(float valorPorSegundo) {
		super();
		this.valorPorSegundo = valorPorSegundo;
	}

	public float getValorPorSegundo() {
		return valorPorSegundo;
	}
	
	// Retorna o valor unitário do exercício, neste caso, corresponde ao valor por segundo.
	
	@Override
	public float getValorUnitario() {
	    return valorPorSegundo;
	}

}	
