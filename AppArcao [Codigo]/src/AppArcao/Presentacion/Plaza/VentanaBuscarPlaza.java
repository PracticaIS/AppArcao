/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Plaza;

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

import AppArcao.Negocio.Plaza.TPlaza;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;


/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 10/05/2015
 * @File_Name VentanaBuscarPlaza.java
 */
public class VentanaBuscarPlaza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3610815232964018624L;
	
	private static VentanaBuscarPlaza instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel llabelID_Plaza;
	private JTextField txtFieldID_Plaza;
	
	private JButton botonBuscarPlaza;
	private JButton botonAtras;
	
	private int tipoEventoGUI;
	
	
	public static void main(String args[]) {
		VentanaBuscarPlaza.getInstance().setVisible(true);
	}
	
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBuscarPlaza(){
		super("Buscar Plaza");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBuscarPlaza getInstance(){
		if(instance == null){
			instance = new VentanaBuscarPlaza();
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
		
		llabelID_Plaza = new JLabel("ID_Plaza: ");
		txtFieldID_Plaza = new  JTextField(10);
		
		botonBuscarPlaza = new JButton("Buscar Plaza");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(llabelID_Plaza);
		panelDatos.add(txtFieldID_Plaza);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBuscarPlaza);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		
		OyenteBuscarPlaza oyente = new OyenteBuscarPlaza();
		this.addWindowListener(new EscuchaVentana());
		botonBuscarPlaza.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	
	public class OyenteBuscarPlaza implements ActionListener{

		/* (sin Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getSource() == botonAtras){
				VentanaBuscarPlaza.this.dispose();
				JPrincipal.getInstance().setVisible(true);
			}
			
			if(event.getSource() == botonBuscarPlaza){
				String stringID = "";
				stringID = txtFieldID_Plaza.getText();
				
				//******* Obtencion de datos de la ventana ******
				try{
					if (!stringID.equalsIgnoreCase("")){
						TPlaza tPlaza = new TPlaza(Integer.parseInt(stringID), -1, null, -1, null, 0); 
						if(tipoEventoGUI == EventoGUI.BUSCA_PLAZA_PARA_MODIFICAR){
							Controlador.getInstance().action(EventoNegocio.BUSCA_PLAZA_MODIFICAR, tPlaza);
						}else if (tipoEventoGUI == EventoGUI.BUSCAR_PLAZA){
							Controlador.getInstance().action(EventoNegocio.BUSCAR_PLAZA, tPlaza);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el ID_Plaza");
						//Devolvemos el foco.
						txtFieldID_Plaza.requestFocus();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un ID de plaza correcto");
					//Devolvemos el foco.
					txtFieldID_Plaza.requestFocus();
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
			VentanaBuscarPlaza.this.dispose();
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
			case EventoGUI.BUSCAR_PLAZA_ERROR:{
				JOptionPane.showMessageDialog(null, "La plaza no existe en el sistema");
				
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
		
		txtFieldID_Plaza.setText("");
		
	}
}
