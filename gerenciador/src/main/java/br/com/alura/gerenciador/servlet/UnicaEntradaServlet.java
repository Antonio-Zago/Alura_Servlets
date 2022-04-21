package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresas;
import br.com.alura.gerenciador.acao.NovaEmpresas;
import br.com.alura.gerenciador.acao.NovaEmpresasForm;
import br.com.alura.gerenciador.acao.RemoverEmpresas;
import br.com.alura.gerenciador.acao.UpdateEmpresas;



@WebServlet("/UnicaEntradaServlet")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("RemoverEmpresas")) {
//			RemoverEmpresas acao = new RemoverEmpresas();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("MostraEmpresas")) {
//			MostraEmpresas acao = new MostraEmpresas();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("UpdateEmpresas")) {
//			UpdateEmpresas acao = new UpdateEmpresas();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("NovaEmpresas")) {
//			NovaEmpresas acao = new NovaEmpresas();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("NovaEmpresasForm")) {
//			NovaEmpresasForm acao = new NovaEmpresasForm();
//			nome = acao.executa(request, response);
//		}
		
		
		
		
		String[] tipoEndereco = nome.split(":");
		
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]); 
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
		
		
		
	}

}
