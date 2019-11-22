package br.ucsal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.dao.UsuarioDAO;
import br.ucsal.model.Usuario;

@WebServlet("/Cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDAO dao = new UsuarioDAO();
		dao.cadastrarUsuario(usuario);

		request.getSession().setAttribute("usuario", usuario);
		response.sendRedirect("./cadastro2.jsp");

	}

}
