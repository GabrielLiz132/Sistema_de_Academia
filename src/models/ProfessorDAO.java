package models;

import java.sql.*;

public class ProfessorDAO implements OperacaoBd {
	private Bd bd;
	private Professor professor;
	
	private PreparedStatement statement;
	private ResultSet resultSet;

	private String sql, msg;
		
	public ProfessorDAO() {
		this.bd = null;
		this.professor = null;
	}
	
	public void setBd(Bd bd) {
		this.bd = bd;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public boolean localizar() {
		if (!bd.connect()) return false;
		sql = "SELECT * FROM professor where cpf = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, professor.getCpf());

            resultSet = statement.executeQuery();
            resultSet.next();
            
            professor.setCpf( resultSet.getString(1) );
            professor.setNome( resultSet.getString(2) );
            professor.setDataNascimento( resultSet.getDate(3) );
            professor.setNumeroTelefone(resultSet.getString(4) );
            professor.setCref(resultSet.getString(5) );
            professor.setEspecialidade(resultSet.getString(6));
            return true;
        }
        catch (SQLException erro) {
            return false;
        }
    }
        

	@Override
	public String atualizar(TipoOperacaoBd operacao) {
		if (!bd.connect()) return "Falha ao conectar!";
		msg = "Operação realizada com sucesso!";
    	try {
    		if (operacao == TipoOperacaoBd.INCLUSAO) {
    			sql = "INSERT INTO professor (cpf,nome,dataNascimento,numeroTelefone,cref,especialidade) VALUES (?,?,?,?,?,?)";
    			statement = bd.connection.prepareStatement(sql);

    			statement.setString(1, professor.getCpf());
    			statement.setString(2, professor.getNome());
    			statement.setDate(3, new java.sql.Date(professor.getDataNascimento().getTime()));

    			statement.setString(4, professor.getNumeroTelefone());
    			statement.setString(5, professor.getCref());
    			statement.setString(6, professor.getEspecialidade());
    		}
    		else if (operacao == TipoOperacaoBd.ALTERACAO) {
    			sql = "UPDATE professor SET nome=?, dataNascimento=?, numeroTelefone=?, cref=?, especialidade=? WHERE cpf=?";
    			statement = bd.connection.prepareStatement(sql);

    			statement.setString(1, professor.getNome());
    			statement.setDate(2, new java.sql.Date( professor.getDataNascimento().getTime()));
    			statement.setString(3, professor.getNumeroTelefone());
    			statement.setString(4, professor.getCref());
    			statement.setString(5, professor.getEspecialidade());
    			statement.setString(6, professor.getCpf());
    		}
    		else if (operacao == TipoOperacaoBd.EXCLUSAO) {
    			sql = "DELETE FROM professor WHERE cpf=?";
    			statement = bd.connection.prepareStatement(sql);

    			statement.setString(1, professor.getCpf());
    		}
    		if(statement.executeUpdate() == 0) {
    			msg = "Falha na operação!";
    		}
    	}
    	catch(SQLException erro) {
    		msg = "Falha na operação - " + erro.toString();
    	}
    	return msg;
	}	
		
}
