package repository;

import java.util.ArrayList;
import java.util.List;

import com.curso.dominio.Departamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DepartamentoRepository {
	
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	
	private EntityManager em;
	
	public DepartamentoRepository(EntityManager em) {
		this.em = em;
	}

	public List<Departamento> getDepartamentos() {
		this.departamentos = getAllDepartamentos();
		return this.departamentos;
	}
	
	public List<String> getNombresDepartamentos() {
		TypedQuery<String> consulta = this.em.createNamedQuery("departamento.getNombresDepartamentos", String.class);
		
		List<String> departamentos = consulta.getResultList();
		
		return departamentos;
	}
	
	public List<Departamento> getAllDepartamentos() {
		TypedQuery<Departamento> consulta = this.em.createNamedQuery("departamento.getAllDepartamentos", Departamento.class);
		
		List<Departamento> departamentos = consulta.getResultList();
		
		return departamentos;
	}

	/*
	public List<Departamento> getDepartamentosConMenosDeNEmpleados(int cantidad) {
		TypedQuery<Departamento> consulta = this.em.createNamedQuery("departamento.getDepartamentosConMenosDeNEmpleados", Departamento.class);
		consulta.setParameter("cantidad", cantidad);
		
		List<Departamento> departamentos = consulta.getResultList();
		
		return departamentos;
	}
	*/
}
