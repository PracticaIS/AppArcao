/**
 * 
 */
package AppArcao.Presentacion.Vehiculo;

import java.awt.GridLayout;
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


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Chema
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaBorrarVehiculo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2278780646502165424L;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	private static VentanaBorrarVehiculo instance = null;
	
	private JPanel panelDatos;
	private JPanel panelBotones;
	
	private JLabel labelID_Vehiculo;
	
	private JTextField txtFieldID_Vehiculo;
	
	private JButton botonBorrarVehiculo;
	
	private JButton botonAtras;
	
	public VentanaBorrarVehiculo(){
		super("Borrar vehiculo");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
		
	}

	public static VentanaBorrarVehiculo getInstance(){
		if(instance==null){
			instance = new VentanaBorrarVehiculo();
		}
		return instance;
	}
	
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(2,1));
		
		labelID_Vehiculo = new JLabel("ID_Vehiculo: ");
		txtFieldID_Vehiculo = new JTextField(15);
		botonBorrarVehiculo = new JButton("Borrar Vehiculo");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Vehiculo);
		panelDatos.add(txtFieldID_Vehiculo);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonBorrarVehiculo);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		//Inicializamos la vista.
		txtFieldID_Vehiculo.setText("");
		txtFieldID_Vehiculo.requestFocus();
	
		pack();
		
	}
	
	private void agregarManejadoresDeEventos() {
		addWindowListener(new EscuchaVentana());
		
		OyenteBorrarVehiculo oyente = new OyenteBorrarVehiculo();
		
		botonAtras.addActionListener(oyente);
		botonBorrarVehiculo.addActionListener(oyente);
		
		// TODO Apéndice de método generado automáticamente
		
	}
	
	public class OyenteBorrarVehiculo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			
			if(event.getSource() == botonAtras){
				VentanaBorrarVehiculo.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonBorrarVehiculo){
				
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Vehiculo.getText();
				if(!stringID.equalsIgnoreCase("")){
					try{
						int id_vehiculo = Integer.parseInt(stringID);
						
						TVehiculo tVehiculo = new TVehiculo(id_vehiculo, -1, null, null, null, null);
						Controlador.getInstance().action(EventoNegocio.BORRAR_VEHICULO, tVehiculo);
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
			VentanaBorrarVehiculo.this.dispose();
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
			case (EventoGUI.VEHICULO_BORRADO):{
				JOptionPane.showMessageDialog(null, "Vehiculo con [ ID: " + txtFieldID_Vehiculo.getText() + " ] borrado.");	
			}break;
	
			case (EventoGUI.VEHICULO_INEXISTENTE):{
				JOptionPane.showMessageDialog(null, "El vehiculo no existe o hay reservas con este vehiculo");
			}break;
		}
	
	}
}