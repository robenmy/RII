package Utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AbrirAyuda {

	public void cargarArchivo() {
	       abrir();
	   }
	 
	  private void abrir() {
		  String ruta = new String("Archivos/AYUDA.pdf"); 
		  try{ 
		   
		     File path = new File (ruta);
		     Desktop.getDesktop().open(path);
		    
		    }catch(IOException e){
		       e.printStackTrace();
		    }catch(IllegalArgumentException e){
		       JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
		       e.printStackTrace();
		   }  
		  }
	
	
	
}
