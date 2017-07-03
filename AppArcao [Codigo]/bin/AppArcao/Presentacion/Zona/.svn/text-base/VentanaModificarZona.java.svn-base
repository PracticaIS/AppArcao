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
 * @File_Name VentanaModificarZona.java
 */
public class VentanaModificarZona extends JFrame {

	private static final long serialVersionUID = 3359820780935322456L;
	
	private static VentanaModificarZona instance = null; // instancia sigleton

	
	private JPanel panelDatos;
	private JPanel panelBotones;
	private JLabel labelID_Zona;
	private JLabel labelColor;
	private JLabel labelPlanta;
	private JTextField txtFieldID_Zona;
	private JTextField txtFieldPlanta;
	private JTextField txtFieldColor;
	
	private JButton botonModificarZona;
	private JButton botonAtras;
	
	
	/**
	 * @throws HeadlessException
	 */
	public VentanaModificarZona(){
		super("Modificar Zona");
		
		create();
		
		agregarManejadoresDeEventos();
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	public static VentanaModificarZona getInstance(){
		if(instance == null){
			instance = new VentanaModificarZona();
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
		txtFieldID_Zona = new  JTextField(10);
		
		labelColor = new JLabel("Color: ");
		txtFieldColor = new JTextField(10);
		
		labelPlanta = new JLabel("Planta: ");
		txtFieldPlanta = new JTextField(10);
		
		botonModificarZona = new JButton("Modificar Zona");
		botonAtras = new JButton("Atras");
		
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		
		
		panelDatos.add(labelID_Zona);
		panelDatos.add(txtFieldID_Zona);
		panelDatos.add(txtFieldColor);
		panelDatos.add(labelColor);
		panelDatos.add(txtFieldColor);
		panelDatos.add(labelPlanta);
		panelDatos.add(txtFieldPlanta);
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonModificarZona);
		
		this.add(panelDatos);
		this.add(panelBotones);
		setLocationRelativeTo(null);
		
		txtFieldID_Zona.setEnabled(false);
	
		pack();
		
	}

	/**
	 * 
	 */
	private void agregarManejadoresDeEventos() {
		OyenteModificarZona oyente = new OyenteModificarZona();
		this.addWindowListener(new EscuchaVentana());
		botonModificarZona.addActionListener(oyente);
		botonAtras.addActionListener(oyente);
		
	}
	
	
	public class OyenteModificarZona implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getSource() == botonAtras){
				VentanaModificarZona.this.dispose();
				VentanaBuscarZona.getInstance().setVisible(true);
				
			}
			
			if(event.getSource() == botonModificarZona){
				//******* Obtencion de datos de la ventana ******
				String stringID = "";
				stringID = txtFieldID_Zona.getText();
				
				String stringColor = "";
				stringColor = txtFieldColor.getText();
				
				String stringPlanta = "";
				stringPlanta = txtFieldPlanta.getText();
				
			
				try{
					if(!stringColor.equalsIgnoreCase("")){
						
						if (!stringPlanta.equalsIgnoreCase("")){
							TZona tZona = new TZona(Integer.parseInt(stringID), stringColor, Integer.parseInt(stringPlanta));
							Controlador.getInstance().action(EventoNegocio.MODIFICAR_ZONA, tZona);
							
						}else{
							
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
					JOptionPane.showMessageDialog(null, "Planta incorrectos");
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
			VentanaModificarZona.this.dispose();
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
	public void actualizar(int evento, TZona tZona) {
		switch (evento) {
			case (EventoGUI.ZONA_MODIFICADA):{
				//Colocamos los campos de nuevo a vacios.
				this.estadoVentanaInicial(tZona);
				JOptionPane.showMessageDialog(null, "Zona modificada correctamente");
				
			}break;
			
			case (EventoGUI.MODIFICAR_ZONA_MOSTRAR_DATOS):{
				String stringID = Integer.toString(tZona.getId_zona());
				txtFieldID_Zona.setText(stringID);
				//txtFieldID_Zona.setEnabled(false);
				
				String stringColor = tZona.getColor();
				txtFieldColor.setText(stringColor);
				
				String stringPlanta = Integer.toString(tZona.getPlanta());
				txtFieldPlanta.setText(stringPlanta);
				
				
			}; break;
	
			case (EventoGUI.MODIFICAR_ZONA_ERROR):{
				JOptionPane.showMessageDialog(null, "Error al modificar la Zona");
			}; break;
		}
	}


	private void estadoVentanaInicial(TZona tZona){
		/*
		String stringID = Integer.toString(tZona.getId_zona());
		txtFieldID_Zona.setText(stringID);
		//txtFieldID_Zona.disable();
		
		String stringColor = tZona.getColor();
		txtFieldColor.setText(stringColor);
		
		String stringPlanta = Integer.toString(tZona.getPlanta());
		txtFieldPlanta.setText(stringPlanta);
		*/
	}
}
