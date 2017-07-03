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
public class VentanaCrearVehiculo extends JFrame {
	
	/**
	 * 
	 */
	public static VentanaCrearVehiculo instance = null;
	
	
	private static final long serialVersionUID = -2917390204473835273L;
	
	private JPanel panelDatos;
	private JPanel panelDatos2;
	private JPanel panelBotones;

	private JLabel labelId_Socio;
	private JLabel labelMatricula;
	private JLabel labelMarca;
	private JLabel labelTipo;
	private JLabel labelColor;

	private JTextField txtFieldId_Socio;
	private JTextField txtFieldMatricua;
	private JTextField txtFieldMarca;
	private JTextField txtFieldTipo;
	private JTextField txtFieldColor;
	
	private JButton botonCrearVehiculo;
	private JButton botonAtras;

	
	public VentanaCrearVehiculo(){
		super("Crear vehiculo");
		
		create();
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
private void create() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(3,1));


		
		labelId_Socio = new JLabel("ID Socio: ");
		txtFieldId_Socio = new JTextField(15);
		
		labelMatricula = new JLabel("Matricula: ");
		txtFieldMatricua = new JTextField(15);
		
		labelMarca = new JLabel("Marca: ");
		txtFieldMarca = new JTextField(15);
		
		
		labelTipo = new JLabel("Tipo: ");
		txtFieldTipo = new JTextField(15);
		
		labelColor = new JLabel("Color: ");
		txtFieldColor = new JTextField(15);
		
		
		
		botonCrearVehiculo = new JButton("Crear Vehiculo");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelDatos2 = new JPanel();
		panelBotones = new JPanel();
		
	
		
		panelDatos.add(labelId_Socio);
		panelDatos.add(txtFieldId_Socio);

		panelDatos.add(labelMatricula);
		panelDatos.add(txtFieldMatricua);
		
		panelDatos.add(labelMarca);
		panelDatos.add(txtFieldMarca);
		
		panelDatos2.add(labelTipo);
		panelDatos2.add(txtFieldTipo);
		
		panelDatos2.add(labelColor);
		panelDatos2.add(txtFieldColor);
		
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrearVehiculo);
		
		this.add(panelDatos);
		this.add(panelDatos2);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}


public static VentanaCrearVehiculo getInstance(){
	if(instance == null){
		instance = new VentanaCrearVehiculo();
	}
	
	return instance ;
}

private void agregarManejadoresDeEventos() {
	OyenteCrearVehiculo oyente = new OyenteCrearVehiculo();
	this.addWindowListener(new EscuchaVentana());
	botonCrearVehiculo.addActionListener(oyente);
	botonAtras.addActionListener(oyente);
	
}	
	
public class OyenteCrearVehiculo implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == botonAtras){
			VentanaCrearVehiculo.this.dispose();
			JPrincipal.getInstance().setVisible(true);
			
		}
		
		if(event.getSource() == botonCrearVehiculo){
			
			Integer idSocio= null;
			try{
				idSocio = Integer.parseInt(txtFieldId_Socio.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Introduzca un Id Socio valido");
				//Devolvemos el foco.
				txtFieldId_Socio.requestFocus();
			};		
			String stringmatricula = "";
			stringmatricula = txtFieldMatricua.getText();
			
			String stringMarca= "";
			stringMarca= txtFieldMarca.getText();
			
			String stringTipo = "";
			stringTipo = txtFieldTipo.getText();
			
			String stringColor = "";
			stringColor = txtFieldColor.getText();
			
			
			//******* Obtencion de datos de la ventana ******

			if(idSocio!=null){
				if (!stringmatricula.equalsIgnoreCase("")){
					if(!stringMarca.equalsIgnoreCase("")){
						if(!stringTipo.equalsIgnoreCase("")){
							if(!stringColor.equalsIgnoreCase("")){
								TVehiculo mivehiculo= new TVehiculo(-1, idSocio, stringmatricula,stringMarca, stringTipo, stringColor);
								Controlador.getInstance().action(EventoNegocio.CREAR_VEHICULO, mivehiculo);
							}else{
								JOptionPane.showMessageDialog(null, "Introduzca el color");
								//Devolvemos el foco.
								txtFieldColor.requestFocus();
							}
						}else{
							JOptionPane.showMessageDialog(null, "Introduzca el tipo");
							//Devolvemos el foco.
							txtFieldTipo.requestFocus();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca la marca");
						//Devolvemos el foco.
						txtFieldMarca.requestFocus();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca la matricula");
					//Devolvemos el foco.
					txtFieldMatricua.requestFocus();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Introduzca un Identificador de Socio");
				//Devolvemos el foco.
				txtFieldColor.requestFocus();
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
			VentanaCrearVehiculo.this.dispose();
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

	public void actualiza(int evento, int datos) {
		switch (evento) {
			case (EventoGUI.MOSTRAR_VEHICULO):{
				//Colocamos los campos de nuevo a vacios.
				this.estadoVentanaInicial();
				JOptionPane.showMessageDialog(null, "Vehiculo creado. ID_Vehiculo: " + datos);
				
			}break;
	
			case (EventoGUI.VEHICULO_EXISTENTE):{
				JOptionPane.showMessageDialog(null, "Vehiculo existente");
			}break;
			
			case (EventoGUI.SOCIO_EXISTENTE):{
				
				JOptionPane.showMessageDialog(null, "No existe socio en el sistema");
			}
		}
	}
	
	private void estadoVentanaInicial(){
		//Colocamos el estado de los campos vacios.
		txtFieldColor.setText("");
		txtFieldId_Socio.setText("");
		txtFieldMarca.setText("");
		txtFieldTipo.setText("");
		txtFieldMatricua.setText("");
		txtFieldColor.requestFocus();
	}
}