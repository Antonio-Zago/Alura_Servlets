package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdadeEmpresasServlet")
public class UpdadeEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		banco.editar(id, nome, dataAbertura);
		
		response.sendRedirect("listaEmpresas");
		
	}

}
