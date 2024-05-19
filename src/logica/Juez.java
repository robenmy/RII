package logica;

public class Juez extends Persona{


	private static final long serialVersionUID = 1L;

	public Juez(String nombre, String cedula, String telefono,
			String ocupacion, String nacionalidad, int dia, int mes, int anio,
			String sexo, String apellido, String localidad) {
		super(nombre, cedula, telefono, ocupacion, nacionalidad, dia, mes, anio, sexo,
				apellido, localidad);

	}

	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}
