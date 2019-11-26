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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeCliente")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();

		licitacoes = dao.getLicitacoes(0);

		request.setAttribute("licitacoes", licitacoes);
		request.getRequestDispatcher("./homeCliente.jsp").forward(request, response);
	}

}
