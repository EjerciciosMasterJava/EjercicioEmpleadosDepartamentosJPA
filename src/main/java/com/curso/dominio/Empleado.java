package com.curso.dominio;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "empleado")
@NamedQueries({
	//@NamedQuery(name="empleado.llevaMenosTiempo", query="SELECT e FROM Empleado e WHERE e.fecha <= (SELECT MAX(e.fecha) FROM Empleado e"),
	@NamedQuery(name="empleado.getAllEmpleados", query="SELECT e FROM Empleado e"),
	@NamedQuery(name="empleado.getEmpleadosDepartamentoConcreto", query="SELECT e FROM Empleado e WHERE e.departamento = :departamento"),
	@NamedQuery(name="empleado.getEmpleadosGananMenosDelPromedio", query="SELECT e FROM Empleado e WHERE e.sueldo < AVG(e.sueldo)")
})
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_emp")
	private Integer id;
	
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private Double sueldo;
	
	@ManyToOne
	@JoinColumn(name = "id_dept")
	private Departamento departamento;

	public Empleado() {
		super();
	}

	public Empleado(Integer id, String nombre, Date fecha, Double sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.sueldo = sueldo;
	}

	public Empleado(Integer id, String nombre, Date fecha, Double sueldo, Departamento departamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Empleado other = (Empleado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", sueldo=" + sueldo
				+ ", departamento=" + departamento + "]";
	}
	
	
	
}
