package models;

public abstract class ExercicioComRepeticao extends Exercicios {
	private byte series;
	private byte repeticoes;
	private short peso;
	
	public ExercicioComRepeticao() {
		super();
		this.series = -1;
		this.repeticoes = -1;
		this.peso = -1;
	}

	public byte getSeries() {
		return series;
	}

	public void setSeries(byte series) {
		this.series = series;
	}

	public byte getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(byte repeticoes) {
		this.repeticoes = repeticoes;
	}

	public short getPeso() {
		return peso;
	}

	public void setPeso(short peso) {
		this.peso = peso;
	}
	
}
