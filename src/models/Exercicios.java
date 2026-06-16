package models;

 //Classe abstrata que representa um exercício genérico do sistema.
 //Serve como base para os diferentes tipos de exercícios.

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
    
    //Retorna o valor unitário do exercício.
    //Deve ser implementado pelas subclasses.
     
    public abstract float getValorUnitario();
}
