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
			String sql = "SELECT login,senha,papel FROM usuarios where login=? and senha=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				retorno = new Usuario();
				retorno.setLogin(resultSet.getString("login"));
				retorno.setSenha(resultSet.getString("senha"));
				retorno.setPapel(resultSet.getInt("papel"));

			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		String sql = "INSERT INTO USUARIOS (LOGIN,SENHA,PAPEL,CNPJ,ENDERECO) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setInt(3, usuario.getPapel());
			preparedStatement.setString(4, usuario.getCnpj());
			preparedStatement.setString(5, usuario.getEndereco());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e ) {
			throw new RuntimeException(e);
		}
	}
	public Usuario getUsuarioById(int id) {
		Usuario retorno = null;

		try {
			String sql = "SELECT USUARIO_ID FROM usuarios where USUARIO_ID =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				retorno = new Usuario();
				retorno.setLogin(resultSet.getString("login"));
				retorno.setSenha(resultSet.getString("senha"));
				retorno.setId(resultSet.getInt("USUARIO_ID"));
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}

}
