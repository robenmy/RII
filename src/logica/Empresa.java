package logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Eventos> misEventos;
	private ArrayList<Juez> todosLosJueces;
	private static Empresa empresa;
	
	public Empresa() {
		super();
		misEventos = new ArrayList<Eventos>();
		todosLosJueces = new ArrayList<Juez>();		
	}
	public static Empresa getInstances(){
		if(empresa == null){
			empresa = new Empresa();			
		}
		return empresa;
	}
	//------------
	public ArrayList<Eventos> getMisEventos() {
		return misEventos;
	}
	public void setMisEventos(ArrayList<Eventos> misEventos) {
		this.misEventos = misEventos;
	}	

	public ArrayList<Juez> getTodosLosJueces() {
		return todosLosJueces;
	}
	public void setTodosLosJueces(ArrayList<Juez> todosLosJueces) {
		this.todosLosJueces = todosLosJueces;
	}

	public void agregarJuez(Juez j){
		todosLosJueces.add(j);
	}

	public void agregarEventos( Eventos evento){
		misEventos.add(evento);
	}

	public void borrarEventos( Eventos evento){
		misEventos.remove(evento);
	}

	public Eventos busquedaEvento(String nombre){
		Eventos e= null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i < misEventos.size()){
			if(misEventos.get(i).getNombre().equalsIgnoreCase(nombre)){
				e = misEventos.get(i);
				encontrado = true;
			}
			i++;		
		}
		return e;	
	}

	
	public void generarFicheroDatos(Empresa emp) throws IOException{
		
	FileOutputStream f = new FileOutputStream ("./Archivos/empresa.dat");
	ObjectOutputStream oos 	= new ObjectOutputStream (f);
	
	oos.writeObject(emp);
	f.close();
	}
	
	
	public void abrirFicheroDatos() throws IOException, ClassNotFoundException{
	FileInputStream f = new FileInputStream ("./Archivos/empresa.dat");
	ObjectInputStream oos = new ObjectInputStream(f);
	Empresa emp=null;
	emp=(Empresa)oos.readObject();
	f.close();
	empresa=emp;
	
	}

	public boolean unicoPresidente(String cedula){
		boolean unicopresi=false;
		for(int i=0; i<getMisEventos().size() ;i++){
			for(int u=0; u<getMisEventos().get(i).getMisAreas().size() ;u++){
				for(int y=0; y<getMisEventos().get(i).getMisAreas().get(u).getMisComisiones().size() ;y++){
					if(getMisEventos().get(i).getMisAreas().get(u).getMisComisiones().get(y).getPre().getCedula().equalsIgnoreCase(cedula)==true){
						unicopresi=true;
					}
					
					
				}
			}
		}
		
		
		return unicopresi;
		
	}

	public boolean buscarArea(String a, ArrayList<Area> todasLasAreas){
		boolean encontrado=false;
		for(int i=0;i<todasLasAreas.size();i++){
			if(todasLasAreas.get(i).getNombre().equalsIgnoreCase(a)==true){
				encontrado=true;
				
			}
		}
		return encontrado;
		
	}
	public int buscarAreaxindice(String a, ArrayList<Area> todasLasAreas){
		int encontrado = 0;
		for(int i=0;i<todasLasAreas.size();i++){
			if(todasLasAreas.get(i).getNombre().equalsIgnoreCase(a)==true){
				encontrado=i;
				
			}
		}
		return encontrado;
		
	}
	
	public int buscarParticipantexEvento(String Cedula){
		int y=0;
		
		for(int i=0; i<misEventos.size() ;i++){
			for(int k=0; k<misEventos.get(i).getMiparticipante().size() ;k++){
			if(misEventos.get(i).getMiparticipante().get(k).getCedula().equalsIgnoreCase(Cedula)==true){
				y=k;
			}
			
		}}
		
		return y;
		
	}
	public boolean encontrarCedulaxEvento(String Cedula, int e){
		boolean encontrado=false;
		for(int i=0; i<Empresa.getInstances().getMisEventos().get(e).getMiparticipante().size(); i++){
			if(Empresa.getInstances().getMisEventos().get(e).getMiparticipante().get(i).getCedula().equalsIgnoreCase(Cedula)){
				encontrado=true;
				
			}
		}
		return encontrado;
	}

	public Participante devolverParticipantexCedula(String Cedula, int e){
		Participante encontrado=null;
		for(int i=0; i<Empresa.getInstances().getMisEventos().get(e).getMiparticipante().size(); i++){
			if(Empresa.getInstances().getMisEventos().get(e).getMiparticipante().get(i).getCedula().equalsIgnoreCase(Cedula)){
				encontrado=Empresa.getInstances().getMisEventos().get(e).getMiparticipante().get(i);
				
			}
		}
		return encontrado;
	}
	public int devolverIndicedeParticipantexCedula(String Cedula, int e){
		int encontrado=0;
		for(int i=0; i<Empresa.getInstances().getMisEventos().get(e).getMiparticipante().size(); i++){
			if(Empresa.getInstances().getMisEventos().get(e).getMiparticipante().get(i).getCedula().equalsIgnoreCase(Cedula)){
				encontrado=i;
				
			}
		}
		return encontrado;
	}
	
	//para pastel
	public int cantidadSeminarios(){
		int cant=0;
		
		for(int i=0; i< misEventos.size();i++){
			if(misEventos.get(i).getTipo().equalsIgnoreCase("Seminario")){
				cant++;
			}
			
		}
		return cant;
	}
	public int cantidadPanel(){
		int cant=0;
		
		for(int i=0; i< misEventos.size();i++){
			if(misEventos.get(i).getTipo().equalsIgnoreCase("Panel")){
				cant++;
			}
			
		}
		return cant;
	}
	public int cantidadConversatorio(){
		int cant=0;
		
		for(int i=0; i< misEventos.size();i++){
			if(misEventos.get(i).getTipo().equalsIgnoreCase("Conversatorio")){
				cant++;
			}
			
		}
		return cant;
	}
	public int cantidadConferencia(){
		int cant=0;
		
		for(int i=0; i< misEventos.size();i++){
			if(misEventos.get(i).getTipo().equalsIgnoreCase("Conferencia")){
				cant++;
			}
			
		}
		return cant;
	}
	public int cantidadMesaRedonda(){
		int cant=0;
		
		for(int i=0; i< misEventos.size();i++){
			if(misEventos.get(i).getTipo().equalsIgnoreCase("Mesa Redonda")){
				cant++;
			}
			
		}
		return cant;
	}
	
	public int cantidadTrabajosxArea(int k){
		int cant=0;
		switch (k) {
		case 1:
			for(int i=0; i< misEventos.size();i++){
				for(int w=0; w< misEventos.get(i).getMisParticipantes().size();w++){
					for(int q=0; q< misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().size();q++){
						
				if(misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().get(q).getArea().getNombre().equalsIgnoreCase("Fisica")){
					cant++;
				}}
				}
			}
			break;
		case 2:
			for(int i=0; i< misEventos.size();i++){
				for(int w=0; w< misEventos.get(i).getMisParticipantes().size();w++){
					for(int q=0; q< misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().size();q++){
						
				if(misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().get(q).getArea().getNombre().equalsIgnoreCase("Biologia")){
					cant++;
				}}
				}
			}
			break;
		case 3:
			for(int i=0; i< misEventos.size();i++){
				for(int w=0; w< misEventos.get(i).getMisParticipantes().size();w++){
					for(int q=0; q< misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().size();q++){
						
				if(misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().get(q).getArea().getNombre().equalsIgnoreCase("Matematicas")){
					cant++;
				}}
				}
			}
			break;
		case 4:
			for(int i=0; i< misEventos.size();i++){
				for(int w=0; w< misEventos.get(i).getMisParticipantes().size();w++){
					for(int q=0; q< misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().size();q++){
						
				if(misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().get(q).getArea().getNombre().equalsIgnoreCase("Quimica")){
					cant++;
				}}
				}
			}
			break;
		case 5:
			for(int i=0; i< misEventos.size();i++){
				for(int w=0; w< misEventos.get(i).getMisParticipantes().size();w++){
					for(int q=0; q< misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().size();q++){
						
				if(misEventos.get(i).getMisParticipantes().get(w).getMisTrabajos().get(q).getArea().getNombre().equalsIgnoreCase("Medicina")){
					cant++;
				}}
				}
			}
			break;

		}
		
		return cant;
	}
	
	
	
	
	
	
	
	
	
	
}
