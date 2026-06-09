package models;

public class Aluno extends Pessoa {
    private int matricula;
 
    public Aluno() {
        super();
        this.matricula = -1;
    }
 
    public int getMatricula() {
        return matricula;
    }
 
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
 
