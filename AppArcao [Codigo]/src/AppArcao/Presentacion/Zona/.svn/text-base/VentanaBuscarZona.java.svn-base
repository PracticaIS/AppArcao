/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Zona;

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

import AppArcao.Negocio.Zona.TZona;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 05/05/2015
 * @File_Name VentanaMostrarZona.java
 */
public class VentanaBuscarZona extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3610815232964018624L;
	
	private static VentanaBuscarZona instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel llabelID_Zona;
	private JTextField txtFieldID_Zona;
	
	private JButton botonBuscarZona;
	private JButton botonAtras;
	
	private int tipoEventoGUI;
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBuscarZona(){
		super("Buscar Zona");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBuscarZona getInstance(){
		if(instance == null){
			instance = new VentanaBuscarZona();
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
		
		llabelID_Zona = new JLabel("ID_Zona: ");
		txtFieldID_Zona = new  JTextField(10);
		
		botonBuscarZona = new JButton("Buscar Zona");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(llabelID_Zona);
		panelDatos.add(txtFieldID_Zona);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarZona);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		
		OyenteBuscarZona oyente = new OyenteBuscarZona();
		this.addWindowListener(new EscuchaVentana());
		botonBuscarZona.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	
	public class OyenteBuscarZona implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Apéndice de método generado automáticamente
			if(event.getSource() == botonAtras){
				VentanaBuscarZona.this.dispose();
				JPrincipal.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarZona){
				String stringID = "";
				stringID = txtFieldID_Zona.getText();
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TZona tZona = new TZona(Integer.parseInt(stringID),null , -1);
						if(tipoEventoGUI == EventoGUI.BUSCA_ZONA_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoNegocio.BUSCA_ZONA_MODIFICAR, tZona);
						}else if (tipoEventoGUI == EventoGUI.BUSCAR_ZONA){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_ZONA, tZona);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Zona");
						//Devolvemos el foco.
						txtFieldID_Zona.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID valido");
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
			VentanaBuscarZona.this.dispose();
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
			case EventoGUI.BUSCAR_ZONA_ERROR:{
				JOptionPane.showMessageDialog(null, "La zona no existe en el sistema");
				
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
		
		txtFieldID_Zona.setText("");
		
	}
		
}
