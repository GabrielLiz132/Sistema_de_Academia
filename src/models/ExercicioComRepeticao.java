package models;

// Classe abstrata que representa exercícios cuja cobrança é baseada na quantidade de repetições realizadas

public abstract class ExercicioComRepeticao extends Exercicios {
	
	private float valorPorRepeticao;
	
	public ExercicioComRepeticao(float valorPorRepeticao ) {
		super();
		this.valorPorRepeticao = valorPorRepeticao;
	}
	
	public float getValorPorRepeticao() {
		return valorPorRepeticao;
	}
	@Override
	public float getValorUnitario() {
	    return valorPorRepeticao;
	}
	
}
