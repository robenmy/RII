package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Utilidades.CellRendererTableColor;

import java.awt.Toolkit;
import java.io.Serializable;

import logica.Empresa;

public class Comisiones extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private static JComboBox<String> comboBoxArea,comboBoxPresidente,comboBoxJuez1,comboBoxJuez2 ;
	private static JComboBox<String> comboBoxEvento,comboBoxJuez3;
	


	private static JComboBox<String> comboBoxCNumero;
	private static int selEvento=0;

	public Comisiones() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Comisiones.class.getResource("/imagenes/logo.png")));
		setTitle("Comisiones");
		setBounds(100, 100, 436, 466);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(7, 222, 416, 2);
		contentPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de la Comisión", TitledBorder.TOP, TitledBorder.TOP, null, null));
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

		//------------------------------------------------------------------
		comboBoxArea = new JComboBox<String>();
		comboBoxArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				if(comboBoxArea.getSelectedIndex()>0){
				eliminarJueces();
				//cargarJueces();
				comboBoxCNumero.removeAllItems();
				int ai=comboBoxArea.getSelectedIndex()-1;
				for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().size() ;i++){
					
					comboBoxCNumero.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(i).getCodigo());
					
					
				}
				//comboBoxCNumero.setSelectedIndex(0);
				comboBoxPresidente.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(0).getPre().getNombre());
				comboBoxJuez1.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(0).getMisJueces().get(0).getNombre());
				comboBoxJuez2.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(0).getMisJueces().get(1).getNombre());
				comboBoxJuez3.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(0).getMisJueces().get(2).getNombre());
				loadTrabajos();
				}
				if(comboBoxArea.getSelectedIndex()==0){
					eliminarJueces();
					cargarJuecesEnBlanco();
					comisionesEnBlancoYEliminado();
					cleanTrabajos();
				}
				
				
			} catch (NullPointerException e) {
				// TODO: handle exception
			}catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
				
			
			}
		});
		comboBoxArea.setBounds(79, 67, 118, 23);
		panel.add(comboBoxArea);
		
		//--------------------------------------------------------------------	
		comboBoxEvento = new JComboBox<String>();
		comboBoxEvento.addItem("<Seleccione>");
		comboBoxEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				
			if(comboBoxEvento.getSelectedIndex()>0){
				selEvento=comboBoxEvento.getSelectedIndex()-1;
				Editable(true);
				cargarJuecesEnBlanco();
				eliminarJueces();
				comisionesEnBlancoYEliminado();
				Editable(false);
				comboBoxArea.addItem("");
				comboBoxArea.removeAllItems();
				comboBoxArea.addItem("<Seleccione>");
				for(int i=0;i<Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().size();i++){
					comboBoxArea.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(i).getNombre());
				}
			}
			if(comboBoxEvento.getSelectedIndex()==0){
				Editable(true);
				eliminarJueces();
				cargarJuecesEnBlanco();
				comisionesEnBlancoYEliminado();
				comboBoxArea.addItem("");
				comboBoxArea.removeAllItems();
				Editable(false);
				cleanTrabajos();
			}
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			
			
			}
		});
		comboBoxEvento.setBounds(77, 22, 196, 23);
		panel.add(comboBoxEvento);
		for(int i=0;i<Empresa.getInstances().getMisEventos().size() ;i++){
			comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
		}
		
		
		
		//-------------------------------------------------------------------------------
		comboBoxCNumero = new JComboBox<String>();
		comboBoxCNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				int ai=comboBoxArea.getSelectedIndex()-1;
				int k=comboBoxCNumero.getSelectedIndex();
				eliminarJueces();
				comboBoxPresidente.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getPre().getNombre());
				comboBoxJuez1.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisJueces().get(0).getNombre());
				comboBoxJuez2.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisJueces().get(1).getNombre());
				comboBoxJuez3.addItem(Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisJueces().get(2).getNombre());
				loadTrabajos();
			} catch (NullPointerException e) {
				// TODO: handle exception
			}catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
			
			}
		});
		comboBoxCNumero.setBounds(322, 68, 65, 20);
		panel.add(comboBoxCNumero);
		
		comboBoxPresidente = new JComboBox<String>();
		comboBoxPresidente.setBounds(79, 112, 118, 23);
		comboBoxPresidente.setEditable(false);
		panel.add(comboBoxPresidente);
		
		comboBoxJuez1 = new JComboBox<String>();
		comboBoxJuez1.setBounds(77, 157, 118, 23);
		comboBoxJuez1.setEditable(false);
		panel.add(comboBoxJuez1);
		
		comboBoxJuez2 = new JComboBox<String>();
		comboBoxJuez2.setBounds(269, 112, 118, 23);
		comboBoxJuez2.setEditable(false);
		panel.add(comboBoxJuez2);
		
		comboBoxJuez3 = new JComboBox<String>();
		comboBoxJuez3.setBounds(269, 157, 118, 23);
		comboBoxJuez3.setEditable(false);
		panel.add(comboBoxJuez3);
		

		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEvento.setBounds(10, 22, 57, 23);
		panel.add(lblEvento);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Comisiones.class.getResource("/imagenes/prueba2.png")));
		lblNewLabel.setBounds(-11, 0, 435, 202);
		panel.add(lblNewLabel);
		
		
		cargarJuecesEnBlanco();
		Editable(false);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Trabajos", TitledBorder.TOP, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 235, 411, 166);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 391, 134);
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Participante","Título","Idioma"};
		tableModel.setColumnIdentifiers(columnNames);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
		table.setModel(tableModel);
		table.setEnabled(false);
		
		scrollPane.setViewportView(table);
		
				
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonCancelar = new JButton("Salir");
				ButtonCancelar.setIcon(new ImageIcon(Comisiones.class.getResource("/imagenes/boton cancelar.png")));
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
	
	public void cargarJueces(){
		for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
			comboBoxPresidente.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
		}
		for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
			comboBoxJuez1.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
		}
		for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
			comboBoxJuez2.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());
		}
		for(int p=0;p<Empresa.getInstances().getTodosLosJueces().size();p++){
			comboBoxJuez3.addItem(Empresa.getInstances().getTodosLosJueces().get(p).getNombre());	
		}
		
	}
	public void cargarJuecesEnBlanco(){
		comboBoxPresidente.addItem("");
		comboBoxJuez1.addItem("");
		comboBoxJuez2.addItem("");
		comboBoxJuez3.addItem("");
	}
	public void eliminarJueces(){
		comboBoxPresidente.removeAllItems();
		comboBoxJuez1.removeAllItems();
		comboBoxJuez2.removeAllItems();
		comboBoxJuez3.removeAllItems();	
	}
	
	public void Editable(boolean h){
		comboBoxPresidente.setEnabled(h);
		comboBoxJuez1.setEnabled(h);
		comboBoxJuez2.setEnabled(h);
		comboBoxJuez3.setEnabled(h);
	}
	
	public void comisionesEnBlancoYEliminado(){
		comboBoxCNumero.removeAllItems();
		comboBoxCNumero.addItem("");
		
	}
	
	public static void loadTrabajos() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		int ai=comboBoxArea.getSelectedIndex()-1;
		int k=comboBoxCNumero.getSelectedIndex();
		for (int i = 0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisTrabajos().size();i++) {
			fila[0] = Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisTrabajos().get(i).getParticipante().getNombre();
			fila[1] = Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisTrabajos().get(i).getTitulo();
			fila[2] = Empresa.getInstances().getMisEventos().get(selEvento).getMisAreas().get(ai).getMisComisiones().get(k).getMisTrabajos().get(i).getIdioma();
			tableModel.addRow(fila);
		}
	}
	public static void cleanTrabajos() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
	}
	
	
	
}
