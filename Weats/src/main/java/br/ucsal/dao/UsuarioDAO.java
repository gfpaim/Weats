package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucsal.model.Usuario;
import br.ucsal.util.BancoUtil;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		this.connection = BancoUtil.getConnection();
	}

	public Usuario autenticar(Usuario usuario) {
		Usuario retorno = null;

		try {
			String sql = "SELECT login,senha FROM usuarios where login=? and senha=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				retorno = new Usuario();
				retorno.setLogin(resultSet.getString("login"));
				retorno.setSenha(resultSet.getString("senha"));

			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}

}