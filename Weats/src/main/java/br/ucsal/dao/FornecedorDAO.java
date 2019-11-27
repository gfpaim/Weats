package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Licitacao;
import br.ucsal.model.Orcamento;
import br.ucsal.util.BancoUtil;

public class FornecedorDAO {
	private Connection connection;

	public FornecedorDAO() {
		this.connection = BancoUtil.getConnection();
	}
	public void novoOrcamento(Orcamento orcamento) {
		String sql = "INSERT INTO ORCAMENTO (LICITACAO_ID, USUARIO_ID, DESCRICAO, VALOR, PRAZO) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orcamento.getLicitacao().getId());
			preparedStatement.setInt(2, orcamento.getFornecedor().getId());
			preparedStatement.setString(3, orcamento.getDescricao());
			preparedStatement.setDouble(4, orcamento.getValor());
			preparedStatement.setString(5, orcamento.getPrazo());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e ) {
			throw new RuntimeException(e);
		}
	}
	public List<Orcamento> getOrcamentos(int id) {
		List<Orcamento> orcamentos = new ArrayList<Orcamento>();
		try {
			String sql = "SELECT DESCRICAO, VALOR, PRAZO FROM ORCAMENTO where usuario_id=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Orcamento retorno = new Orcamento();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setValor(resultSet.getDouble("valor"));
				retorno.setPrazo(resultSet.getString("prazo"));
				retorno.setId(resultSet.getInt("orcamento_id"));
				orcamentos.add(retorno);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 

		return orcamentos;
	}
	public List<Licitacao> getLicitacoes() {
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		try {
			String sql = "SELECT descricao,data_inicial,data_final FROM licitacao";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Licitacao retorno = new Licitacao();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setData_inicio(resultSet.getString("data_inicial"));
				retorno.setData_fim(resultSet.getString("data_final"));
				retorno.setId(resultSet.getInt("LICITACAO_ID"));
				licitacoes.add(retorno);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 

		return licitacoes;
	}



}
