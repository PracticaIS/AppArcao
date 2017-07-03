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
 * @File_Name VentanaBorrarPlaza.java
 */
public class VentanaBorrarPlaza extends JFrame {
	
	private static final long serialVersionUID = 4153035853123180002L;
	
	private static VentanaBorrarPlaza instance = null; // instancia sigleton
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Plaza;
	
	private JTextField txtFieldID_Plaza;
	
	private JButton botonBorrarPlaza;
	
	private JButton botonAtras;
	
	
	public static void main(String args[]) {
		VentanaBorrarPlaza.getInstance().setVisible(true);
	}
	
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaBorrarPlaza(){
		super("Borrar Plaza");
		
		create();
		
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBorrarPlaza getInstance(){
		if(instance == null){
			instance = new VentanaBorrarPlaza();
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
		
		labelID_Plaza = new JLabel("ID_Plaza: ");
		txtFieldID_Plaza = new JTextField(15);
		botonBorrarPlaza = new JButton("Borrar Plaza");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Plaza);
		panelDatos.add(txtFieldID_Plaza);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarPlaza);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Plaza.setText("");
		txtFieldID_Plaza.requestFocus();
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		addWindowListener(new EscuchaVentana());
		
		OyenteBorrarPlaza oyente = new OyenteBorrarPlaza();
		
		botonAtras.addActionListener(oyente);
		botonBorrarPlaza.addActionListener(oyente);
		
	}
	
	
	public class OyenteBorrarPlaza implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			
			if(event.getSource() == botonAtras){
				VentanaBorrarPlaza.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonBorrarPlaza){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Plaza.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int ID_Plaza = Integer.parseInt(stringID);
						
						TPlaza tPlaza = new TPlaza(ID_Plaza, -1, null, -1, null, 0);
						Controlador.getInstance().action(EventoNegocio.BORRAR_PLAZA, tPlaza);
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
			VentanaBorrarPlaza.this.dispose();
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
		String IDPlaza = txtFieldID_Plaza.getText();
		estadoVentanaInicial();
		
		switch (evento) {
			case (EventoGUI.PLAZA_BORRADA):{
				JOptionPane.showMessageDialog(null, "Plaza con [ ID: " + IDPlaza + " ] borrada.");	
			}break;
	
			case (EventoGUI.PLAZA_INEXISTENTE):{
				JOptionPane.showMessageDialog(null, "La plaza no existe o hay una reserva con esta plaza.");
			}break;
		}
	}
	
	public void estadoVentanaInicial() {

		txtFieldID_Plaza.setText("");

	}

}
