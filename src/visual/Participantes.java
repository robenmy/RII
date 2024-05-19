package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Utilidades.CellRendererTableColor;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;

import logica.Empresa;
import logica.Participante;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Participantes extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtNombre,txtApellido,txtNacionalidad,txtLocalidad;
	private JFormattedTextField txtCedula, txtTelefono;
	private JCheckBox chckbxM,chckbxF ; 
	private JComboBox<String> comboBoxOcupacion,comboBoxEvento ;
	private MaskFormatter patron, tele;
	private JDateChooser txtFecha ;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private ArrayList<Integer> numeroEventos = new ArrayList<Integer>();
	private JButton ButtonBuscar ;
	


	public Participantes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Participantes.class.getResource("/imagenes/logo.png")));
		setTitle("Participantes");
		setBounds(100, 100, 544, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Participante", TitledBorder.TOP, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 521, 187);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		ButtonBuscar = new JButton("");
		ButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaryCargar();
				
			}
		});
		ButtonBuscar.setIcon(new ImageIcon(RegistrarTrabajo.class.getResource("/imagenes/botonbuscar.png")));
		ButtonBuscar.setBounds(213, 17, 25, 23);
		ButtonBuscar.setBackground(new Color(230, 230, 250));
		ButtonBuscar.setBorderPainted(false);
		panel.add(ButtonBuscar);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 17, 57, 23);
		panel.add(lblCdula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 83, 63, 23);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 116, 73, 23);
		panel.add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 50, 83, 23);
		panel.add(lblTelfono);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(259, 50, 83, 23);
		panel.add(lblNacionalidad);
		
		JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
		lblOcupacin.setBounds(259, 116, 83, 23);
		panel.add(lblOcupacin);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(259, 83, 83, 23);
		panel.add(lblLocalidad);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(10, 150, 131, 23);
		panel.add(lblFechaDeNacimiento);
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCedula = new JFormattedTextField(patron);
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					buscaryCargar();
		          }
			
			}
		});
		txtCedula.setBounds(67, 17, 138, 23);
		panel.add(txtCedula);
		
		txtTelefono = new JFormattedTextField(tele);
		txtTelefono.setBounds(67, 50, 171, 23);
		panel.add(txtTelefono);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
public void keyTyped(java.awt.event.KeyEvent evt) {
				
				char c = evt.getKeyChar();
				
				if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
					evt.consume();
			
					          } 
		});
		txtNombre.setBounds(67, 83, 171, 23);
		panel.add(txtNombre);
		
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
public void keyTyped(java.awt.event.KeyEvent evt) {
				
				char c = evt.getKeyChar();
				
				if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
					evt.consume();
			
					          } 
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(67, 116, 171, 23);
		panel.add(txtApellido);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.addKeyListener(new KeyAdapter() {
			@Override
public void keyTyped(java.awt.event.KeyEvent evt) {
				
				char c = evt.getKeyChar();
				
				if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
					evt.consume();
			
					          } 
		});
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(340, 50, 171, 23);
		panel.add(txtNacionalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.addKeyListener(new KeyAdapter() {
			@Override
public void keyTyped(java.awt.event.KeyEvent evt) {
				
				char c = evt.getKeyChar();
				
				if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
					evt.consume();
			
					          } 
		});
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(340, 83, 171, 23);
		panel.add(txtLocalidad);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(134, 150, 104, 23);
		panel.add(txtFecha);
		
		comboBoxOcupacion = new JComboBox<String>();
		comboBoxOcupacion.setBounds(340, 116, 171, 23); 
		panel.add(comboBoxOcupacion);
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setBounds(259, 17, 57, 23);
		panel.add(lblEvento);
		
		comboBoxEvento = new JComboBox<String>();
		comboBoxEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			if(comboBoxEvento.getSelectedIndex()>0){
				
				
			}
			
			
			
			
			}
		});
		comboBoxEvento.setBounds(340, 17, 171, 23);
		panel.add(comboBoxEvento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(259, 150, 46, 23);
		panel.add(lblSexo);
		
		chckbxM = new JCheckBox("M");
		chckbxM.setBounds(374, 150, 38, 23);
		panel.add(chckbxM);
		chckbxM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(chckbxM.isSelected()==true)
				chckbxF.setSelected(false);
			}
		});
		
		
		chckbxF = new JCheckBox("F");
		chckbxF.setBounds(436, 150, 38, 23);
		panel.add(chckbxF);
		chckbxF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxF.isSelected()==true)
					chckbxM.setSelected(false);
				
			}
		});
		
		
		Editable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new TitledBorder(null, "Datos del Trabajo", TitledBorder.TOP, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 222, 521, 203);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 501, 170);
		tableModel = new DefaultTableModel(){

 			private static final long serialVersionUID = 1L;
 			boolean[] canEdit = new boolean[]{
 					false, false,false,false //solo se pone no editable la segunda columna
             };

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit[columnIndex];
             }
        	 
         };
		String[] columnNames = {"T�tulo", "�rea", "Idioma","Fecha Realizaci�n"};
		tableModel.setColumnIdentifiers(columnNames);
		panel_1.add(scrollPane);
		
		table = new JTable();scrollPane.setColumnHeaderView(table);
		table.setModel(tableModel);
		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(9, 209, 525, 2);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonAplicar = new JButton("Aplicar");
				ButtonAplicar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean continuar=true;
						Editable(false);
						int indice=0;
						txtCedula.setEditable(true);
						if(txtTelefono.getText().equalsIgnoreCase("(   )-   -    ")==true
								|txtNombre.getText()==""
								|txtApellido.getText()==""
								|txtNacionalidad.getText()==""
								|txtLocalidad.getText()==""
								){
							continuar=false;
							JOptionPane.showMessageDialog(null, "");
							
						}
						
						if(continuar==true){
							for(int i=0; i<Empresa.getInstances().getMisEventos().size(); i++){
								if(Empresa.getInstances().encontrarCedulaxEvento(txtCedula.getText(),i)==true){
									indice=i;
								}}
							int k=Empresa.getInstances().devolverIndicedeParticipantexCedula(txtCedula.getText(),indice);
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setNombre(txtNombre.getText());
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setTelefono(txtTelefono.getText());
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setApellido(txtApellido.getText());
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setNacionalidad(txtNacionalidad.getText());
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setLocalidad(txtLocalidad.getText());
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setOcupacion((String)comboBoxOcupacion.getSelectedItem()); 
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setDia(txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setMes((txtFecha.getCalendar().get(Calendar.MONTH)+1));
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setAnio(txtFecha.getCalendar().get(Calendar.YEAR));
							
							String sexo="";
							if(chckbxM.isSelected()==true){
								sexo="M";
							}
							if(chckbxF.isSelected()==true){
								sexo="F";
							}
							
							Empresa.getInstances().getMisEventos().get(indice).getMisParticipantes().get(k).setSexo(sexo);
							
							JOptionPane.showMessageDialog(null, "Participante modificado con �xito");
							try {
								Empresa.getInstances().generarFicheroDatos(Empresa.getInstances());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					
						
					
					}
				});
				ButtonAplicar.setIcon(new ImageIcon(Participantes.class.getResource("/imagenes/boton aplicar.png")));
				ButtonAplicar.setActionCommand("Cancel");
				buttonPane.add(ButtonAplicar);
			}
			{
				JButton ButtonEditar = new JButton("Editar");
				ButtonEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Editable(true);
						txtCedula.setEditable(false);
						comboBoxEvento.setEnabled(false);
						
					
					}
				});
				ButtonEditar.setIcon(new ImageIcon(Participantes.class.getResource("/imagenes/boton editar.png")));
				ButtonEditar.setActionCommand("Cancel");
				buttonPane.add(ButtonEditar);
			}
			{
				JButton ButtonCancelar = new JButton("Cancelar");
				ButtonCancelar.setIcon(new ImageIcon(Participantes.class.getResource("/imagenes/boton cancelar.png")));
				ButtonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				ButtonCancelar.setActionCommand("OK");
				buttonPane.add(ButtonCancelar);
				getRootPane().setDefaultButton(ButtonCancelar);
			}
		}
	}
	
	public void cargartrabajo(Participante e){
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i< numeroEventos.size() ;i++) {
			for (int q = 0; q< e.getMisTrabajos().size() ;q++) {
			fila[0] = e.getMisTrabajos().get(q).getTitulo();
			fila[1] = e.getMisTrabajos().get(q).getArea().getNombre();
			fila[2] = e.getMisTrabajos().get(q).getIdioma();
			fila[3] = e.getMisTrabajos().get(q).getFechaRealizacion();
			tableModel.addRow(fila);
		}}
		

	}
	
	public void buscaryCargar(){
		boolean continuar=false;
		numeroEventos = new ArrayList<Integer>();
		if(txtCedula.getText().equalsIgnoreCase("   -       - ")==false){
		
		for(int i=0; i<Empresa.getInstances().getMisEventos().size(); i++){
			if(Empresa.getInstances().encontrarCedulaxEvento(txtCedula.getText(),i)==true){
				numeroEventos.add(i);
				continuar=true;
			}
		}}
		
		if(txtCedula.getText().equalsIgnoreCase("   -       - ")==true){
			JOptionPane.showMessageDialog(null, "Digite una c�dula");
			txtCedula.setText("");
		}else{
		if(continuar==false){
			JOptionPane.showMessageDialog(null, "C�dula no encontrada");
			txtCedula.setText("");
		}}
		
		if(continuar==true){
			for(int i=0; i<numeroEventos.size(); i++){
				comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(numeroEventos.get(i)).getNombre());
			}
			
			Participante e= Empresa.getInstances().devolverParticipantexCedula(txtCedula.getText(), numeroEventos.get(0));
			txtTelefono.setText(e.getTelefono());
			txtApellido.setText(e.getApellido());
			txtLocalidad.setText(e.getLocalidad());
			txtNacionalidad.setText(e.getNacionalidad());
			txtNombre.setText(e.getNombre());
			comboBoxOcupacion.addItem(e.getOcupacion());
			comboBoxOcupacion.setSelectedIndex(0);
			cargartrabajo(e);
			if(e.getSexo().equalsIgnoreCase("M"))
				chckbxM.setSelected(true);
			
			if(e.getSexo().equalsIgnoreCase("F"))
				chckbxF.setSelected(true);
			
			String FR="";
			FR=Integer.toString(e.getDia())+"/";
			FR+=Integer.toString(e.getMes())+"/";
			FR+=Integer.toString(e.getAnio());
			String inputStr = FR;
			@SuppressWarnings("deprecation")
			Date date = new Date(inputStr);
			txtFecha.setDate(date);
			
			}
		
	}
	
	public void Editable(boolean n){
		txtTelefono.setEditable(n);
		txtNombre.setEditable(n);
		txtApellido.setEditable(n);
		txtNacionalidad.setEditable(n);
		txtLocalidad.setEditable(n);
		txtFecha.setEnabled(n);
		comboBoxOcupacion.setEnabled(n);
		comboBoxEvento.setEnabled(n);
		chckbxF.setEnabled(n);
		chckbxM.setEnabled(n);
	}
	
	
	
}
