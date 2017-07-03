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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AppArcao.Negocio.Plaza.TPlaza;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 10/05/2015
 * @File_Name VentanaMostrarPlaza.java
 */
public class VentanaMostrarPlaza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1632467470956944297L;


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
	private JTextField txtFieldTipo_Plaza;
	private JTextField txtFieldNum_Plaza;

	private JTextArea txtAreaDescripcion;


	private JButton botonAtras;

	private static VentanaMostrarPlaza instance = null; // instancia sigleton



	public static void main(String args[]) {
		VentanaMostrarPlaza.getInstance().setVisible(true);
	}


	/**
	 * @throws HeadlessException
	 */
	public VentanaMostrarPlaza(){
		super("Mostrar Plaza");

		create();

		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static VentanaMostrarPlaza getInstance(){
		if(instance == null){
			instance = new VentanaMostrarPlaza();
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
		txtFieldColor_Zona = new JTextField(6);
		panelDatos.add(labelColor_Zona);
		panelDatos.add(txtFieldColor_Zona);


		labelTipo_Plaza = new JLabel("Tipo Plaza: ");
		txtFieldTipo_Plaza = new JTextField(10);
		panelDatos.add(labelTipo_Plaza);
		panelDatos.add(txtFieldTipo_Plaza);

		labelNum_Plaza = new JLabel("Num Plaza: ");
		txtFieldNum_Plaza = new JTextField(5);
		panelDatos.add(labelNum_Plaza);
		panelDatos.add(txtFieldNum_Plaza);

		labelDescripcion = new JLabel("Descripción: ");
		txtAreaDescripcion = new JTextArea(3, 30);
		txtAreaDescripcion.setBorder(BorderFactory.createLineBorder(Color.gray));
		panelDescripcion.add(labelDescripcion);
		panelDescripcion.add(txtAreaDescripcion);


		botonAtras = new JButton("Atras");		
		panelBotones.add(botonAtras);

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
		OyenteMostrarPlaza oyente = new OyenteMostrarPlaza();
		this.addWindowListener(new EscuchaVentana());
		botonAtras.addActionListener(oyente);

	}


	public class OyenteMostrarPlaza implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {


			if(event.getSource() == botonAtras){
				VentanaMostrarPlaza.this.dispose();
				VentanaBuscarPlaza.getInstance().setVisible(true);

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
			VentanaMostrarPlaza.this.dispose();
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

			case (EventoGUI.MOSTRAR_PLAZA):{
				
				String stringID = Integer.toString(datos.getId_plaza());
				txtFieldID_Plaza.setText(stringID);
				//txtFieldID_Plaza.setEnabled(false);
				
				String stringColorZona = datos.getColor_Zona();
				txtFieldColor_Zona.setText(stringColorZona);

				String stringNumPlaza = Integer.toString(datos.getNum_plaza());
				txtFieldNum_Plaza.setText(stringNumPlaza);

				//comboBoxTipoPlaza.setSelectedItem(datos.getTipo_plaza());
				//comboBoxTipoPlaza.setEditable(false);

				
				txtFieldTipo_Plaza.setText(datos.getTipo_plaza());

				txtAreaDescripcion.setText(datos.getDescripcion());
				
	
			}; break;
		}
	}

}
