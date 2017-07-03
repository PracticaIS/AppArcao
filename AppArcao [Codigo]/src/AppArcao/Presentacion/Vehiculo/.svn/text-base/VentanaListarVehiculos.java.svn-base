/**
 * 
 */
package AppArcao.Presentacion.Vehiculo;

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

import AppArcao.Negocio.Vehiculo.TVehiculo;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Chema
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaListarVehiculos extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5057224413035247774L;

	private static VentanaListarVehiculos instance = null; // instancia sigleton
	
	private MyModeloTabla model;
	
	private JScrollPane tableScrollPane;
    private JTable tTabla;
    private JButton botonAtras;
    private JPanel panelBotones;
    private JPanel panelDatos;
    
    private JPanel panelPrincipal;

    public VentanaListarVehiculos(){
    	super("Listar Vehiculos");
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
    }
    
    public static VentanaListarVehiculos getInstance(){
		if(instance == null){
			instance = new VentanaListarVehiculos();
		}
		
		return instance;
	}
    
    
    private void create() {
		// TODO Apéndice de método generado automáticamente
		
		
		//panelPrincipal = new JPanel(new GridLayout(2,1));
		panelPrincipal = new JPanel(new BorderLayout());
		//panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel Principal"));
		this.setSize(600, 200);
		
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
		OyenteListarVehiculos oyente = new OyenteListarVehiculos();	
		this.addWindowListener(new EscuchaVentana());
		
		botonAtras.addActionListener(oyente);
	}
	
	
	public class OyenteListarVehiculos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaListarVehiculos.this.dispose();
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
			VentanaListarVehiculos.this.dispose();
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
	
    public void actualiza(int evento, ArrayList<TVehiculo> datos) {
		switch (evento) {
			case (EventoGUI.LISTAR_VEHICULOS):{
							
				model.setListaTabla(datos);
				
				tTabla.setModel(model);

		        setLocationRelativeTo(null);
				
			}break;
			
			case (EventoGUI.LISTAR_VEHICULOS_ERROR):{
				//Mostramos un mensaje de error.
				
				JOptionPane.showMessageDialog(null, "Error al listar los vehiculos");
				
			}break;
			
			case (EventoGUI.LISTAR_VEHICULOS_ERRORAUX):{
				//Mostramos un mensaje de error.
				
				JOptionPane.showMessageDialog(null, "No hay vehículos que listar");
				JPrincipal.getInstance().setVisible(true);
				
			}break;
		}
	}
    
    private class MyModeloTabla extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID_VEHICULO", "ID_SOCIO", "MATRICULA", "MARCA", "TIPO", "COLOR" };
		private ArrayList<TVehiculo> listaTabla = new ArrayList<TVehiculo>();

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
				TVehiculo i = listaTabla.get(rowIndex);
				
				if (columnIndex == 0)
					return i.getId_vehiculo();
				else if (columnIndex == 1)
					return i.getId_socio();
				else if (columnIndex == 2)
					return i.getMatricula();
				else if (columnIndex ==3)
					return i.getMarca();
				else if (columnIndex == 4)
					return i.getTipo();
				else if (columnIndex == 5)
					return i.getColor();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TVehiculo i){
			boolean encontrado = false;
			int j = 0;
			
			while(!encontrado && j< listaTabla.size()){
				
				if(listaTabla.get(j).getId_vehiculo() == i.getId_vehiculo()){
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

		public void setListaTabla(ArrayList<TVehiculo> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}