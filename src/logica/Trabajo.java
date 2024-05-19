package logica;

import java.io.Serializable;

public class Trabajo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private String fechaRealizacion;
	private String idioma;
	
	private Area area;
	private Participante participante;
	
	
	public Trabajo(String titulo, String fechaRealizacion, String idioma,
			Area area,Participante participante) {
		super();
		this.titulo = titulo;
		this.fechaRealizacion = fechaRealizacion;
		this.idioma = idioma;
		this.area = area;
		
		this.participante=participante;
	}
	


	public Trabajo() {
		super();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFechaRealizacion() {
		return fechaRealizacion;
	}
	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
}
