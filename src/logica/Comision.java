package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Comision implements Serializable{

	private static final long serialVersionUID = 1L;
	private String area;
	private String codigo;
	private Juez pre;
	private ArrayList<Juez> misJueces;
	private ArrayList<Trabajo> misTrabajos;
	
	
	public Comision() {
		super();
		misJueces = new ArrayList<Juez>();
		misTrabajos= new ArrayList<Trabajo>();
	}

	public Comision(String area, Juez pre
			, String codigo) {
		super();
		this.area = area;
		this.codigo=codigo;
		this.pre = pre;
		misJueces = new ArrayList<Juez>();
		misTrabajos= new ArrayList<Trabajo>();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Juez getPre() {
		return pre;
	}

	public void setPre(Juez pre) {
		this.pre = pre;
	}

	public ArrayList<Juez> getMisJueces() {
		return misJueces;
	}

	public void setMisJueces(ArrayList<Juez> misJueces) {
		this.misJueces = misJueces;
	}

	public ArrayList<Trabajo> getMisTrabajos() {
		return misTrabajos;
	}

	public void setMisTrabajos(ArrayList<Trabajo> misTrabajos) {
		this.misTrabajos = misTrabajos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void anadirJueces(Juez j){
		misJueces.add(j);
	}
	public void borrarJueces(Juez j){
		misJueces.remove(j);
	}
	public void anadirTrabajos(Trabajo t){
		misTrabajos.add(t);
	}
	public void borrarTrabajos(Trabajo t){
		misTrabajos.remove(t);
	}

	
	
}
