package models;
 
public class Login {
    private int id;
    private String codigo;
    private String senhaHash;
 
    public Login() {
        this.id = -1;
        this.codigo = null;
        this.senhaHash = null;
    }
 
    public boolean validarLogin(String codigo, String senha) {
        if (this.codigo == null || this.senhaHash == null) return false;
        return this.codigo.equals(codigo) && this.senhaHash.equals(String.valueOf(senha.hashCode()));
    }
    
    public boolean setSenhaHash(String senhaHash) {
        if (senhaHash == null) return false;
        int numeroHash = senhaHash.hashCode();
        this.senhaHash = String.valueOf(numeroHash); 
        return this.senhaHash != null;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getCodigo() {
        return codigo;
    }
 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
