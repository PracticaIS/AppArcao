/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Reserva;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppArcao.Negocio.Reserva.TPlaza_vehiculo;
import AppArcao.Negocio.Reserva.TReserva;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name VentanaMostrarReserva.java
 */
public class VentanaMostrarReserva extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7737607202472161743L;

	private static VentanaMostrarReserva instance = null;

	private JPanel panelDatos;
	private JPanel panelDatosPV;
	private JPanel panelBotones;
	
	
	private JLabel labelId_Reserva;
	private JTextField txtFieldID_Reserva;
	
	private JLabel labelId_Socio;
	private JTextField txtFieldId_Socio;
	
	private JLabel labelFechaRegistro;
	private JTextField txtFieldFecha_Registro;
	
	//*********** PLAZA-VEHICULO ********
	
	private JLabel labelID_Vehiculo;
	private JTextField txtFieldID_Vehiculo;
	
	private JLabel labelId_Plaza;
	private JTextField txtFieldID_Plaza;
	
	private JLabel labelFechaReserva;
	private JTextField txtFieldFechaReserva;;
	
	private JLabel labelEstado;
	private JTextField txtFieldEstado;
	
	private JLabel labelTipo_reserva;
	private JTextField txtFieldTipo_reserva;
	
	private JButton botonAtras;
	
	
	
	public static void main(String args[]) {
		VentanaMostrarReserva.getInstance().setVisible(true);
	}
	
	public VentanaMostrarReserva(){
		super("Mostrar Reserva");
		create();
		
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}


	/**
	 * 
	 */
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(3,1));
		
		labelId_Reserva = new JLabel("ID Reserva: ");
		txtFieldID_Reserva = new JTextField(4);
		
		
		labelId_Socio = new JLabel("ID Socio: ");
		txtFieldId_Socio = new JTextField(4);
		
		labelFechaRegistro = new JLabel("Fecha resgistro: ");
		txtFieldFecha_Registro = new JTextField(7);
		
		labelID_Vehiculo = new JLabel("ID Vehiculo: ");
		txtFieldID_Vehiculo = new JTextField(4);

		labelId_Plaza = new JLabel("ID plaza: ");
		txtFieldID_Plaza  = new JTextField(4);

		labelFechaReserva = new JLabel("Fecha Reserva: ");
		txtFieldFechaReserva = new JTextField(6);

		labelEstado = new JLabel("Estado: ");
		txtFieldEstado = new JTextField(4);

		labelTipo_reserva = new JLabel("TIpo Reserva: ");
		txtFieldTipo_reserva = new JTextField(6);
		
		
		botonAtras = new JButton("Atras");
		
		
		panelDatos = new JPanel();
		panelDatosPV = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelId_Reserva);
		panelDatos.add(txtFieldID_Reserva);
		
		panelDatos.add(labelId_Socio);
		panelDatos.add(txtFieldId_Socio);
		
		panelDatos.add(labelFechaRegistro);
		panelDatos.add(txtFieldFecha_Registro);
		
		
		
		panelDatosPV.add(labelID_Vehiculo);
		panelDatosPV.add(txtFieldID_Vehiculo);

		panelDatosPV.add(labelId_Plaza);
		panelDatosPV.add(txtFieldID_Plaza);

		panelDatosPV.add(labelFechaReserva);
		panelDatosPV.add(txtFieldFechaReserva);

		panelDatosPV.add(labelEstado);
		panelDatosPV.add(txtFieldEstado);

		panelDatosPV.add(labelTipo_reserva);
		panelDatosPV.add(txtFieldTipo_reserva);
		
		
		panelBotones.add(botonAtras);
		
		this.add(panelDatos);
		this.add(panelDatosPV);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}


	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteMostrarReserva oyente = new OyenteMostrarReserva();
		this.addWindowListener(new EscuchaVentana());
		botonAtras.addActionListener(oyente);
		
	}

	
	public static VentanaMostrarReserva getInstance(){
		if(instance == null){
			instance = new VentanaMostrarReserva();
		}
		
		return instance ;
	}
	
	public class OyenteMostrarReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaMostrarReserva.this.dispose();
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
			VentanaMostrarReserva.this.dispose();
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

	public void actualiza(int evento, TReserva datos) {
		switch (evento) {
			case (EventoGUI.MOSTRAR_RESERVA):{
				
				String stringID_Reserva = Integer.toString(datos.getId_Reserva());
				txtFieldID_Reserva.setText(stringID_Reserva);
				txtFieldID_Reserva.setEnabled(false);
				
				String stringID_Socio = Integer.toString(datos.getId_Socio());
				txtFieldId_Socio.setText(stringID_Socio);

				String stringFecha_Registro = datos.getFecha_Registro();
				txtFieldFecha_Registro.setText(stringFecha_Registro.split(" ")[0]);
				
				
				TPlaza_vehiculo tpv = datos.getPlaza_vehiculo();
				
					String stringFechaID_Vehiculo = Integer.toString(tpv.getId_vehiculo());
					txtFieldID_Vehiculo.setText(stringFechaID_Vehiculo);
	
					String stringID_Plaza = Integer.toString(tpv.getId_plaza());
					txtFieldID_Plaza.setText(stringID_Plaza);
	
					String stringFechaReserva = tpv.getFecha_registro();
					txtFieldFechaReserva.setText(stringFechaReserva.split(" ")[0]);
					
					String stringEstado = tpv.getEstado();
					txtFieldEstado.setText(stringEstado);
					
					String stringTipo_reserva = tpv.getTipo_reserva();
					txtFieldTipo_reserva.setText(stringTipo_reserva);
				
			}break;
	
		}
	}
	
	private void estadoVentanaInicial(){
		//Colocamos el estado de los campos vacios.
		
		txtFieldFecha_Registro.setText("");
		txtFieldId_Socio.setText(""); 
		txtFieldFecha_Registro.setText("");
		txtFieldID_Vehiculo.setText("");
		txtFieldID_Plaza.setText("");
		txtFieldFechaReserva.setText("");
		txtFieldEstado.setText("");
		txtFieldTipo_reserva.setText("");
	}
	
	@Override
	public void dispose(){
		this.estadoVentanaInicial();
		super.dispose();
	}

}
