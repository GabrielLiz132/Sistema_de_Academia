package models;

public abstract class ExercicioComRepeticao extends Exercicios {
	
	private float valorPorRepeticao;
	
	public ExercicioComRepeticao(float exercicioComRepeticao ) {
		super();
		this.valorPorRepeticao = exercicioComRepeticao;
	}
	
	public float getValorPorRepeticao() {
		return valorPorRepeticao;
	}
	@Override
	public float getValorUnitario() {
	    return valorPorRepeticao;
	}
	
}
