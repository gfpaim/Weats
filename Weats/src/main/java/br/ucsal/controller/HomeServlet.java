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
import br.ucsal.model.Licitacao;
import br.ucsal.model.Orcamento;
import br.ucsal.model.Usuario;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		if (usuario.getPapel() == 0) { // Cliente
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Licitacao> licitacoes = new ArrayList<Licitacao>();
			licitacoes = clienteDAO.getLicitacoes(usuario.getId());

			request.setAttribute("licitacoes", licitacoes);
			request.getRequestDispatcher("homeCliente.jsp").forward(request, response);
		} else { // Fornecedor
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			List<Licitacao> licitacoes = new ArrayList<Licitacao>();
			licitacoes = fornecedorDAO.getLicitacoes();
			List<Orcamento> orcamentos = new ArrayList<Orcamento>();
			orcamentos = fornecedorDAO.getOrcamentos(usuario.getId());
			request.setAttribute("licitacoes", licitacoes);
			request.setAttribute("orcamentos", orcamentos);
			request.getRequestDispatcher("homeFornecedor.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
