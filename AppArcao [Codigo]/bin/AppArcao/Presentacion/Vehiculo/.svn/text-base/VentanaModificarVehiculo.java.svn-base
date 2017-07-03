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
public class VentanaModificarVehiculo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829754883523203662L;

	
private static VentanaModificarVehiculo instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
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
	
	private JButton botonModificarVehiculo;
	private JButton botonAtras;
	
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaModificarVehiculo(){
		super("Modificar Vehiculo");
		
		create();
		
		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	private void create(){
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
		
		botonModificarVehiculo = new JButton("Modificar ");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelDatos2 = new JPanel();
		panelBotones = new JPanel();
		
		panelDatos.add(labelId_Vehiculo);
		panelDatos.add(txtFieldIdVehiculo);
		
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
		panelBotones.add(botonModificarVehiculo);
		
		this.add(panelDatos);
		this.add(panelDatos2);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	
	}
	
	
	public static VentanaModificarVehiculo getInstance(){
		if(instance == null){
			instance = new VentanaModificarVehiculo();
		}
		
		return instance;
	}
	
	private void agregarManejadoresDeEventos() {
		OyenteModificarVehiculo oyente = new OyenteModificarVehiculo();
		this.addWindowListener(new EscuchaVentana());
		botonModificarVehiculo.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	
	public class OyenteModificarVehiculo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getSource() == botonAtras){
				VentanaModificarVehiculo.this.dispose();
				VentanaBuscarVehiculo.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonModificarVehiculo){
				Integer idSocio= null;
				try{
					idSocio = Integer.parseInt(txtFieldId_Socio.getText());
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Introduzca un Id Socio valido");
					//Devolvemos el foco.
					txtFieldId_Socio.requestFocus();
				};	
				
				Integer idVehiculo= null;
				try{
					idVehiculo = Integer.parseInt(txtFieldIdVehiculo.getText());
				
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
									TVehiculo mivehiculo= new TVehiculo(idVehiculo, idSocio, stringmatricula,stringMarca, stringTipo, stringColor);
									Controlador.getInstance().action(EventoNegocio.MODIFICAR_VEHICULO, mivehiculo);
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
				}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "El id de vehiculo no es valido");
					//Devolvemos el foco.
					txtFieldId_Socio.requestFocus();
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
			VentanaModificarVehiculo.this.dispose();
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
	public void actualizar(int evento, TVehiculo tVehiculo) {
		switch (evento) {
			case (EventoGUI.VEHICULO_MODIFICADA):{
				//Colocamos los campos de nuevo a vacios.
				
				this.estadoVentanaInicial(tVehiculo);
				VentanaModificarVehiculo.this.dispose();
				JOptionPane.showMessageDialog(null, "Vehiculo modificado correctamente");
				
			}break;
			
			case (EventoGUI.MODIFICAR_VEHICULO_MOSTRAR_DATOS):{
				
				String stringID = Integer.toString(tVehiculo.getId_vehiculo());
				txtFieldIdVehiculo.setText(stringID);
				txtFieldIdVehiculo.setEnabled(false);
				
				Integer idSocio = tVehiculo.getId_socio();
				txtFieldId_Socio.setText(idSocio.toString());
				
				String matricula = tVehiculo.getMatricula();
				txtFieldMatricua.setText(matricula);
				
				String marca = tVehiculo.getMarca();
				txtFieldMarca.setText(marca);
				
				String tipo = tVehiculo.getTipo();
				txtFieldTipo.setText(tipo);
				
				String stringColor = tVehiculo.getColor();
				txtFieldColor.setText(stringColor);
				
				
			}; break;
	
			case (EventoGUI.MODIFICAR_VEHICULO_ERROR):{
				JOptionPane.showMessageDialog(null, "Error al modificar el vehiculo");
			}; break;
		}
	}


	private void estadoVentanaInicial(TVehiculo tvehiculo){
		
	}
}