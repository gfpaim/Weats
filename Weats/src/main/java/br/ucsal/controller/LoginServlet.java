package br.ucsal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.dao.ClienteDAO;
import br.ucsal.dao.UsuarioDAO;
import br.ucsal.model.Licitacao;
import br.ucsal.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		UsuarioDAO dao = new UsuarioDAO();

		usuario = dao.autenticar(usuario);

		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			if (usuario.getPapel() == 0) { // Cliente
				ClienteDAO clienteDAO = new ClienteDAO();
				List<Licitacao> licitacoes = new ArrayList<Licitacao>();
				licitacoes = clienteDAO.getLicitacoes(usuario.getId());

				request.getSession().setAttribute("licitacoes", licitacoes);
				request.getRequestDispatcher("homeCliente.jsp").forward(request, response);
			} else { // Fornecedor
				request.getRequestDispatcher("homeFornecedor.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erro", "login ou senha inválidos!");
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
	}

}
