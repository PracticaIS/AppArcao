/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Socio;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppArcao.Negocio.Socio.TSocio;
import AppArcao.Negocio.Socio.TSocioNoVIP;
import AppArcao.Negocio.Socio.TSocioVIP;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.Controlador.Controlador;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name VentanaModificarSocio.java
 */
public class VentanaModificarSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7881414256091095629L;

	private static VentanaModificarSocio instance = null;

	private JPanel panelDatos0;
	private JPanel panelDatos1;
	private JPanel panelDatos2;
	private JPanel panelBotones;

	private JLabel labelID_Socio;
	private JTextField txtFieldId_Socio;

	private JLabel labelTipo_Socio;
	private JComboBox comboBoxTipo_Socio;

	private JLabel labelNombreSocio;
	private JTextField txtFieldNombreSocio;

	private JLabel labelApellidos;
	private JTextField txtFieldApellidos;

	private JLabel labelDireccion;
	private JTextField txtFieldDireccion;

	private JLabel labelCiudad;
	private JTextField txtFieldCiudad;

	private JLabel labelProvincia;
	private JTextField txtFieldProvincia;

	private JLabel labelCod_Postal;
	private JTextField txtFieldCod_Postal;

	private JLabel labelNumTarjeta;
	private JTextField txtFieldNumTarjeta;
	
	private JLabel labelFecha_registro;
	private JTextField txtFieldFecha_registro;

	private JLabel labelEmail;
	private JTextField txtFieldEmail;

	private JLabel labelTelefono;
	private JTextField txtFieldTelefono;


	private JButton botonModificarSocio;
	private JButton botonAtras;




	public static void main(String args[]) {
		VentanaModificarSocio.getInstance().setVisible(true);
	}

	public VentanaModificarSocio(){
		super("Modificar Socio");
		create();

		agregarManejadoresDeEventos();
		
		setLocationRelativeTo(null);
		setResizable(false);
	}


	/**
	 * 
	 */
	private void create() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new GridLayout(4,1));

		labelID_Socio = new JLabel("Id Socio: ");
		txtFieldId_Socio = new JTextField(4);

		labelTipo_Socio = new JLabel("Tipo Socio ");
		Vector<String> items = new Vector<String>();
		items.add("VIP");
		items.add("NO VIP");
		comboBoxTipo_Socio = new JComboBox(items);


		labelNombreSocio = new JLabel("Nombre: ");
		txtFieldNombreSocio = new JTextField(6);

		labelApellidos = new JLabel("Apellidos: ");
		txtFieldApellidos = new JTextField(9);

		labelDireccion = new JLabel("Dirección: ");
		txtFieldDireccion = new JTextField(12);

		labelCiudad = new JLabel("Ciudad: ");
		txtFieldCiudad = new JTextField(6);

		labelProvincia = new JLabel("Provincia: ");
		txtFieldProvincia = new JTextField(6);

		labelCod_Postal = new JLabel("Codigo Postal: ");
		txtFieldCod_Postal = new JTextField(4);

		labelNumTarjeta = new JLabel("Num Tarjeta: ");
		txtFieldNumTarjeta = new JTextField(12);
		
		labelFecha_registro = new JLabel("Fecha resgistro: ");
		txtFieldFecha_registro = new JTextField(6);
		
		labelEmail = new JLabel("Email: ");
		txtFieldEmail = new JTextField(16);

		labelTelefono = new JLabel("Telefono: ");
		txtFieldTelefono = new JTextField(7);


		botonModificarSocio = new JButton("Modificar Socio");
		botonAtras = new JButton("Atras");


		labelEmail.setVisible(false);
		txtFieldEmail.setVisible(false);


		panelDatos0 = new JPanel();
		panelDatos1 = new JPanel();
		panelDatos2 = new JPanel();
		panelBotones = new JPanel();

		panelDatos0.add(labelTipo_Socio);
		panelDatos0.add(comboBoxTipo_Socio);

		panelDatos1.add(labelID_Socio);
		panelDatos1.add(txtFieldId_Socio);

		panelDatos1.add(labelNombreSocio);
		panelDatos1.add(txtFieldNombreSocio);

		panelDatos1.add(labelApellidos);
		panelDatos1.add(txtFieldApellidos);

		panelDatos1.add(labelDireccion);
		panelDatos1.add(txtFieldDireccion);

		panelDatos1.add(labelCiudad);
		panelDatos1.add(txtFieldCiudad);

		panelDatos2.add(labelProvincia);
		panelDatos2.add(txtFieldProvincia);

		panelDatos2.add(labelCod_Postal);
		panelDatos2.add(txtFieldCod_Postal);

		panelDatos2.add(labelNumTarjeta);
		panelDatos2.add(txtFieldNumTarjeta);

		panelDatos2.add(labelFecha_registro);
		panelDatos2.add(txtFieldFecha_registro);

		panelDatos2.add(labelEmail);
		panelDatos2.add(txtFieldEmail);

		panelDatos2.add(labelTelefono);
		panelDatos2.add(txtFieldTelefono);

		panelBotones.add(botonAtras);
		panelBotones.add(botonModificarSocio);

		this.add(panelDatos0);
		this.add(panelDatos1);
		this.add(panelDatos2);
		this.add(panelBotones);
		setLocationRelativeTo(null);

		pack();
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteModificarSocio oyente = new OyenteModificarSocio();
		this.addWindowListener(new EscuchaVentana());
		botonModificarSocio.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		comboBoxTipo_Socio.addActionListener(oyente);

	}


	public static VentanaModificarSocio getInstance(){
		if(instance == null){
			instance = new VentanaModificarSocio();
		}

		return instance ;
	}

	public class OyenteModificarSocio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == botonAtras){
				VentanaModificarSocio.this.dispose();
				VentanaBuscarSocio.getInstance().setVisible(true);

			}

			if (event.getSource() == comboBoxTipo_Socio) {

				if (comboBoxTipo_Socio.getSelectedItem().equals("VIP")){

					labelEmail.setVisible(false);
					txtFieldEmail.setVisible(false);
					txtFieldEmail.setText("");

					labelTelefono.setVisible(true);
					txtFieldTelefono.setVisible(true);

				} else if (comboBoxTipo_Socio.getSelectedItem().equals("NO VIP")){

					labelTelefono.setVisible(false);
					txtFieldTelefono.setVisible(false);
					txtFieldTelefono.setText("");

					labelEmail.setVisible(true);
					txtFieldEmail.setVisible(true);
				}

			}

			if(event.getSource() == botonModificarSocio){
				TSocio socioNuevo = null;
				boolean socioVip = false;

				@SuppressWarnings("unused")
				String stringId_Socio = "";
				stringId_Socio = txtFieldId_Socio.getText();
				
				String stringNombre = "";
				stringNombre = txtFieldNombreSocio.getText();

				String stringApellidos = "";
				stringApellidos = txtFieldApellidos.getText();

				String stringDireccion = "";
				stringDireccion = txtFieldDireccion.getText();

				String stringCiudad = "";
				stringCiudad = txtFieldCiudad.getText();

				String stringProvincia = "";
				stringProvincia = txtFieldProvincia.getText();

				String stringCod_Postal = "";
				stringCod_Postal = txtFieldCod_Postal.getText();

				String stringNumTarjeta = "";
				stringNumTarjeta = txtFieldNumTarjeta.getText();


				String stringEmail = "";
				String stringTelefono = "";

				String stringTipoSocio = "";

				if(comboBoxTipo_Socio.getSelectedItem().equals("VIP")){
					socioVip = true;
					stringTipoSocio = "VIP";
					stringTelefono = txtFieldTelefono.getText();
				}else{
					socioVip = false;
					stringTipoSocio = "NO VIP";
					stringEmail = txtFieldEmail.getText();
				}

				//******* Obtencion de datos de la ventana ******


				if(!stringNombre.equalsIgnoreCase("")){
					if (!stringApellidos.equalsIgnoreCase("")){
						if(!stringDireccion.equalsIgnoreCase("")){
							if(!stringCiudad.equalsIgnoreCase("")){
								if(!stringProvincia.equalsIgnoreCase("")){
									if(!stringCod_Postal.equalsIgnoreCase("") && (stringCod_Postal.length() == 5)){
										try{
											Integer.parseInt(stringCod_Postal);
											if(!stringNumTarjeta.equalsIgnoreCase("")  && (stringNumTarjeta.length() == 16)){

												if(socioVip){
													if(!stringTelefono.equalsIgnoreCase("")){
														socioNuevo = new TSocioVIP(Integer.parseInt(txtFieldId_Socio.getText()), stringNombre, stringApellidos, stringDireccion, stringCiudad, stringProvincia, 
																stringCod_Postal, stringNumTarjeta, null, 1, stringTipoSocio, -1, stringTelefono, Integer.parseInt(txtFieldId_Socio.getText()));
														socioNuevo.setId_socio(Integer.parseInt(txtFieldId_Socio.getText()));
														Controlador.getInstance().action(EventoNegocio.MODIFICAR_SOCIO, socioNuevo);
													}else{
														JOptionPane.showMessageDialog(null, "Introduzca un telefono");
														txtFieldTelefono.requestFocus();
													}

												}else{
													if(!stringEmail.equalsIgnoreCase("")){
														socioNuevo = new TSocioNoVIP(Integer.parseInt(txtFieldId_Socio.getText()), stringNombre, stringApellidos, stringDireccion, stringCiudad, stringProvincia, 
																stringCod_Postal, stringNumTarjeta, null, 0, stringTipoSocio, -1, stringEmail, Integer.parseInt(txtFieldId_Socio.getText()));
														socioNuevo.setId_socio(Integer.parseInt(txtFieldId_Socio.getText()));
														Controlador.getInstance().action(EventoNegocio.MODIFICAR_SOCIO, socioNuevo);
													}else{
														JOptionPane.showMessageDialog(null, "Introduzca un email");
														txtFieldEmail.requestFocus();
													}

												}


											}else{
												JOptionPane.showMessageDialog(null, "Introduzca un numero de tarjeta correcto");
												txtFieldNumTarjeta.requestFocus();
											}

										}catch(NumberFormatException e){
											JOptionPane.showMessageDialog(null, "Introduzca un numero de tarjeta correcto");
											txtFieldNumTarjeta.requestFocus();
										}


									}else{
										JOptionPane.showMessageDialog(null, "Introduzca un codigo postal numérico");
										txtFieldCod_Postal.requestFocus();
									}
								}else{
									JOptionPane.showMessageDialog(null, "Introduzca una provincia");
									txtFieldProvincia.requestFocus();
								}
							}else{
								JOptionPane.showMessageDialog(null, "Introduzca una ciudad");
								txtFieldCiudad.requestFocus();
							}
						}else{
							JOptionPane.showMessageDialog(null, "Introduzca una dirección");
							txtFieldDireccion.requestFocus();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca los apellidos");
						txtFieldApellidos.requestFocus();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca un nombre");
					txtFieldNombreSocio.requestFocus();
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
			VentanaBuscarSocio.getInstance().setVisible(true);
			VentanaModificarSocio.this.dispose();
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

	public void actualiza(int evento, TSocio datos) {
		switch (evento) {
		case (EventoGUI.SOCIO_MODIFICADO):{
			//Colocamos los campos de nuevo a vacios.
			this.estadoVentanaInicial();
			JOptionPane.showMessageDialog(null, "Socio modificado correctamente");
			VentanaModificarSocio.this.dispose();
			VentanaBuscarSocio.getInstance().setVisible(true);
		}break;

		case (EventoGUI.MODIFICAR_SOCIO_MOSTRAR_DATOS):{
			TSocio socio = datos;

			txtFieldId_Socio.setText(Integer.toString(socio.getId_socio()));

			comboBoxTipo_Socio.setSelectedItem(socio.getTipo_socio());

			txtFieldNombreSocio.setText(socio.getNombre());

			txtFieldApellidos.setText(socio.getApellidos());

			txtFieldDireccion.setText(socio.getDireccion());

			txtFieldCiudad.setText(socio.getCiudad());

			txtFieldProvincia.setText(socio.getProvincia());

			txtFieldCod_Postal.setText(socio.getCod_postal());

			txtFieldNumTarjeta.setText(socio.getNum_tarjeta());
			
			txtFieldFecha_registro.setText(socio.getFecha_regis());

			//txtFieldID_Vehiculo.setText(socio.getId_vehiculo());

			if(socio.getTipo_socio().equals("VIP")){
				TSocioVIP socioVIP = (TSocioVIP) socio;

				txtFieldEmail.setText("");
				labelEmail.setVisible(false);
				txtFieldEmail.setVisible(false);

				txtFieldTelefono.setText(socioVIP.getTelefono());
				labelTelefono.setVisible(true);
				txtFieldTelefono.setVisible(true);
			}else{
				TSocioNoVIP socioNoVIP = (TSocioNoVIP) socio;

				txtFieldTelefono.setText("");
				labelTelefono.setVisible(false);
				txtFieldTelefono.setVisible(false);

				txtFieldEmail.setText(socioNoVIP.getEmail());
				labelEmail.setVisible(true);
				txtFieldEmail.setVisible(true);
			}
			txtFieldId_Socio.setEnabled(false);
			pack();

		}break;		


		case (EventoGUI.MODIFICAR_SOCIO_ERROR):{
			JOptionPane.showMessageDialog(null, "Error al modificar el socio. Num tarjeta ya existe.");
		}break;
		}
	}

	private void estadoVentanaInicial(){
		//Colocamos el estado de los campos vacios.
		txtFieldNombreSocio.setText("");
		txtFieldApellidos.setText("");
		txtFieldDireccion.setText("");
		txtFieldCiudad.setText("");
		txtFieldProvincia.setText("");
		txtFieldCod_Postal.setText("");
		txtFieldNumTarjeta.setText("");
		txtFieldTelefono.setText("");
		txtFieldEmail.setText("");

		txtFieldNombreSocio.requestFocus();
	}

	@Override
	public void dispose(){
		this.estadoVentanaInicial();
		super.dispose();
	}
}
