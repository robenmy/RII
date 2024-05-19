package visual;

import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import Utilidades.CELL_RENDERER;
import Utilidades.CellRendererTableColor;

import com.toedter.calendar.JDateChooser;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.ImageIcon;

import logica.Empresa;
import logica.Eventos;
import java.awt.event.KeyAdapter;

public class RegistrarEventos extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private static ArrayList<String> recurso;
	private MaskFormatter  hora;
	private static DefaultCellEditor defaultCellEditor1;
	private JComboBox<String> comboBoxTipo,comboBoxLugar ;
	private JDateChooser txtFecha ;
	private JFormattedTextField txtHoraInicio,txtHoraFinal;
	private JCheckBox checkBox;


	public RegistrarEventos() {
		setTitle("Registrar Evento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarEventos.class.getResource("/imagenes/logo.png")));
		setBounds(100, 100, 642, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		recurso = new  ArrayList<String>();
		recurso.add("Pizarra");
		recurso.add("Computadora");
		recurso.add("Planta Eléctrica");
		recurso.add("Proyector");
		recurso.add("Mesas");
		recurso.add("Sillas");
		recurso.add("Bocinas");
		recurso.add("Micrófonos");
		recurso.add("Parabanes");
		recurso.add("Podium");
		recurso.add("Adorno Central para Mesa Principal");
		recurso.add("Arboles Decorativos");
		
		
		try {
			hora = new MaskFormatter("##:##");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contentPanel.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 617, 267);
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBorder(new TitledBorder(null, "Datos del Evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(18, 65, 64, 23);
		panel.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(18, 145, 64, 23);
		panel.add(lblFecha);
		
		JLabel lblHoraDeInicio = new JLabel("Hora de inicio:");
		lblHoraDeInicio.setBounds(18, 185, 91, 23);
		panel.add(lblHoraDeInicio);
		
		JLabel lblHoraDe = new JLabel("Hora final:");
		lblHoraDe.setBounds(18, 225, 91, 23);
		panel.add(lblHoraDe);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(18, 25, 64, 23);
		panel.add(lblTipo);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(18, 105, 64, 23);
		panel.add(lblLugar);
		
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBounds(106, 25, 156, 23);
		comboBoxTipo.addItem("<Seleccionar>");
		comboBoxTipo.addItem("Seminario");
		comboBoxTipo.addItem("Panel");
		comboBoxTipo.addItem("Conversatorio");
		comboBoxTipo.addItem("Conferencia");
		comboBoxTipo.addItem("Mesa Redonda");
		panel.add(comboBoxTipo);
		
		comboBoxLugar = new JComboBox<String>();
		comboBoxLugar.setBounds(106, 105, 156, 23);
		comboBoxLugar.addItem("<Seleccionar>");
		comboBoxLugar.addItem("Estadio");
		comboBoxLugar.addItem("Multiusos");
		comboBoxLugar.addItem("Biblioteca");
		panel.add(comboBoxLugar);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(106, 145, 156, 23);
		panel.add(txtFecha);

		txtHoraInicio = new JFormattedTextField(hora);
		txtHoraInicio.setBounds(106, 185, 156, 23);
		panel.add(txtHoraInicio);
	
		txtHoraFinal = new JFormattedTextField(hora);
		txtHoraFinal.setBounds(106, 225, 156, 23);
		panel.add(txtHoraFinal);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
public void keyTyped(java.awt.event.KeyEvent evt) {
				
				char c = evt.getKeyChar();
				
				if((c<'a' || c>'z') && (c<'A' || c>'Z' )  )
					evt.consume();
			
					          } 
		});
		txtNombre.setBounds(106, 65, 156, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 26, 261, 215);
		
		tableModel = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[]{
                    true, false //solo se pone no editable la segunda columna
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
		};
		String[] columnNames = {" ", "Recursos"};
		tableModel.setColumnIdentifiers(columnNames);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setModel(tableModel);
		loadRecursos();
		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		

		
		checkBox = new JCheckBox();
		checkBox.setHorizontalAlignment(JLabel.CENTER);
		defaultCellEditor1=new DefaultCellEditor(checkBox);
		table.getColumnModel().getColumn(0).setCellEditor(defaultCellEditor1);
        table.getColumnModel().getColumn(0).setCellRenderer(new CELL_RENDERER());
        
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(SystemColor.activeCaption);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(300, 15, 1, 232);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(88, 145, 189, -52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegistrarEventos.class.getResource("/imagenes/fondoregistrarevento.png")));
		lblNewLabel_1.setBounds(0, 44, 617, 223);
		panel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(4, 280, 626, 35);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setBorder(null);
			{
				JButton ButtonRegistrar = new JButton("Registrar");
				ButtonRegistrar.setBounds(395, 5, 116, 26);
				ButtonRegistrar.setIcon(new ImageIcon(RegistrarEventos.class.getResource("/imagenes/boton registrar.png")));
				ButtonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					boolean continuar=true;
					if(txtNombre.getText()=="" 
							|comboBoxLugar.getSelectedIndex()==0
							|comboBoxTipo.getSelectedIndex()==0
							|txtHoraInicio.getText()==""
							|txtHoraFinal.getText()==""
							){
						continuar=false;
						JOptionPane.showMessageDialog(null, "Por favor rellene los campos vacios");
					}else{
					if(todosenFalse()==true){
						continuar=false;
						JOptionPane.showMessageDialog(null, "Por favor seleccione un recurso");
					}}
					
					if(continuar==true){
					Eventos e = new Eventos();
					e.setNombre(txtNombre.getText());
					e.setLugar((String)comboBoxLugar.getSelectedItem());
					e.setTipo((String)comboBoxTipo.getSelectedItem());
					e.setHoraInicio(txtHoraInicio.getText());
					e.setHoraFinal(txtHoraFinal.getText());
					e.setDia(txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
					e.setMes((txtFecha.getCalendar().get(Calendar.MONTH)+1));
					e.setYear(txtFecha.getCalendar().get(Calendar.YEAR));
					
					for(int i=0;i<recurso.size() ;i++){
						if((boolean)table.getValueAt(i, 0)==true){
							e.getMisRecursos().add(recurso.get(i));
						}
					}
						
					
					Empresa.getInstances().agregarEventos(e);
					JOptionPane.showMessageDialog(null, "Evento registrado con éxito");
					
					try {
						Empresa.getInstances().generarFicheroDatos(Empresa.getInstances());
					} catch (IOException q) {
						// TODO Auto-generated catch block
						q.printStackTrace();
					}
					
					limpiarCampos();
					
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
				ButtonCancelar.setBounds(515, 5, 106, 26);
				ButtonCancelar.setIcon(new ImageIcon(RegistrarEventos.class.getResource("/imagenes/boton cancelar.png")));
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
	
	public static void loadRecursos() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
			for (int i = 0; i< recurso.size();i++) {
				fila[0] = false;
				fila[1] = recurso.get(i);
				tableModel.addRow(fila);
							
			}
			
	}
	
		
	public boolean todosenFalse(){
		int valor=0;
		for(int i=0;i<recurso.size() ;i++){
			if((boolean)table.getValueAt(i, 0)==false){
				valor+=1;
			}
		}
		if(valor==recurso.size()){
			return true;
		}
		return false;
	}
	
	public void limpiarCampos(){
		txtNombre.setText("");
		comboBoxLugar.setSelectedIndex(0);
		comboBoxTipo.setSelectedIndex(0);
		txtHoraInicio.setText("");
		txtHoraFinal.setText("");
		txtFecha.setDate(null);
		loadRecursos();
	}
	
}
