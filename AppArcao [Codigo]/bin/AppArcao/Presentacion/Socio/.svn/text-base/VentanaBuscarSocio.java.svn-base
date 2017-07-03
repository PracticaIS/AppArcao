package AppArcao.Presentacion.Socio;

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

import AppArcao.Negocio.Socio.TSocio;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;


public class VentanaBuscarSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159338575153538012L;

private static VentanaBuscarSocio instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel llabelId_Socio;
	private JTextField txtFieldId_Socio;
	
	private JButton botonBuscarSocio;
	private JButton botonAtras;
	
	private int tipoEventoGUI;
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBuscarSocio(){
		super("Buscar Socio");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBuscarSocio getInstance(){
		if(instance == null){
			instance = new VentanaBuscarSocio();
		}
		
		return instance;
	}
private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		llabelId_Socio = new JLabel("ID_Socio: ");
		txtFieldId_Socio = new  JTextField(10);
		
		botonBuscarSocio = new JButton("Buscar Socio");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(llabelId_Socio);
		panelDatos.add(txtFieldId_Socio);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarSocio);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		txtFieldId_Socio.setText("");
	
		pack();
		
	}
private void agregarManejadoresDeEventos() {
	
	OyenteBuscarSocio oyente = new OyenteBuscarSocio();
	this.addWindowListener(new EscuchaVentana());
	botonBuscarSocio.addActionListener(oyente);
	botonAtras.addActionListener(oyente);
	
}


public class OyenteBuscarSocio implements ActionListener{

	/* (sin Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Apéndice de método generado automáticamente
		if(event.getSource() == botonAtras){
			VentanaBuscarSocio.this.dispose();
			JPrincipal.getInstance().setVisible(true);
		}
		
		if(event.getSource() == botonBuscarSocio){
			String stringID = "";
			stringID = txtFieldId_Socio.getText();
			//******* Obtencion de datos de la ventana ******
			try{
				if (!stringID.equalsIgnoreCase("")){
					
					TSocio misocio = new TSocio(Integer.parseInt(stringID), null, null, null, null, null, null, null, null, 0, null);
					
					if(tipoEventoGUI == EventoGUI.BUSCA_SOCIO_PARA_MODIFICAR){
				
						Controlador.getInstance().action(EventoNegocio.BUSCAR_SOCIO_MODIFICAR, misocio);
					
					}else{
						if (tipoEventoGUI == EventoGUI.BUSCAR_SOCIO){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_SOCIO, misocio);
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca el ID del Socio");
					//Devolvemos el foco.
					txtFieldId_Socio.requestFocus();
				}}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID del Socio valido");};
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
		VentanaBuscarSocio.this.dispose();
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
		case EventoGUI.BUSCAR_SOCIO_ERROR:{
			JOptionPane.showMessageDialog(null, "Socio no registrado en el sistema");
			
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
	txtFieldId_Socio.setText("");
	
}
}
