package visual;

import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.Empresa;
import logica.Participante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

import Utilidades.CellRendererTableColor;

import java.awt.Toolkit;

public class ListaParticipantes extends JDialog implements Serializable{


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	private JTable table;
	static Object[] fila;
	
	private JComboBox<String> comboBoxEvento;
	private static int selEvento=0;

	public ListaParticipantes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaParticipantes.class.getResource("/imagenes/logo.png")));
		setTitle("Lista de participantes");
		setBounds(100, 100, 804, 493);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		tableModel = new DefaultTableModel(){

 			private static final long serialVersionUID = 1L;
 			boolean[] canEdit = new boolean[]{
 					false, false,false,false,false,false 
             };

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit[columnIndex];
             }
        	 
         };
		String[] columnNames = {"Cédula", "Nombre", "Apellido","Teléfono","Ocupación","Nacionalidad"};
		tableModel.setColumnIdentifiers(columnNames);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(-4, 430, 800, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton ButtonOK = new JButton("OK");
				ButtonOK.setIcon(new ImageIcon(ListaParticipantes.class.getResource("/imagenes/boton ok.png")));
				ButtonOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
					dispose();
					}
				});
				
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						if(comboBoxEvento.getSelectedIndex()>0){
							if(table.getSelectedRow()!=-1){
							Participante p1= Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(table.getSelectedRow());
							Empresa.getInstances().getMisEventos().get(selEvento).borrarParticipante(p1);
							JOptionPane.showMessageDialog(null, "Eliminado con éxito");
							loadParticipantes();
							
							}
							else{
								JOptionPane.showMessageDialog(null, "Seleccione un participante");
							}
						}
						if(comboBoxEvento.getSelectedIndex()==0){
							JOptionPane.showMessageDialog(null, "Seleccione un evento");
							
						}
						
					
					}
				});
				btnBorrar.setIcon(new ImageIcon(ListaParticipantes.class.getResource("/imagenes/boton borrar.png")));
				buttonPane.add(btnBorrar);
				ButtonOK.setActionCommand("OK");
				buttonPane.add(ButtonOK);
				getRootPane().setDefaultButton(ButtonOK);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(176, 196, 222)));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 778, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 47, 695, 348);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(tableModel);
		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("Elegir el evento:");
		lblNewLabel.setBounds(44, 11, 235, 23);
		panel.add(lblNewLabel);
		
		comboBoxEvento = new JComboBox<String>();
		comboBoxEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(comboBoxEvento.getSelectedIndex()>0){
					selEvento=comboBoxEvento.getSelectedIndex()-1;
					loadParticipantes() ;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			
			}
		});
		comboBoxEvento.setBounds(144, 11, 251, 23);
		panel.add(comboBoxEvento);
		comboBoxEvento.addItem("<Seleccionar>");
		for(int i=0;i<Empresa.getInstances().getMisEventos().size() ;i++){
			comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListaParticipantes.class.getResource("/imagenes/fondolistadeparticipantes.png")));
		lblNewLabel_1.setBounds(0, 0, 778, 417);
		panel.add(lblNewLabel_1);

	}
	
	public static void loadParticipantes() {
		
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().size() ;i++) {
			fila[0] = Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(i).getCedula();
			fila[1] = Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(i).getNombre();
			fila[2] = Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(i).getApellido();
			fila[3] = Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(i).getTelefono();
			fila[4] = Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(i).getOcupacion();
			fila[5] = Empresa.getInstances().getMisEventos().get(selEvento).getMiparticipante().get(i).getNacionalidad();
			
			tableModel.addRow(fila);
		}
		
		
		
	}


}
