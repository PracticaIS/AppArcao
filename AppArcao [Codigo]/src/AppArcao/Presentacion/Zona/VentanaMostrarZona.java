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
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppArcao.Negocio.Zona.TZona;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.JPrincipal;

/**
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 07/05/2015
 * @File_Name VentanaMostrarZona.java
 */
public class VentanaMostrarZona extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3359820780935322456L;
		
		private static VentanaMostrarZona instance = null; //instancia sigleton

		
		private JPanel panelDatos;
		private JPanel panelBoton;
		
		private JLabel labelID_Zona;
		private JLabel labelColor;
		private JLabel labelPlanta;
		
		private JTextField txtFieldID_Zona;
		private JTextField txtFieldPlanta;
		private JTextField txtFieldColor;
		
		private JButton botonAtras;
		
		
		/**
		 * @throws HeadlessException
		 */
		public VentanaMostrarZona(){
			super("Mostrar Zona");
			
			create();
			
			agregarManejadoresDeEventos();
			
			setLocationRelativeTo(null);
			setResizable(false);
		}
		
		public static VentanaMostrarZona getInstance(){
			if(instance == null){
				instance = new VentanaMostrarZona();
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
			
			
			botonAtras = new JButton("Atras");
			
			panelDatos = new JPanel();
			panelBoton = new JPanel();
			
			
			panelDatos.add(labelID_Zona);
			panelDatos.add(txtFieldID_Zona);
			panelDatos.add(txtFieldColor);
			panelDatos.add(labelColor);
			panelDatos.add(txtFieldColor);
			panelDatos.add(labelPlanta);
			panelDatos.add(txtFieldPlanta);
			
			panelBoton.add(botonAtras);
			
			this.add(panelDatos);
			this.add(panelBoton);
			setLocationRelativeTo(null);
			
			txtFieldID_Zona.setEnabled(false);
		
			pack();
			
		}

		/**
		 * 
		 */
		private void agregarManejadoresDeEventos() {
			OyenteMostrarZona oyente = new OyenteMostrarZona();
			this.addWindowListener(new EscuchaVentana());
			botonAtras.addActionListener(oyente);
			
		}
		
		
		public class OyenteMostrarZona implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				
				
				if(event.getSource() == botonAtras){
					VentanaMostrarZona.this.dispose();
					VentanaBuscarZona.getInstance().setVisible(true);
					
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
				VentanaMostrarZona.this.dispose();
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
			case (EventoGUI.MOSTRAR_ZONA):{
				String stringID = Integer.toString(tZona.getId_zona());
				txtFieldID_Zona.setText(stringID);
				//txtFieldID_Zona.setEnabled(false);
				
				String stringColor = tZona.getColor();
				txtFieldColor.setText(stringColor);
				
				String stringPlanta = Integer.toString(tZona.getPlanta());
				txtFieldPlanta.setText(stringPlanta);
			}break;
	
		}
	}
}
