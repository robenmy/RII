package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;

import logica.Empresa;
import logica.Juez;

import javax.swing.JComboBox;

import Utilidades.CellRendererTableColor;

import java.awt.Font;

public class ListadeJueces extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBoxEvento;
	private static int selEvento=0;
	private JRadioButton rdbtnTodos,rdbtnFisica,rdbtnQuimica,rdbtnMatematicas,rdbtnBiologa,rdbtnMedicina;
	

	public ListadeJueces() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadeJueces.class.getResource("/imagenes/logo.png")));
		setTitle("Lista de Jueces");
		setBounds(100, 100, 907, 469);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		tableModel = new DefaultTableModel(){

	 			private static final long serialVersionUID = 1L;
	 			boolean[] canEdit = new boolean[]{
	 					false, false,false,false, false,false //solo se pone no editable la segunda columna
	             };

	             public boolean isCellEditable(int rowIndex, int columnIndex) {
	                 return canEdit[columnIndex];
	             }
	        	 
	         };
		String[] columnNames = {"Cédula", "Nombre", "Apellido","Telefono", "Ocupación", "Nacionalidad"};
		tableModel.setColumnIdentifiers(columnNames);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBounds(0, 402, 890, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton ButtonOK = new JButton("OK");
				ButtonOK.setIcon(new ImageIcon(ListadeJueces.class.getResource("/imagenes/boton ok.png")));
				ButtonOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				ButtonOK.setActionCommand("OK");
				buttonPane.add(ButtonOK);
				getRootPane().setDefaultButton(ButtonOK);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption));
		panel.setBorder(new TitledBorder(null, "Listado de Jueces", TitledBorder.DEFAULT_POSITION, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 880, 390);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 21, 695, 341);
		panel.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setModel(tableModel);
		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
		scrollPane.setViewportView(table);
		
		
		rdbtnTodos = new JRadioButton("TODOS");
		rdbtnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxEvento.getSelectedIndex()>0){
				rdbtnTodos.setSelected(true);
				rdbtnFisica.setSelected(false);
				rdbtnQuimica.setSelected(false);
				rdbtnMatematicas.setSelected(false);
				rdbtnBiologa.setSelected(false);
				rdbtnMedicina.setSelected(false);
				loadJueces(0);
				}else{
					rdbtnTodos.setSelected(false);
					JOptionPane.showMessageDialog(null, "Seleccione un Evento");
					
				}
			}
		});
		rdbtnTodos.setBackground(new Color(230, 230, 250));
		rdbtnTodos.setBounds(21, 80, 109, 23);
		panel.add(rdbtnTodos);
		
		rdbtnFisica = new JRadioButton("F\u00CDSICA");
		rdbtnFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxEvento.getSelectedIndex()>0){
				rdbtnTodos.setSelected(false);
				rdbtnFisica.setSelected(true);
				rdbtnQuimica.setSelected(false);
				rdbtnMatematicas.setSelected(false);
				rdbtnBiologa.setSelected(false);
				rdbtnMedicina.setSelected(false);
				loadJueces(1);
			}else{
				rdbtnFisica.setSelected(false);
				JOptionPane.showMessageDialog(null, "Seleccione un Evento");
				
			}
			}
		});
		rdbtnFisica.setBackground(new Color(230, 230, 250));
		rdbtnFisica.setBounds(21, 110, 109, 23);
		panel.add(rdbtnFisica);
		
		rdbtnQuimica = new JRadioButton("QU\u00CDMICA");
		rdbtnQuimica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxEvento.getSelectedIndex()>0){
				rdbtnTodos.setSelected(false);
				rdbtnFisica.setSelected(false);
				rdbtnQuimica.setSelected(true);
				rdbtnMatematicas.setSelected(false);
				rdbtnBiologa.setSelected(false);
				rdbtnMedicina.setSelected(false);
				loadJueces(2);
				}else{
					rdbtnQuimica.setSelected(false);
					JOptionPane.showMessageDialog(null, "Seleccione un Evento");
					
				}
			}
		});
		rdbtnQuimica.setBackground(new Color(230, 230, 250));
		rdbtnQuimica.setBounds(21, 140, 109, 23);
		panel.add(rdbtnQuimica);
		
		rdbtnMatematicas = new JRadioButton("MATEM\u00C1TICAS");
		rdbtnMatematicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxEvento.getSelectedIndex()>0){
				rdbtnTodos.setSelected(false);
				rdbtnFisica.setSelected(false);
				rdbtnQuimica.setSelected(false);
				rdbtnMatematicas.setSelected(true);
				rdbtnBiologa.setSelected(false);
				rdbtnMedicina.setSelected(false);
				loadJueces(3);
				}else{
					rdbtnMatematicas.setSelected(false);
					JOptionPane.showMessageDialog(null, "Seleccione un Evento");
					
				}
			}
		});
		rdbtnMatematicas.setBackground(new Color(230, 230, 250));
		rdbtnMatematicas.setBounds(21, 170, 109, 23);
		panel.add(rdbtnMatematicas);
		
		rdbtnBiologa = new JRadioButton("BIOLOG\u00CDA");
		rdbtnBiologa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxEvento.getSelectedIndex()>0){
				rdbtnTodos.setSelected(false);
				rdbtnFisica.setSelected(false);
				rdbtnQuimica.setSelected(false);
				rdbtnMatematicas.setSelected(false);
				rdbtnBiologa.setSelected(true);
				rdbtnMedicina.setSelected(false);
				loadJueces(4);
				}else{
					rdbtnBiologa.setSelected(false);
					JOptionPane.showMessageDialog(null, "Seleccione un Evento");
					
				}
				}
		});
		rdbtnBiologa.setBackground(new Color(230, 230, 250));
		rdbtnBiologa.setBounds(21, 200, 109, 23);
		panel.add(rdbtnBiologa);
		
		rdbtnMedicina = new JRadioButton("MEDICINA");
		rdbtnMedicina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxEvento.getSelectedIndex()>0){
				rdbtnTodos.setSelected(false);
				rdbtnFisica.setSelected(false);
				rdbtnQuimica.setSelected(false);
				rdbtnMatematicas.setSelected(false);
				rdbtnBiologa.setSelected(false);
				rdbtnMedicina.setSelected(true);
				loadJueces(5);
				}else{
					rdbtnMedicina.setSelected(false);
					JOptionPane.showMessageDialog(null, "Seleccione un Evento");
					
				}
			}
		});
		rdbtnMedicina.setBounds(21, 230, 109, 23);
		rdbtnMedicina.setBackground(new Color(230, 230, 250));;
		panel.add(rdbtnMedicina);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ListadeJueces.class.getResource("/imagenes/fondolistadejueces.png")));
		lblNewLabel.setBounds(0, 8, 880, 377);
		panel.add(lblNewLabel);
		
		
		comboBoxEvento= new JComboBox<String>();
		comboBoxEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(comboBoxEvento.getSelectedIndex()>0){
					selEvento=comboBoxEvento.getSelectedIndex()-1;
					rdbtnTodos.setSelected(true);
					rdbtnFisica.setSelected(false);
					rdbtnQuimica.setSelected(false);
					rdbtnMatematicas.setSelected(false);
					rdbtnBiologa.setSelected(false);
					rdbtnMedicina.setSelected(false);
					loadJueces(0);
					}
					if(comboBoxEvento.getSelectedIndex()==0){
					clear();
					rdbtnTodos.setSelected(false);
					rdbtnFisica.setSelected(false);
					rdbtnQuimica.setSelected(false);
					rdbtnMatematicas.setSelected(false);
					rdbtnBiologa.setSelected(false);
					rdbtnMedicina.setSelected(false);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			
			}
		});
		comboBoxEvento.setBounds(21, 50, 109, 20);
		panel.add(comboBoxEvento);
		comboBoxEvento.addItem("<Seleccionar>");
		for(int i=0;i<Empresa.getInstances().getMisEventos().size() ;i++){
			comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
		}
		
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEvento.setBounds(21, 22, 109, 23);
		panel.add(lblEvento);
	}
	
	public static void loadJueces(int j) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		
		ArrayList<Juez> t= todosLosJueces(j);
		for (int i = 0; i< t.size();i++) {

			fila[0] = t.get(i).getCedula();
			fila[1] = t.get(i).getNombre();
			fila[2] = t.get(i).getApellido();
			fila[3] = t.get(i).getTelefono();
			fila[4] = t.get(i).getOcupacion();
			fila[5] = t.get(i).getNacionalidad();
			tableModel.addRow(fila);
			
		}
	}
	public static void clear() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];

	}
	
	public static ArrayList<Juez> todosLosJueces(int j){
		ArrayList<Juez> todos = new ArrayList<Juez>();
		if(Empresa.getInstances().getMisEventos().size()>0){
			switch (j) {
			case 0:
				for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size() ;u++){
					for(int y=0;y<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().size() ;y++){
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(0));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(1));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(2));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getPre());
				}}
				break;
			case 1:
				for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size() ;u++){
					if(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getNombre().equalsIgnoreCase("Fisica")){
					for(int y=0;y<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().size() ;y++){
						
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(0));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(1));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(2));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getPre());
					}
					}}
				break;
				
			case 2:
				for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size() ;u++){
					if(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getNombre().equalsIgnoreCase("Quimica")){
					for(int y=0;y<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().size() ;y++){
						
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(0));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(1));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(2));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getPre());
					}
					}}
				break;
	
			case 3:
				for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size() ;u++){
					if(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getNombre().equalsIgnoreCase("Matematicas")){
					for(int y=0;y<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().size() ;y++){
						
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(0));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(1));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(2));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getPre());
					}
					}}
				break;
	
			case 4:
				for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size() ;u++){
					if(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getNombre().equalsIgnoreCase("Biologa")){
					for(int y=0;y<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().size() ;y++){
						
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(0));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(1));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(2));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getPre());
					}
					}}
				break;
			case 5:
				for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size() ;u++){
					if(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getNombre().equalsIgnoreCase("Medicina")){
					for(int y=0;y<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().size() ;y++){
						
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(0));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(1));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getMisJueces().get(2));
						todos.add(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(u).getMisComisiones().get(y).getPre());
					}
					}}
				break;

			
			}}
			
			
			
		return todos;
		
	}
}
