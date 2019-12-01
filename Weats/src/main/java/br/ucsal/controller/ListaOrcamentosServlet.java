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
import br.ucsal.model.Orcamento;
import br.ucsal.model.Usuario;

/**
 * Servlet implementation class ListaOrcamentosServlet
 */
@WebServlet("/ListaOrcamentos")
public class ListaOrcamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		ClienteDAO clienteDAO = new ClienteDAO();
		Licitacao licitacao = clienteDAO.getLicitacao(Integer.parseInt(sid));
		List<Orcamento> orcamentos = new ArrayList<Orcamento>();
		orcamentos = clienteDAO.getOrcamentos(Integer.parseInt(sid));
		
		Usuario cliente = (Usuario) request.getSession().getAttribute("usuario");
		
		request.setAttribute("orcamentos", orcamentos);
		request.getSession().setAttribute("usuario", cliente);
		request.setAttribute("licitacao", licitacao);
		request.getRequestDispatcher("listaOrcamentos.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
