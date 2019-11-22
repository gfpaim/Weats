package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ucsal.model.Cliente;
import br.ucsal.util.BancoUtil;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
		this.connection = BancoUtil.getConnection();
	}
	
	public void cadastrarCliente(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE (USUARIO_ID,CNPJ,CPF) VALUES (0,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getCnpj());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e ) {
			throw new RuntimeException(e);
		}
	}

}
