package com.curso.principales;

import java.util.List;

import com.curso.dominio.Departamento;
import com.curso.dominio.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import repository.DepartamentoRepository;
import repository.EmpleadosRepository;

public class MainEmpresa {
	public static void main(String[] args) {

		// Crear la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empresa");
		EntityManager em = emf.createEntityManager();
		
		// Instanciar repositorios
		DepartamentoRepository dr = new DepartamentoRepository(em);
		EmpleadosRepository er = new EmpleadosRepository(em);
		
		// Crear un departamento, crear tres empleados y asignarlos a ese departamento.
		System.out.println("Crear un departamento, crear tres empleados y asignarlos a ese departamento.");
		crearDeptYTresEmpleados(em);

		// Crear un empleado y asignarlo a un departamento
		System.out.println("Crear un empleado y asignarlo a un departamento");
		crearEmpYAsignar(em);
		
		/*
		// Mostrar el empleado que lleva menos tiempo en la empresa
		System.out.println("Mostrar el empleado que lleva menos tiempo en la empresa");
		System.out.println(er.getEmpleadoMenosTiempoEnEmpresa());
		*/
		
		// Dados dos empleados muestra por pantalla el que lleva menos tiempo trabajando en la empresa.
		System.out.println("Dados dos empleados muestra por pantalla el que lleva menos tiempo trabajando en la empresa.");
		Empleado uno = em.find(Empleado.class, 1);
		Empleado dos = em.find(Empleado.class, 2);
		Empleado empleadoMenosTiempo = er.getEmpleadoMenosTiempo(uno, dos);
		System.out.println(empleadoMenosTiempo);
		
		
		// Muestra todos los departamentos.
		List<Departamento> todosLosDepartamentos = dr.getAllDepartamentos();
		System.out.println("Muestra todos los departamentos.");
		for (Departamento departamento : todosLosDepartamentos) {
			System.out.println(departamento);
		}

		
		// Selecciona todos los empleados de un departamento concreto.
		Departamento dept = em.find(Departamento.class, 1);
		List<Empleado> empleadosDepartamentoConcreto = er.getEmpleadosDepartamentoConcreto(dept);
		System.out.println("Selecciona todos los empleados de un departamento concreto.");
		for (Empleado empleado : empleadosDepartamentoConcreto) {
			System.out.println(empleado);
		}
		
		
		
/*
		// Selecciona los departamentos con menos de n empleados.
		
		List<Departamento> departamentosMenosDe5Empleados = dr.getDepartamentosConMenosDeNEmpleados(5);
		System.out.println("Selecciona los departamentos con menos de n empleados.");
		for (Departamento departamento : departamentosMenosDe5Empleados) {
			System.out.println(departamento);
		}
		*/
		
		
		// Selecciona los empleados que ganan menos que el promedio
		List<Empleado> empleadosGananMenosDelPromedio = er.getEmpleadosGananMenosDelPromedio();
		System.out.println("Selecciona los empleados que ganan menos que el promedio");
		for (Empleado empleado : empleadosGananMenosDelPromedio) {
			System.out.println(empleado);
		}
		

		
	}
		
	public static void crearDeptYTresEmpleados(EntityManager em) {
		Departamento dept = new Departamento(null,"Informatica", "Ourense");
		//Integer id, String nombre, Date fecha, Double sueldo, Departamento departamento
		Empleado empleado = new Empleado(null,"Pepe",null,2000d,dept);
		
		em.getTransaction().begin();
		
		em.persist(dept);
		
		em.persist(empleado);
		
		em.getTransaction().commit();
	}
	
	public static void crearEmpYAsignar(EntityManager em) {
		Departamento dept = em.find(Departamento.class, 1);
		Empleado empleado = new Empleado(null, "Pepito", null, 2000d, dept);
		
		em.getTransaction().begin();

		em.persist(empleado);
		
		em.getTransaction().commit();
	}
	

	
	
}
