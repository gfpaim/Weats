package br.ucsal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.dao.ClienteDAO;
import br.ucsal.model.Cliente;

/**
 * Servlet implementation class CadastroClienteServlet
 */
@WebServlet("/CadastroCliente")
public class CadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cnpj = request.getParameter("cnpj");
		String cpf = request.getParameter("cpf");
		
		Cliente cliente = new Cliente();
		cliente.setCnpj(cnpj);
		cliente.setCpf(cpf);
		
		ClienteDAO dao = new ClienteDAO();
		dao.cadastrarCliente(cliente);
		
		request.getSession().setAttribute("cliente", cliente);
		response.sendRedirect("./homeCliente.jsp");
	}

}
