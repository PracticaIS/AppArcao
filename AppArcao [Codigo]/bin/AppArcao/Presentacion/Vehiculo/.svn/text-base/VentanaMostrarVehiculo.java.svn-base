/**
 * 
 */
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
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppArcao.Negocio.Vehiculo.TVehiculo;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Chema
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaMostrarVehiculo extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1589253766443634608L;


	private static VentanaMostrarVehiculo instance = null; //instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBoton;
	private JPanel panelDatos2;
	
	private JLabel labelId_Vehiculo;
	private JLabel labelId_Socio;
	private JLabel labelMatricula;
	private JLabel labelMarca;
	private JLabel labelTipo;
	private JLabel labelColor;

	private JTextField txtFieldIdVehiculo;
	private JTextField txtFieldId_Socio;
	private JTextField txtFieldMatricua;
	private JTextField txtFieldMarca;
	private JTextField txtFieldTipo;
	private JTextField txtFieldColor;
	
	private JButton botonAtras;
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaMostrarVehiculo(){
		super("Mostrar Vehiculo");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	public static VentanaMostrarVehiculo getInstance(){
		if(instance == null){
			instance = new VentanaMostrarVehiculo();
		}
		
		return instance;
	}

	/**
	 * 
	 */
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
		
		labelId_Vehiculo = new JLabel("Id vehiculo: ");
		txtFieldIdVehiculo = new JTextField(15);
		
	
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBoton = new JPanel();
		panelDatos2 = new JPanel();
		
		panelDatos.add(labelId_Vehiculo);
		panelDatos.add(txtFieldIdVehiculo);
		
		panelDatos.add(labelId_Socio);
		panelDatos.add(txtFieldId_Socio);

		panelDatos.add(labelMatricula);
		panelDatos.add(txtFieldMatricua);
		
		panelDatos2.add(labelMarca);
		panelDatos2.add(txtFieldMarca);
		
		panelDatos2.add(labelTipo);
		panelDatos2.add(txtFieldTipo);
		
		panelDatos2.add(labelColor);
		panelDatos2.add(txtFieldColor);
		
		
		panelBoton.add(botonAtras);
		
		this.add(panelDatos);
		this.add(panelDatos2);
		this.add(panelBoton);
		setLocationRelativeTo(null);
	
		pack();
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteMostrarVehiculo oyente = new OyenteMostrarVehiculo();
		this.addWindowListener(new EscuchaVentana());
		botonAtras.addActionListener(oyente);
		
	}
	
	
	public class OyenteMostrarVehiculo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getSource() == botonAtras){
				VentanaMostrarVehiculo.this.dispose();
				VentanaBuscarVehiculo.getInstance().setVisible(true);
				
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
			VentanaMostrarVehiculo.this.dispose();
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
	 * @param modificarZona
	 */
public void actualizar(int evento, TVehiculo mivehiculo) {
	switch (evento) {
		case (EventoGUI.MOSTRAR_VEHICULO):{
			
			String stringID = Integer.toString(mivehiculo.getId_vehiculo());
			txtFieldIdVehiculo.setText(stringID);
				
			String stringID2 = Integer.toString(mivehiculo.getId_socio());
			txtFieldId_Socio.setText(stringID2);
		
			String stringMatricula = mivehiculo.getMatricula();
			txtFieldMatricua.setText(stringMatricula);
			
			String stringmarca = mivehiculo.getMarca();
			txtFieldMarca.setText(stringmarca);
			
			String stringtipo = mivehiculo.getTipo();
			txtFieldTipo.setText(stringtipo);
			
			String stringColor = mivehiculo.getColor();
			txtFieldColor.setText(stringColor);
		
		}break;

	}
}
}