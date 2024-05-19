package logica;

import java.util.ArrayList;

public class Participante extends Persona {
	
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Trabajo> misTrabajos;


	public Participante(String nombre, String cedula, String telefono,
			String ocupacion, String nacionalidad, int dia, int mes, int anio,
			String sexo, String apellido, String localidad) {
		super(nombre, cedula, telefono, ocupacion, nacionalidad, dia, mes, anio,
				sexo, apellido, localidad);
		misTrabajos= new ArrayList<Trabajo>();
	}
	

	public ArrayList<Trabajo> getMisTrabajos() {
		return misTrabajos;
	}
	public void setMisTrabajos(ArrayList<Trabajo> misTrabajos) {
		this.misTrabajos = misTrabajos;
	}
	public void anadirTrabajos(Trabajo trabajo){
		
		misTrabajos.add(trabajo);
	}
	public void borrarTrabajos(Trabajo trabajo){
		
		misTrabajos.remove(trabajo);
	}


	@Override
	public int compareTo(Persona p) {
	       int compareage=((Participante)p).getMisTrabajos().size();
	        /* For Ascending order*/
	        //return this.getMisTrabajos().size()-compareage;
	        return compareage-this.getMisTrabajos().size();
	
	}


	
	

	
	
	
	
	
	

}
