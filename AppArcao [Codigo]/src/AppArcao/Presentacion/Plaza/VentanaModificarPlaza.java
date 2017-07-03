/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Plaza;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
 * @File_Name VentanaModificarPlaza.java
 */
public class VentanaModificarPlaza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -704472961850798836L;



	private JPanel panelDatos;
	private JPanel panelBotones;
	private JPanel panelDescripcion;

	private JLabel labelID_Plaza;
	private JLabel labelColor_Zona;
	private JLabel labelTipo_Plaza;
	private JLabel labelNum_Plaza;
	private JLabel labelDescripcion;

	private JTextField txtFieldID_Plaza;
	private JTextField txtFieldColor_Zona;
	private JComboBox comboBoxTipoPlaza;
	private JTextField txtFieldNum_Plaza;
	private JTextArea txtAreaDescripcion;


	private JButton botonModificarZona;
	private JButton botonAtras;

	private static VentanaModificarPlaza instance = null; // instancia sigleton



	public static void main(String args[]) {
		VentanaModificarPlaza.getInstance().setVisible(true);
	}


	/**
	 * @throws HeadlessException
	 */
	public VentanaModificarPlaza(){
		super("Modificar Plaza");

		create();

		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);

	}

	public static VentanaModificarPlaza getInstance(){
		if(instance == null){
			instance = new VentanaModificarPlaza();
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


		panelDatos = new JPanel();
		panelBotones = new JPanel();
		panelDescripcion = new JPanel();


		labelID_Plaza = new JLabel("ID_Plaza: ");
		txtFieldID_Plaza = new  JTextField(5);
		panelDatos.add(labelID_Plaza);
		panelDatos.add(txtFieldID_Plaza);


		labelColor_Zona = new JLabel("Color Zona: ");
		txtFieldColor_Zona = new JTextField(10);
		panelDatos.add(labelColor_Zona);
		panelDatos.add(txtFieldColor_Zona);


		labelTipo_Plaza = new JLabel("Tipo Plaza: ");
		Vector<String> items = new Vector<String>();
		items.add(" ");
		items.add("NORMAL");
		items.add("MINUSVÁLIDOS");
		items.add("MOTO");
		items.add("CAMIÓN");
		comboBoxTipoPlaza = new JComboBox(items);
		panelDatos.add(labelTipo_Plaza);
		panelDatos.add(comboBoxTipoPlaza);

		labelNum_Plaza = new JLabel("Num Plaza: ");
		txtFieldNum_Plaza = new JTextField(5);
		panelDatos.add(labelNum_Plaza);
		panelDatos.add(txtFieldNum_Plaza);

		labelDescripcion = new JLabel("Descripción: ");
		txtAreaDescripcion = new JTextArea(3, 30);
		txtAreaDescripcion.setBorder(BorderFactory.createLineBorder(Color.gray));
		panelDescripcion.add(labelDescripcion);
		panelDescripcion.add(txtAreaDescripcion);


		botonModificarZona = new JButton("Modificar Zona");
		botonAtras = new JButton("Atras");		
		panelBotones.add(botonAtras);
		panelBotones.add(botonModificarZona);

		this.add(panelDatos);
		this.add(panelDescripcion);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		txtFieldID_Plaza.setEnabled(false);
		txtFieldNum_Plaza.setEnabled(false);
		
		pack();

	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteModificarPlaza oyente = new OyenteModificarPlaza();
		this.addWindowListener(new EscuchaVentana());
		botonModificarZona.addActionListener(oyente);
		botonAtras.addActionListener(oyente);

	}


	public class OyenteModificarPlaza implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {


			if(event.getSource() == botonAtras){
				VentanaModificarPlaza.this.dispose();
				VentanaBuscarPlaza.getInstance().setVisible(true);

			}

			if(event.getSource() == botonModificarZona){
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Plaza.getText();

				String stringColorZona = "";
				stringColorZona = txtFieldColor_Zona.getText();

				String stringNumPlaza = "";
				stringNumPlaza = txtFieldNum_Plaza.getText();

				String stringTipoPlaza = "";
				stringTipoPlaza = (String) comboBoxTipoPlaza.getSelectedItem();

				String stringDescrip = "";
				stringDescrip = txtAreaDescripcion.getText();

				if(!stringColorZona.equalsIgnoreCase("")){
					if (!stringTipoPlaza.equalsIgnoreCase(" ")){
						if (!stringDescrip.equalsIgnoreCase("")){

							TPlaza tPlaza = new TPlaza(Integer.parseInt(stringID), stringColorZona, stringTipoPlaza, Integer.parseInt(stringNumPlaza),stringDescrip,0);
							Controlador.getInstance().action(EventoNegocio.MODIFICAR_PLAZA, tPlaza);

						}else{
							JOptionPane.showMessageDialog(null, "Introduzca una descripción de plaza");
							//Devolvemos el foco.
							txtAreaDescripcion.requestFocus();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Introduzca el tipo de plaza");
						//Devolvemos el foco.
						comboBoxTipoPlaza.requestFocus();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca el color de la Zona");
					//Devolvemos el foco.
					txtFieldColor_Zona.requestFocus();
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
			VentanaModificarPlaza.this.dispose();
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
	public void actualizar(int evento, TPlaza datos) {
		switch (evento) {
		case (EventoGUI.PLAZA_MODIFICADA):{
			//Colocamos los campos de nuevo a vacios.
			//this.estadoVentanaInicial(tZona);

			JOptionPane.showMessageDialog(null, "Plaza modificada correctamente");
			VentanaModificarPlaza.this.dispose();
			VentanaBuscarPlaza.getInstance().setVisible(true);

		}break;

		case (EventoGUI.MODIFICAR_PLAZA_MOSTRAR_DATOS):{

			String stringID = Integer.toString(datos.getId_plaza());
			txtFieldID_Plaza.setText(stringID);
			//txtFieldID_Plaza.setEnabled(false);

			/*txtFieldID_Plaza;
				txtFieldColor_Zona;
				comboBoxTipoPlaza;
				txtFieldNum_Plaza;*/
			String stringColorZona = datos.getColor_Zona();
			txtFieldColor_Zona.setText(stringColorZona);

			String stringPlanta = Integer.toString(datos.getNum_plaza());
			txtFieldNum_Plaza.setText(stringPlanta);

			String stringDescripcion = datos.getDescripcion();
			txtAreaDescripcion.setText(stringDescripcion);

			comboBoxTipoPlaza.setSelectedItem(datos.getTipo_plaza());
			comboBoxTipoPlaza.setEditable(false);

			//Vector<String> itemsAux = new Vector<String>();

			//itemsAux.add(datos.getTipo_plaza());
			//comboBoxTipoPlaza = new JComboBox(itemsAux);



		}; break;

		case (EventoGUI.MODIFICAR_ZONA_ERROR):{
			JOptionPane.showMessageDialog(null, "Error al modificar la Plaza");
		}; break;
		}
	}

}
