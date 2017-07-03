/**
 * @ProjectName AppArcaoProg
 */
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

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 10/05/2015
 * @File_Name VentanaBorrarPlaza.java
 */
public class VentanaBorrarSocio extends JFrame {
	
	private static final long serialVersionUID = 4153035853123180002L;
	
	private static VentanaBorrarSocio instance = null; // instancia sigleton
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Socio;
	
	private JTextField txtFieldID_Socio;
	
	private JButton botonBorrarSocio;
	
	private JButton botonAtras;
	
	
	public static void main(String args[]) {
		VentanaBorrarSocio.getInstance().setVisible(true);
	}
	
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBorrarSocio(){
		super("Borrar Socio");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBorrarSocio getInstance(){
		if(instance == null){
			instance = new VentanaBorrarSocio();
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
		
		labelID_Socio = new JLabel("ID_Socio: ");
		txtFieldID_Socio = new JTextField(15);
		botonBorrarSocio = new JButton("Borrar Socio");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Socio);
		panelDatos.add(txtFieldID_Socio);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarSocio);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Socio.setText("");
		txtFieldID_Socio.requestFocus();
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		addWindowListener(new EscuchaVentana());
		
		OyenteBorrarSocio oyente = new OyenteBorrarSocio();
		
		botonAtras.addActionListener(oyente);
		botonBorrarSocio.addActionListener(oyente);
		
	}
	
	
	public class OyenteBorrarSocio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			
			if(event.getSource() == botonAtras){
				VentanaBorrarSocio.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonBorrarSocio){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Socio.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int ID_Socio = Integer.parseInt(stringID);
						
						TSocio tSocio = new TSocio(ID_Socio, null, null, null, null, null, null, null, null, 0, null);
						Controlador.getInstance().action(EventoNegocio.BORRAR_SOCIO, tSocio);
					}catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null, "ID incorrecto");
						txtFieldID_Socio.requestFocus();
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Introduce un ID socio");
					txtFieldID_Socio.requestFocus();
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
			VentanaBorrarSocio.this.dispose();
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
		String IDSocio = txtFieldID_Socio.getText();
		estadoVentanaInicial();
		
		switch (evento) {
			case (EventoGUI.SOCIO_BORRADO):{
				JOptionPane.showMessageDialog(null, "Socio con [ ID: " + IDSocio + " ] dado de baja.");	
				txtFieldID_Socio.requestFocus();
			}break;
	
			case (EventoGUI.SOCIO_EXISTENTE):{
				JOptionPane.showMessageDialog(null, "El socio no existe o tiene reservas asignadas.");
				txtFieldID_Socio.requestFocus();
			}break;
		}
	}
	
	public void estadoVentanaInicial() {

		txtFieldID_Socio.setText("");

	}

}
