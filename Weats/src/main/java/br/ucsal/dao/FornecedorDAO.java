package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Licitacao;
import br.ucsal.model.Orcamento;
import br.ucsal.model.Usuario;
import br.ucsal.util.BancoUtil;

public class FornecedorDAO {
	private Connection connection;

	public FornecedorDAO() {
		this.connection = BancoUtil.getConnection();
	}
	public void novoOrcamento(Orcamento orcamento) {
		String sql = "INSERT INTO ORCAMENTO (LICITACAO_ID, USUARIO_ID, DESCRICAO, VALOR, PRAZO) VALUES (?,?,?,?,?)";
		try {			
			java.util.Date prazo = new SimpleDateFormat("dd/MM/yyyy").parse(orcamento.getPrazo());
			java.sql.Date sqlPrazo = new java.sql.Date(prazo.getTime());
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orcamento.getLicitacao().getId());
			preparedStatement.setInt(2, orcamento.getFornecedor().getId());
			preparedStatement.setString(3, orcamento.getDescricao());
			preparedStatement.setDouble(4, orcamento.getValor());
			preparedStatement.setDate(5, sqlPrazo);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException | ParseException e ) {
			throw new RuntimeException(e);
		}
	}
	public List<Orcamento> getOrcamentos(int id) {
		List<Orcamento> orcamentos = new ArrayList<Orcamento>();
		try {
			String sql = "SELECT * FROM ORCAMENTO where usuario_id=" + id;
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
			String sql = "SELECT * FROM licitacao";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Licitacao retorno = new Licitacao();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setData_inicio(resultSet.getString("data_inicio"));
				retorno.setData_fim(resultSet.getString("data_fim"));
				retorno.setId(resultSet.getInt("LICITACAO_ID"));
				retorno.setCliente(getClienteById(resultSet.getInt("USUARIO_ID")));
				licitacoes.add(retorno);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 

		return licitacoes;
	}
	
	public Usuario getClienteById(int id) {
		Usuario retorno = null;

		try {
			String sql = "SELECT * FROM usuario where USUARIO_ID=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				retorno = new Usuario();
				retorno.setLogin(resultSet.getString("login"));
				retorno.setSenha(resultSet.getString("senha"));
				retorno.setPapel(resultSet.getInt("papel"));
				retorno.setId(resultSet.getInt("usuario_id"));
				retorno.setCnpj(resultSet.getString("cnpj"));
				retorno.setEndereco(resultSet.getString("endereco"));

			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}
	
	public Licitacao getLicitacao(int id) {
		Licitacao licitacao = null;
		try {
			String sql = "SELECT * FROM licitacao where LICITACAO_ID=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				licitacao = new Licitacao();
				licitacao.setDescricao(resultSet.getString("descricao"));
				licitacao.setData_inicio(resultSet.getString("data_inicio"));
				licitacao.setData_fim(resultSet.getString("data_fim"));
				licitacao.setId(resultSet.getInt("LICITACAO_ID"));
				licitacao.setCliente(getClienteById(resultSet.getInt("USUARIO_ID")));
				
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 

		return licitacao;
	}



}
