package dao;

import models.Login;
import java.sql.*;


public class LoginDAO implements OperacaoBD {
	 
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
		
        sql = "SELECT * FROM login where id = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, login.getId());

            resultSet = statement.executeQuery();
            resultSet.next();
            
            login.setId( resultSet.getInt(1) );
            login.setCodigo( resultSet.getString(2) );
            login.setSenhaHash( resultSet.getString(3) );
            bd.close();
            return true;
        }
        catch (SQLException erro) {
        	bd.close();
            return false;
        }
	}

	@Override
	 public String atualizar(TipoOperacaoBD operacao) {
		if (!bd.connect()) return "Falha ao conectar!";
        msg = "Operação realizada com sucesso!";
        try {
            if (operacao == TipoOperacaoBD.INCLUSAO) {
                sql = "INSERT into login(id,senhaHash) values (?,?)";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, login.getId());
                statement.setString(2, login.getSenhaHash());
            }
            else if (operacao == TipoOperacaoBD.ALTERACAO) {
            	sql = "UPDATE login SET senhaHash = ? WHERE id = ?";
                statement = bd.connection.prepareStatement(sql);

                statement.setString(1, login.getSenhaHash());
                statement.setInt(2, login.getId());
            }
            else if (operacao == TipoOperacaoBD.EXCLUSAO) {
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
