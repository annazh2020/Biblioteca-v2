package org.iesalandalus.programacion.biblioteca.mvc.vista.texto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.biblioteca.mvc.controlador.IControlador;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Curso;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;
import org.iesalandalus.programacion.biblioteca.mvc.vista.IVista;



public class VistaTexto implements IVista {

	private IControlador controlador;

	public VistaTexto() {
		Opcion.setVista(this);
	}

	@Override
	public void setControlador(IControlador controlador) {
		if(controlador==null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador = controlador;
	}

	@Override
	public void comenzar() {
		Consola.mostrarCabecera("Gestión de préstamos de libros de la Biblioteca IES Al-Andalus.");
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	@Override
	public void terminar() {
		controlador.terminar();
	}

	public void insertarAlumno() {
		Consola.mostrarCabecera("Insertar Alumno");
		try {
			controlador.insertar(Consola.leerAlumno());
			System.out.println("Alumno insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarAlumno() {
		Consola.mostrarCabecera("Buscar Alumno");
		Alumno alumno;
		try {
			alumno = controlador.buscar(Consola.leerAlumnoFicticio());
			String mensaje = (alumno != null) ? alumno.toString() : "No existe dicho alumno.";
			System.out.println(mensaje);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarAlumno() {
		Consola.mostrarCabecera("Borrar Alumno");
		try {
			controlador.borrar(Consola.leerAlumnoFicticio());
			System.out.println("Alumno borrado satisfactoriamente.");
		}  catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarAlumnos() {
		Consola.mostrarCabecera("Listado de Alumnos");
		List<Alumno> alumnos = controlador.getAlumnos();
		if (!alumnos.isEmpty()) {
			for (Alumno alumno : alumnos) {
				if (alumno != null) 
					System.out.println(alumno);
			}
		} else {
			System.out.println("No hay alumnos que mostrar.");
		}
	}

	public void insertarLibro() {
		Consola.mostrarCabecera("Insertar Libro");
		try {
			controlador.insertar(Consola.leerLibro());
			System.out.println("Libro insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarLibro() {
		Consola.mostrarCabecera("Buscar Libro");
		Libro libro;
		try {
			libro = controlador.buscar(Consola.leerLibro());
			String mensaje = (libro != null) ? libro.toString() : "No existe dicho libro.";
			System.out.println(mensaje);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarLibro() {
		Consola.mostrarCabecera("Borrar Libro");
		try {
			controlador.borrar(Consola.leerLibro());
			System.out.println("Libro borrado satisfactoriamente.");
		}  catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarLibros() {
		Consola.mostrarCabecera("Listado de Libros");
		List<Libro> libros = controlador.getLibros();
		if (!libros.isEmpty()) {
			for (Libro libro : libros) {
				if (libro != null) 
					System.out.println(libro);
			}
		} else {
			System.out.println("No hay libros que mostrar.");
		}
	}

	public void prestarLibro() {
		Consola.mostrarCabecera("Insertar Préstamo del libro");
		try {
			Prestamo prestamo = Consola.leerPrestamo();
			controlador.prestar(prestamo);
			System.out.println("Libro prestado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void devolverLibro() {
		Consola.mostrarCabecera("Devolver libro prestado");
		try {
			Prestamo prestamo = Consola.leerPrestamoFicticio();
			LocalDate fechaDevolucion=Consola.leerFecha("Introduce la fecha de devolucion");
			controlador.devolver(prestamo, fechaDevolucion);
			System.out.println("Préstamo devuelto correctamente.");
		}catch(OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarPrestamo() {
		Consola.mostrarCabecera("Buscar Préstamo");
		Prestamo prestamo;
		try {
			prestamo = controlador.buscar(Consola.leerPrestamoFicticio());
			String mensaje = (prestamo != null) ? prestamo.toString() : "No existe dicho préstamo.";
			System.out.println(mensaje);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarPrestamo() {
		Consola.mostrarCabecera("Borrar Préstamo");
		try {
			controlador.borrar(Consola.leerPrestamoFicticio());
			System.out.println("Préstamo borrado satisfactoriamente.");
		}  catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarPrestamos() {
		Consola.mostrarCabecera("Listado de Préstamos");
		List<Prestamo> prestamos = controlador.getPrestamos();
		if (!prestamos.isEmpty()) {
			for (Prestamo prestamo : prestamos) {
				if (prestamo != null) 
					System.out.println(prestamo);
			}
		} else {
			System.out.println("No hay préstamos que mostrar.");
		}
	}

	public void listarPrestamosAlumno() {
		Consola.mostrarCabecera("Listado de Préstamos por Alumno");
		List<Prestamo> prestamos = controlador.getPrestamos(Consola.leerAlumnoFicticio());
		if (!prestamos.isEmpty()) {
			for (Prestamo prestamo : prestamos) {
				if (prestamo != null) 
					System.out.println(prestamo);
			}
		} else {
			System.out.println("No hay préstamos, para dicho alumno, que mostrar.");
		}
	}

	public void listarPrestamosLibro() {
		Consola.mostrarCabecera("Listado de Préstamos por Libro");
		List<Prestamo> prestamos = controlador.getPrestamos(Consola.leerLibro());
		if (!prestamos.isEmpty()) {
			for (Prestamo prestamo : prestamos) {
				if (prestamo != null) 
					System.out.println(prestamo);
			}
		} else {
			System.out.println("No hay préstamos, para dicho libro, que mostrar.");
		}
	}

	public void listarPrestamosFecha() {
		Consola.mostrarCabecera("Listado de Préstamos por Fecha");
		List<Prestamo> prestamos = controlador.getPrestamos(Consola.leerFecha("Introduce la fecha que quiere consultar"));
		if (!prestamos.isEmpty()) {
			for (Prestamo prestamo : prestamos) {
				if (prestamo != null) 
					System.out.println(prestamo);
			}
		} else {
			System.out.println("No hay préstamos que mostrar para la fecha introducida.");
		}
	}

	public void mostrarEstadisticaMensualPorCurso() throws OperationNotSupportedException {
		Consola.mostrarCabecera("Estadística mensual por curso");
		try {
			Map<Curso,Integer> estadisticaMensualPorCurso = controlador.getEstadisticaMensualPorCurso(Consola.leerFecha("Introduce la fecha que quiere consultar"));
			System.out.println(estadisticaMensualPorCurso);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
