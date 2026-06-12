package models;

import java.sql.*;

public class AlunoDAO implements OperacaoBD {
	 
    private BD bd;
    private Aluno aluno;
    
    private PreparedStatement statement;
    private ResultSet resultSet;
 
    private String sql, msg;

    public AlunoDAO() {
    	bd = null;
    	aluno = null;
    }
 

    public void setBd(BD bd) {
        this.bd = bd;
    }
 
    public Aluno getAluno() {
        return aluno;
    }
 
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

	public boolean localizar() {
		if (!bd.connect()) return false;
		sql = "SELECT * FROM aluno where matricula = ?";
		try {
			statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, aluno.getMatricula());

            resultSet = statement.executeQuery();
            resultSet.next();
            
            aluno.setMatricula( resultSet.getInt(1) );
            aluno.setNome( resultSet.getString(2) );
            aluno.setCpf( resultSet.getString(3) );
            aluno.setDataNascimento( resultSet.getDate(4) );
            aluno.setNumeroTelefone( resultSet.getString(5) );
  
            bd.close();
            return true;
		}
		catch(SQLException erro) {
            bd.close();
			return false;
		}
	}

	public String atualizar(TipoOperacaoBd operacao) {
		if (!bd.connect()) return "Falha ao conectar!";
        msg = "Operação realizada com sucesso!";
        try {
            if (operacao == TipoOperacaoBd.INCLUSAO) {
                sql = "INSERT into aluno(matricula,nome,cpf,dataNascimento,numeroTelefone) values (?,?,?,?,?)";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, aluno.getMatricula());
                statement.setString(2, aluno.getNome());
                statement.setString(3, aluno.getCpf());
                statement.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTime()));
                statement.setString(5, aluno.getNumeroTelefone());
            }
            else if (operacao == TipoOperacaoBd.ALTERACAO) {
            	sql = "UPDATE  aluno SET nome = ?, cpf = ?, dataNascimento = ?, numeroTelefone = ? WHERE matricula = ?";
                statement = bd.connection.prepareStatement(sql);
                
                statement.setString(1, aluno.getNome());
                statement.setString(2, aluno.getCpf());
                statement.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
                statement.setString(4, aluno.getNumeroTelefone());    
                statement.setInt(5, aluno.getMatricula());

                
            }
            else if (operacao == TipoOperacaoBd.EXCLUSAO) {
                sql = "DELETE FROM aluno WHERE matricula = ?";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, aluno.getMatricula());
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
