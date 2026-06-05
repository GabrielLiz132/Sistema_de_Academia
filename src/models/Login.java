package models;

public class Login {
	 
    private int id;
    private String codigo;
    private String senhaHash;
 
    public Login() {
    }
 
    public boolean validarLogin(String codigo, String senha) {
        String hashSenhaInformada = string2hash(senha);
        return this.codigo.equals(codigo) && this.senhaHash.equals(hashSenhaInformada);
    }
 
    public String string2hash(String valor) {
        // Falta implementar algoritmo de hash
        return valor;
    }
 
    public boolean setSenhaHash(String senhaHash) {
        if (senhaHash != null && !senhaHash.isEmpty()) {
            this.senhaHash = senhaHash;
            return true;
        }
        return false;
    }
 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
 
    public String getCodigo() {
        return codigo;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
}
