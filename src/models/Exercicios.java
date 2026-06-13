package models;

public abstract class Exercicios {

    private String nomeExercicio;
    private String descricao;

    public Exercicios() {
        this.nomeExercicio = null;
        this.descricao = null;
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
    public abstract float getValorUnitario();
}
