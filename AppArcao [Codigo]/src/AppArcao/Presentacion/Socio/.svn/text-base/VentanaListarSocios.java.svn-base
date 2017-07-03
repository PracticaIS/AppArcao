package AppArcao.Presentacion.Socio;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import AppArcao.Negocio.Socio.TSocio;
import AppArcao.Negocio.Socio.TSocioNoVIP;
import AppArcao.Negocio.Socio.TSocioVIP;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

public class VentanaListarSocios extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4490139405115890537L;

	private static VentanaListarSocios instance = null; // instancia sigleton
	
	private MyModeloTabla model;
	
	private JScrollPane tableScrollPane;
    private JTable tTabla;
    private JButton botonAtras;
    private JPanel panelBotones;
    private JPanel panelDatos;
    
    private JPanel panelPrincipal;

    public VentanaListarSocios(){
    	super("Listar Socios");
		create();
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
    }
    
    public static VentanaListarSocios getInstance(){
		if(instance == null){
			instance = new VentanaListarSocios();
		}
		
		return instance;
	}
    
    
    private void create() {
		// TODO Apéndice de método generado automáticamente
		
		
		//panelPrincipal = new JPanel(new GridLayout(2,1));
		panelPrincipal = new JPanel(new BorderLayout());
		//panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel Principal"));
		this.setSize(1000, 200);
		
		panelDatos = new JPanel(new BorderLayout());
		//panelDatos.setBorder(BorderFactory.createTitledBorder("Panel Datos"));
		model = new MyModeloTabla();
		tTabla = new JTable(model);
		tableScrollPane = new JScrollPane(tTabla);
		//tTabla.setFillsViewportHeight(true);
		//tableScrollPane.setBorder(BorderFactory.createTitledBorder("Tabla datos"));
		
		panelDatos.add(tableScrollPane);
		
        botonAtras = new JButton("Atras");
        panelBotones = new JPanel();
        //panelBotones.setBorder(BorderFactory.createTitledBorder("Panel botones"));
        panelBotones.add(botonAtras);
        
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        panelPrincipal.add(panelDatos, BorderLayout.CENTER);
        
        this.add(panelPrincipal);
		
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //pack();
	}
    
	private void agregarManejadoresDeEventos() {
		OyenteListarSocios oyente = new OyenteListarSocios();	
		this.addWindowListener(new EscuchaVentana());
		
		botonAtras.addActionListener(oyente);
	}
	
	
	public class OyenteListarSocios implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaListarSocios.this.dispose();
				JPrincipal.getInstance().setVisible(true);
			}
			
		}
		
	}
	
	class EscuchaVentana implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			JPrincipal.getInstance().setVisible(true);
			VentanaListarSocios.this.dispose();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			
		}
    }
	
    public void actualiza(int evento, ArrayList<TSocio> datos) {
		switch (evento) {
			case (EventoGUI.LISTAR_SOCIOS):{
							
				model.setListaTabla(datos);
				
				tTabla.setModel(model);

		        setLocationRelativeTo(null);
				
			}break;
			
			case (EventoGUI.LISTAR_SOCIOS_ERROR):{
				//Mostramos un mensaje de error.
				
				JOptionPane.showMessageDialog(null, "Error al listar los Socios");
				
			}break;
			
			case (EventoGUI.LISTAR_SOCIOS_ERRORAUX):{
				//Mostramos un mensaje de error.
				
				JOptionPane.showMessageDialog(null, "No hay socios que listar.");
				JPrincipal.getInstance().setVisible(true);
				
			}break;
		}
	}
    
    private class MyModeloTabla extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID_SOCIO", "NOMBRE" , "APELLIDOS", "DIRECCION", "CIUDAD", "PROVINCIA", "COD_POSTAL", "NUM_TARJETA"
				, "FECHA_REGIS", "ESTADO", "TIPO_SOCIO", "TELEFONO", "EMAIL"};
		private ArrayList<TSocio> listaTabla = new ArrayList<TSocio>();

		@Override
		public int getColumnCount() {
			return columnas.length;
		}

		@Override
		public int getRowCount() {
			return listaTabla.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (rowIndex >= listaTabla.size()) {
				return null;
			} else {
				TSocio i = listaTabla.get(rowIndex);
				if (columnIndex == 0)
					return i.getId_socio();
				else if (columnIndex == 1)
					return i.getNombre();
				else if (columnIndex == 2)
					return i.getApellidos();
				else if (columnIndex ==3)
					return i.getDireccion();
				else if (columnIndex == 4)
					return i.getCiudad();
				else if (columnIndex == 5)
					return i.getProvincia();
				else if (columnIndex == 6)
					return i.getCod_postal();
				else if (columnIndex == 7)
					return i.getNum_tarjeta();
				else if (columnIndex == 8)
					return i.getFecha_regis();
				else if (columnIndex == 9)
					return i.getEstado();
				else if (columnIndex == 10)
					return i.getTipo_socio();
				else if (columnIndex == 11){
					if (i.getTipo_socio().equalsIgnoreCase("vip"))
					{
						TSocioVIP aux = (TSocioVIP) i;
						return aux.getTelefono();
					}
					else return "";
				}
				else if (columnIndex == 12){
					if (i.getTipo_socio().equalsIgnoreCase("novip"))
					{
						TSocioNoVIP aux = (TSocioNoVIP) i;
						return aux.getEmail();
					}
					else return "";
				}
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TSocio i){
			boolean encontrado = false;
			int j = 0;
			
			while(!encontrado && j< listaTabla.size()){
				
				if(listaTabla.get(j).getId_socio() == i.getId_socio()){
					listaTabla.remove(j);
					listaTabla.add(j, i);
					encontrado = true;
				}
				j++;
			}
			
			if(!encontrado){
				listaTabla.add(i);
			}
			
			this.fireTableDataChanged();
		}

		@SuppressWarnings("unused")
		public void clear() {
			this.listaTabla.clear();
		}

		public void setListaTabla(ArrayList<TSocio> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
    
}
