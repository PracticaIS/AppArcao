package AppArcao.Presentacion.Vehiculo;

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

import AppArcao.Negocio.Vehiculo.TVehiculo;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;

public class VentanaBuscarVehiculo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7183390626349184998L;

	private static VentanaBuscarVehiculo instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel llabelId_vehiculo;
	private JTextField txtFieldId_vehiculo;
	
	private JButton botonBuscarVehiculo;
	private JButton botonAtras;
	
	private int tipoEventoGUI;
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBuscarVehiculo(){
		super("Buscar Vehiculo");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBuscarVehiculo getInstance(){
		if(instance == null){
			instance = new VentanaBuscarVehiculo();
		}
		
		return instance;
	}

	/**
	 * 
	 */
	private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		llabelId_vehiculo = new JLabel("ID_Vehiculo: ");
		txtFieldId_vehiculo = new  JTextField(10);
		
		botonBuscarVehiculo = new JButton("Buscar Vehiculo");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(llabelId_vehiculo);
		panelDatos.add(txtFieldId_vehiculo);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarVehiculo);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		
		OyenteBuscarVehiculo oyente = new OyenteBuscarVehiculo();
		this.addWindowListener(new EscuchaVentana());
		botonBuscarVehiculo.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	
	public class OyenteBuscarVehiculo implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Apéndice de método generado automáticamente
			if(event.getSource() == botonAtras){
				VentanaBuscarVehiculo.this.dispose();
				JPrincipal.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarVehiculo){
				String stringID = "";
				stringID = txtFieldId_vehiculo.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						
						TVehiculo tVehiculo = new TVehiculo(Integer.parseInt(stringID), -1, null, null, null, null);
					
						if(tipoEventoGUI == EventoGUI.BUSCA_VEHICULO_PARA_MODIFICAR){
					
							Controlador.getInstance().action(EventoNegocio.BUSCAR_VEHICULO_MODIFICAR, tVehiculo);
						
						}else{
							if (tipoEventoGUI == EventoGUI.BUSCAR_VEHICULO){
								Controlador.getInstance().action(EventoNegocio.BUSCAR_VEHICULO, tVehiculo);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID del vehiculo");
						//Devolvemos el foco.
						txtFieldId_vehiculo.requestFocus();
					}}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Introduzca un ID del vehiculo valido");};
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
			VentanaBuscarVehiculo.this.dispose();
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
	
	/**
	 * @param buscarZonaError
	 */
	public void actualizar(int evento) {
		
		switch (evento){
			case EventoGUI.BUSCAR_VEHICULO_ERROR:{
				JOptionPane.showMessageDialog(null, "Error al buscar el vehiculo en el sistema");
				
			}; break;
		}
			
	}

	/**
	 * @param tipoEventoGUI el tipoEventoGUI a establecer
	 */
	public void setTipoEventoGUI(int tipoEventoGUI) {
		this.tipoEventoGUI = tipoEventoGUI;
	}

	/**
	 * 
	 */
	public void estadoVentanaInicial() {
		
		txtFieldId_vehiculo.setText("");
		
	}
}
