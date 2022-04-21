package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static{
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		
		empresa1.setId(chaveSequencial++);
		empresa2.setId(chaveSequencial++);
		
		empresa1.setNome("Alura");
		empresa2.setNome("GM");
		
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
	public Empresa getEmpresa(Integer id) {
		
		for(Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
		
	}
	
	public void editar(Integer id, String nome, Date data) {
		
		for(Empresa empresa : lista) {
			if(empresa.getId() == id) {
				empresa.setNome(nome);
				empresa.setDataAbertura(data);
			}
		}
		
		
	}

	public void remove(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		
//		for(Empresa empresa : lista) {
//			if(empresa.getId() == id) {
//				lista.remove(empresa);
//			}
//		}
		
	}
	

}
