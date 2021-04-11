package org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio;

public class LibroEscrito extends Libro {


	private static final int PAGINAS_PARA_RECOMPENSA=25;
	private static final float PUNTOS_PREMIO=0.5f;

	private int numPaginas;

	public LibroEscrito(String titulo, String autor, int numPaginas) {
		super(titulo,autor);
		setNumPaginas(numPaginas);
	}

	public LibroEscrito(LibroEscrito libro) {
		super(libro);
		this.numPaginas=libro.numPaginas;
	}

	@Override
	public float getPuntos() {
		int resultado=numPaginas/PAGINAS_PARA_RECOMPENSA;
		return PUNTOS_PREMIO*(resultado+1);
	}

	private void setNumPaginas(int numPaginas) {
		if (numPaginas <=0) {
			throw new IllegalArgumentException("ERROR: El número de páginas debe ser mayor que cero.");
		}

		this.numPaginas = numPaginas;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return String.format("%s, número de páginas=%d", super.toString(), numPaginas);
	}


}
