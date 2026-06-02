package models;

public abstract class Exercicios {

    private String nomeExercicio;
    private String descricao;
    private CategoriaExercicios categoria;
    private boolean comMaquina;

    public Exercicios() {
        this.nomeExercicio = null;
        this.descricao = null;
        this.categoria = null;
        this.comMaquina = false;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaExercicios getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaExercicios categoria) {
        this.categoria = categoria;
    }
    
	public boolean isComMaquina() {
		return comMaquina;
	}

	public void setComMaquina(boolean comMaquina) {
		this.comMaquina = comMaquina;
	}
	
	public abstract float calculaValorExercicios();
	
}
