package br.ucsal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.dao.FornecedorDAO;
import br.ucsal.model.Fornecedor;
import br.ucsal.model.Licitacao;
import br.ucsal.model.Orcamento;
import br.ucsal.model.Usuario;

/**
 * Servlet implementation class NovoOrcamentoServlet
 */
@WebServlet("/NovoOrcamento")
public class NovoOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Licitacao licitacao = fornecedorDAO.getLicitacao(Integer.parseInt(sid));
		
		Usuario fornecedor = (Usuario) request.getSession().getAttribute("usuario");
		
		request.getSession().setAttribute("usuario", fornecedor);
		request.setAttribute("licitacao", licitacao);
		request.getRequestDispatcher("novoOrcamento.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Slicitacao_id = request.getParameter("licitacao_id");
		String descricao = request.getParameter("descricao");
		String valor = request.getParameter("valor");
		String prazo = request.getParameter("prazo");
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		Orcamento orcamento = new Orcamento();
		orcamento.setLicitacao(fornecedorDAO.getLicitacao(Integer.parseInt(Slicitacao_id)));
		orcamento.setDescricao(descricao);
		orcamento.setValor(Double.parseDouble(valor));
		orcamento.setPrazo(prazo);
		
		Usuario fornecedor = (Usuario) request.getSession().getAttribute("usuario");
		orcamento.setFornecedor(fornecedor);
		
		
		fornecedorDAO.novoOrcamento(orcamento);
		
		List<Licitacao> licitacoes = new ArrayList<Licitacao>();
		licitacoes = fornecedorDAO.getLicitacoes();
		
		request.getSession().setAttribute("licitacoes", licitacoes);
		request.getSession().setAttribute("usuario", fornecedor);
		request.getRequestDispatcher("homeFornecedor.jsp").forward(request, response);
		
	}

}
