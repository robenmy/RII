package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import Utilidades.CellRendererTableColor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Empresa;

public class Eventos extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHoraInicio;
	private JTextField txtHoraFinal,txtCantParticipantes;
	private JTextField txtCantTrabajos,txtCantJueces,txtCantComisiones;
	private JDateChooser txtFecha;
	private JComboBox<String> comboBoxEvento,txtTipo,txtLugar;
	private static DefaultTableModel tableModel_P,tableModel_R,tableModel_T;
	static Object[] fila;
	private JTable table_Participantes;
	private JTable table_Recursos;
	private JTable table_Trabajos;
	private static int selEvento=0;

	public Eventos() {
		setTitle("Eventos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eventos.class.getResource("/imagenes/logo.png")));
		setBounds(100, 100, 961, 621);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(135, 206, 235)));
		panel.setBounds(10, 11, 934, 542);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(33, 67, 46, 23);
		panel.add(lblTipo);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(33, 107, 46, 23);
		panel.add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(33, 147, 46, 23);
		panel.add(lblFecha);
		
		JLabel lblHoraInicio = new JLabel("Hora de Inicio:");
		lblHoraInicio.setBounds(33, 187, 89, 23);
		panel.add(lblHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora Final:");
		lblHoraFin.setBounds(33, 227, 89, 23);
		panel.add(lblHoraFin);
				
		txtTipo = new JComboBox<String>();
		txtTipo.setBounds(119, 67, 182, 23);
		panel.add(txtTipo);
		

		txtLugar = new JComboBox<String>();
		txtLugar.setBounds(119, 107, 182, 23);
		panel.add(txtLugar);
		
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(119, 147, 182, 23);
		panel.add(txtFecha);
		
		txtHoraInicio = new JTextField();
		txtHoraInicio.setColumns(10);
		txtHoraInicio.setBounds(119, 187, 182, 23);
		panel.add(txtHoraInicio);
		
		txtHoraFinal = new JTextField();
		txtHoraFinal.setColumns(10);
		txtHoraFinal.setBounds(119, 227, 182, 23);
		panel.add(txtHoraFinal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 55, 244, 206);
		panel.add(scrollPane);
		tableModel_R = new DefaultTableModel(){

 			private static final long serialVersionUID = 1L;
 			boolean[] canEdit = new boolean[]{
 					false 
             };

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit[columnIndex];
             }
        	 
         };
		String[] columnNames = {"Recursos"};
		tableModel_R.setColumnIdentifiers(columnNames);
		
		table_Recursos = new JTable();
		scrollPane.setColumnHeaderView(table_Recursos);
		table_Recursos .setDefaultRenderer(Object.class, new CellRendererTableColor());
		table_Recursos.setModel(tableModel_R);
		scrollPane.setViewportView(table_Recursos);
		
		JLabel lblCantidadDeParticipantes = new JLabel("Cantidad de Participantes:");
		lblCantidadDeParticipantes.setBounds(660, 86, 157, 23);
		panel.add(lblCantidadDeParticipantes);
		
		txtCantParticipantes = new JTextField();
		txtCantParticipantes.setColumns(10);
		txtCantParticipantes.setBounds(828, 86, 74, 23);
		panel.add(txtCantParticipantes);
		
		JLabel lblCantidadDeTrabajos = new JLabel("Cantidad de Trabajos:");
		lblCantidadDeTrabajos.setBounds(660, 126, 127, 23);
		panel.add(lblCantidadDeTrabajos);
		
		txtCantTrabajos = new JTextField();
		txtCantTrabajos.setColumns(10);
		txtCantTrabajos.setBounds(828, 126, 74, 23);
		panel.add(txtCantTrabajos);
		
		JLabel lblCantidadDeJueces = new JLabel("Cantidad de Jueces:");
		lblCantidadDeJueces.setBounds(660, 166, 127, 23);
		panel.add(lblCantidadDeJueces);
		
		txtCantJueces = new JTextField();
		txtCantJueces.setColumns(10);
		txtCantJueces.setBounds(828, 166, 74, 23);
		panel.add(txtCantJueces);
		
		JLabel lblCantidadDeComisiones = new JLabel("Cantidad de Comisiones:");
		lblCantidadDeComisiones.setBounds(660, 206, 145, 23);
		panel.add(lblCantidadDeComisiones);
		
		txtCantComisiones = new JTextField();
		txtCantComisiones.setColumns(10);
		txtCantComisiones.setBounds(828, 206, 74, 23);
		panel.add(txtCantComisiones);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(330, 27, 2, 250);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(630, 27, 2, 250);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 277, 892, 2);
		panel.add(separator_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 313, 327, 206);
		panel.add(scrollPane_1);
		tableModel_P = new DefaultTableModel(){

 			private static final long serialVersionUID = 1L;
 			boolean[] canEdit = new boolean[]{
 					false, false,false  
             };

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit[columnIndex];
             }
        	 
         };
		String[] columnNames1 = {"Cédula", "Nombre", "Teléfono"};
		tableModel_P.setColumnIdentifiers(columnNames1);
		
		
		table_Participantes = new JTable();
		scrollPane_1.setColumnHeaderView(table_Participantes);
		table_Participantes.setDefaultRenderer(Object.class, new CellRendererTableColor());
		table_Participantes.setModel(tableModel_P);
		scrollPane_1.setViewportView(table_Participantes);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(448, 313, 464, 206);
		panel.add(scrollPane_2);

		tableModel_T = new DefaultTableModel(){

 			private static final long serialVersionUID = 1L;
 			boolean[] canEdit = new boolean[]{
 					false, false,false,false //solo se pone no editable la segunda columna
             };

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit[columnIndex];
             }
        	 
         };
		String[] columnNames2 = {"Autor", "Título", "Área", "Idioma"};
		tableModel_T.setColumnIdentifiers(columnNames2);
		
		
		table_Trabajos = new JTable();
		scrollPane_2.setColumnHeaderView(table_Trabajos);
		table_Trabajos.setDefaultRenderer(Object.class, new CellRendererTableColor());
		table_Trabajos.setModel(tableModel_T);
		scrollPane_2.setViewportView(table_Trabajos);
		
		
		comboBoxEvento = new JComboBox<String>();
		comboBoxEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			if(comboBoxEvento.getSelectedIndex()>0){
				 selEvento=comboBoxEvento.getSelectedIndex()-1;
				 limpiarCampos();
				 rellenar();
				 editableEvento(false);
				 
			}
			if(comboBoxEvento.getSelectedIndex()==0){
				 
				limpiarCampos();
			}
			
			
			}
		});
		comboBoxEvento.setBounds(360, 11, 244, 23);
		comboBoxEvento.addItem("<Seleccione>");
		for(int i=0; i< Empresa.getInstances().getMisEventos().size(); i++){
			comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
		}
		panel.add(comboBoxEvento);
		
		
		editableTodo(false);
		resizable(false);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(401, 277, 2, 257);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(20, 25, 332, 2);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(614, 25, 310, 2);
		panel.add(separator_5);
		
		JLabel lblNewLabel = new JLabel("DATOS B\u00C1SICOS");
		lblNewLabel.setBounds(119, 27, 127, 23);
		panel.add(lblNewLabel);
		
		JLabel lblDatosEstadisticos = new JLabel("DATOS ESTAD\u00CDSTICOS");
		lblDatosEstadisticos.setBounds(724, 27, 127, 23);
		panel.add(lblDatosEstadisticos);
		
		JLabel lblListadoDeParticpantes = new JLabel("LISTADO DE PARTICPANTES");
		lblListadoDeParticpantes.setBounds(119, 280, 182, 23);
		panel.add(lblListadoDeParticpantes);
		
		JLabel lblListadoDeTrabajos = new JLabel("LISTADO DE TRABAJOS");
		lblListadoDeTrabajos.setBounds(610, 280, 182, 23);
		panel.add(lblListadoDeTrabajos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 934, 542);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Eventos.class.getResource("/imagenes/logomoisaco.png")));
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(3, 554, 945, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			JButton ButtonAplicar = new JButton("Aplicar");
			ButtonAplicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean continuar=true;
					if(
					txtFecha.getDate()==null|
					txtHoraInicio.getText().equalsIgnoreCase("")==true|
					txtHoraFinal.getText().equalsIgnoreCase("")==true){
						
						continuar=false;
					}
					if(continuar==true){
						Empresa.getInstances().getMisEventos().get(selEvento).setTipo((String)txtTipo.getSelectedItem());
						Empresa.getInstances().getMisEventos().get(selEvento).setLugar((String)txtLugar.getSelectedItem());
						
						Empresa.getInstances().getMisEventos().get(selEvento).setHoraInicio(txtHoraInicio.getText());
						Empresa.getInstances().getMisEventos().get(selEvento).setHoraFinal(txtHoraFinal.getText());
						
						Empresa.getInstances().getMisEventos().get(selEvento).setDia(txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
						Empresa.getInstances().getMisEventos().get(selEvento).setMes((txtFecha.getCalendar().get(Calendar.MONTH)+1));
						Empresa.getInstances().getMisEventos().get(selEvento).setYear(txtFecha.getCalendar().get(Calendar.YEAR));
						
						editableEvento(false);
						try {
							Empresa.getInstances().generarFicheroDatos(Empresa.getInstances());
						} catch (IOException q) {
							// TODO Auto-generated catch block
							q.printStackTrace();
						}	
					}
					
				
				}
			});
			
			JButton btnGenerarReporte = new JButton("Generar Reporte");
			btnGenerarReporte.setIcon(new ImageIcon(Eventos.class.getResource("/imagenes/boton reporte.png")));
			btnGenerarReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Fichero Generado");
				}
			});
			buttonPane.add(btnGenerarReporte);
			ButtonAplicar.setIcon(new ImageIcon(ListaEventos.class.getResource("/imagenes/boton aplicar.png")));
			ButtonAplicar.setActionCommand("Cancel");
			buttonPane.add(ButtonAplicar);
			{
				JButton ButtonEditar = new JButton("Editar");
				ButtonEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						
						editableEvento(true);
						
						switch ((String)txtLugar.getSelectedItem()) {
						case "Estadio":
							
							txtLugar.addItem("Multiusos");
							txtLugar.addItem("Biblioteca");
							break;
						case "Multiusos":
							txtLugar.addItem("Estadio");
							
							txtLugar.addItem("Biblioteca");
							break;
						case "Biblioteca":
							txtLugar.addItem("Estadio");
							txtLugar.addItem("Multiusos");
							
							break;
						}
						
						switch ((String)txtTipo.getSelectedItem()) {
						case "Seminario":
							txtTipo.addItem("Panel");
							txtTipo.addItem("Conversatorio");
							txtTipo.addItem("Conferencia");
							txtTipo.addItem("Mesa Redonda");
							break;
						case "Panel":
							txtTipo.addItem("Seminario");
							txtTipo.addItem("Conversatorio");
							txtTipo.addItem("Conferencia");
							txtTipo.addItem("Mesa Redonda");
							break;
						case "Conversatorio":
							txtTipo.addItem("Seminario");
							txtTipo.addItem("Panel");
							txtTipo.addItem("Conferencia");
							txtTipo.addItem("Mesa Redonda");
							break;
						case "Conferencia":
							txtTipo.addItem("Seminario");
							txtTipo.addItem("Panel");
							txtTipo.addItem("Conversatorio");
							txtTipo.addItem("Mesa Redonda");
							break;
						case "Mesa Redonda":
							txtTipo.addItem("Seminario");
							txtTipo.addItem("Panel");
							txtTipo.addItem("Conversatorio");
							txtTipo.addItem("Conferencia");
							break;
						}
						
						
						
						
					}
				});
				ButtonEditar.setIcon(new ImageIcon(ListaEventos.class.getResource("/imagenes/boton editar.png")));
				ButtonEditar.setActionCommand("Cancel");
				buttonPane.add(ButtonEditar);
			}
			
			{
				JButton ButtonOK = new JButton("OK");
				ButtonOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					dispose();
					}
				});
				ButtonOK.setIcon(new ImageIcon(Eventos.class.getResource("/imagenes/boton ok.png")));
				ButtonOK.setActionCommand("OK");
				buttonPane.add(ButtonOK);
				getRootPane().setDefaultButton(ButtonOK);
			}
		}
	}
	
	
	public void rellenar(){
		txtTipo.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getTipo());
		txtLugar.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getLugar());
		String FR="";
		FR=Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getDia())+"/";
		FR+=Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getMes())+"/";
		FR+=Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getYear());
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
		Date fecha = null;
		try {
		fecha = formatoDelTexto.parse(FR);
		} catch (ParseException ex) {
		ex.printStackTrace();
		}
		
		txtFecha.setDate(fecha);
		
		txtHoraInicio.setText(Empresa.getInstances().getMisEventos().get(selEvento).getHoraInicio());
		txtHoraFinal.setText(Empresa.getInstances().getMisEventos().get(selEvento).getHoraFinal());
		txtCantParticipantes.setText(Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().size()));
		cantTrabajos();
		cantJueces();
		cantComisiones();
		loadRecursos();
		cargarTrabajos();
		cargarParticipantes();
		
		
	}
	public void limpiarCampos(){
		try {
			txtTipo.removeAllItems();
		txtLugar.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		txtFecha.setDate(null);
		txtHoraInicio.setText("");
		txtHoraFinal.setText("");
		txtCantComisiones.setText("");
		txtCantJueces.setText("");
		txtCantParticipantes.setText("");
		txtCantTrabajos.setText("");
		tableModel_P.setRowCount(0);
		fila = new Object[tableModel_P.getColumnCount()];
		tableModel_T.setRowCount(0);
		fila = new Object[tableModel_T.getColumnCount()];
		tableModel_R.setRowCount(0);
		fila = new Object[tableModel_R.getColumnCount()];
		
	}
	
	public void cantTrabajos(){
		int cant=0;
		
		for(int i=0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().size();i++){
			cant+=Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().size();	
		}
		txtCantTrabajos.setText(Integer.toString(cant));
		
	}
	
	public void cantJueces(){
		int cant=0;
		
		for(int i=0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size();i++){
			for(int u=0;u<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getMisComisiones().size() ; u++){
				cant+=1;
				cant+=Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getMisComisiones().get(u).getMisJueces().size();	
		}}
		
		txtCantJueces.setText(Integer.toString(cant));
		
	}
	public void cantComisiones(){
		int cant=0;
		
		for(int i=0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size();i++){
			
			cant+=Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getMisComisiones().size();	
		}
		
		txtCantComisiones.setText(Integer.toString(cant));
		
	}
	
	public void loadRecursos() {
		
		tableModel_R.setRowCount(0);
		fila = new Object[tableModel_R.getColumnCount()];
		
		for (int i = 0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisRecursos().size() ;i++) {
			fila[0] = Empresa.getInstances().getMisEventos().get(selEvento).getMisRecursos().get(i);
		
			tableModel_R.addRow(fila);
		}
		
	}
	
	public void cargarTrabajos(){
		tableModel_T.setRowCount(0);
		fila = new Object[tableModel_T.getColumnCount()];
		
		for (int i = 0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().size() ;i++) {
			for (int q = 0; q<Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().size() ;q++) {
			fila[0] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().get(q).getParticipante().getNombre();
			fila[1] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().get(q).getTitulo();
			fila[2] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().get(q).getArea().getNombre();
			fila[3] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().get(q).getIdioma();
			tableModel_T.addRow(fila);
		}}
		

	}
	
	public void cargarParticipantes(){
		tableModel_P.setRowCount(0);
		fila = new Object[tableModel_P.getColumnCount()];
		
		for (int i = 0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().size() ;i++) {
			
			fila[0] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getCedula();
			fila[1] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getNombre();
			fila[2] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getTelefono();
			tableModel_P.addRow(fila);
		}
		

	}
	
	
	public void editableEvento(boolean t){
		txtTipo.setEnabled(t);
		txtLugar.setEnabled(t);
		txtFecha.setEnabled(t);
		txtHoraInicio.setEditable(t);
		txtHoraFinal.setEditable(t);

	}
	public void editableTodo(boolean t){
		txtTipo.setEnabled(t);
		txtLugar.setEnabled(t);
		txtFecha.setEnabled(t);
		txtHoraInicio.setEditable(t);
		txtHoraFinal.setEditable(t);
		txtCantComisiones.setEditable(t);
		txtCantJueces.setEditable(t);
		txtCantParticipantes.setEditable(t);
		txtCantTrabajos.setEditable(t);

	}
	
	public void resizable(boolean t){
		
		table_Participantes.getColumnModel().getColumn(0).setResizable(t);
		table_Participantes.getColumnModel().getColumn(1).setResizable(t);
		table_Participantes.getColumnModel().getColumn(2).setResizable(t);
		table_Participantes.setDragEnabled(false);
		table_Trabajos.getColumnModel().getColumn(0).setResizable(t);
		table_Trabajos.getColumnModel().getColumn(1).setResizable(t);
		table_Trabajos.getColumnModel().getColumn(2).setResizable(t);
		table_Trabajos.getColumnModel().getColumn(3).setResizable(t);
		table_Trabajos.setDragEnabled(false);

	}
}
