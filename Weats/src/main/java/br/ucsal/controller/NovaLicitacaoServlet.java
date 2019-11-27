package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.dao.ClienteDAO;
import br.ucsal.model.Licitacao;
import br.ucsal.model.Usuario;

/**
 * Servlet implementation class NovaLicitacao
 */
@WebServlet("/NovaLicitacao")
public class NovaLicitacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		String dataInicio = request.getParameter("data_inicio");
		String dataFinal = request.getParameter("data_final");
		String obs = request.getParameter("obs");

		Licitacao licitacao = new Licitacao();
		licitacao.setDescricao(descricao);
		licitacao.setObservacoes(obs);
		licitacao.setData_inicio(dataInicio);
		licitacao.setData_fim(dataFinal);
		Usuario cliente =  (Usuario) request.getSession().getAttribute("usuario");
		licitacao.setCliente(cliente);
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.novaLicitacao(licitacao);
		response.sendRedirect("./homeCliente.jsp");
	}
}
