package org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio;

import java.util.Objects;

public class Alumno {

	private static final String ER_NOMBRE="[a-zA-ZñÑáéíóúÁÉÍÓÚ]+(\\s+[a-zA-ZñÑáéíóúÁÉÍÓÚ]+)+";
	private static final String ER_CORREO=".+@[a-zA-Z]+\\.[a-zA-Z]+";

	private Curso curso;

	private String nombre;
	private String correo;

	public Alumno(String nombre,String correo,Curso curso) {
		setNombre(nombre);
		setCorreo(correo);
		setCurso(curso);
	}

	public Alumno(Alumno alumno) {
		if (alumno==null) {
			throw new NullPointerException("ERROR: No es posible copiar un alumno nulo.");
		}
		this.nombre=alumno.nombre.trim();
		this.correo=alumno.correo;
		this.curso=alumno.curso;
	}

	public static Alumno getAlumnoFicticio (String correo) {
		return new Alumno ("Bob Esponja", correo, Curso.PRIMERO);
	}

	private String formateaNombre(String nombre) {
		String[]palabras=nombre.trim().split("\\s+");
		StringBuilder nombreFormateado=new StringBuilder();
		for(String palabra : palabras) {
			nombreFormateado.append(palabra.substring(0,1).toUpperCase())
			.append(palabra.substring(1).toLowerCase())
			.append(" ");
		}
		return nombreFormateado.toString();
	}

	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		/*if (nombre.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El nombre no puede estar vacío.");
		}*/
		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}
		this.nombre = formateaNombre(nombre).trim();
	}

	private void setCorreo(String correo) {
		if (correo == null) {
			throw new NullPointerException("ERROR: El correo no puede ser nulo.");
		}
		if (!correo.matches(ER_CORREO)) {
			throw new IllegalArgumentException("ERROR: El formato del correo no es válido.");
		}
		this.correo = correo;
	}

	public void setCurso(Curso curso) {
		if (curso == null){
			throw new NullPointerException("ERROR: El curso no puede ser nulo.");
		}
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public Curso getCurso() {
		return curso;
	}

	private String getIniciales() {
		StringBuilder builder = new StringBuilder();

		String palabras[] = nombre.split(" ");

		for (String palabra : palabras) {

			builder.append(palabra.substring(0, 1));
		}
		return builder.toString().trim();

	}

	@Override
	public int hashCode() {
		return Objects.hash(correo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alumno)) {
			return false;
		}
		Alumno other = (Alumno) obj;
		return Objects.equals(correo, other.correo);
	}

	@Override
	public String toString() {
		return String.format("nombre=%s (%s), correo=%s, curso=%s", nombre, getIniciales(), correo, curso);
	}




}
