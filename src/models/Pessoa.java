package models;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private int numeroTelefone;
 
    public Pessoa() {
        this.nome = null;
        this.cpf = null;
        this.dataNascimento = null;
        this.numeroTelefone = 0;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getCpf() {
        return cpf;
    }
 
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    public Date getDataNascimento() {
        return dataNascimento;
    }
 
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
 
    public long getNumeroTelefone() {
        return numeroTelefone;
    }
 
    public void setNumeroTelefone(int i) {
        this.numeroTelefone = i;
    }
}
