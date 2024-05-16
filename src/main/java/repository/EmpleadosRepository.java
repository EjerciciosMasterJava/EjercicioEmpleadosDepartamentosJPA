package repository;

import java.util.ArrayList;
import java.util.List;

import com.curso.dominio.Departamento;
import com.curso.dominio.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EmpleadosRepository {

private List<Empleado> empleados = new ArrayList<Empleado>();
	
	private EntityManager em;
	
	public EmpleadosRepository(EntityManager em) {
		this.em = em;
	}

	public List<Empleado> getEmpleados() {
		this.empleados = getAllEmpleados();
		return this.empleados;
	}
	
	public List<Empleado> getAllEmpleados() {
		TypedQuery<Empleado> consulta = this.em.createNamedQuery("empleado.getAllEmpleados", Empleado.class);
		
		List<Empleado> empleados = consulta.getResultList();
		
		return empleados;
	}
	

	public Empleado getEmpleadoMenosTiempo(Empleado uno, Empleado dos) {
		if(uno.getFecha().after(dos.getFecha())) {
			return uno;
		}else {
			return dos;
		}
	}
	
	/*
	public Empleado getEmpleadoMenosTiempoEnEmpresa(){
		TypedQuery<Empleado> queryLibro = this.em.createNamedQuery("empleado.llevaMenosTiempo", Empleado.class);
		Empleado libros = queryLibro.getSingleResult();
		return libros;
	}
	*/
	
	public List<Empleado> getEmpleadosDepartamentoConcreto(Departamento departamento) {
		TypedQuery<Empleado> consulta = this.em.createNamedQuery("empleado.getEmpleadosDepartamentoConcreto", Empleado.class);
		
		consulta.setParameter("departamento", departamento);
		
		List<Empleado> empleados = consulta.getResultList();
		
		return empleados;
	}
	
	public List<Empleado> getEmpleadosGananMenosDelPromedio() {
		TypedQuery<Empleado> consulta = this.em.createNamedQuery("empleado.getEmpleadosGananMenosDelPromedio", Empleado.class);

		List<Empleado> empleados = consulta.getResultList();
		
		return empleados;
	}
	

}
