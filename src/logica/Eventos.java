package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Eventos implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int dia;
	private int mes;
	private int year;
	private String horaInicio;
	private String horaFinal;
	private String lugar;
	private String Tipo;
	
	private ArrayList<Participante> misParticipantes;
	private ArrayList<String> misRecursos;
	private ArrayList<Area> misAreas;

	
	public Eventos() {
		super();
		misParticipantes = new ArrayList<Participante>();
		misRecursos= new ArrayList<String>();
		misAreas= new ArrayList<Area>();

	
	}


	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Participante> getMisParticipantes() {
		return misParticipantes;
	}

	public void setMisParticipantes(ArrayList<Participante> misParticipantes) {
		this.misParticipantes = misParticipantes;
	}

	public ArrayList<Area> getMisAreas() {
		return misAreas;
	}

	public void setMisAreas(ArrayList<Area> misAreas) {
		this.misAreas = misAreas;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public ArrayList<Participante> getMiparticipante() {
		return misParticipantes;
	}

	public void setMiparticipante(ArrayList<Participante> miparticipante) {
		this.misParticipantes = miparticipante;
	}

	public ArrayList<String> getMisRecursos() {
		return misRecursos;
	}

	public void setMisRecursos(ArrayList<String> misRecursos) {
		this.misRecursos = misRecursos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void anadirParticipante(Participante p){
		misParticipantes.add(p);
	}
	public void borrarParticipante(Participante p){
		misParticipantes.remove(p);
	}
	public void anadirArea(Area a){
		misAreas.add(a);
	}
	public void borrarArea(Area a){
		misAreas.remove(a);
	}
	

}
