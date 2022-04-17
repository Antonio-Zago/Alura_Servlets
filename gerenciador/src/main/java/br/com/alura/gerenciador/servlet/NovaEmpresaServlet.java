package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
			
		String nomeEmpresa = request.getParameter("nome");//Recebe o parametro da URL
		Empresa empresa = new Empresa();
		
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		
		//Criando objeto para dispachar para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada3.jsp");
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response);
		

	}

}
