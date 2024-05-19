package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Area implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Comision> misComisiones;
	
	public Area(String nombre) {
		super();
		this.nombre = nombre;
		misComisiones= new ArrayList<Comision>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Comision> getMisComisiones() {
		return misComisiones;
	}
	public void setMisComisiones(ArrayList<Comision> misComisiones) {
		this.misComisiones = misComisiones;
	}
	
	public void anadirComision(Comision c){
		misComisiones.add(c);
	}
	public void borrarComision(Comision c){
		misComisiones.remove(c);
	}
	
	
}
