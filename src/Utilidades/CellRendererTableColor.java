package Utilidades;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



public class CellRendererTableColor extends DefaultTableCellRenderer{
	/*
	 */
	private static final long serialVersionUID = 1L;
	private Component componente;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
    	componente= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       
               
       if(row % 2 == 0){
    	   componente.setBackground(new Color(153, 204, 255));
       
        }else{
        	
        	componente.setBackground(Color.WHITE);
        	
        }
        return componente;
    }
}

//para implimentarla solo basta conque pongan en cada ventana donde hay tablas, debajo de la creacion de cada tabla lost

//(nombredelatabla).setDefaultRenderer(Object.class, new CellrenderColor());