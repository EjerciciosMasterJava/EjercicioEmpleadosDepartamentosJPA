package com.curso.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
@NamedQueries({
	//@NamedQuery(name="departamento.getNombresDepartamentos", query="SELECT DISTINCT d.nombre FROM Departamento d"),
	@NamedQuery(name="departamento.getAllDepartamentos", query="SELECT d FROM Departamento d"),
	//@NamedQuery(name="departamento.getDepartamentosConMenosDeNEmpleados", query="SELECT d FROM Departamento d JOIN Empleado e ON e.departamento.idDept = d.idDept WHERE COUNT(e.nombre) <= :cantidad"),
})
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_dept")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDept;
	
	private String nombre;
	
	private String localidad;
	
	@OneToMany
	private List<Empleado> empleados = new ArrayList<Empleado>();

	public Departamento() {
		super();
	}

	public Departamento(Integer idDept, String nombre, String localidad) {
		super();
		this.idDept = idDept;
		this.nombre = nombre;
		this.localidad = localidad;
	}


	public Departamento(Integer idDept, String nombre, String localidad, List<Empleado> empleados) {
		super();
		this.idDept = idDept;
		this.nombre = nombre;
		this.localidad = localidad;
		this.empleados = empleados;
	}

	public Integer getIdDept() {
		return idDept;
	}

	public void setIdDept(Integer idDept) {
		this.idDept = idDept;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDept == null) ? 0 : idDept.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (idDept == null) {
			if (other.idDept != null)
				return false;
		} else if (!idDept.equals(other.idDept))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [idDept=" + idDept + ", nombre=" + nombre + ", localidad=" + localidad + ", empleados="
				+ empleados + "]";
	}


	
}
