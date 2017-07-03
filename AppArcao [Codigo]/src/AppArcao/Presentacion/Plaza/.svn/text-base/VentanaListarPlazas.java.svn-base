/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Plaza;

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

import AppArcao.Negocio.Plaza.TPlaza;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 10/05/2015
 * @File_Name VentanaListarPlaza.java
 */
public class VentanaListarPlazas extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034276102749385091L;

	private static VentanaListarPlazas instance = null; // instancia sigleton
	
	private MyModeloTabla model;
	
	private JScrollPane tableScrollPane;
    private JTable tTabla;
    private JButton botonAtras;
    private JPanel panelBotones;
    private JPanel panelDatos;
    
    private JPanel panelPrincipal;

	


    
    public static void main(String args[]) {
		VentanaListarPlazas.getInstance().setVisible(true);
	}
    
	/**
	 * @throws HeadlessException
	 */
	public VentanaListarPlazas(){
		super("Listar Plazas");
		
		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaListarPlazas getInstance(){
		if(instance == null){
			instance = new VentanaListarPlazas();
		}
		
		return instance;
	}

	/**
	 * 
	 */
	private void create() {
		
		panelPrincipal = new JPanel(new BorderLayout());
		this.setSize(700, 200);
		
		panelDatos = new JPanel(new BorderLayout());
		model = new MyModeloTabla();
		tTabla = new JTable(model);
		tableScrollPane = new JScrollPane(tTabla);
		
		
		panelDatos.add(tableScrollPane);
		
        botonAtras = new JButton("Atras");
        panelBotones = new JPanel();
       
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
		OyenteListarPlazas oyente = new OyenteListarPlazas();	
		this.addWindowListener(new EscuchaVentana());
		
		botonAtras.addActionListener(oyente);
	}
	
	
	public class OyenteListarPlazas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaListarPlazas.this.dispose();
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
			VentanaListarPlazas.this.dispose();
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
	
	public void actualiza(int evento, ArrayList<TPlaza> datos) {
		switch (evento) {
			case (EventoGUI.LISTAR_PLAZAS):{
							
				model.setListaTabla(datos);
				
				tTabla.setModel(model);

		        setLocationRelativeTo(null);
				
			}break;
			
			case (EventoGUI.LISTAR_PLAZAS_ERRORAUX):{
				
				JOptionPane.showMessageDialog(null, "No hay plazas que listar");
				JPrincipal.getInstance().setVisible(true);
				
			}break;
			
			case (EventoGUI.LISTAR_PLAZAS_ERROR):{
				//Mostramos un mensaje de error.
				
				JOptionPane.showMessageDialog(null, "Error al listar las plazas");
				
			}break;
		}
	}
	private class MyModeloTabla extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1400601842772476569L;

		private String[] columnas = { "ID", "ID_ZONA", "COLOR_ZONA", "TIPO_PLAZA", "NUM_PLAZA", "ESTADO", "DESCRIPCIÓN" };
		private ArrayList<TPlaza> listaTabla = new ArrayList<TPlaza>();

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
				TPlaza i = listaTabla.get(rowIndex);
				
				if (columnIndex == 0)
					return i.getId_plaza();
				else if (columnIndex == 1)
					return i.getId_zona();
				else if (columnIndex == 2)
					return i.getColor_Zona();
				else if (columnIndex == 3)
					return i.getTipo_plaza();
				else if (columnIndex == 4)
					return i.getNum_plaza();
				else if (columnIndex == 5)
					return i.getEstado();
				else if (columnIndex == 6)
					return i.getDescripcion();
				else
					return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void clear() {
			this.listaTabla.clear();
		}

		public void setListaTabla(ArrayList<TPlaza> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}
