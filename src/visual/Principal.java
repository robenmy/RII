package visual;



import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Utilidades.AbrirAyuda;
import Utilidades.CellRendererTableColor;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;




import logica.Empresa;




import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Principal extends JFrame implements Serializable{
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Dimension dimention;
	private JTable table;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private JTextField txtTipo,txtHoraFinal,txtHoradeInicio,txtFecha,txtLugar;
	private JComboBox<String> comboBoxEvento;
	private static int selEvento=0;
	private DefaultPieDataset data1 ;
	private DefaultCategoryDataset dataset ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Principal() throws ClassNotFoundException, IOException {
		setTitle("Eventos RII");
		Empresa.getInstances().abrirFicheroDatos();
		setResizable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 431);
		
		dimention = super.getToolkit().getScreenSize(); 
		dimention.setSize(super.getToolkit().getScreenSize().getWidth(), super.getToolkit().getScreenSize().getHeight());
		//super.setSize(dimention);
		super.setMinimumSize(dimention);
		
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setJMenuBar(menuBar);
				
		JMenu mnEvento = new JMenu("Evento");
		mnEvento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuBar.add(mnEvento);
		
		JMenuItem mntmRegistrarEvento = new JMenuItem("Registrar Evento");
		mntmRegistrarEvento.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/IconoregEvento.png")));
		mntmRegistrarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarEventos RegEventos = new RegistrarEventos();
				RegEventos.setLocationRelativeTo(null);
				RegEventos.setResizable(false);
				RegEventos.setModal(true);
				RegEventos.setVisible(true);
				RegEventos.setResizable(false);
			
			
			}
		});
		
		JMenuItem mntmEventos = new JMenuItem("Eventos");
		mntmEventos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/IconoEventos.png")));
		mntmEventos.setHorizontalAlignment(SwingConstants.LEFT);
		mntmEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eventos eventos = new Eventos();
				eventos.setLocationRelativeTo(null);
				eventos.setResizable(false);
				eventos.setModal(true);
				eventos.setVisible(true);
				eventos.setResizable(false);
			
			}
		});
		mnEvento.add(mntmEventos);
		mnEvento.add(mntmRegistrarEvento);
		
		JMenuItem mntmListaDeEventos = new JMenuItem("Lista de Eventos");
		mntmListaDeEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaEventos ListEventos = new ListaEventos();
				ListEventos.setLocationRelativeTo(null);
				ListEventos.setResizable(false);
				ListEventos.setModal(true);
				ListEventos.setVisible(true);
				ListEventos.setResizable(false);
			
			}
		});
		mnEvento.add(mntmListaDeEventos);
		
		JMenu mnParticipante = new JMenu("Participante");
		mnParticipante.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuBar.add(mnParticipante);
		
		JMenuItem mntmRegistrarParticipante = new JMenuItem("Registrar participante");
		mntmRegistrarParticipante.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Iconoparticipante.png")));
		mntmRegistrarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(Empresa.getInstances().getMisEventos().size()==0){
				JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
			}				
			if(Empresa.getInstances().getMisEventos().size()>0){	
			RegistrarParticipante RegParticipante= new RegistrarParticipante();
			RegParticipante.setLocationRelativeTo(null);
			RegParticipante.setResizable(false);
			RegParticipante.setModal(true);
			RegParticipante.setVisible(true);
			RegParticipante.setResizable(false);
			}
			}
		});
		mnParticipante.add(mntmRegistrarParticipante);
		
		JLabel label = new JLabel("");
		mnParticipante.add(label);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Trabajo");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Iconotrabajos.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Empresa.getInstances().getMisEventos().size()==0){
					JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
				}
				if(Empresa.getInstances().getMisEventos().size()>0){	
			RegistrarTrabajo RegTrabajo = new RegistrarTrabajo();
			RegTrabajo.setLocationRelativeTo(null);
			RegTrabajo.setResizable(false);
			RegTrabajo.setModal(true);
			RegTrabajo.setVisible(true);
			RegTrabajo.setResizable(false);
			}
			}
		});
		mnParticipante.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Participantes ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Empresa.getInstances().getMisEventos().size()==0){
					JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
				}
				if(Empresa.getInstances().getMisEventos().size()>0){	
				Participantes participantes = new Participantes();
			participantes.setLocationRelativeTo(null);
			participantes.setResizable(false);
			participantes.setModal(true);
			participantes.setVisible(true);
			participantes.setResizable(false);
			}
				}
		});
		mnParticipante.add(mntmNewMenuItem_1);
		
		JMenuItem mntmListadoDeParticipantes = new JMenuItem("Listado de Participantes");
		mntmListadoDeParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaParticipantes ListaPart =new ListaParticipantes();
				ListaPart.setLocationRelativeTo(null);
				ListaPart.setResizable(false);
				ListaPart.setModal(true);
				ListaPart.setVisible(true);
				ListaPart.setResizable(false);
			
			}
		});
		mnParticipante.add(mntmListadoDeParticipantes);
		
		JMenu mnJuez = new JMenu("Juez");
		mnJuez.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuBar.add(mnJuez);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Juez");
		mntmRegistrar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Iconojuez.png")));
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			RegistrarJuez RegJuez = new RegistrarJuez();
			RegJuez.setLocationRelativeTo(null);
			RegJuez.setResizable(false);
			RegJuez.setModal(true);
			RegJuez.setVisible(true);
			RegJuez.setResizable(false);
			
			}
		});
		mnJuez.add(mntmRegistrar);
		
		JMenuItem mntmListadoDeJueces = new JMenuItem("Listado de Jueces");
		mntmListadoDeJueces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadeJueces ListaJuez = new ListadeJueces();
				ListaJuez.setLocationRelativeTo(null);
				ListaJuez.setResizable(false);
				ListaJuez.setModal(true);
				ListaJuez.setVisible(true);
				ListaJuez.setResizable(false);
			
			}
		});
		mnJuez.add(mntmListadoDeJueces);
		
		JMenu mnComisin = new JMenu("Comisi\u00F3n");
		mnComisin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuBar.add(mnComisin);
		
		JMenuItem mntmRegistrarComisin = new JMenuItem("Registrar Comisi\u00F3n");
		mntmRegistrarComisin.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icono comision.png")));
		mntmRegistrarComisin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Empresa.getInstances().getMisEventos().size()==0){
					JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
				}
				if(Empresa.getInstances().getMisEventos().size()>0){
				RegistrarComision RegComision = new RegistrarComision();
			RegComision.setLocationRelativeTo(null);
			RegComision.setResizable(false);
			RegComision.setModal(true);
			RegComision.setVisible(true);
			RegComision.setResizable(false);
				}
			}
		});
		mnComisin.add(mntmRegistrarComisin);
		
		JMenuItem mntmComisiones = new JMenuItem("Comisiones");
		mntmComisiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Comisiones comisiones = new Comisiones();
			comisiones.setLocationRelativeTo(null);
			comisiones.setResizable(false);
			comisiones.setModal(true);
			comisiones.setVisible(true);
			comisiones.setResizable(false);
			}
		});
		mnComisin.add(mntmComisiones);
		
		JMenu mnGrficos = new JMenu("Gr\u00E1ficos");
		menuBar.add(mnGrficos);
		
		JMenuItem mntmActualizarGrficos = new JMenuItem("Actualizar gr\u00E1ficos");
		mntmActualizarGrficos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarPastel();
				for(int i=0;i< Empresa.getInstances().getMisEventos().size();i++){
					Collections.sort(Empresa.getInstances().getMisEventos().get(i).getMisParticipantes());
				}
				 
						 }
		});
		mnGrficos.add(mntmActualizarGrficos);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmInformacinGeneral = new JMenuItem("Informaci\u00F3n General");
		mntmInformacinGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbrirAyuda ayuda=new AbrirAyuda();
				  ayuda.cargarArchivo();
				
			}
		});
		mnAyuda.add(mntmInformacinGeneral);
		contentPane = 
		new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1365, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JButton ButtonEventos = new JButton("");
		ButtonEventos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/IconoEventos.png")));
		ButtonEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Eventos eventos = new Eventos();
				eventos.setLocationRelativeTo(null);
				eventos.setResizable(false);
				eventos.setModal(true);
				eventos.setVisible(true);
				eventos.setResizable(false);	
				
			}
		});
		ButtonEventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ButtonEventos.setBackground(new Color(100, 149, 237));
				ButtonEventos.setToolTipText("Eventos");
				
				
			}
			public void mouseExited(MouseEvent e){
				ButtonEventos.setBackground(new Color(176, 196, 222));
				
			}
		});
		ButtonEventos.setBounds(5, 4, 25, 22);
		ButtonEventos.setBorderPainted(false);
		ButtonEventos.setBackground(new Color(176, 196, 222));
		panel.add(ButtonEventos);
		
		final JButton buttonRegEvento = new JButton("");
		buttonRegEvento.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/IconoregEvento.png")));
		buttonRegEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarEventos reventos = new RegistrarEventos();
				reventos.setLocationRelativeTo(null);
				reventos.setResizable(false);
				reventos.setModal(true);
				reventos.setVisible(true);
				reventos.setResizable(false);
				
			}
		});
		buttonRegEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buttonRegEvento.setBackground(new Color(100, 149, 237));
				buttonRegEvento.setToolTipText("Registrar Evento");
			}
			public void mouseExited(MouseEvent e){
				buttonRegEvento.setBackground(new Color(176, 196, 222));
				
			}
		});
		buttonRegEvento.setBounds(40, 4, 25, 22);
		buttonRegEvento.setBorderPainted(false);
		buttonRegEvento.setBackground(new Color(176, 196, 222));
		panel.add(buttonRegEvento);
		
		final JButton buttonParticipante = new JButton("");
		buttonParticipante.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Iconoparticipante.png")));
		buttonParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Empresa.getInstances().getMisEventos().size()==0){
					JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
				}				
				if(Empresa.getInstances().getMisEventos().size()>0){	
				RegistrarParticipante RegParticipante= new RegistrarParticipante();
				RegParticipante.setLocationRelativeTo(null);
				RegParticipante.setResizable(false);
				RegParticipante.setModal(true);
				RegParticipante.setVisible(true);
				RegParticipante.setResizable(false);
				}
				}
		});
		buttonParticipante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buttonParticipante.setBackground(new Color(100, 149, 237));
				buttonParticipante.setToolTipText("Registrar Participante");
			}
			public void mouseExited(MouseEvent e){
				buttonParticipante.setBackground(new Color(176, 196, 222));
				
			}
		});
		buttonParticipante.setBounds(82, 4, 25, 22);
		buttonParticipante.setBorderPainted(false);
		buttonParticipante.setBackground(new Color(176, 196, 222));
		panel.add(buttonParticipante);
		
		final JButton buttonTrabajo = new JButton("");
		buttonTrabajo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Iconotrabajos.png")));
		buttonTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Empresa.getInstances().getMisEventos().size()==0){
					JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
				}
				if(Empresa.getInstances().getMisEventos().size()>0){	
			RegistrarTrabajo RegTrabajo = new RegistrarTrabajo();
			RegTrabajo.setLocationRelativeTo(null);
			RegTrabajo.setResizable(false);
			RegTrabajo.setModal(true);
			RegTrabajo.setVisible(true);
			RegTrabajo.setResizable(false);
			}
			}
		});
		buttonTrabajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buttonTrabajo.setBackground(new Color(100, 149, 237));
				buttonTrabajo.setToolTipText("Agregar Trabajo");
			}
			public void mouseExited(MouseEvent e){
				buttonTrabajo.setBackground(new Color(176, 196, 222));
				
			}
		});
		buttonTrabajo.setBounds(117, 4, 25, 22);
		buttonTrabajo.setBorderPainted(false);
		buttonTrabajo.setBackground(new Color(176, 196, 222));
		panel.add(buttonTrabajo);
		
		final JButton buttonJuez = new JButton("");
		buttonJuez.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Iconojuez.png")));
		buttonJuez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarJuez RegJuez = new RegistrarJuez();
				RegJuez.setLocationRelativeTo(null);
				RegJuez.setResizable(false);
				RegJuez.setModal(true);
				RegJuez.setVisible(true);
				RegJuez.setResizable(false);
				
				}
		});
		buttonJuez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buttonJuez.setBackground(new Color(100, 149, 237));
				buttonJuez.setToolTipText("Registrar Juez");
			}
			public void mouseExited(MouseEvent e){
				buttonJuez.setBackground(new Color(176, 196, 222));
				
			}
		});
		buttonJuez.setBounds(160, 4, 25, 22);
		buttonJuez.setBorderPainted(false);
		buttonJuez.setBackground(new Color(176, 196, 222));
		panel.add(buttonJuez);
		
		final JButton buttonComision = new JButton("");
		buttonComision.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icono comision.png")));
		buttonComision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Empresa.getInstances().getMisEventos().size()==0){
					JOptionPane.showMessageDialog(null, "Registrar un Evento primero");
				}
				if(Empresa.getInstances().getMisEventos().size()>0){
				RegistrarComision RegComision = new RegistrarComision();
			RegComision.setLocationRelativeTo(null);
			RegComision.setResizable(false);
			RegComision.setModal(true);
			RegComision.setVisible(true);
			RegComision.setResizable(false);
				}
			}
		});
		buttonComision.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buttonComision.setBackground(new Color(100, 149, 237));
				buttonComision.setToolTipText("Registrar Comisión");
			}
			public void mouseExited(MouseEvent e){
				buttonComision.setBackground(new Color(176, 196, 222));
				
			}
		});
		buttonComision.setBounds(205, 4, 25, 22);
		buttonComision.setBorderPainted(false);
		buttonComision.setBackground(new Color(176, 196, 222));
		panel.add(buttonComision);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(72, 1, 8, 26);
		panel.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(151, 1, 8, 26);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(193, 1, 8, 26);
		panel.add(separator_2);
		
		
		///////////////////////////////////GRAFICO Barra////////////////////////////////////
		
		dataset = new DefaultCategoryDataset();
		
        dataset.setValue(Empresa.getInstances().cantidadTrabajosxArea(1), "Fisica", "Trabajo");
        
        dataset.setValue(Empresa.getInstances().cantidadTrabajosxArea(2), "Biologia", "Trabajo");
        
        dataset.setValue(Empresa.getInstances().cantidadTrabajosxArea(3), "Matematicas", "Trabajo");
        
        dataset.setValue(Empresa.getInstances().cantidadTrabajosxArea(4), "Quimica", "Trabajo");
        
        dataset.setValue(Empresa.getInstances().cantidadTrabajosxArea(5), "Medicina", "Trabajo");
        
        // Creando el Grafico
        
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Cantidad de trabajos por area","Area", "Trabajos",
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(new Color(230, 230, 250));
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.orange);
        
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(80, 351, 575, 302);
        contentPane.add(chartPanel);
        chartPanel.setLayout(new CardLayout(0, 0));
        
        ////////////////////////////////////////GRAFICO PASTEL////////////////////////////////////
        
       // Fuente de Datos
        data1 = new DefaultPieDataset();
        actualizarPastel();
        
        // Creando el Grafico
        JFreeChart chart1 = ChartFactory.createPieChart(
         "Cantidad de Eventos por tipo", 
         data1, 
         true, 
         true, 
         false);
        
         // Crear el Panel del Grafico con ChartPanel
         ChartPanel chartPanel1 = new ChartPanel(chart1);
         chartPanel1.setBounds(80, 41, 575, 287);
         contentPane.add(chartPanel1);
         chart1.setBackgroundPaint(new Color(230, 230, 250));
         chartPanel1.setMouseZoomable(true);
         chartPanel1.setDomainZoomable(true);
               
               
         JSeparator separator_3 = new JSeparator();
         separator_3.setBackground(new Color(160, 160, 160));
         separator_3.setForeground(new Color(255, 255, 255));
         separator_3.setBounds(35, 338, 1275, 2);
         contentPane.add(separator_3);
               
         JSeparator separator_4 = new JSeparator();
         separator_4.setOrientation(SwingConstants.VERTICAL);
         separator_4.setBackground(new Color(160, 160, 160));
         separator_4.setForeground(new Color(255, 255, 255));
         separator_4.setBounds(770, 38, 2, 302);
         contentPane.add(separator_4);
               
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(920, 121, 302, 183);
         tableModel = new DefaultTableModel(){

 			private static final long serialVersionUID = 1L;
 			boolean[] canEdit = new boolean[]{
 					false, false,false //solo se pone no editable la segunda columna
             };

             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return canEdit[columnIndex];
             }
        	 
         };
       	 String[] columnNames = {"No.", "Participante", "Cantidad de Trabajos"};
         tableModel.setColumnIdentifiers(columnNames);
         contentPane.add(scrollPane);
               
            table = new JTable();
               
       		table.setModel(tableModel);
       		scrollPane.setColumnHeaderView(table);
       		
       		table.setDefaultRenderer(Object.class, new CellRendererTableColor());
       		scrollPane.setViewportView(table);
       		
       		JLabel lblNewLabel = new JLabel("Participantes con m\u00E1s trabajos");
       		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
       		lblNewLabel.setBounds(896, 51, 344, 46);
       		contentPane.add(lblNewLabel);
       		
       		JPanel panel_1 = new JPanel();
       		panel_1.setBackground(new Color(230, 230, 250));
       		panel_1.setBounds(889, 57, 358, 271);
       		contentPane.add(panel_1);
       		panel_1.setLayout(null);
       		

       		txtTipo = new JTextField();
       		txtTipo.setBounds(800, 410, 183, 23);
       		contentPane.add(txtTipo);
       		txtTipo.setColumns(10);
       		
       		txtLugar = new JTextField();
       		txtLugar.setColumns(10);
       		txtLugar.setBounds(800, 455, 183, 23);
       		contentPane.add(txtLugar);
       		
       		txtFecha = new JTextField();
       		txtFecha.setColumns(10);
       		txtFecha.setBounds(800, 500, 183, 23);
       		contentPane.add(txtFecha);
       		
       		txtHoradeInicio = new JTextField();
       		txtHoradeInicio.setColumns(10);
       		txtHoradeInicio.setBounds(800, 545, 183, 23);
       		contentPane.add(txtHoradeInicio);
       		
       		txtHoraFinal = new JTextField();
       		txtHoraFinal.setColumns(10);
       		txtHoraFinal.setBounds(800, 590, 183, 23);
       		contentPane.add(txtHoraFinal);
       		
       		comboBoxEvento = new JComboBox<String>();
       		comboBoxEvento.addActionListener(new ActionListener() {
       			public void actionPerformed(ActionEvent arg0) {
       				if(comboBoxEvento.getSelectedIndex()>0){
       				 selEvento=comboBoxEvento.getSelectedIndex()-1;
       				 
       				 rellenar();
       				loadParticipantes();
       				actualizarPastel();
       				
       				
       			}
       				if(comboBoxEvento.getSelectedIndex()==0){
       				 
       					limCampos();
       				}
       				
       			
       			}
       		});
       		comboBoxEvento.setBounds(800, 365, 183, 23);
       		comboBoxEvento.addItem("<Seleccione>");
    		for(int i=0; i< Empresa.getInstances().getMisEventos().size(); i++){
    			comboBoxEvento.addItem(Empresa.getInstances().getMisEventos().get(i).getNombre());
    		}
       		contentPane.add(comboBoxEvento);
       		
       		editablee(false);
       		JLabel lblNewLabel_1 = new JLabel("Tipo: ");
       		lblNewLabel_1.setBounds(714, 410, 103, 23);
       		contentPane.add(lblNewLabel_1);
       		
       		JLabel lblLugar = new JLabel("Lugar:");
       		lblLugar.setBounds(714, 455, 103, 23);
       		contentPane.add(lblLugar);
       		
       		JLabel lblHoraInicio = new JLabel("Hora de Inicio:");
       		lblHoraInicio.setBounds(714, 545, 103, 23);
       		contentPane.add(lblHoraInicio);
       		
       		JLabel lblFecha = new JLabel("Fecha:");
       		lblFecha.setBounds(714, 500, 103, 23);
       		contentPane.add(lblFecha);
       		
       		JLabel lblHoraFinal = new JLabel("Hora Final:");
       		lblHoraFinal.setBounds(714, 590, 103, 23);
       		contentPane.add(lblHoraFinal);
       		
       		
       		JLabel lblNewLabel_2 = new JLabel("");
       		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/LogoE.png")));
       		lblNewLabel_2.setBounds(1014, 410, 244, 196);
       		contentPane.add(lblNewLabel_2);
       		
       		JLabel lblEvento = new JLabel("Evento:");
       		lblEvento.setBounds(714, 365, 103, 23);
       		contentPane.add(lblEvento);
       		table.getColumnModel().getColumn(0).setPreferredWidth(30);
       		table.getColumnModel().getColumn(0).setMinWidth(30);
       		table.getColumnModel().getColumn(0).setMaxWidth(30);
  
               
	}

	private void loadParticipantes() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
			for (int i = 0; i< Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().size();i++) {
				fila[0] = i+1;
				fila[1] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getNombre();
				fila[2] = Empresa.getInstances().getMisEventos().get(selEvento).getMisParticipantes().get(i).getMisTrabajos().size();
				tableModel.addRow(fila);
							
			}
		
	}
	
	
	public void rellenar(){
		txtTipo.setText(Empresa.getInstances().getMisEventos().get(selEvento).getTipo());
		txtLugar.setText(Empresa.getInstances().getMisEventos().get(selEvento).getLugar());
		String FR="";
		FR=Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getDia())+"/";
		FR+=Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getMes())+"/";
		FR+=Integer.toString(Empresa.getInstances().getMisEventos().get(selEvento).getYear());
		txtFecha.setText(FR);
		txtHoradeInicio.setText(Empresa.getInstances().getMisEventos().get(selEvento).getHoraInicio());
		txtHoraFinal.setText(Empresa.getInstances().getMisEventos().get(selEvento).getHoraFinal());
	
	}
	public void limCampos(){
		txtTipo.setText("");
		txtLugar.setText("");
		txtFecha.setText("");
		txtHoradeInicio.setText("");
		txtHoraFinal.setText("");
		
	}
	public void editablee(boolean t){
		txtTipo.setEditable(t);
		txtLugar.setEditable(t);
		txtFecha.setEditable(t);
		txtHoradeInicio.setEditable(t);
		txtHoraFinal.setEditable(t);
		
	}
	
	public void actualizarPastel(){
		if(Empresa.getInstances().cantidadSeminarios()>0)
	        data1.setValue("Seminario",Empresa.getInstances().cantidadSeminarios());
	        if(Empresa.getInstances().cantidadPanel()>0)
	        data1.setValue("Panel", Empresa.getInstances().cantidadPanel());
	        if(Empresa.getInstances().cantidadConversatorio()>0)
	        data1.setValue("Conversatorio", Empresa.getInstances().cantidadConversatorio());
	        if(Empresa.getInstances().cantidadConferencia()>0)
	        data1.setValue("Conferencia", Empresa.getInstances().cantidadConferencia());
	        if(Empresa.getInstances().cantidadMesaRedonda()>0)
	        data1.setValue("Mesa Redonda", Empresa.getInstances().cantidadMesaRedonda());
		
	}
}
