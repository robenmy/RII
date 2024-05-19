package logica;

import java.io.Serializable;

public abstract class Persona implements Serializable, Comparable<Persona> {

	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String apellido;
	protected String cedula;
	protected String telefono;
	protected String ocupacion;
	protected String nacionalidad;
	protected String sexo;
	protected int dia;
	protected int mes;
	protected int anio;
	protected String localidad;
	
	public Persona(String nombre, String cedula, String telefono,
			String ocupacion, String nacionalidad, int dia, int mes, int anio, String sexo, String apellido, String localidad) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.ocupacion = ocupacion;
		this.nacionalidad = nacionalidad;
	
		this.dia=dia;
		this.mes=mes;
		this.anio=anio;
		this.sexo=sexo;
		this.apellido=apellido;
		this.localidad=localidad;
		
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int compareTo(Participante p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
