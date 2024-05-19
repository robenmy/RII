package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;

import logica.Area;
import logica.Comision;
import logica.Empresa;

public class RegistrarComision extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumero;
	private JComboBox<String> comboBoxArea,comboBoxPresidente,comboBoxJuez1,comboBoxJuez2,comboBoxJuez3,comboBoxEvento;
	private int selEvento=0;

	public RegistrarComision() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarComision.class.getResource("/imagenes/logo.png")));
		setTitle("Registrar Comisi\u00F3n");
		setBounds(100, 100, 439, 281);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 11, 414, 202);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			
			JLabel lblArea = new JLabel("\u00C1rea:");
			lblArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblArea.setBounds(10, 67, 57, 23);
			panel.add(lblArea);
			
			
			JLabel lblComisinNo = new JLabel("Comisi\u00F3n N\u00FAmero:");
			lblComisinNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblComisinNo.setBounds(218, 67, 115, 23);
			panel.add(lblComisinNo);
			
			JLabel lblPresidente = new JLabel("Presidente:");
			lblPresidente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPresidente.setBounds(10, 112, 70, 23);
			panel.add(lblPresidente);
			
			JLabel lblJuez = new JLabel("Juez 1:");
			lblJuez.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblJuez.setBounds(10, 157, 57, 23);
			panel.add(lblJuez);
			
			
			JLabel lblJuez_1 = new JLabel("Juez 2:");
			lblJuez_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblJuez_1.setBounds(218, 112, 57, 23);
			panel.add(lblJuez_1);
			
			
			JLabel lblJuez_2 = new JLabel("Juez 3:");
			lblJuez_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblJuez_2.setBounds(218, 157, 57, 23);
			panel.add(lblJuez_2);
			
			
			txtNumero = new JTextField();
			txtNumero.setEditable(false);
			txtNumero.setColumns(10);
			txtNumero.setBounds(323, 67, 64, 23);
			panel.add(txtNumero);
			
			
			
			comboBoxArea = new JComboBox<String>();
			
			comboBoxArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtNumero.setText("1");
					try {
						if(Empresa.getInstances().getMisEventos().size()>0){
					for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size();i++){
						if(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getNombre().equalsIgnoreCase((String)comboBoxArea.getSelectedItem())){
							txtNumero.setText(Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getMisComisiones().size()+1));
							}
						}
					}
					} catch (ArrayIndexOutOfBoundsException e) {
						// TODO: handle exception
					}
					
				
				}
			});
			comboBoxArea.setBounds(79, 67, 118, 23);
			comboBoxArea.addItem("<Seleccione>");
			comboBoxArea.addItem("Fisica");
			comboBoxArea.addItem("Biologia");
			comboBoxArea.addItem("Matematicas");
			comboBoxArea.addItem("Quimica");
			comboBoxArea.addItem("Medicina");
			panel.add(comboBoxArea);
			
			
			comboBoxEvento = new JComboBox<String>();
			comboBoxEvento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBoxEvento.getSelectedIndex()>0)
					selEvento= comboBoxEvento.getSelectedIndex()-1;
					
										
				}
			});
			comboBoxEvento.setBounds(79, 23, 190, 23);
			comboBoxEvento.addItem("<Seleccione>");
			for(int i=0;i<Empresa.getInstances().getMisEventos().size() ;i++){
				comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
				
			}
			
			panel.add(comboBoxEvento);
			
			
			comboBoxPresidente = new JComboBox<String>();
			comboBoxPresidente.setBounds(79, 112, 118, 23);
			comboBoxPresidente.addItem("<Seleccione>");
			try {
				for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
					comboBoxPresidente.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
					
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			panel.add(comboBoxPresidente);
			
			comboBoxJuez1 = new JComboBox<String>();
			comboBoxJuez1.setBounds(77, 157, 118, 23);
			comboBoxJuez1.addItem("<Seleccione>");
			try {
				for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
					comboBoxJuez1.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
					
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			panel.add(comboBoxJuez1);
			
			comboBoxJuez2 = new JComboBox<String>();
			comboBoxJuez2.setBounds(269, 112, 118, 23);
			comboBoxJuez2.addItem("<Seleccione>");
			try {
				for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
					comboBoxJuez2.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
					
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			panel.add(comboBoxJuez2);
			
			comboBoxJuez3 = new JComboBox<String>();
			comboBoxJuez3.setBounds(269, 157, 118, 23);
			comboBoxJuez3.addItem("<Seleccione>");
			try {
				for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
					comboBoxJuez3.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
					
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			panel.add(comboBoxJuez3);
			
			JLabel lblEvento = new JLabel("Evento:");
			lblEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEvento.setBounds(10, 22, 57, 23);
			panel.add(lblEvento);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistrarComision.class.getResource("/imagenes/prueba2.png")));
			lblNewLabel.setBounds(-11, -11, 435, 224);
			panel.add(lblNewLabel);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton ButtonRegistrar = new JButton("Registrar");
				ButtonRegistrar.setIcon(new ImageIcon(RegistrarComision.class.getResource("/imagenes/boton registrar.png")));
				ButtonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					boolean continuar=true;
					if(comboBoxPresidente.getSelectedIndex()==comboBoxJuez1.getSelectedIndex()
							|comboBoxPresidente.getSelectedIndex()==comboBoxJuez2.getSelectedIndex()
							|comboBoxPresidente.getSelectedIndex()==comboBoxJuez3.getSelectedIndex()
							
							|comboBoxJuez1.getSelectedIndex()==comboBoxJuez3.getSelectedIndex()
							|comboBoxJuez1.getSelectedIndex()==comboBoxJuez2.getSelectedIndex()
							|comboBoxJuez1.getSelectedIndex()==comboBoxPresidente.getSelectedIndex()
							
							|comboBoxJuez2.getSelectedIndex()==comboBoxJuez3.getSelectedIndex()
							|comboBoxJuez2.getSelectedIndex()==comboBoxJuez1.getSelectedIndex()
							|comboBoxJuez2.getSelectedIndex()==comboBoxPresidente.getSelectedIndex()
							
							|comboBoxJuez3.getSelectedIndex()==comboBoxJuez1.getSelectedIndex()
							|comboBoxJuez3.getSelectedIndex()==comboBoxJuez2.getSelectedIndex()
							|comboBoxJuez3.getSelectedIndex()==comboBoxPresidente.getSelectedIndex()
							
							){
						continuar=false;
						JOptionPane.showMessageDialog(null, "El Juez o Presidente no deben compartir campos");
					}
					
					if(comboBoxPresidente.getSelectedIndex()==0 |comboBoxJuez1.getSelectedIndex()==0
							|comboBoxJuez2.getSelectedIndex()==0 | comboBoxJuez3.getSelectedIndex()==0 
							| comboBoxEvento.getSelectedIndex()==0 ){
						continuar=false;
						JOptionPane.showMessageDialog(null, "Hay un campo vacio, porfavor llenarlo para continuar");
					}
					if(Empresa.getInstances().unicoPresidente(Empresa.getInstances().getTodosLosJueces().get(comboBoxPresidente.getSelectedIndex()-1).getCedula())==true){
						continuar=false;
						JOptionPane.showMessageDialog(null, "El presidente elegido ya esta elegido como presidente en otra comisión");
					}
					if(continuar==true){
					Comision c= new Comision();
					c.setCodigo(txtNumero.getText());
					c.setArea((String)comboBoxArea.getSelectedItem());
					c.setPre(Empresa.getInstances().getTodosLosJueces().get(comboBoxPresidente.getSelectedIndex()-1));
					c.anadirJueces(Empresa.getInstances().getTodosLosJueces().get(comboBoxJuez1.getSelectedIndex()-1));
					c.anadirJueces(Empresa.getInstances().getTodosLosJueces().get(comboBoxJuez2.getSelectedIndex()-1));
					c.anadirJueces(Empresa.getInstances().getTodosLosJueces().get(comboBoxJuez3.getSelectedIndex()-1));
					
					if(Empresa.getInstances().buscarArea((String)comboBoxArea.getSelectedItem(),Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas())==true){
						int j=Empresa.getInstances().buscarAreaxindice((String)comboBoxArea.getSelectedItem(),Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas());
						Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(j).anadirComision(c);
					}
					else{
						Area a= new Area((String)comboBoxArea.getSelectedItem());
						a.anadirComision(c);
						Empresa.getInstances().getMisEventos().get(selEvento).anadirArea(a);
					}
					JOptionPane.showMessageDialog(null, "Comision agregada exitosamente");
					limpiarcampos();
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
				ButtonCancelar.setIcon(new ImageIcon(RegistrarComision.class.getResource("/imagenes/boton cancelar.png")));
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
	
	
	public void limpiarcampos(){
		comboBoxEvento.setSelectedIndex(0);
		comboBoxArea.setSelectedIndex(0);
		comboBoxPresidente.setSelectedIndex(0);
		comboBoxJuez1.setSelectedIndex(0);
		comboBoxJuez2.setSelectedIndex(0);
		comboBoxJuez3.setSelectedIndex(0);
		txtNumero.setText("");
		
	}
	

	
	
}
