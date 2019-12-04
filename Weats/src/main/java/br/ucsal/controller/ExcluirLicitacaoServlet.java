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
import br.ucsal.model.Licitacao;
import br.ucsal.model.Usuario;

/**
 * Servlet implementation class ExcluirLicitacaoServlet
 */
@WebServlet("/ExcluirLicitacao")
public class ExcluirLicitacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluirLicitacao(Integer.parseInt(sId));

		Usuario usuario = new Usuario();
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		licitacoes = clienteDAO.getLicitacoes(usuario.getId());
		request.setAttribute("licitacoes", licitacoes);

		response.sendRedirect("Home");
	}
}
