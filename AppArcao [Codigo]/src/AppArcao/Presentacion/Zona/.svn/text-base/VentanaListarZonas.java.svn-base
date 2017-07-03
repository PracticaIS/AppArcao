/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Zona;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
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

import AppArcao.Negocio.Zona.TZona;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 05/05/2015
 * @File_Name VentanaListarZonas.java
 */
public class VentanaListarZonas extends JFrame {

	private static final long serialVersionUID = -4745547839503845772L;
	
	private static VentanaListarZonas instance = null; // instancia sigleton
	
	private MyModeloTabla model;
	
	private JScrollPane tableScrollPane;
    private JTable tTabla;
    private JButton botonAtras;
    private JPanel panelBotones;
    private JPanel panelDatos;
    
    private JPanel panelPrincipal;

	


	/**
	 * @throws HeadlessException
	 */
	public VentanaListarZonas(){
		super("Listar Zonas");
		
		create();
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaListarZonas getInstance(){
		if(instance == null){
			instance = new VentanaListarZonas();
		}
		
		return instance;
	}

	/**
	 * 
	 */
	private void create() {
		// TODO Apéndice de método generado automáticamente
		
		
		//panelPrincipal = new JPanel(new GridLayout(2,1));
		panelPrincipal = new JPanel(new BorderLayout());
		//panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel Principal"));
		this.setSize(300, 200);
		
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

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteListarZonas oyente = new OyenteListarZonas();	
		this.addWindowListener(new EscuchaVentana());
		
		botonAtras.addActionListener(oyente);
	}
	
	
	public class OyenteListarZonas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaListarZonas.this.dispose();
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
			VentanaListarZonas.this.dispose();
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
	
	public void actualiza(int evento, ArrayList<TZona> datos) {
		switch (evento) {
			case (EventoGUI.LISTAR_ZONAS):{
							
				model.setListaTabla(datos);
				
				tTabla.setModel(model);

		        setLocationRelativeTo(null);
				
			}break;
			
			case (EventoGUI.LISTAR_ZONAS_ERRORAUX):{
				
				JOptionPane.showMessageDialog(null, "No existen zonas que listar.");
				JPrincipal.getInstance().setVisible(true);
				
			}break;
			
			case (EventoGUI.LISTAR_ZONAS_ERROR):{
				//Mostramos un mensaje de error.
				
				JOptionPane.showMessageDialog(null, "Error al listar las zonas");
				
			}break;
		}
	}
	private class MyModeloTabla extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "COLOR", "PLANTA" };
		private ArrayList<TZona> listaTabla = new ArrayList<TZona>();

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
				TZona i = listaTabla.get(rowIndex);
				
				if (columnIndex == 0)
					return i.getId_zona();
				else if (columnIndex == 1)
					return i.getColor();
				else if (columnIndex == 2)
					return i.getPlanta();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TZona i){
			boolean encontrado = false;
			int j = 0;
			
			while(!encontrado && j< listaTabla.size()){
				
				if(listaTabla.get(j).getId_zona() == i.getId_zona()){
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

		public void setListaTabla(ArrayList<TZona> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}
