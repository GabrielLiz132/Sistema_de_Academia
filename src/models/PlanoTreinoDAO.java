package models;

import java.sql.*;
import java.util.ArrayList;

public class PlanoTreinoDAO implements OperacaoBD {
	private Bd bd;
	private PlanoTreino planoTreino;
	
	private PreparedStatement statement;
	private ResultSet resultSet;

	private String sql, msg;
	
	public PlanoTreinoDAO() {
		this.bd = null;
		this.planoTreino = null;
	}

	public void setBd(Bd bd) {
		this.bd = bd;
	}

	public PlanoTreino getPlanoTreino() {
		return planoTreino;
	}

	public void setPlanoTreino(PlanoTreino planoTreino) {
		this.planoTreino = planoTreino;
	}

	@Override
	public boolean localizar() {
		sql = "SELECT * FROM PlanoTreino WHERE idPlanoTreino = ?";

		try {

			statement = bd.connection.prepareStatement(sql);
		    statement.setInt(1, planoTreino.getIdPlanoTreino());

		    resultSet = statement.executeQuery();
		    resultSet.next();
		    
		    planoTreino.setIdPlanoTreino(resultSet.getInt(1));

		    Aluno aluno = new Aluno();
		    aluno.setMatricula(resultSet.getInt(2));

		    AlunoDAO alunoDAO = new AlunoDAO();
		    alunoDAO.setBd(bd);
		    alunoDAO.setAluno(aluno);

		    alunoDAO.localizar();

		    // Professor
		    Professor professor = new Professor();
		    professor.setCpf(resultSet.getString(3));

		    ProfessorDAO professorDAO = new ProfessorDAO();
		    professorDAO.setBd(bd);
		    professorDAO.setProfessor(professor);

		    professorDAO.localizar();

		    // Preenche o plano
		    planoTreino.setAluno(alunoDAO.getAluno());
		    planoTreino.setProfessorResponsavel(professorDAO.getProfessor());
		    planoTreino.setDataDeCriacao(resultSet.getDate(4));
		    
		    ArrayList<Exercicios> listaExercicios = new ArrayList<>();
		    ArrayList<Integer> listaQuantidades = new ArrayList<>();

		    sql = "SELECT * FROM ExerciciosPlanoTreino WHERE idPlanoTreino = ?";

		    statement = bd.connection.prepareStatement(sql);
		    statement.setInt(1, planoTreino.getIdPlanoTreino());

		    resultSet = statement.executeQuery();

		    while(resultSet.next()) {

		        String nomeExercicio = resultSet.getString(3);
		        int quantidade = resultSet.getInt(4);

		        Exercicios exercicio = criarExercicio(nomeExercicio);

		        listaExercicios.add(exercicio);
		        listaQuantidades.add(quantidade);
		    }
		    
		    Exercicios[] exercicios =
		            listaExercicios.toArray(new Exercicios[0]);

		    planoTreino.setExercicios(exercicios);

		    int[] quantidades =
		            new int[listaQuantidades.size()];

		    for(int i = 0; i < listaQuantidades.size(); i++) {
		        quantidades[i] = listaQuantidades.get(i);
		    }

		    planoTreino.setQuantidadeExercicios(quantidades);

		    return true;

		}
		catch (SQLException erro) {

			return false;

		}
	}

	private Exercicios criarExercicio(String nomeExercicio) {
	    switch(nomeExercicio) {
	        // Exercícios com repetição

	        case "LegPress45":
	            return new LegPress45();

	        case "SupinoRetoComBarra":
	            return new SupinoRetoComBarra();

	        case "ElevacaoLateral":
	            return new ElevacaoLateral();

	        case "SupinoRetoComHalter":
	            return new SupinoRetoComHalter();

	        case "DesenvolvimentoComHalter":
	            return new DesenvolvimentoComHalter();

	        case "RemadaCurvadaComHalter":
	            return new RemadaCurvadaComHalter();

	        case "PanturrilhaSentado":
	            return new PanturrilhaSentado();

	        case "SupinoInclinado":
	            return new SupinoInclinado();

	        case "TricepsNaPolia":
	            return new TricepsNaPolia();

	        case "RemadaSerrote":
	            return new RemadaSerrote();

	        case "MesaFlexora":
	            return new MesaFlexora();

	        case "PanturrilhaEmPe":
	            return new PanturrilhaEmPe();

	        case "TricepsTesta":
	            return new TricepsTesta();

	        case "AgachamentoLivre":
	            return new AgachamentoLivre();

	        case "TricepsComHalter":
	            return new TricepsComHalter();

	        case "BicepsRoscaNaPolia":
	            return new BicepsRoscaNaPolia();

	        case "BicepsRoscaComHalter":
	            return new BicepsRoscaComHalter();

	        case "ElevacaoFrontal":
	            return new ElevacaoFrontal();

	        case "ElevacaoPelvica":
	            return new ElevacaoPelvica();

	        case "Stiff":
	            return new Stiff();

	        case "AbdominalArticulado":
	            return new AbdominalArticulado();

	        case "Bulgaro":
	            return new Bulgaro();

	        case "AgachamentoNoHack":
	            return new AgachamentoNoHack();



	        // Exercícios com tempo

	        case "PranchaFrontal":
	            return new PranchaFrontal();

	        case "Bicicleta":
	            return new Bicicleta();

	        case "PularCorda":
	            return new PularCorda();

	        case "Escada":
	            return new Escada();

	        case "Esteira":
	            return new Esteira();

	        case "Eliptico":
	            return new Eliptico();

	        case "WallSit":
	            return new WallSit();



	        default:
	            return null;
	    }
	}
	
	@Override
	public String atualizar(TipoOperacaoBd operacao) {
		// TODO Auto-generated method stub
		msg = "Operação realizada com sucesso!";
        try {
            if (operacao == TipoOperacaoBd.INCLUSAO) {
            	
            	// Insere PlanoTreino
            	
                sql = "INSERT INTO PlanoTreino(matriculaAluno, cpfProfessor, dataDeCriacao)) VALUES (?,?,?)";
                statement = bd.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                statement.setInt(1, planoTreino.getAluno().getMatricula());
                statement.setString(2, planoTreino.getProfessorResponsavel().getCpf());
                statement.setDate(3, new java.sql.Date(planoTreino.getDataDeCriacao().getTime()));
                
                statement.executeUpdate();
                
                // Recupera o id gerado do planoTreino
                
                ResultSet chaveGerada = statement.getGeneratedKeys();

                chaveGerada.next();

                int idPlanoTreino = chaveGerada.getInt(1);
                
                // Insere na tabela ExerciciosPlanoTreino os exercicios e a quantidade

                Exercicios[] exercicios = planoTreino.getExercicios();

                int[] quantidades = planoTreino.getQuantidadeExercicios();

                for (int i = 0; i < exercicios.length; i++) {

                    sql = "INSERT INTO ExerciciosPlanoTreino (idPlanoTreino, nomeExercicio, quantidade) VALUES (?, ?, ?)";
                    statement = bd.connection.prepareStatement(sql);

                    statement.setInt(1, idPlanoTreino);
                    statement.setString(2, exercicios[i].getClass().getSimpleName());
                    statement.setInt(3,quantidades[i]);

                    statement.executeUpdate();
                }               
            }
            else if (operacao == TipoOperacaoBd.ALTERACAO) {
           
            	sql = "UPDATE PlanoTreino SET matriculaAluno=?, cpfProfessor=?, dataDeCriacao=? WHERE idPlanoTreino=?";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, planoTreino.getAluno().getMatricula());
                statement.setString(2, planoTreino.getProfessorResponsavel().getCpf());
                statement.setDate(3, new java.sql.Date(planoTreino.getDataDeCriacao().getTime()));
                statement.setInt(4, planoTreino.getIdPlanoTreino());

                statement.executeUpdate();

                // Remove todos os exercícios antigos

                sql = "DELETE FROM ExerciciosPlanoTreino WHERE idPlanoTreino=?";
                statement = bd.connection.prepareStatement(sql);

                statement.setInt(1, planoTreino.getIdPlanoTreino());

                statement.executeUpdate();

                // Insere os exercícios atuais

                Exercicios[] exercicios = planoTreino.getExercicios();

                int[] quantidades = planoTreino.getQuantidadeExercicios();

                for (int i = 0; i < exercicios.length; i++) {

                	sql = "INSERT INTO ExerciciosPlanoTreino(idPlanoTreino, nomeExercicio, quantidade) VALUES (?, ?, ?)";
                    statement =bd.connection.prepareStatement(sql);

                    statement.setInt(1, planoTreino.getIdPlanoTreino());
                    statement.setString(2, exercicios[i].getClass().getSimpleName());
                    statement.setInt(3,quantidades[i]);

                    statement.executeUpdate();
                }
            }
            else if (operacao == TipoOperacaoBd.EXCLUSAO) {

                sql = "DELETE FROM ExerciciosPlanoTreino WHERE idPlanoTreino=?";
                statement = bd.connection.prepareStatement(sql);
                
                statement.setInt(1, planoTreino.getIdPlanoTreino());
                
                statement.executeUpdate();


                sql = "DELETE FROM PlanoTreino WHERE idPlanoTreino=?";
                statement = bd.connection.prepareStatement(sql);
                
                statement.setInt(1, planoTreino.getIdPlanoTreino());
                
                statement.executeUpdate();
            }
             
        }
        catch (SQLException erro) {
            msg = "Falha na operação - " + erro.toString();
        }

        return msg;
    }
}        
