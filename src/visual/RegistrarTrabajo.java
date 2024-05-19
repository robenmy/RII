package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;

import logica.Empresa;
import logica.Trabajo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarTrabajo extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitulo;
	private JFormattedTextField txtCedula;
	private JComboBox<String> comboBoxArea,comboBoxComision,comboBoxEvento,comboBoxIdioma;
	private JDateChooser txtFecha;
	private MaskFormatter patron;
	private int selEvento=0;


	public RegistrarTrabajo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarTrabajo.class.getResource("/imagenes/logo.png")));
		setTitle("Agregar Trabajo");
		setBounds(100, 100, 504, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		try {
			patron = new MaskFormatter("###-#######-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Trabajo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 292, 243);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblArea = new JLabel("\u00C1rea:");
		lblArea.setBounds(10, 79, 46, 23);
		panel.add(lblArea);
		
		JLabel lblComisin = new JLabel("Comisi\u00F3n:");
		lblComisin.setBounds(10, 110, 59, 23);
		panel.add(lblComisin);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 141, 46, 23);
		panel.add(lblTtulo);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(10, 172, 46, 23);
		panel.add(lblIdioma);
		
		JLabel lblFecha = new JLabel("Fecha de Realizaci\u00F3n:");
		lblFecha.setBounds(10, 207, 126, 23);
		panel.add(lblFecha);
		
		txtCedula = new JFormattedTextField(patron);
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					buscaryCargar();
		          }
			
			}
		});
		txtCedula.setBounds(94, 48, 158, 23);
		panel.add(txtCedula);
		
		comboBoxArea = new JComboBox<String>();
		comboBoxArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if(comboBoxArea.getSelectedIndex()>0){
						
						comboBoxComision.addItem("");
						comboBoxComision.removeAllItems();
						int ai=comboBoxArea.getSelectedIndex()-1;
						for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().size() ;i++){
							comboBoxComision.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(i).getCodigo());
							
						}
						comboBoxComision.setSelectedIndex(0);
						
					}
					if(comboBoxArea.getSelectedIndex()==0){
						comboBoxComision.addItem("");
						comboBoxComision.removeAllItems();
						
					}
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				
			}
		});
		comboBoxArea.setBounds(94, 79, 183, 23);
		panel.add(comboBoxArea);
		
		
		comboBoxComision = new JComboBox<String>();
		comboBoxComision.setBounds(94, 110, 183, 23);
		panel.add(comboBoxComision);
		
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(94, 141, 183, 23);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		
		comboBoxIdioma = new JComboBox<String>();
		comboBoxIdioma.setBounds(94, 172, 183, 23);
		comboBoxIdioma.addItem("<Seleccione>");
		comboBoxIdioma.addItem("Español");
		comboBoxIdioma.addItem("Ingles");
		comboBoxIdioma.addItem("Frances");
		comboBoxIdioma.addItem("Alemán");
		panel.add(comboBoxIdioma);
		
		
		JButton ButtonBuscar = new JButton("");
		ButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				buscaryCargar();
				
				
			}
		});
		ButtonBuscar.setIcon(new ImageIcon(RegistrarTrabajo.class.getResource("/imagenes/botonbuscar.png")));
		ButtonBuscar.setBounds(252, 48, 25, 23);
		ButtonBuscar.setBackground(new Color(230, 230, 250));
		ButtonBuscar.setBorderPainted(false);
		panel.add(ButtonBuscar);
		
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 48, 46, 23);
		panel.add(lblCdula);
		
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(141, 207, 136, 23);
		panel.add(txtFecha);
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setBounds(10, 17, 46, 23);
		panel.add(lblEvento);
		
		
		comboBoxEvento = new JComboBox<String>();
		comboBoxEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				if(comboBoxEvento.getSelectedIndex()>0){
					selEvento=comboBoxEvento.getSelectedIndex()-1;	
					comboBoxArea.addItem("");
					comboBoxArea.removeAllItems();
					comboBoxComision.addItem("");
					comboBoxComision.removeAllItems();
					comboBoxArea.addItem("<Seleccione>");
					for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size();i++){
						comboBoxArea.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getNombre());
					}
				}
				if(comboBoxEvento.getSelectedIndex()==0){
					comboBoxArea.addItem("");
					comboBoxArea.removeAllItems();
					comboBoxComision.addItem("");
					comboBoxComision.removeAllItems();
					}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			}
		});
		comboBoxEvento.setBounds(94, 17, 183, 23);
		panel.add(comboBoxEvento);
		comboBoxEvento.addItem("<Seleccione>");
		for(int i=0;i<Empresa.getInstances().getMisEventos().size() ;i++){
			comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
		}
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrarTrabajo.class.getResource("/imagenes/documento.png")));
		label.setBounds(301, 27, 189, 204);
		contentPanel.add(label);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonRegistrar = new JButton("Registrar");
				ButtonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean continuar=true;
						boolean encontrado=Empresa.getInstances().encontrarCedulaxEvento(txtCedula.getText(),selEvento);
						if(txtCedula.getText()=="" |comboBoxArea.getSelectedIndex()==0 |txtTitulo.getText()==""
								|comboBoxIdioma.getSelectedIndex()==0 |comboBoxEvento.getSelectedIndex()==0
								|txtFecha.getDate()==null){
							continuar=false;
							JOptionPane.showMessageDialog(null, "Por favor rellene los campos vacios");
							
						}
						if(encontrado==false){
							JOptionPane.showMessageDialog(null, "Participante no encontrado/registrado, por favor revise la cedula");
							txtCedula.setText("");
							continuar=false;
						}
						if(continuar==true){
							Trabajo t1= new Trabajo();
							t1.setParticipante(Empresa.getInstances().devolverParticipantexCedula(txtCedula.getText(),selEvento));
							
							t1.setIdioma((String)comboBoxIdioma.getSelectedItem());
							t1.setTitulo(txtTitulo.getText());
							int j=Empresa.getInstances().buscarAreaxindice((String)comboBoxArea.getSelectedItem(), Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas());
							t1.setArea(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(j));
							String FR="";
							FR=Integer.toString(txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH))+"/";
							FR+=Integer.toString((txtFecha.getCalendar().get(Calendar.MONTH)+1))+"/";
							FR+=Integer.toString(txtFecha.getCalendar().get(Calendar.YEAR));
							t1.setFechaRealizacion(FR);
							int l=Empresa.getInstances().devolverIndicedeParticipantexCedula(txtCedula.getText(),selEvento);
							Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(comboBoxArea.getSelectedIndex()-1).getMisComisiones().get(comboBoxComision.getSelectedIndex()).anadirTrabajos(t1);
							Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(l).anadirTrabajos(t1);
							
							JOptionPane.showMessageDialog(null, "Trabajo agregado con éxito");
							try {
								Empresa.getInstances().generarFicheroDatos(Empresa.getInstances());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							limpiarCampos();
						}
						
						
					}
				});
				ButtonRegistrar.setIcon(new ImageIcon(RegistrarTrabajo.class.getResource("/imagenes/boton registrar.png")));
				ButtonRegistrar.setActionCommand("OK");
				buttonPane.add(ButtonRegistrar);
				getRootPane().setDefaultButton(ButtonRegistrar);
			}
			{
				JButton ButtonCancelar = new JButton("Cancelar");
				ButtonCancelar.setIcon(new ImageIcon(RegistrarTrabajo.class.getResource("/imagenes/boton cancelar.png")));
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
		
		txtTitulo.setText("");
		comboBoxArea.addItem("");
		comboBoxArea.removeAllItems();
		comboBoxComision.addItem("");
		comboBoxComision.removeAllItems();
		txtCedula.setText("");
		comboBoxEvento.setSelectedIndex(0);		
		comboBoxIdioma.setSelectedIndex(0);		
		txtFecha.setDate(null);		
				
	}
	public void buscaryCargar(){
		boolean encontrado=Empresa.getInstances().encontrarCedulaxEvento(txtCedula.getText(),selEvento);
		if(encontrado==false){
			JOptionPane.showMessageDialog(null, "Participante no encontrado/registrado, por favor revise la cedula");
			txtCedula.setText("");
		}
		else{
			JOptionPane.showMessageDialog(null, "Participante encontrado, rellene los campos");
		}
		
	}
	
}
