package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoverEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id= Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		banco.remove(id);
		
		System.out.println("Removendo Empresa");
		
		return "redirect:UnicaEntradaServlet?acao=ListaEmpresas";
		
	
	}


	
}
