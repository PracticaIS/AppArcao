package AppArcao.Presentacion.Reserva;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppArcao.Negocio.Reserva.TReserva;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;


public class VentanaBorrarReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8451406567478924599L;
	
	
	
	private static VentanaBorrarReserva instance = null; // instancia sigleton
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Reserva;
	
	private JTextField txtFieldID_Reserva;
	
	private JButton botonBorrarReserva;
	
	private JButton botonAtras;
	
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBorrarReserva(){
		super("Borrar Reserva");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBorrarReserva getInstance(){
		if(instance == null){
			instance = new VentanaBorrarReserva();
		}
		
		return instance;
	}

	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Reserva = new JLabel("ID_Reserva: ");
		txtFieldID_Reserva = new JTextField(15);
		botonBorrarReserva = new JButton("Borrar Reserva");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Reserva);
		panelDatos.add(txtFieldID_Reserva);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarReserva);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Reserva.setText("");
		txtFieldID_Reserva.requestFocus();
	
		pack();
		
	}
	
	private void agregarManejadoresDeEventos() {
		addWindowListener(new EscuchaVentana());
		
		OyenteBorrarReserva oyente = new OyenteBorrarReserva();
		
		botonAtras.addActionListener(oyente);
		botonBorrarReserva.addActionListener(oyente);
		
		
	}
	public class OyenteBorrarReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			
			if(event.getSource() == botonAtras){
				VentanaBorrarReserva.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonBorrarReserva){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Reserva.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int ID_Reserva = Integer.parseInt(stringID);
						
						TReserva treserva = new TReserva(ID_Reserva, -1, null, null);
						Controlador.getInstance().action(EventoNegocio.BORRAR_RESERVA, treserva);
					}catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "ID incorrecto");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "ID incorrecto");
				}
				
				
			}
		}
		
	}

	class EscuchaVentana implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			VentanaBorrarReserva.this.dispose();
			JPrincipal.getInstance().setVisible(true);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente
		}
    }
	
public void actualizar(int evento) {
		switch (evento) {
			case (EventoGUI.RESERVA_BORRADA):{
				JOptionPane.showMessageDialog(null, "Reserva con [ ID: " + txtFieldID_Reserva.getText() + " ] borrada.");	
			}break;
	
			case (EventoGUI.RESERVA_INEXISTENTE):{
				JOptionPane.showMessageDialog(null, "La reserva no existe en el sistema, o es una reserva para hoy.");
			}break;
		}
	}
}
