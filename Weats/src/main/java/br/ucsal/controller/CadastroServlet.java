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
import br.ucsal.dao.FornecedorDAO;
import br.ucsal.dao.UsuarioDAO;
import br.ucsal.model.Licitacao;
import br.ucsal.model.Orcamento;
import br.ucsal.model.Usuario;

@WebServlet("/Cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		String endereco = request.getParameter("endereco");
		int papel = Integer.parseInt(request.getParameter("papel"));

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setCnpj(cnpj);
		usuario.setEndereco(endereco);
		usuario.setPapel(papel);

		UsuarioDAO dao = new UsuarioDAO();
		Usuario aut = dao.autenticar(usuario);
		if (aut != null) {
			request.getSession().setAttribute("erroC", "Nome de usuario já existe!");
			request.getRequestDispatcher("./cadastro.jsp").forward(request, response);
			;
		} else {
			dao.cadastrarUsuario(usuario);
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("./Home");
		}
	}

}
