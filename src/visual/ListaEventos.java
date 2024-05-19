package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.io.Serializable;
import javax.swing.JTable;
import Utilidades.CellRendererTableColor;
import logica.Empresa;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ListaEventos extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila;

	public ListaEventos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEventos.class.getResource("/imagenes/logo.png")));
		setTitle("Lista de Eventos");
		setBounds(100, 100, 806, 477);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		String[] columnNames = {"Tipo", "Nombre", "Lugar","Fecha","Hora Inicio","Hora final"};
		tableModel.setColumnIdentifiers(columnNames);
		//loadParticipantes();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237), 1, true), "Lista de Eventos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 11, 771, 399);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 38, 698, 343);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		regularSize();
		loadEventos();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(7, 18, 756, 374);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ListaEventos.class.getResource("/imagenes/fond eventos.png")));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(4, 410, 780, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			

			{
				JButton ButtonOK = new JButton("OK");
				ButtonOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					dispose();
					}
				});
				ButtonOK.setIcon(new ImageIcon(ListaEventos.class.getResource("/imagenes/boton ok.png")));
				ButtonOK.setActionCommand("OK");
				buttonPane.add(ButtonOK);
				getRootPane().setDefaultButton(ButtonOK);
			}
		}
	}
	
	
	
	
	
	public static void loadEventos() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i< Empresa.getInstances().getMisEventos().size();i++) {
			fila[0] = Empresa.getInstances().getMisEventos().get(i).getTipo();
			fila[1] = Empresa.getInstances().getMisEventos().get(i).getNombre();
			fila[2] = Empresa.getInstances().getMisEventos().get(i).getLugar();
			String Fecha="";
			Fecha=Integer.toString(Empresa.getInstances().getMisEventos().get(i).getDia())+"/";
			Fecha+=Integer.toString(Empresa.getInstances().getMisEventos().get(i).getMes())+"/";
			Fecha+=Integer.toString(Empresa.getInstances().getMisEventos().get(i).getYear());
			fila[3] = Fecha;
			fila[4] = Empresa.getInstances().getMisEventos().get(i).getHoraInicio();
			fila[5] = Empresa.getInstances().getMisEventos().get(i).getHoraFinal();	
		
			tableModel.addRow(fila);
		}
	
		
	
	}
	
	public void regularSize(){
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(1).setMaxWidth(180);
		table.getColumnModel().getColumn(1).setMinWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		
	}
}
