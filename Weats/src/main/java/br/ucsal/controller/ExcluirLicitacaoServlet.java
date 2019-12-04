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

/**
 * Servlet implementation class ExcluirLicitacaoServlet
 */
@WebServlet("/ExcluirLicitacao")
public class ExcluirLicitacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClienteDAO clienteDAO = new ClienteDAO();
		String sId = request.getParameter("id");
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		licitacoes = (List<Licitacao>) request.getSession().getAttribute("licitacoes");
		licitacoes.remove(Integer.parseInt(sId));
		request.getSession().setAttribute("licitacoes", licitacoes);
		clienteDAO.ExcluirLicitacao(Integer.parseInt(sId));
		response.sendRedirect("./homeCliente.jsp");
	}
}
