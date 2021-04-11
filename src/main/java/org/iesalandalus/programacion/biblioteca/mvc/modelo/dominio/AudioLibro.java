package org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio;



public class AudioLibro extends Libro {


	private static final int MINUTOS_PARA_RECOMPENSA=15;
	private static final float PUNTOS_PREMIO=0.25f;

	private int duracion;

	public AudioLibro(String titulo, String autor, int duracion) {
		super(titulo,autor);
		setDuracion(duracion);
	}

	public AudioLibro(AudioLibro libro) {
		super(libro);
		this.duracion=libro.duracion;
	}

	@Override
	public float getPuntos() {
		int resultado=duracion/MINUTOS_PARA_RECOMPENSA;
		return PUNTOS_PREMIO*(resultado+1);
	}

	private void setDuracion(int duracion) {
		if (duracion <=0) {
			throw new IllegalArgumentException("ERROR: La duración debe ser mayor que cero.");
		}

		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
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
		return String.format("%s, duración=%d", super.toString(), duracion);
	}


}
