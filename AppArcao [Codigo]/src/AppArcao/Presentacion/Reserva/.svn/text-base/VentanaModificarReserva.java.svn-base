package AppArcao.Presentacion.Reserva;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;

import AppArcao.Negocio.Reserva.TPlaza_vehiculo;
import AppArcao.Negocio.Reserva.TReserva;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;


public class VentanaModificarReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5211238731172926185L;

	private static VentanaModificarReserva instance = null; // instancia sigleton


	private JPanel panelDatos;
	private JPanel panelDatosPV;
	private JPanel panelBotones;


	private JLabel labelID_Reserva;
	private JTextField txtFieldID_Reserva;

	/*private JLabel labelID_Socio;
	private JTextField txtFieldID_Socio;*/

	private JLabel labelMatricula;
	private JTextField txtFieldMatricula;

	//*********** PLAZA-VEHICULO ********


	private JLabel labelFechaReserva;
	private JCalendarCombo comboCalendar;


	private JButton botonModificarReserva;
	private JButton botonAtras;



	/**
	 * @throws HeadlessException
	 */
	public VentanaModificarReserva(){
		super("Modificar Reserva");

		create();

		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}


	public static void main(String args[]) {
		VentanaModificarReserva.getInstance().setVisible(true);
	}



	public static VentanaModificarReserva getInstance(){
		if(instance == null){
			instance = new VentanaModificarReserva();
		}

		return instance;
	}

	/**
	 * 
	 */

	private void create() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(3,1));

		labelID_Reserva = new JLabel("ID Reserva: ");
		txtFieldID_Reserva = new JTextField(4);

		txtFieldID_Reserva.setEnabled(false);

		/*labelID_Socio = new JLabel("ID Socio: ");
		txtFieldID_Socio = new JTextField(4);*/


		labelFechaReserva = new JLabel("Fecha Reserva: ");
		comboCalendar = new JCalendarCombo();
		

		labelMatricula = new JLabel("Matricula: ");
		txtFieldMatricula = new JTextField(6);
		
		botonModificarReserva = new JButton("Modificar Reserva");
		botonAtras = new JButton("Atras");


		panelDatos = new JPanel();
		panelDatosPV = new JPanel();
		panelBotones = new JPanel();


		panelDatos.add(labelID_Reserva);
		panelDatos.add(txtFieldID_Reserva);


		panelDatosPV.add(labelMatricula);
		panelDatosPV.add(txtFieldMatricula);
		
		panelDatosPV.add(labelFechaReserva);
		panelDatosPV.add(comboCalendar);

		panelBotones.add(botonAtras);
		panelBotones.add(botonModificarReserva);
		

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
		OyenteModificarReserva oyente = new OyenteModificarReserva();
		this.addWindowListener(new EscuchaVentana());
		botonModificarReserva.addActionListener(oyente);
		botonAtras.addActionListener(oyente);

	}

	public class OyenteModificarReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {


			if(event.getSource() == botonAtras){
				VentanaModificarReserva.this.dispose();
				VentanaBuscarReserva.getInstance().setVisible(true);

			}

			if(event.getSource() == botonModificarReserva){
				//******* Obtencion de datos de la ventana ******

				Date fechaEscogida = comboCalendar.getDate();
				String stringFecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaEscogida);
				String stringFechaActual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

				String stringMatricula = "";
				stringMatricula = txtFieldMatricula.getText();
				
				
				//try{
				if(stringFecha.compareTo(stringFechaActual) >= 0) { // Si la fecha es correcta...
					stringFecha = new SimpleDateFormat("yyyy-MM-dd").format(fechaEscogida);
					stringFecha += " 00:00:00.0";

					if(!stringMatricula.equalsIgnoreCase("")){
						
						TReserva reserva = new TReserva();
						reserva.setId_Reserva(Integer.parseInt(txtFieldID_Reserva.getText()));
						reserva.setMatricula(stringMatricula);
						
						TPlaza_vehiculo pv = new TPlaza_vehiculo();
						pv.setFecha_registro(stringFecha);
						reserva.setPlaza_vehiculo(pv);
						
						Controlador.getInstance().action(EventoNegocio.MODIFICAR_RESERVA, reserva);
						
					}else{
						JOptionPane.showMessageDialog(null, "Instrocuzca una matricula"); 
						txtFieldMatricula.requestFocus();
					}
				}else{
					JOptionPane.showMessageDialog(null, "ERROR:\n"+ "Fecha elegida: " + stringFecha + "\nFecha actual: " +stringFechaActual);
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
				VentanaModificarReserva.this.dispose();
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

		public void actualizar(int evento, TReserva tReserva) {
			switch (evento) {
			case (EventoGUI.RESERVA_MODIFICADO):{
				//Colocamos los campos de nuevo a vacios.
				this.estadoVentanaInicial(tReserva);
				JOptionPane.showMessageDialog(null, "Reserva modificada correctamente");
				VentanaModificarReserva.this.dispose();
				VentanaBuscarReserva.getInstance().setVisible(true);


			}break;

			case (EventoGUI.MODIFICAR_RESERVA_MOSTRAR_DATOS):{
				String stringID = Integer.toString(tReserva.getId_Reserva());
				txtFieldID_Reserva.setText(stringID);

				try {
					comboCalendar.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tReserva.getPlaza_vehiculo().getFecha_registro()));
					
		
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "Error con la fecha de la reserva");
				}
				String stringMatricula = tReserva.getMatricula();
				txtFieldMatricula.setText(stringMatricula);

			}; break;
			
			case (EventoGUI.MODIFICAR_RESERVA_ERROR):{
				JOptionPane.showMessageDialog(null, "Matrícula no existente o plazas completas");
			}; break;
			}
		}

		private void estadoVentanaInicial(TReserva tReserva){
			/*
		String stringID = Integer.toString(tZona.getId_zona());
		txtFieldID_Zona.setText(stringID);
		//txtFieldID_Zona.disable();

		String stringColor = tZona.getColor();
		txtFieldColor.setText(stringColor);

		String stringPlanta = Integer.toString(tZona.getPlanta());
		txtFieldPlanta.setText(stringPlanta);
			 */
		}

	
}
