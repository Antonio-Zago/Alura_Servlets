package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		// *Boa pratica, pois se faço o redirecionamento com o Servlet
		// *como abaixo, se atualizo a pagina ele faz inumeras inserções, 
		// *no banco de dados, pois está chamando o Servlet novaEmpresa.
		// *Chamando dessa forma, ele redireciona pelo navegador

		
		return "redirect:UnicaEntradaServlet?acao=ListaEmpresas";
		
		
//		//Criando objeto para dispachar para o JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //Chamando outro servlet
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
	}

}
