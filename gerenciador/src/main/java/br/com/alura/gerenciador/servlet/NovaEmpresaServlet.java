package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
			
		String nomeEmpresa = request.getParameter("nome");//Recebe o parametro da URL
		String data = request.getParameter("data");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		
		empresa.setDataAbertura(dataAbertura);
		
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//Redirecionamento pelo navegador
		// *Boa pratica, pois se fa�o o redirecionamento com o Servlet
		// *como abaixo, se atualizo a pagina ele faz inumeras inser��es, 
		// *no banco de dados, pois est� chamando o Servlet novaEmpresa.
		// *Chamando dessa forma, ele redireciona pelo navegador
		response.sendRedirect("listaEmpresas");
		
		
//		//Criando objeto para dispachar para o JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //Chamando outro servlet
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		

	}

}
