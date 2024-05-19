 package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;

import logica.Empresa;
import logica.Juez;
import java.awt.event.KeyAdapter;


public class RegistrarJuez extends JDialog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JTextField txtLocalidad;
	
	private JComboBox<String> txtOcupacion;
	private JFormattedTextField txtCedula,txtTelefono;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private JDateChooser txtFecha;
	private final JCheckBox checkMasculino, checkFemenino;

	public RegistrarJuez() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarJuez.class.getResource("/imagenes/logo.png")));
		setTitle("Registrar Juez");
		setBounds(100, 100, 452, 288);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();panel.setBorder(new TitledBorder(null, "Datos del Juez", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(new Color(230, 230, 250));
			panel.setBounds(10, 11, 426, 212);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setBounds(10, 17, 57, 23);
			panel.add(lblCdula);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 57, 63, 23);
			panel.add(lblNombre);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 97, 73, 23);
			panel.add(lblApellido);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10, 137, 46, 23);
			panel.add(lblSexo);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(214, 17, 63, 23);
			panel.add(lblTelfono);
			
			JLabel lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setBounds(214, 57, 83, 23);
			panel.add(lblNacionalidad);
			
			JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
			lblOcupacin.setBounds(214, 137, 83, 23);
			panel.add(lblOcupacin);
			
			JLabel lblLocalidad = new JLabel("Localidad:");
			lblLocalidad.setBounds(214, 97, 73, 23);
			panel.add(lblLocalidad);
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			lblFechaDeNacimiento.setBounds(10, 177, 132, 23);
			panel.add(lblFechaDeNacimiento);
			try {
				patron = new MaskFormatter("###-#######-#");
				tele = new MaskFormatter("(###)-###-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			txtCedula = new JFormattedTextField(patron);
			txtCedula.setBounds(67, 17, 120, 23);
			panel.add(txtCedula);
			
			txtTelefono = new JFormattedTextField(tele);
			txtTelefono.setBounds(293, 17, 120, 23);
			panel.add(txtTelefono);
			
			checkMasculino = new JCheckBox("M");
			checkMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				if(checkMasculino.isSelected()==true){
					checkFemenino.setSelected(false);
				}
				}
			});
			checkMasculino.setBounds(77, 137, 38, 23);
			panel.add(checkMasculino);
			
			checkFemenino = new JCheckBox("F");
			checkFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkFemenino.isSelected()==true){
						checkMasculino.setSelected(false);
					}
				}
			});
			checkFemenino.setBounds(139, 137, 38, 23);
			panel.add(checkFemenino);
			
			txtNombre = new JTextField();
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent evt) {
					
					char c = evt.getKeyChar();
					
					if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
						evt.consume();
				
						          } 
			});
			txtNombre.setBounds(67, 57, 120, 23);
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
			txtApellido.setBounds(67, 97, 120, 23);
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
			txtNacionalidad.setBounds(293, 57, 120, 23);
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
			txtLocalidad.setBounds(293, 97, 120, 23);
			panel.add(txtLocalidad);
			
			txtOcupacion =  new JComboBox<String>();
			txtOcupacion.setBounds(293, 137, 120, 23);
			txtOcupacion.addItem(" <Seleccione>");
			txtOcupacion.addItem("Estudiante");
			txtOcupacion.addItem("Ingeniero");
			txtOcupacion.addItem("Administrador");
			txtOcupacion.addItem("Matemático");
			txtOcupacion.addItem("Profesor");
			txtOcupacion.addItem("Médico");
			panel.add(txtOcupacion);
			
			txtFecha = new JDateChooser();
			txtFecha.setBounds(146, 177, 146, 23);
			panel.add(txtFecha);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistrarJuez.class.getResource("/imagenes/fondo de registrar juez.png")));
			lblNewLabel.setBounds(10, 11, 403, 189);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonRegistrar = new JButton("Registrar");
				ButtonRegistrar.setIcon(new ImageIcon(RegistrarJuez.class.getResource("/imagenes/boton registrar.png")));
				ButtonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean continuar=true;
						if(txtFecha.getDate()==null |txtCedula.getText().equalsIgnoreCase("   -       - ")
								|txtNombre.getText()=="" |txtApellido.getText()==""
								|txtNacionalidad.getText()=="" |txtLocalidad.getText()==""
								|txtOcupacion.getSelectedIndex()==0 |txtTelefono.getText().equalsIgnoreCase("(  )-   -    ")
								
								){
							continuar=false;
							JOptionPane.showMessageDialog(null, "Por favor rellene los campos vacios");
							
						}else{
						if(checkFemenino.isSelected()==false & checkMasculino.isSelected()==false
								){
							continuar=false;
							JOptionPane.showMessageDialog(null, "Seleccione un Sexo");
							
						}
						}
						if(continuar==true){
						String sexo="";
						if(checkMasculino.isSelected()==true){
							sexo="M";
						}
						if(checkFemenino.isSelected()==true){
							sexo="F";
						}
					
						
						Juez j1= new Juez(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(),
							(String)txtOcupacion.getSelectedItem(), txtNacionalidad.getText(), 
							txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH), 
							(txtFecha.getCalendar().get(Calendar.MONTH)+1), 
							txtFecha.getCalendar().get(Calendar.YEAR), 
							sexo, txtApellido.getText(), txtLocalidad.getText());
						
						 
						Empresa.getInstances().agregarJuez(j1);
						JOptionPane.showMessageDialog(null, "Juez Agregado Satisfactoriamente");
						limpiarCampos();
						try {
							Empresa.getInstances().generarFicheroDatos(Empresa.getInstances());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						
						
						
					}
				});
				ButtonRegistrar.setActionCommand("OK");
				buttonPane.add(ButtonRegistrar);
				getRootPane().setDefaultButton(ButtonRegistrar);
			}
			{
				JButton ButtonCancelar = new JButton("Cancelar");
				ButtonCancelar.setIcon(new ImageIcon(RegistrarJuez.class.getResource("/imagenes/boton cancelar.png")));
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
		txtNombre.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		txtOcupacion.setSelectedIndex(0);
		txtNacionalidad.setText("");
		txtApellido.setText("");
		txtLocalidad.setText("");
		txtFecha.setDate(null);
		checkFemenino.setSelected(false);
		checkMasculino.setSelected(false);
	}
	
	
}
