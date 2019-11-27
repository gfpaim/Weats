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
import br.ucsal.util.BancoUtil;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		this.connection = BancoUtil.getConnection();
	}

	public List<Licitacao> getLicitacoes(int id) {
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		try {
			String sql = "SELECT descricao,data_inicial,data_final FROM licitacao where usuario_id=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Licitacao retorno = new Licitacao();
				retorno.setDescricao(resultSet.getString("descricao"));
				retorno.setData_inicio(resultSet.getString("data_inicial"));
				retorno.setData_fim(resultSet.getString("data_final"));
				
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
			preparedStatement.setDate(3,sqlDataInicio);
			preparedStatement.setDate(4, sqlDataFinal);
			preparedStatement.setInt(5, licitacao.getCliente().getId());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e ) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
