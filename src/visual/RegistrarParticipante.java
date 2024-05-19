package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;

import logica.Empresa;
import logica.Participante;
import logica.Trabajo;

import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;

public class RegistrarParticipante extends JDialog implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JTextField txtLocalidad;
	private JTextField txtTitulo;
	private JComboBox<String> comboBoxOcupacion,comboBoxIdioma ;
	private JFormattedTextField txtCedula, txtTelefono;
	private final JCheckBox CBMasculino, CBFemenino;
	private MaskFormatter patron, tele;
	private final JDateChooser txtFecha, txtFecha2;
	private final JComboBox<String> comboBoxArea,comboBoxCNumero,comboBoxEvento;
	private int selEvento=0;


	public RegistrarParticipante() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarParticipante.class.getResource("/imagenes/logo.png")));
		setTitle("Registrar Participante");
		setBounds(100, 100, 494, 404);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Participante", TitledBorder.TOP, TitledBorder.TOP, null, null));
			panel.setBackground(new Color(230, 230, 250));
			panel.setBounds(10, 163, 468, 176);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setBounds(10, 17, 57, 23);
			panel.add(lblCdula);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 48, 63, 23);
			panel.add(lblNombre);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 79, 73, 23);
			panel.add(lblApellido);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10, 110, 46, 23);
			panel.add(lblSexo);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(227, 17, 63, 23);
			panel.add(lblTelfono);
			
			JLabel lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setBounds(227, 48, 83, 23);
			panel.add(lblNacionalidad);
			
			JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
			lblOcupacin.setBounds(227, 110, 83, 23);
			panel.add(lblOcupacin);
			
			JLabel lblLocalidad = new JLabel("Localidad:");
			lblLocalidad.setBounds(227, 79, 73, 23);
			panel.add(lblLocalidad);
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			lblFechaDeNacimiento.setBounds(10, 141, 132, 23);
			panel.add(lblFechaDeNacimiento);
			
			txtCedula = new JFormattedTextField(patron);
			txtCedula.setBounds(67, 17, 137, 23);
			panel.add(txtCedula);
			
			txtTelefono = new JFormattedTextField(tele);
			txtTelefono.setBounds(320, 17, 137, 23);
			panel.add(txtTelefono);
			
			CBMasculino = new JCheckBox("M");
			CBMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(CBMasculino.isSelected()==true){
						CBFemenino.setSelected(false);
					}
				}
			});
			CBMasculino.setBounds(77, 109, 38, 23);
			panel.add(CBMasculino);
			
			CBFemenino = new JCheckBox("F");
			CBFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(CBFemenino.isSelected()==true){
						CBMasculino.setSelected(false);	
					}
					
				}
			});
			CBFemenino.setBounds(139, 110, 38, 23);
			panel.add(CBFemenino);
			
			
			CBFemenino.setSelected(false);
			CBMasculino.setSelected(false);
			
			txtNombre = new JTextField();
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent evt) {
					
					char c = evt.getKeyChar();
					
					if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
						evt.consume();
				
						          } 
			});
			txtNombre.setBounds(67, 49, 137, 23);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
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
			txtApellido.setBounds(67, 82, 137, 23);
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
			txtNacionalidad.setBounds(320, 48, 137, 23);
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
			txtLocalidad.setBounds(320, 79, 137, 23);
			panel.add(txtLocalidad);
			
			txtFecha = new JDateChooser();
			txtFecha.setBounds(146, 141, 164, 23);
			panel.add(txtFecha);
			
			comboBoxOcupacion = new JComboBox<String>();
			comboBoxOcupacion.setBounds(320, 110, 137, 23);
			comboBoxOcupacion.addItem("<Seleccione>");
			comboBoxOcupacion.addItem("Estudiante");
			comboBoxOcupacion.addItem("Ingeniero");
			comboBoxOcupacion.addItem("Administrador");
			comboBoxOcupacion.addItem("Matemático");
			comboBoxOcupacion.addItem("Profesor");
			comboBoxOcupacion.addItem("Médico");
			
			panel.add(comboBoxOcupacion);
			
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			panel.setBorder(new TitledBorder(null, "Datos del Trabajo", TitledBorder.TOP, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 468, 131);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblArea = new JLabel("\u00C1rea:");
			lblArea.setBounds(10, 57, 57, 23);
			panel.add(lblArea);
			
			JLabel lblComisin = new JLabel("Comisi\u00F3n:");
			lblComisin.setBounds(227, 23, 57, 23);
			panel.add(lblComisin);
			
			JLabel lblIdioma = new JLabel("Idioma:");
			lblIdioma.setBounds(10, 91, 57, 23);
			panel.add(lblIdioma);
			
			JLabel lblFechaDeRealizacin = new JLabel("Fecha de Realizaci\u00F3n:");
			lblFechaDeRealizacin.setBounds(227, 91, 139, 23);
			panel.add(lblFechaDeRealizacin);
			
			JLabel lblTtulo = new JLabel("T\u00EDtulo:");
			lblTtulo.setBounds(227, 57, 57, 23);
			panel.add(lblTtulo);
			
			comboBoxArea = new JComboBox<String>();
			comboBoxArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						
						if(comboBoxArea.getSelectedIndex()>0){
							
							comboBoxCNumero.addItem("");
							comboBoxCNumero.removeAllItems();
							int ai=comboBoxArea.getSelectedIndex()-1;
							for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().size() ;i++){
								comboBoxCNumero.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(i).getCodigo());
								
							}
							comboBoxCNumero.setSelectedIndex(0);
							
						}
						if(comboBoxArea.getSelectedIndex()==0){
							comboBoxCNumero.addItem("");
							comboBoxCNumero.removeAllItems();
							
						}
						
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				
				}
			});
			comboBoxArea.setBounds(70, 57, 137, 23);
			comboBoxArea.addItem("<Seleccione>");
			panel.add(comboBoxArea);
			
			comboBoxCNumero = new JComboBox<String>();
			comboBoxCNumero.setBounds(320, 23, 137, 23);
			comboBoxCNumero.addItem("<Seleccione>");
			panel.add(comboBoxCNumero);
			
			txtTitulo = new JTextField();
			txtTitulo.setColumns(10);
			txtTitulo.setBounds(320, 57, 137, 23);
			panel.add(txtTitulo);
			
			txtFecha2 = new JDateChooser();
			txtFecha2.setBounds(355, 91, 102, 23);
			panel.add(txtFecha2);
			
			comboBoxIdioma = new JComboBox<String>();
			comboBoxIdioma.setBounds(70, 91, 137, 23);
			comboBoxIdioma.addItem("<Seleccione>");
			comboBoxIdioma.addItem("Español");
			comboBoxIdioma.addItem("Ingles");
			comboBoxIdioma.addItem("Frances");
			comboBoxIdioma.addItem("Alemán");
			panel.add(comboBoxIdioma);
			
			JLabel lblEvento = new JLabel("Evento:");
			lblEvento.setBounds(10, 23, 57, 23);
			panel.add(lblEvento);
			
			comboBoxEvento = new JComboBox<String>();
			comboBoxEvento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(comboBoxEvento.getSelectedIndex()>0){
							selEvento=comboBoxEvento.getSelectedIndex()-1;	
							comboBoxArea.addItem("");
							comboBoxArea.removeAllItems();
							comboBoxCNumero.addItem("");
							comboBoxCNumero.removeAllItems();
							comboBoxArea.addItem("<Seleccione>");
							for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size();i++){
								comboBoxArea.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getNombre());
							}
						}
						if(comboBoxEvento.getSelectedIndex()==0){
							comboBoxArea.addItem("");
							comboBoxArea.removeAllItems();
							comboBoxCNumero.addItem("");
							comboBoxCNumero.removeAllItems();
							}
					} catch (Exception e) {
						// TODO: handle exception
					}

				
					
					
				}
			});
			comboBoxEvento.setBounds(70, 24, 137, 23);
			panel.add(comboBoxEvento);
			comboBoxEvento.addItem("<Seleccione>");
			for(int i=0; i< Empresa.getInstances().getMisEventos().size(); i++){
				comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
			}
		}
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(10, 150, 465, 2);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(3, 339, 478, 33);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setBorder(null);
			{
				JButton ButtonRegistrar = new JButton("Registrar");
				ButtonRegistrar.setBounds(246, 5, 119, 26);
				ButtonRegistrar.setIcon(new ImageIcon(RegistrarParticipante.class.getResource("/imagenes/boton registrar.png")));
				ButtonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean continuar=true;
						for(int i=0; i<Empresa.getInstances().getMisEventos().size(); i++){
							if(Empresa.getInstances().encontrarCedulaxEvento(txtCedula.getText(),i)==true){
								continuar=false;
								JOptionPane.showMessageDialog(null, "Hay un participante registrado con esta cedula");
							}
						}
						if(comboBoxEvento.getSelectedIndex()==0| comboBoxArea.getSelectedIndex()==0
								|comboBoxIdioma.getSelectedIndex()==0|txtTitulo.getText()==""
								|txtFecha.getDate()==null |txtCedula.getText()==""
								|txtNombre.getText()=="" |txtApellido.getText()==""
								|txtNacionalidad.getText()=="" |txtLocalidad.getText()==""
								|comboBoxOcupacion.getSelectedIndex()==0 |txtFecha2.getDate()==null							
								){
							
							continuar=false;
							JOptionPane.showMessageDialog(null, "Por favor rellene los campos vacios");
						}
												
						if(CBMasculino.isSelected()==false & CBFemenino.isSelected()==false){
							continuar=false;
							JOptionPane.showMessageDialog(null, "Seleccione una opción para el sexo");
						}
						
						
						
						
						if(continuar==true){
						String sexo="";
						if(CBMasculino.isSelected()==true){
							sexo="M";
						}
						if(CBFemenino.isSelected()==true){
							sexo="F";
						}
						Participante p= new Participante(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), 
							(String)comboBoxOcupacion.getSelectedItem(), txtNacionalidad.getText(),
							txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH), 
							(txtFecha.getCalendar().get(Calendar.MONTH)+1), 
							txtFecha.getCalendar().get(Calendar.YEAR), 
							sexo, txtApellido.getText(), txtLocalidad.getText());
						
						Trabajo t1= new Trabajo();
						t1.setIdioma((String)comboBoxIdioma.getSelectedItem());
						t1.setParticipante(p);
						t1.setTitulo(txtTitulo.getText());
						int j=Empresa.getInstances().buscarAreaxindice((String)comboBoxArea.getSelectedItem(), Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas());
						t1.setArea(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(j));
						
						String FR="";
						FR=Integer.toString(txtFecha2.getCalendar().get(Calendar.DAY_OF_MONTH))+"/";
						FR+=Integer.toString((txtFecha2.getCalendar().get(Calendar.MONTH)+1))+"/";
						FR+=Integer.toString(txtFecha2.getCalendar().get(Calendar.YEAR));
						t1.setFechaRealizacion(FR);
						p.anadirTrabajos(t1);
						Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(comboBoxArea.getSelectedIndex()-1).getMisComisiones().get(comboBoxCNumero.getSelectedIndex()).anadirTrabajos(t1);
						Empresa.getInstances().getMisEventos().get(selEvento).anadirParticipante(p);
						JOptionPane.showMessageDialog(null, "Participante agregado exitosamente");
						try {
							Empresa.getInstances().generarFicheroDatos(Empresa.getInstances());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						limpiarCampos();
						for(int i=0;i< Empresa.getInstances().getMisEventos().size();i++){
							Collections.sort(Empresa.getInstances().getMisEventos().get(i).getMisParticipantes());
						}
						}
					}
				});
				buttonPane.setLayout(null);
				ButtonRegistrar.setActionCommand("OK");
				buttonPane.add(ButtonRegistrar);
				getRootPane().setDefaultButton(ButtonRegistrar);
			}
			{
				JButton ButtonCancelar = new JButton("Cancelar");
				ButtonCancelar.setBounds(368, 5, 105, 26);
				ButtonCancelar.setIcon(new ImageIcon(RegistrarParticipante.class.getResource("/imagenes/boton cancelar.png")));
				ButtonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				ButtonCancelar.setActionCommand("Cancel");
				buttonPane.add(ButtonCancelar);
			}
		}
	}
	
	public void limpiarCampos(){
		txtApellido.setText("");
		txtCedula.setText("");
		txtLocalidad.setText("");
		txtNacionalidad.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtTitulo.setText("");
		comboBoxArea.removeAllItems();
		comboBoxCNumero.removeAllItems();
		comboBoxEvento.setSelectedIndex(0);
		comboBoxIdioma.setSelectedIndex(0);
		comboBoxOcupacion.setSelectedIndex(0);
		txtFecha.setDate(null);
		txtFecha2.setDate(null);
	}
}


