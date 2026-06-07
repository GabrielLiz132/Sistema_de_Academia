package dao;

import models.Login;

public class LoginDAO implements OperacaoBD {
	 
    private BD bd;
    private Login login;
 
    public LoginDAO() {
    }
 
    public void setLogin(Login login) {
        this.login = login;
    }
 
    public Login getLogin() {
        return login;
    }
 
    public void setBD(BD bd) {
        this.bd = bd;
    }

	@Override
	public boolean localizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String atualizar(TipoOperacaoBD operacao) {
		// TODO Auto-generated method stub
		return null;
	}
}
