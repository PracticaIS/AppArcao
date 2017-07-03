package AppArcao.Presentacion.Zona;

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

import AppArcao.Negocio.Zona.TZona;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Controlador.Controlador;

/**
 * @Project_Name PruebaVentanaAppArcao
 * @Author Rodrigo de Miguel GonzÃ¡lez
 * @Date 03/05/2015
 * @File_Name CrearZona.java
 */
public class VentanaCrearZona extends JFrame {

	private static VentanaCrearZona instance = null;

	private JPanel panelDatos;
	private JPanel panelBotones;
	private JLabel labelColor;
	private JLabel labelPlanta;
	private JTextField txtFieldPlanta;
	private JTextField txtFieldColor;
	private JButton botonCrearZona;
	private JButton botonAtras;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8750603703477734784L;

	
	public VentanaCrearZona(){
		super("Crear Zona");
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
		this.setLayout(new GridLayout(2,1));
		
		labelColor = new JLabel("Color: ");
		txtFieldColor = new JTextField(15);
		labelPlanta = new JLabel("Planta: ");
		txtFieldPlanta = new JTextField(15);
		botonCrearZona = new JButton("Crear Zona");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelColor);
		panelDatos.add(txtFieldColor);
		panelDatos.add(labelPlanta);
		panelDatos.add(txtFieldPlanta);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonCrearZona);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
	
		pack();
	}


	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteCrearZona oyente = new OyenteCrearZona();
		this.addWindowListener(new EscuchaVentana());
		botonCrearZona.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}

	
	public static VentanaCrearZona getInstance(){
		if(instance == null){
			instance = new VentanaCrearZona();
		}
		
		return instance ;
	}
	
	public class OyenteCrearZona implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == botonAtras){
				estadoVentanaInicial();
				VentanaCrearZona.this.dispose();
				JPrincipal.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonCrearZona){
				String stringColor = "";
				stringColor = txtFieldColor.getText();
				String stringPlanta = "";
				stringPlanta = txtFieldPlanta.getText();
				//******* Obtencion de datos de la ventana ******
			
			try{
				if(!stringColor.equalsIgnoreCase("")){
					if (!stringPlanta.equalsIgnoreCase("")){
						TZona tZona = new TZona(-1, stringColor, Integer.parseInt(stringPlanta));
						Controlador.getInstance().action(EventoNegocio.CREAR_ZONA, tZona);
					}
					else{
						JOptionPane.showMessageDialog(null, "Introduzca la planta");
						//Devolvemos el foco.
						txtFieldPlanta.requestFocus();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Introduzca un color");
					//Devolvemos el foco.
					txtFieldColor.requestFocus();
				}
				
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Introduzca un numero de planta");
				//Devolvemos el foco.
				txtFieldPlanta.requestFocus();
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
			estadoVentanaInicial();
			JPrincipal.getInstance().setVisible(true);
			VentanaCrearZona.this.dispose();
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
			case (EventoGUI.MOSTRAR_ZONA):{
				//Colocamos los campos de nuevo a vacios.
				this.estadoVentanaInicial();
				JOptionPane.showMessageDialog(null, "Zona creada. ID_ZONA: " + datos);
				
			}break;
	
			case (EventoGUI.ZONA_EXISTENTE):{
				this.estadoVentanaInicial();
				JOptionPane.showMessageDialog(null, "Color de zona ya existente en el sistema.");
			}break;
		}
	}
	
	private void estadoVentanaInicial(){
		//Colocamos el estado de los campos vacios.
		txtFieldColor.setText("");
		txtFieldPlanta.setText("");
		txtFieldColor.requestFocus();
	}
	
	@Override
	public void dispose(){
		estadoVentanaInicial();
		super.dispose();
	}

}
