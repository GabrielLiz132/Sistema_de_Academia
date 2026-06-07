package models;

public abstract class Exercicios {

    private String nomeExercicio;
    private String descricao;
    private CategoriaExercicios categoria;

    public Exercicios() {
        this.nomeExercicio = null;
        this.descricao = null;
        this.categoria = null;
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
    public abstract float getValorUnitario();
}
