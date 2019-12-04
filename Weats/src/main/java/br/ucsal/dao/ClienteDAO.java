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

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		this.connection = BancoUtil.getConnection();
	}

	public List<Licitacao> getLicitacoes(int id) {
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		try {
			String sql = "SELECT * FROM licitacao where usuario_id=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Licitacao retorno = new Licitacao();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setData_inicio(resultSet.getString("data_inicial"));
				retorno.setData_fim(resultSet.getString("data_final"));
				retorno.setId(resultSet.getInt("licitacao_id"));
				licitacoes.add(retorno);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return licitacoes;
	}

	public void novaLicitacao(Licitacao licitacao) {
		String sql = "INSERT INTO LICITACAO (DESCRICAO,OBSERVACOES,DATA_INICIAL,DATA_FINAL,USUARIO_ID) VALUES (?,?,?,?,?)";
		try {
			java.util.Date DataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(licitacao.getData_inicio());
			java.sql.Date sqlDataInicio = new java.sql.Date(DataInicio.getTime());
			java.util.Date DataFinal = new SimpleDateFormat("dd/MM/yyyy").parse(licitacao.getData_fim());
			java.sql.Date sqlDataFinal = new java.sql.Date(DataFinal.getTime());
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, licitacao.getDescricao());
			preparedStatement.setString(2, licitacao.getObservacoes());
			preparedStatement.setDate(3, sqlDataInicio);
			preparedStatement.setDate(4, sqlDataFinal);
			preparedStatement.setInt(5, licitacao.getCliente().getId());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
				licitacao.setData_inicio(resultSet.getString("data_inicial"));
				licitacao.setData_fim(resultSet.getString("data_final"));
				licitacao.setId(resultSet.getInt("LICITACAO_ID"));

			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return licitacao;
	}

	public List<Orcamento> getOrcamentos(int id) {
		List<Orcamento> orcamentos = new ArrayList<Orcamento>();
		try {
			String sql = "SELECT * FROM orcamento where licitacao_id=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Orcamento retorno = new Orcamento();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setValor(resultSet.getInt("valor"));
				retorno.setPrazo(resultSet.getString("prazo"));
				retorno.setFornecedor(getClienteById(resultSet.getInt("USUARIO_ID")));
				orcamentos.add(retorno);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return orcamentos;
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

	public void excluirLicitacao(int id) {
		String sql = "DELETE FROM LICITACAO WHERE LICITACAO.LICITACAO_ID =" + id;
		excluirOrcamento(id);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void excluirOrcamento(int id) {
		String sql = "DELETE FROM ORCAMENTO USING LICITACAO WHERE ORCAMENTO.LICITACAO_ID = LICITACAO.LICTACAO ID "
				+ "AND LICITACAO.LICITACAO_ID ="
				+ id;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
