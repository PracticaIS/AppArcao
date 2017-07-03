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

public class VentanaBuscarReserva  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3765404618322888554L;
	
	
	private static VentanaBuscarReserva instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel llabelID_Reserva;
	private JTextField txtFieldID_Reserva;
	
	private JButton botonBuscarReserva;
	private JButton botonAtras;
	
	private int tipoEventoGUI;
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBuscarReserva(){
		super("Buscar Reserva");
		
		create();
		
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBuscarReserva getInstance(){
		if(instance == null){
			instance = new VentanaBuscarReserva();
		}
		
		return instance;
	}

private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		llabelID_Reserva = new JLabel("ID_Reserva: ");
		txtFieldID_Reserva = new  JTextField(10);
		
		botonBuscarReserva = new JButton("Buscar Reserva");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(llabelID_Reserva);
		panelDatos.add(txtFieldID_Reserva);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarReserva);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		this.estadoVentanaInicial();
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		
		OyenteBuscarReserva oyente = new OyenteBuscarReserva();
		this.addWindowListener(new EscuchaVentana());
		botonBuscarReserva.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	
	
	public class OyenteBuscarReserva implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Apéndice de método generado automáticamente
			if(event.getSource() == botonAtras){
				VentanaBuscarReserva.this.dispose();
				JPrincipal.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarReserva){
				String stringID = "";
				stringID = txtFieldID_Reserva.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TReserva tReserva = new TReserva(Integer.parseInt(stringID),-1 , null, null);
						if(tipoEventoGUI == EventoGUI.BUSCA_RESERVA_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_RESERVA_MODIFICAR, tReserva);
						}else if (tipoEventoGUI == EventoGUI.BUSCAR_RESERVA){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_RESERVA, tReserva);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Reserva");
						//Devolvemos el foco.
						txtFieldID_Reserva.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un de ID_Reserva correcto");
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
			VentanaBuscarReserva.this.dispose();
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
	
		public void actualizar(int evento) {
			
			switch (evento){
				case EventoGUI.BUSCAR_RESERVA_ERROR:{
					JOptionPane.showMessageDialog(null, "Error al buscar la reserva en el sistema");
					
				}; break;
			}

		}
		public void setTipoEventoGUI(int tipoEventoGUI) {
			this.tipoEventoGUI = tipoEventoGUI;
		}

		/**
		 * 
		 */
		public void estadoVentanaInicial() {
			
			txtFieldID_Reserva.setText("");
			
		}
	
}
