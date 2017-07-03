/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Reserva;

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

import AppArcao.Negocio.Reserva.TReserva;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;


/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 22/05/2015
 * @File_Name VentanaListarReservas.java
 */
public class VentanaListarReservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4405562958330205282L;

	private static VentanaListarReservas instance = null; // instancia sigleton

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
	public VentanaListarReservas(){
		super("Listar Reservas");

		create();
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static VentanaListarReservas getInstance(){
		if(instance == null){
			instance = new VentanaListarReservas();
		}

		return instance;
	}

	/**
	 * 
	 */
	private void create() {

		//panelPrincipal = new JPanel(new GridLayout(2,1));
		panelPrincipal = new JPanel(new BorderLayout());
		//panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel Principal"));
		this.setSize(700, 200);

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
		OyenteListarReservas oyente = new OyenteListarReservas();	
		this.addWindowListener(new EscuchaVentana());

		botonAtras.addActionListener(oyente);
	}


	public class OyenteListarReservas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == botonAtras){
				VentanaListarReservas.this.dispose();
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
			VentanaListarReservas.this.dispose();
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

	public void actualiza(int evento, ArrayList<TReserva> datos) {
		switch (evento) {
			case (EventoGUI.LISTAR_RESERVAS):{
	
				model.setListaTabla(datos);
	
				tTabla.setModel(model);
	
				setLocationRelativeTo(null);
	
			}break;
	
			case (EventoGUI.LISTAR_RESERVAS_ERROR):{
				//Mostramos un mensaje de error.
	
				JOptionPane.showMessageDialog(null, "Error al listar las reservas");
	
			}break;
	
			case (EventoGUI.LISTAR_RESERVAS_ERRORAUX):{
				//Mostramos un mensaje de error.
	
				JOptionPane.showMessageDialog(null, "No hay reservas que listar.");
				JPrincipal.getInstance().setVisible(true);
	
			}break;
		}
	}
	private class MyModeloTabla extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1400601842772476569L;
		
		private String[] columnas = { "ID_RESERVA", "ID_SOCIO", "MATRICULA", "FECHA DE REGISTRO", "FECHA RESERVA", "ID_PLAZA", "ID_VEHICULO"};
		private ArrayList<TReserva> listaTabla = new ArrayList<TReserva>();

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
				TReserva i = listaTabla.get(rowIndex);

				if (columnIndex == 0)
					return i.getId_Reserva();
				else if (columnIndex == 1)
					return i.getId_Socio();
				else if (columnIndex == 2)
					return i.getMatricula();
				else if (columnIndex == 3)
					return i.getFecha_Registro();
				else if (columnIndex == 4)
					return i.getPlaza_vehiculo().getFecha_registro();
				else if (columnIndex == 5)
					return i.getPlaza_vehiculo().getId_plaza();
				else if (columnIndex == 6)
					return i.getPlaza_vehiculo().getId_vehiculo();
				else	
				return null;
			}
		}

		@Override
		public String getColumnName(int col) {
			return columnas[col];
		}

		@SuppressWarnings("unused")
		public void add(TReserva i){
			boolean encontrado = false;
			int j = 0;

			while(!encontrado && j< listaTabla.size()){

				if(listaTabla.get(j).getId_Reserva() == i.getId_Reserva()){
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

		public void setListaTabla(ArrayList<TReserva> listaTabla) {
			this.listaTabla = listaTabla;
		}
	}
}