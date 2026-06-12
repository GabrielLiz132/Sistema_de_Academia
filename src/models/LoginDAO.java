package models;

import java.sql.*;


public class LoginDAO implements OperacaoBd {
	 
    private BD bd;
    private Login login;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private String sql, msg;

    public LoginDAO() {
        bd = null;
        login = null;
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
		if (!bd.connect()) return false;
		
		sql = "SELECT * FROM login WHERE codigo = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, login.getCodigo());

            resultSet = statement.executeQuery();
            resultSet.next();
            
            login.setId( resultSet.getInt(1) );
            login.setCodigo( resultSet.getString(2) );
            login.setString2hash( resultSet.getString(3) );
            bd.close();
            return true;
        }
        catch (SQLException erro) {
        	bd.close();
            return false;
        }
	}

	@Override
	 public String atualizar(TipoOperacaoBd operacao) {
		if (!bd.connect()) return "Falha ao conectar!";
        msg = "Operação realizada com sucesso!";
        try {
            if (operacao == TipoOperacaoBd.INCLUSAO) {
            	sql = "INSERT into login(id, codigo, senhaHash) values (?,?,?)";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, login.getId());
                statement.setString(2, login.getCodigo());
                statement.setString(3, login.getSenhaHash());
            }
            else if (operacao == TipoOperacaoBd.ALTERACAO) {
            	sql = "UPDATE login SET senhaHash = ? WHERE id = ?";
                statement = bd.connection.prepareStatement(sql);

                statement.setString(1, login.getSenhaHash());
                statement.setInt(2, login.getId());
            }
            else if (operacao == TipoOperacaoBd.EXCLUSAO) {
                sql = "DELETE FROM login WHERE id = ?";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, login.getId());
            }

            if (statement.executeUpdate() == 0) {
                msg = "Falha na operação!";
            }
        }
        catch (SQLException erro) {
            msg = "Falha na operação - " + erro.toString();
        }
        bd.close();
        return msg;
    }
}
