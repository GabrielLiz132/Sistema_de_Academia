package models;

public abstract class ExercicioComTempo extends Exercicios {
	
	private float valorPorSegundo;
	
	public ExercicioComTempo(float valorPorSegundo) {
		super();
		this.valorPorSegundo = valorPorSegundo;
	}

	public float getValorPorSegundo() {
		return valorPorSegundo;
	}
	@Override
	public float getValorUnitario() {
	    return valorPorSegundo;
	}

}	
