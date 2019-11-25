package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Licitacao;
import br.ucsal.util.BancoUtil;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		this.connection = BancoUtil.getConnection();
	}

	public List<Licitacao> getLicitacoes(int id) {
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		try {
			String sql = "SELECT descricao,data_inicial,data_final FROM licitacoes where usuario_id=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Licitacao retorno = new Licitacao();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setData_inicio(resultSet.getString("datainicial"));
				retorno.setData_fim(resultSet.getString("datafinal"));
				
				licitacoes.add(retorno);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return licitacoes;
	}

	public void novaLicitacao(int id) {

	}

}
