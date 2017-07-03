/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Presentacion.Plaza;

import java.awt.Color;
import java.awt.GridLayout;
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
 * @File_Name VentanaCrearPlaza.java
 */
public class VentanaCrearPlaza extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4175818216560116321L;

	private static VentanaCrearPlaza instance = null;

	private JPanel panelDatos;
	private JPanel panelDescripcion;
	private JPanel panelBotones;
	
	private JLabel labelColorZona;
	private JLabel labelTipoPlaza;
	private JLabel labelDescripcion;
	
	private JTextField txtFieldColorZona;
	private JComboBox comboBoxTipoPlaza;
	private JTextArea txtAreaDescripcion;
	
	private JButton botonCrearPlaza;
	private JButton botonAtras;
	
	
	
	
	public static void main(String args[]) {
		VentanaCrearPlaza.getInstance().setVisible(true);
	}
	
	public VentanaCrearPlaza(){
		super("Crear Plaza");
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
		this.setLayout(new GridLayout(3,1));
		
		labelColorZona = new JLabel("Color Zona: ");
		txtFieldColorZona = new JTextField(10);
		
		labelTipoPlaza = new JLabel("Tipo Plaza: ");
		Vector<String> items = new Vector<String>();
		items.add(" ");
		items.add("NORMAL");
		items.add("MINUSVÁLIDOS");
		items.add("MOTO");
		items.add("CAMIÓN");
		
		comboBoxTipoPlaza = new JComboBox(items);
		
		botonCrearPlaza = new JButton("Crear Plaza");
		botonAtras = new JButton("Atras");
		
		labelDescripcion = new JLabel("Descrpción: ");
		txtAreaDescripcion = new JTextArea(3, 30);
		txtAreaDescripcion.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		
		
		panelDatos = new JPanel();
		panelDescripcion = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelColorZona);
		panelDatos.add(txtFieldColorZona);
		
		panelDatos.add(labelTipoPlaza);
		panelDatos.add(comboBoxTipoPlaza);
		
		panelDescripcion.add(labelDescripcion);
		panelDescripcion.add(txtAreaDescripcion);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrearPlaza);
		
		this.add(panelDatos);
		this.add(panelDescripcion);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}


	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteCrearPlazas oyente = new OyenteCrearPlazas();
		this.addWindowListener(new EscuchaVentana());
		botonCrearPlaza.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}

	
	public static VentanaCrearPlaza getInstance(){
		if(instance == null){
			instance = new VentanaCrearPlaza();
		}
		
		return instance ;
	}
	
	public class OyenteCrearPlazas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				VentanaCrearPlaza.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonCrearPlaza){
				String stringColorZona = "";
				stringColorZona = txtFieldColorZona.getText();
				String stringTipoPlaza = "";
				stringTipoPlaza = (String) comboBoxTipoPlaza.getSelectedItem();
				String stringDescripcion = "";
				stringDescripcion = txtAreaDescripcion.getText();
				
				//******* Obtencion de datos de la ventana ******
			
			
				if(!stringColorZona.equalsIgnoreCase("")){
					if (!stringTipoPlaza.equalsIgnoreCase(" ")){
						if(!stringDescripcion.equalsIgnoreCase("")){


							TPlaza tPlaza = new TPlaza(-1, stringColorZona, stringTipoPlaza, -1, stringDescripcion, 0);
							Controlador.getInstance().action(EventoNegocio.CREAR_PLAZA, tPlaza);

						}else{
							JOptionPane.showMessageDialog(null, "Introduzca una descripción");
							txtAreaDescripcion.requestFocus();
						}

					}else{
						JOptionPane.showMessageDialog(null, "Introduzca un tipo de plaza");
						//Devolvemos el foco.
						comboBoxTipoPlaza.requestFocus();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca un color de zona");
					//Devolvemos el foco.
					txtFieldColorZona.requestFocus();
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
			VentanaCrearPlaza.this.dispose();
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
			case (EventoGUI.MOSTRAR_PLAZA):{
				//Colocamos los campos de nuevo a vacios.
				this.estadoVentanaInicial();
				JOptionPane.showMessageDialog(null, "Plaza creada ID_Plaza: " + datos);
				
			}break;
	
			case (EventoGUI.ZONA_INEXISTENTE):{
				//Colocamos los campos de nuevo a vacios.
				JOptionPane.showMessageDialog(null, "La zona introducida no existe");
				txtFieldColorZona.requestFocus();
			}break;
			
			
			case (EventoGUI.ERROR_CREAR_PLAZA):{
				JOptionPane.showMessageDialog(null, "Error al crear la plaza");
			}break;
		}
	}
	
	private void estadoVentanaInicial(){
		//Colocamos el estado de los campos vacios.
		txtFieldColorZona.setText("");
		comboBoxTipoPlaza.setSelectedIndex(0);
		txtAreaDescripcion.setText("");
		
		txtFieldColorZona.requestFocus();
	}

}