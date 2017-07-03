package AppArcao.Presentacion.Reserva;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;

import AppArcao.Negocio.Reserva.TReserva;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;


public class VentanaCrearReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4175818216560116321L;

	private static VentanaCrearReserva instance = null;

	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelId_Socio;
	private JLabel labelFechaReserva;
	
	private JTextField txtFieldmatricula;
	private JCalendarCombo comboCalendar;
	
	private JButton botonCrearReserva;
	private JButton botonAtras;
	
	
	
	public static void main(String args[]) {
		VentanaCrearReserva.getInstance().setVisible(true);
	}
	
	public VentanaCrearReserva(){
		super("Crear Reserva");
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
		this.setLayout(new GridLayout(2,1));
		
		labelId_Socio = new JLabel("Matrícula: ");
		txtFieldmatricula = new JTextField(10);
		
		labelFechaReserva = new JLabel("Fecha: ");
		
		comboCalendar = new JCalendarCombo();
		//comboCalendar.setPreferredSize(new Dimension(150, 20));
		
		botonCrearReserva = new JButton("Crear reserva");
		botonAtras = new JButton("Atras");
		
		
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelId_Socio);
		panelDatos.add(txtFieldmatricula);
		
		panelDatos.add(labelFechaReserva);
		panelDatos.add(comboCalendar);
		
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrearReserva);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}


	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteCrearReserva oyente = new OyenteCrearReserva();
		this.addWindowListener(new EscuchaVentana());
		botonCrearReserva.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}

	
	public static VentanaCrearReserva getInstance(){
		if(instance == null){
			instance = new VentanaCrearReserva();
		}
		
		return instance ;
	}
	
	public class OyenteCrearReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaCrearReserva.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonCrearReserva){
				
				String stringID_Socio = "";
				stringID_Socio = txtFieldmatricula.getText();
				
				Date fechaEscogida = comboCalendar.getDate();
				String stringFecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaEscogida);
				String stringFechaActual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				
				if(!stringID_Socio.equals("")){
					if(stringFecha.compareTo(stringFechaActual) >= 0) { // Si la fecha es correcta...
						stringFecha = new SimpleDateFormat("yyyy/MM/dd").format(fechaEscogida);
						try{
							TReserva mireserva = new TReserva(-1,-1,stringFecha,null,txtFieldmatricula.getText());

							Controlador.getInstance().action(EventoNegocio.CREAR_RESERVA, mireserva);

						}catch(NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Introduzca un id de socio correcto");
							txtFieldmatricula.requestFocus();
						}
					}else{
						JOptionPane.showMessageDialog(null, "ERROR:\n"+ "Fecha elegida: " + stringFecha + "\nFecha actual: " +stringFechaActual);
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca una matrícula.");
					txtFieldmatricula.requestFocus();
				}
		
		
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
			VentanaCrearReserva.this.dispose();
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

	public void actualiza(int evento, int datos) {
		switch (evento) {
			case (EventoGUI.MOSTRAR_RESERVA):{
				//Colocamos los campos de nuevo a vacios.
				this.estadoVentanaInicial();
				JOptionPane.showMessageDialog(null, "Reserva creada ID_Reserva: " + datos);
				
			}break;
	
			case (EventoGUI.ERROR_VEHICULO_RESERVA_NOEXISTE):{
				JOptionPane.showMessageDialog(null, "No existe ningún vehículo con esta matrícula");
			}break;
			
			case (EventoGUI.ERROR_PLAZAS_LLENAS):{
				JOptionPane.showMessageDialog(null, "Todas las plazas están ocupadas");
			}break;
			
			case (EventoGUI.ERROR_CREAR_RESERVA):{
				JOptionPane.showMessageDialog(null, "Error al crear la reserva");
			}break;
			
			case (EventoGUI.ERROR_RESERVA_SOCIOINACTIVO):{
				JOptionPane.showMessageDialog(null, "Un socio inactivo no puede crear reservas.");
			}break;
		}
	}
	
	private void estadoVentanaInicial(){
		//Colocamos el estado de los campos vacios.
		txtFieldmatricula.setText("");
		comboCalendar.setSelectedIndex(0);
		//txtAreaDescripcion.setText("");
		
		txtFieldmatricula.requestFocus();
	}
	
	@Override
	public void dispose(){
		this.estadoVentanaInicial();
		super.dispose();
	}

}
