package com.omar.controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.omar.dao.CiudadDAO;
import com.omar.dao.DepartamentoDAO;
import com.omar.modelo.Ciudad;
import com.omar.modelo.Departamento;

@ManagedBean(name = "depaBean")
@RequestScoped
public class DepartamentoBean {
	public List<Departamento> obtenerDepartamento() {
		DepartamentoDAO depaDAO = new DepartamentoDAO();

		/*
		 * List<Departamento> listaDepa = new ArrayList<>(); Departamento d1 = new
		 * Departamento(); d1.setId_departamento(1); d1.setDepartamento_codigo(2);
		 * d1.setDepartamento_nombre("Largo");
		 * 
		 * 
		 * Departamento d2 = new Departamento(); d2.setId_departamento(2);
		 * d2.setDepartamento_codigo(3); d2.setDepartamento_nombre("Largo12");
		 * 
		 * listaDepa.add(d1); listaDepa.add(d2);
		 * 
		 * return listaDepa;
		 */

		return depaDAO.obtenerDepartamento();
	}

	public String editar(int id_departamento) {
		DepartamentoDAO depaDAO = new DepartamentoDAO();
		Departamento d = new Departamento();
		d = depaDAO.buscar(id_departamento);
		System.out.println("******************************************");
		System.out.println(d);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("depa", d);
		return "/faces/departamento/editardepartamento.xhtml";
	}

	public String actualizar(Departamento departamento) {
		DepartamentoDAO depaDAO = new DepartamentoDAO();
		depaDAO.editar(departamento);
		return "/faces/departamento/departamento.xhtml";
	}

	public String eliminar(int id_departamento) {
		DepartamentoDAO depaDAO = new DepartamentoDAO();
		depaDAO.eliminar(id_departamento);
		System.out.println("Departamento Eliminado");
		return "/faces/departamento/departamento.xhtml";
	}

	public String insertar() {
		Departamento d = new Departamento();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("depa", d);
		return "/faces/departamento/depainsert.xhtml";
	}

	public String añadir(Departamento departamento) {
		DepartamentoDAO depaDAO = new DepartamentoDAO();
		depaDAO.guardar(departamento);
		return "/faces/departamento/departamento.xhtml";
	}
}
