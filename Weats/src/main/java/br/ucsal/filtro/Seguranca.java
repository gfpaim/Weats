package br.ucsal.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.model.Usuario;

/**
 * Servlet Filter implementation class Seguranca
 */
@WebFilter("/Seguranca")
public class Seguranca implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute("usuario");
		if (usuario != null) {
			if (usuario.getPapel() == 0 || (httpServletRequest.getRequestURI().endsWith("homeCliente.jsp")
					|| httpServletRequest.getRequestURI().endsWith("Login")
					|| httpServletRequest.getRequestURI().endsWith("novaLicitacao.jsp")
					|| httpServletRequest.getRequestURI().endsWith("NovaLicitacao")
					|| httpServletRequest.getRequestURI().endsWith("ListaOrcamentos")
					|| httpServletRequest.getRequestURI().endsWith("NovaLicitacao"))) { // Cliente
				chain.doFilter(request, response);
			} else if (usuario.getPapel() == 1 || httpServletRequest.getRequestURI().endsWith("homeFornecedor.jsp")
					|| httpServletRequest.getRequestURI().endsWith("Login")
					|| httpServletRequest.getRequestURI().endsWith("novoOrcamento.jsp")
					|| httpServletRequest.getRequestURI().endsWith("NovoOrcamento")) {
				chain.doFilter(request, response);
			}
		} else {

			if (httpServletRequest.getRequestURI().endsWith("index.jsp")
					|| httpServletRequest.getRequestURI().endsWith("Login")
					|| httpServletRequest.getRequestURI().endsWith("cadastro.jsp")
					|| httpServletRequest.getRequestURI().endsWith("Cadastro")) {
				chain.doFilter(request, response);

			} else {

				httpServletResponse.sendRedirect("./index.jsp");
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
