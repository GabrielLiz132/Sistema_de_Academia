package models;

public class Professor extends Pessoa {
	private String cref;
	private String especialidade;

	public Professor() {
		super();
		this.cref = "";
		this.especialidade = "";
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
