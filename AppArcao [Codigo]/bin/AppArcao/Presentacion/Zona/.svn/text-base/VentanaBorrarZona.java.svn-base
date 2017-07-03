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
 * @File_Name ventanaBorrarZona.java
 */
public class VentanaBorrarZona extends JFrame{

	private static final long serialVersionUID = 4153035853123180002L;
	
	
	private static VentanaBorrarZona instance = null; // instancia sigleton
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Zona;
	
	private JTextField txtFieldID_Zona;
	
	private JButton botonBorrarZona;
	
	private JButton botonAtras;
	/**
	 * @throws HeadlessException
	 */
	public VentanaBorrarZona(){
		super("Borrar Zona");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static VentanaBorrarZona getInstance(){
		if(instance == null){
			instance = new VentanaBorrarZona();
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
		
		labelID_Zona = new JLabel("ID_Zona: ");
		txtFieldID_Zona = new JTextField(15);
		botonBorrarZona = new JButton("Borrar Zona");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Zona);
		panelDatos.add(txtFieldID_Zona);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarZona);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Zona.setText("");
		txtFieldID_Zona.requestFocus();
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		addWindowListener(new EscuchaVentana());
		
		OyenteBorrarZona oyente = new OyenteBorrarZona();
		
		botonAtras.addActionListener(oyente);
		botonBorrarZona.addActionListener(oyente);
		
		// TODO Apéndice de método generado automáticamente
		
	}
	
	
	public class OyenteBorrarZona implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			
			if(event.getSource() == botonAtras){
				VentanaBorrarZona.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonBorrarZona){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Zona.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int ID_Zona = Integer.parseInt(stringID);
						
						TZona tZona = new TZona(ID_Zona, null, -1);
						Controlador.getInstance().action(EventoNegocio.BORRAR_ZONA, tZona);
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
			VentanaBorrarZona.this.dispose();
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
			case (EventoGUI.ZONA_BORRADA):{
				JOptionPane.showMessageDialog(null, "Zona con [ ID: " + txtFieldID_Zona.getText() + " ] borrada.");	
			}break;
	
			case (EventoGUI.ZONA_INEXISTENTE):{
				JOptionPane.showMessageDialog(null, "La zona no existe o tiene plazas asignadas");
			}break;
		}
	}
	
}
