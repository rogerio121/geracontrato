package br.com.geracontrato.controller;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroController
 */
@WebFilter("/*")
public class FiltroController implements Filter {

    public FiltroController() {
        // TODO Auto-generated constructor stub
}

public void destroy() {
	// TODO Auto-generated method stub
}

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	String url = httpServletRequest.getRequestURI();
	
	HttpSession sessao = httpServletRequest.getSession();
	if(sessao.getAttribute("usuarioLogado") != null || url.lastIndexOf("login") >-1 || url.lastIndexOf("LoginController") >-1) {
	chain.doFilter(request, response);	
}else {
	((HttpServletResponse) response).sendRedirect("");
	}
	
}

public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
	}

}
