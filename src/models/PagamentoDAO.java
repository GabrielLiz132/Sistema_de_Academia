package models;

import java.sql.*;

public class PagamentoDAO implements OperacaoBD {
	 
    private BD bd;
    private Pagamento pagamento;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String sql, msg;
    
    public PagamentoDAO() {
    }
 
    public void setBD(BD bd) {
        this.bd = bd;
    }
 
    public Pagamento getPagamento() {
        return pagamento;
    }
 
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

	@Override
	public boolean localizar() {
	    if (pagamento == null) return false;
	    if (!bd.connect()) return false;	
	    try {
	    	String sql = "SELECT * FROM pagamento WHERE id_pagamento = ?";
			    	    
			statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, pagamento.getId());
            resultSet = statement.executeQuery();
            
            resultSet.next();
            
            pagamento.setId( resultSet.getInt(1) );
            pagamento.setValor( resultSet.getFloat(2) );
            
            sql = "SELECT * FROM formaPagamento WHERE id_pagamento = ?";
            
            statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, pagamento.getId());
            resultSet = statement.executeQuery();

            int count = 0;

            while (resultSet.next()) count++;
            
            resultSet = statement.executeQuery();
            
            FormaPagamento[] formas = new FormaPagamento[count];
            
            int i = 0;
            while (resultSet.next()) {
                String tipo = resultSet.getString("tipo");
 
                if (tipo.equals("DINHEIRO")) {
                    formas[i] = new Dinheiro();
 
                } else if (tipo.equals("PIX")) {
                    Pix pix = new Pix();
                    pix.setChave(resultSet.getString("chave_pix"));
                    pix.setTipo(TipoChave.valueOf(resultSet.getString("tipo_chave")));
                    formas[i] = pix;
 
                } else if (tipo.equals("CARTAO_CREDITO")) {
                    CartaoCredito cc = new CartaoCredito();
                    cc.setBandeira(BandeiraCartao.valueOf(resultSet.getString("bandeira")));
                    cc.setQuantidadeParcela(resultSet.getByte("parcelas"));
                    formas[i] = cc;
 
                } else if (tipo.equals("CARTAO_DEBITO")) {
                    CartaoDebito cd = new CartaoDebito();
                    cd.setBandeira(BandeiraCartao.valueOf(resultSet.getString("bandeira")));
                    formas[i] = cd;
                }
                i++;
            }
 
            pagamento.setFormaPagamento(formas);
            bd.close();
            return true;
 
        } catch (SQLException erro) {
            System.out.println("Erro ao localizar pagamento: " + erro.toString());
            bd.close();
            return false;
        }
	}

	@Override
	public String atualizar(TipoOperacaoBd operacao) {
        if (pagamento == null) return "Pagamento nulo!";
        if (!bd.connect()) return "Falha ao conectar!";
 
        msg = "Operacao realizada com sucesso!";
 
        try {
            if (operacao == TipoOperacaoBd.INCLUSAO) {
 
                sql = "INSERT INTO pagamento(valor) VALUES (?)";
                statement = bd.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setFloat(1, pagamento.getValor());
                statement.executeUpdate();
 
                resultSet = statement.getGeneratedKeys();
                if (!resultSet.next()) {
                    bd.close();
                    return "Falha ao obter id do pagamento!";
                }
                int idGerado = resultSet.getInt(1);
                pagamento.setId(idGerado);
 
                inserirFormasPagamento(idGerado);
 
            } else if (operacao == TipoOperacaoBd.ALTERACAO) {
 
                sql = "UPDATE pagamento SET valor = ? WHERE id_pagamento = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setFloat(1, pagamento.getValor());
                statement.setInt(2, pagamento.getId());
                statement.executeUpdate();
 
                sql = "DELETE FROM formaPagamento WHERE id_pagamento = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setInt(1, pagamento.getId());
                statement.executeUpdate();
 
                inserirFormasPagamento(pagamento.getId());
 
            } else if (operacao == TipoOperacaoBd.EXCLUSAO) {
 
                sql = "DELETE FROM formaPagamento WHERE id_pagamento = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setInt(1, pagamento.getId());
                statement.executeUpdate();
 
                sql = "DELETE FROM pagamento WHERE id_pagamento = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setInt(1, pagamento.getId());
 
                if (statement.executeUpdate() == 0) {
                    msg = "Falha na operacao!";
                }
            }
 
        } catch (SQLException erro) {
            msg = "Falha na operacao - " + erro.toString();
        }
 
        bd.close();
        return msg;
    }
 
    private void inserirFormasPagamento(int idPagamento) throws SQLException {
        if (pagamento.getFormaPagamento() == null) return;
 
        for (FormaPagamento fp : pagamento.getFormaPagamento()) {
            if (fp instanceof Dinheiro) {
                sql = "INSERT INTO formaPagamento(tipo, id_pagamento) VALUES ('DINHEIRO', ?)";
                statement = bd.connection.prepareStatement(sql);
                statement.setInt(1, idPagamento);
 
            } else if (fp instanceof Pix) {
                Pix pix = (Pix) fp;
                sql = "INSERT INTO formaPagamento(tipo, chave_pix, tipo_chave, id_pagamento) VALUES ('PIX', ?, ?, ?)";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, pix.getChave());
                statement.setString(2, pix.getTipo().name());
                statement.setInt(3, idPagamento);
 
            } else if (fp instanceof CartaoCredito) {
                CartaoCredito cc = (CartaoCredito) fp;
                sql = "INSERT INTO formaPagamento(tipo, bandeira, parcelas, id_pagamento) VALUES ('CARTAO_CREDITO', ?, ?, ?)";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, cc.getBandeira().name());
                statement.setByte(2, cc.getQuantidadeParcela());
                statement.setInt(3, idPagamento);
 
            } else if (fp instanceof CartaoDebito) {
                CartaoDebito cd = (CartaoDebito) fp;
                sql = "INSERT INTO formaPagamento(tipo, bandeira, id_pagamento) VALUES ('CARTAO_DEBITO', ?, ?)";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, cd.getBandeira().name());
                statement.setInt(2, idPagamento);
            }
 
            statement.executeUpdate();
        }
    }
}