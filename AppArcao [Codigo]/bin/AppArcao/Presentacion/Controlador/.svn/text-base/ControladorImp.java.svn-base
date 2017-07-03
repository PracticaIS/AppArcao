package AppArcao.Presentacion.Controlador;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import AppArcao.Negocio.Excepciones.ExcepcionNegocio;
import AppArcao.Negocio.FactoriaNegocio.FactoriaNegocio;
import AppArcao.Negocio.Plaza.ServicioAplicacionPlaza;
import AppArcao.Negocio.Plaza.TPlaza;
import AppArcao.Negocio.Reserva.ServicioAplicacionReserva;
import AppArcao.Negocio.Reserva.TReserva;
import AppArcao.Negocio.Socio.ServicioAplicacionSocio;
import AppArcao.Negocio.Socio.TSocio;
import AppArcao.Negocio.Vehiculo.ServicioAplicacionVehiculo;
import AppArcao.Negocio.Vehiculo.TVehiculo;
import AppArcao.Negocio.Zona.ServicioAplicacionZona;
import AppArcao.Negocio.Zona.TZona;
import AppArcao.Presentacion.EventoGUI;
import AppArcao.Presentacion.EventoNegocio;
import AppArcao.Presentacion.JPrincipal;
import AppArcao.Presentacion.Plaza.VentanaBorrarPlaza;
import AppArcao.Presentacion.Plaza.VentanaBuscarPlaza;
import AppArcao.Presentacion.Plaza.VentanaCrearPlaza;
import AppArcao.Presentacion.Plaza.VentanaListarPlazas;
import AppArcao.Presentacion.Plaza.VentanaModificarPlaza;
import AppArcao.Presentacion.Plaza.VentanaMostrarPlaza;
import AppArcao.Presentacion.Reserva.VentanaBorrarReserva;
import AppArcao.Presentacion.Reserva.VentanaBuscarReserva;
import AppArcao.Presentacion.Reserva.VentanaCrearReserva;
import AppArcao.Presentacion.Reserva.VentanaListarReservas;
import AppArcao.Presentacion.Reserva.VentanaModificarReserva;
import AppArcao.Presentacion.Reserva.VentanaMostrarReserva;
import AppArcao.Presentacion.Socio.VentanaBorrarSocio;
import AppArcao.Presentacion.Socio.VentanaBuscarSocio;
import AppArcao.Presentacion.Socio.VentanaCrearSocio;
import AppArcao.Presentacion.Socio.VentanaListarSocios;
import AppArcao.Presentacion.Socio.VentanaModificarSocio;
import AppArcao.Presentacion.Socio.VentanaMostrarSocio;
import AppArcao.Presentacion.Vehiculo.VentanaBorrarVehiculo;
import AppArcao.Presentacion.Vehiculo.VentanaBuscarVehiculo;
import AppArcao.Presentacion.Vehiculo.VentanaCrearVehiculo;
import AppArcao.Presentacion.Vehiculo.VentanaListarVehiculos;
import AppArcao.Presentacion.Vehiculo.VentanaModificarVehiculo;
import AppArcao.Presentacion.Vehiculo.VentanaMostrarVehiculo;
import AppArcao.Presentacion.Zona.VentanaBorrarZona;
import AppArcao.Presentacion.Zona.VentanaBuscarZona;
import AppArcao.Presentacion.Zona.VentanaCrearZona;
import AppArcao.Presentacion.Zona.VentanaListarZonas;
import AppArcao.Presentacion.Zona.VentanaModificarZona;
import AppArcao.Presentacion.Zona.VentanaMostrarZona;


public class ControladorImp extends Controlador {
	
	/** 
	 * (sin Javadoc)
	 * @see Controlador#action(int eventoNegocio, Clase action)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public void action(int eventoNegocio, Object datos) {

	
		switch (eventoNegocio) {
		
			// ******************* EVENTOS ZONA *******************//
			//*****************************************************//
		
			case EventoNegocio.CREAR_ZONA:{
				TZona tzona = (TZona) datos;
				
				ServicioAplicacionZona SAZona  = FactoriaNegocio.getInstance().creaServicioAplicacionZona();
				try{
					int resultado = SAZona.crearZona(tzona);
					
					//*****Actualizar la ventana adecuadamente******
					
					if(resultado >= 0){
						VentanaCrearZona.getInstance().actualiza(EventoGUI.MOSTRAR_ZONA, resultado);
					}else{
						VentanaCrearZona.getInstance().actualiza(EventoGUI.ZONA_EXISTENTE, resultado); 
					}
					
				} catch (ExcepcionNegocio e) {
					
					JOptionPane.showMessageDialog(null, e.getMessage());
					VentanaCrearZona.getInstance().dispose();
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;
			
			case EventoNegocio.BORRAR_ZONA:{
				TZona tzona = (TZona) datos;
				
				ServicioAplicacionZona SAZona  = FactoriaNegocio.getInstance().creaServicioAplicacionZona();
				boolean resultado;
				
				try {
					resultado = SAZona.borrarZona(tzona);
					if(resultado){
						VentanaBorrarZona.getInstance().actualizar(EventoGUI.ZONA_BORRADA); 
					}else{
						VentanaBorrarZona.getInstance().actualizar(EventoGUI.ZONA_INEXISTENTE); 
					}
				 
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;
			
			case EventoNegocio.BUSCAR_ZONA:{
				TZona tzona = (TZona) datos;
				TZona miZona = null;
				ServicioAplicacionZona SAZona  = FactoriaNegocio.getInstance().creaServicioAplicacionZona();
				
				try{
					miZona = SAZona.buscarZona(tzona);
					
					if(miZona != null){
						VentanaBuscarZona.getInstance().dispose();
						VentanaMostrarZona.getInstance().actualizar(EventoGUI.MOSTRAR_ZONA, miZona);
						
						VentanaMostrarZona.getInstance().setVisible(true);
					}else{
						VentanaBuscarZona.getInstance().actualizar(EventoGUI.BUSCAR_ZONA_ERROR); 
					}
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;
	
			case EventoNegocio.BUSCA_ZONA_MODIFICAR:{
				TZona tzona = (TZona) datos;
				TZona miZona = null;
				
				ServicioAplicacionZona SAZona  = FactoriaNegocio.getInstance().creaServicioAplicacionZona();
				try{
					miZona = SAZona.buscarZona(tzona);
					
					if(miZona != null){
						VentanaBuscarZona.getInstance().dispose();
						VentanaModificarZona.getInstance().actualizar(EventoGUI.MODIFICAR_ZONA_MOSTRAR_DATOS, miZona);
						VentanaModificarZona.getInstance().setVisible(true);
					}else{
						VentanaBuscarZona.getInstance().actualizar(EventoGUI.BUSCAR_ZONA_ERROR); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					
					VentanaModificarZona.getInstance().setVisible(false);
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;
			
			case EventoNegocio.MODIFICAR_ZONA:{
				boolean resultado;
				
				TZona tzona = (TZona) datos;
				
				ServicioAplicacionZona SAZona  = FactoriaNegocio.getInstance().creaServicioAplicacionZona();
				try{
					resultado = SAZona.modificarZona(tzona);
					
					if(resultado){
						 VentanaModificarZona.getInstance().actualizar(EventoGUI.ZONA_MODIFICADA, tzona);
					}else{
						 VentanaModificarZona.getInstance().actualizar(EventoGUI.MODIFICAR_ZONA_ERROR, tzona); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;
			
			case EventoNegocio.LISTAR_ZONAS:{
				ArrayList<TZona> arrayZonas;
	
				
				ServicioAplicacionZona SAZona  = FactoriaNegocio.getInstance().creaServicioAplicacionZona();
				
				try{
					arrayZonas = SAZona.listarZonas();
					
					if(arrayZonas != null){
						if (arrayZonas.size()!=0){							
							VentanaListarZonas.getInstance().actualiza(EventoGUI.LISTAR_ZONAS, arrayZonas);
							VentanaListarZonas.getInstance().setVisible(true);
						}
						else{
							VentanaListarZonas.getInstance().actualiza(EventoGUI.LISTAR_ZONAS_ERRORAUX, null);
						}
					}else{
						VentanaListarZonas.getInstance().actualiza(EventoGUI.LISTAR_ZONAS_ERROR, null); 
					}
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;
			
			
			
			// ******************* EVENTOS PLAZA ******************//
			//*****************************************************//
			

			case EventoNegocio.CREAR_PLAZA:{

				TPlaza tPlaza = (TPlaza) datos;
				ServicioAplicacionPlaza SAPlaza  = FactoriaNegocio.getInstance().creaServicioAplicacionPlaza();
				
				try{
					int resultado = SAPlaza.crearPlaza(tPlaza);
					
					//*****Actualizar la ventana adecuadamente******
					
					if(resultado >= 0){
						VentanaCrearPlaza.getInstance().actualiza(EventoGUI.MOSTRAR_PLAZA, resultado);
					}else if(resultado == -1){
						VentanaCrearPlaza.getInstance().actualiza(EventoGUI.ZONA_INEXISTENTE, resultado); 
					}else{
						VentanaCrearPlaza.getInstance().actualiza(EventoGUI.ERROR_CREAR_PLAZA, resultado); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
				
			}; break;

			
			case EventoNegocio.BORRAR_PLAZA:{
				
				ServicioAplicacionPlaza SAPlaza  = FactoriaNegocio.getInstance().creaServicioAplicacionPlaza();
				
				try {
					boolean result = SAPlaza.borrarPlaza((TPlaza) datos);
					
					if(result){
						VentanaBorrarPlaza.getInstance().actualizar(EventoGUI.PLAZA_BORRADA); 
					}else{
						VentanaBorrarPlaza.getInstance().actualizar(EventoGUI.PLAZA_INEXISTENTE); 
					}
					
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
				


			}; break;

			case EventoNegocio.BUSCAR_PLAZA:{

				TPlaza plaza = (TPlaza) datos;
				//TZona miZona = null;
				ServicioAplicacionPlaza SAPlaza  = FactoriaNegocio.getInstance().creaServicioAplicacionPlaza();
				
				try{
					plaza = SAPlaza.buscarPlaza(plaza);
					
					if(plaza != null){
						VentanaBuscarPlaza.getInstance().dispose();
						
						VentanaMostrarPlaza.getInstance().actualizar(EventoGUI.MOSTRAR_PLAZA, plaza);
						VentanaMostrarPlaza.getInstance().setVisible(true);
					}else{
						VentanaBuscarPlaza.getInstance().actualizar(EventoGUI.BUSCAR_PLAZA_ERROR); 
					}
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}

			}; break;
			
			case EventoNegocio.BUSCA_PLAZA_MODIFICAR:{
				TPlaza miPlaza = (TPlaza) datos;
				TPlaza auxPlaza;
				
				ServicioAplicacionPlaza SAPlaza  = FactoriaNegocio.getInstance().creaServicioAplicacionPlaza();
				
				try{
					auxPlaza = SAPlaza.buscarPlaza(miPlaza);
					if(auxPlaza != null){
						VentanaBuscarPlaza.getInstance().dispose();
						VentanaModificarPlaza.getInstance().actualizar(EventoGUI.MODIFICAR_PLAZA_MOSTRAR_DATOS, auxPlaza);
						VentanaModificarPlaza.getInstance().setVisible(true);
					}else{
						VentanaBuscarPlaza.getInstance().actualizar(EventoGUI.BUSCAR_PLAZA_ERROR); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}; break;
			
			case EventoNegocio.MODIFICAR_PLAZA:{
				boolean resultado;
				
				TPlaza tPlaza = (TPlaza) datos;
				
				ServicioAplicacionPlaza SAPlaza  = FactoriaNegocio.getInstance().creaServicioAplicacionPlaza();
				try{
					resultado = SAPlaza.modificarPlaza(tPlaza);
					
					if(resultado){
						 VentanaModificarPlaza.getInstance().actualizar(EventoGUI.PLAZA_MODIFICADA, tPlaza);
					}else{
						 VentanaModificarPlaza.getInstance().actualizar(EventoGUI.MODIFICAR_PLAZA_ERROR, tPlaza); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					VentanaModificarPlaza.getInstance().setVisible(false);
					JPrincipal.getInstance().setVisible(true);
					
				}
				
			}; break;

			case EventoNegocio.LISTAR_PLAZAS:{
				ArrayList<TPlaza> arrayPlazas;
				
				ServicioAplicacionPlaza SAPlaza  = FactoriaNegocio.getInstance().creaServicioAplicacionPlaza();
			
				try{
					arrayPlazas = SAPlaza.listarPlazas();
					
					if(arrayPlazas != null){
						if (arrayPlazas.size()!=0){
							VentanaListarPlazas.getInstance().actualiza(EventoGUI.LISTAR_PLAZAS, arrayPlazas);
							VentanaListarPlazas.getInstance().setVisible(true);
						}
						else{
							VentanaListarPlazas.getInstance().actualiza(EventoGUI.LISTAR_PLAZAS_ERRORAUX, arrayPlazas);
						}
					}else{
						VentanaListarPlazas.getInstance().actualiza(EventoGUI.LISTAR_PLAZAS_ERROR, null); 
					}
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					VentanaListarPlazas.getInstance().setVisible(false);
					JPrincipal.getInstance().setVisible(true);

				}

			}; break;
			
			
			
			
			// ******************* EVENTOS VEHICULO ******************//
			//*****************************************************//	
			
			case EventoNegocio.CREAR_VEHICULO:{
				TVehiculo mivehiculo = (TVehiculo) datos;

				ServicioAplicacionVehiculo SAVehivulo  = FactoriaNegocio.getInstance().creaServicioAplicacionVehiculo();
				try{
					int resultado = SAVehivulo.crearVehiculo(mivehiculo);
					
					//*****Actualizar la ventana adecuadamente******
					
					if(resultado >= 0){
						VentanaCrearVehiculo.getInstance().actualiza(EventoGUI.MOSTRAR_VEHICULO, resultado);
					}else{
						if(resultado==-1){
						VentanaCrearVehiculo.getInstance().actualiza(EventoGUI.VEHICULO_EXISTENTE, resultado); 
						}else{
							VentanaCrearVehiculo.getInstance().actualiza(EventoGUI.SOCIO_EXISTENTE, resultado);
						}
						
						}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
					VentanaCrearVehiculo.getInstance().setVisible(false);

				}
				
				
			} break;
			
			
			case EventoNegocio.BUSCAR_VEHICULO_MODIFICAR:{
				TVehiculo mivehiculo = (TVehiculo) datos;
				ServicioAplicacionVehiculo SAVehivulo  = FactoriaNegocio.getInstance().creaServicioAplicacionVehiculo();
				
				try{
					 mivehiculo = SAVehivulo.buscarVehiculo(mivehiculo);
					
					if(mivehiculo!=null){
						VentanaModificarVehiculo.getInstance().actualizar(EventoGUI.MODIFICAR_VEHICULO_MOSTRAR_DATOS, mivehiculo);
						VentanaModificarVehiculo.getInstance().setVisible(true);
					}else{
						VentanaBuscarVehiculo.getInstance().actualizar(EventoGUI.BUSCAR_VEHICULO_ERROR);
					}
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
					VentanaModificarVehiculo.getInstance().setVisible(false);

				};
				
			} break;
			
			case EventoNegocio.BORRAR_VEHICULO:{
				TVehiculo mivehiculo = (TVehiculo) datos;

				ServicioAplicacionVehiculo SAVehivulo  = FactoriaNegocio.getInstance().creaServicioAplicacionVehiculo();
				
				try{
					boolean resultado =	SAVehivulo.borrarVehiculo(mivehiculo);
					
					if(resultado){
						VentanaBorrarVehiculo.getInstance().actualizar(EventoGUI.VEHICULO_BORRADO);
					}else{
						VentanaBorrarVehiculo.getInstance().actualizar(EventoGUI.VEHICULO_INEXISTENTE);
					}
					
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
					VentanaBorrarVehiculo.getInstance().setVisible(false);

				};
				
				
			} break;
			
			case EventoNegocio.MODIFICAR_VEHICULO:{
				TVehiculo mivehiculo = (TVehiculo) datos;
				ServicioAplicacionVehiculo SAVehivulo  = FactoriaNegocio.getInstance().creaServicioAplicacionVehiculo();
				
				try{
					 boolean resultado = SAVehivulo.modificarVehiculo(mivehiculo);
					
					if(resultado){
						VentanaModificarVehiculo.getInstance().actualizar(EventoGUI.VEHICULO_MODIFICADA, mivehiculo);
					
					}else{
						VentanaModificarVehiculo.getInstance().actualizar(EventoGUI.MODIFICAR_VEHICULO_ERROR, mivehiculo);
					}
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
					VentanaBuscarVehiculo.getInstance().setVisible(false);
					VentanaModificarVehiculo.getInstance().setVisible(false);

				};
			} break;
			
			case EventoNegocio.BUSCAR_VEHICULO:{
				TVehiculo mivehiculo = (TVehiculo) datos;
				TVehiculo unvehiculo = null;
				ServicioAplicacionVehiculo SAVehivulo  = FactoriaNegocio.getInstance().creaServicioAplicacionVehiculo();
				
				try{
					unvehiculo = SAVehivulo.buscarVehiculo(mivehiculo);
					
					if(unvehiculo!=null){
						VentanaBuscarVehiculo.getInstance().dispose();
						VentanaMostrarVehiculo.getInstance().actualizar(EventoGUI.MOSTRAR_VEHICULO, unvehiculo);
						VentanaMostrarVehiculo.getInstance().setVisible(true);
					}else{
						VentanaBuscarVehiculo.getInstance().actualizar(EventoGUI.BUSCAR_VEHICULO_ERROR);
					}
				
				
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
					VentanaBuscarVehiculo.getInstance().setVisible(false);
					VentanaMostrarVehiculo.getInstance().setVisible(false);

				};
		
			} break;
			
			case EventoNegocio.LISTAR_VEHICULOS:{
					
				ServicioAplicacionVehiculo SAVehivulo  = FactoriaNegocio.getInstance().creaServicioAplicacionVehiculo();

				ArrayList<TVehiculo> misvehiculos= null;
				
				try{
					misvehiculos= SAVehivulo.listarVehiculos();
					
					if(misvehiculos!=null){
						if (misvehiculos.size()!=0){
							VentanaListarVehiculos.getInstance().actualiza(EventoGUI.LISTAR_VEHICULOS, misvehiculos);
							VentanaListarVehiculos.getInstance().setVisible(true);
						}
						else{
							VentanaListarVehiculos.getInstance().actualiza(EventoGUI.LISTAR_VEHICULOS_ERRORAUX, misvehiculos);
						}
					}else{
						VentanaListarVehiculos.getInstance().actualiza(EventoGUI.LISTAR_VEHICULOS_ERROR, null);
					}
					
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
					VentanaListarVehiculos.getInstance().setVisible(false);
				};
				
			} break;
			
			
			
			// ******************* EVENTOS SOCIOS ******************//
			//*****************************************************//	
			
			case EventoNegocio.CREAR_SOCIO:{
				TSocio misocio = (TSocio) datos;

				ServicioAplicacionSocio SASocio  = FactoriaNegocio.getInstance().creaServicioAplicacionSocio();
				try{
					int resultado = SASocio.crearSocio(misocio);
					
					//*****Actualizar la ventana adecuadamente******
					
					if(resultado >= 0){
						VentanaCrearSocio.getInstance().actualiza(EventoGUI.MOSTRAR_SOCIO, resultado);
					}else{
						VentanaCrearSocio.getInstance().actualiza(EventoGUI.SOCIO_EXISTENTE, resultado); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					VentanaCrearSocio.getInstance().dispose();
					JPrincipal.getInstance().setVisible(true);
				}
			} break;
			
			
			case EventoNegocio.MODIFICAR_SOCIO:{
				TSocio misocio = (TSocio) datos;
				ServicioAplicacionSocio SASocio  = FactoriaNegocio.getInstance().creaServicioAplicacionSocio();
				
				try{
					boolean resultado = SASocio.modificarSocio(misocio);
					
					if(resultado){
						VentanaModificarSocio.getInstance().actualiza(EventoGUI.SOCIO_MODIFICADO, misocio);
					}else{
						VentanaModificarSocio.getInstance().actualiza(EventoGUI.MODIFICAR_SOCIO_ERROR, misocio);
					}
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				};
				
			} break;
			
			case EventoNegocio.BORRAR_SOCIO:{
				TSocio misocio = (TSocio) datos;
				ServicioAplicacionSocio SASocio  = FactoriaNegocio.getInstance().creaServicioAplicacionSocio();
				
				try{
					boolean resultado =	SASocio.borrarSocio(misocio);
					
					if(resultado){
						VentanaBorrarSocio.getInstance().actualizar(EventoGUI.SOCIO_BORRADO);
					}else{
						VentanaBorrarSocio.getInstance().actualizar(EventoGUI.SOCIO_EXISTENTE);
					}
					
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				};
				
				
			} break;
			
			case EventoNegocio.BUSCAR_SOCIO_MODIFICAR:{
				TSocio misocio = (TSocio) datos;
				ServicioAplicacionSocio SASocio  = FactoriaNegocio.getInstance().creaServicioAplicacionSocio();
				TSocio miAuxiliar;
				
				try{
					miAuxiliar = SASocio.buscarSocio(misocio);
					
					if(miAuxiliar != null){
						miAuxiliar.setId_socio(misocio.getId_socio());
						VentanaBuscarSocio.getInstance().dispose();
						VentanaModificarSocio.getInstance().actualiza(EventoGUI.MODIFICAR_SOCIO_MOSTRAR_DATOS, miAuxiliar);
						VentanaModificarSocio.getInstance().setVisible(true);
					}else{
						VentanaBuscarSocio.getInstance().actualizar(EventoGUI.BUSCAR_SOCIO_ERROR); 
					}
					
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			
			} break;
			
			case EventoNegocio.BUSCAR_SOCIO:{
				TSocio tsocio = (TSocio) datos;
				TSocio miSocio = null;
				ServicioAplicacionSocio SASocio  = FactoriaNegocio.getInstance().creaServicioAplicacionSocio();
				
				try{
					miSocio = SASocio.buscarSocio(tsocio);
					if(miSocio != null){
						miSocio.setId_socio(tsocio.getId_socio());
						VentanaBuscarSocio.getInstance().dispose();
						VentanaMostrarSocio.getInstance().actualiza(EventoGUI.MOSTRAR_SOCIO, miSocio);
						VentanaMostrarSocio.getInstance().setVisible(true);
					}else{
						VentanaBuscarSocio.getInstance().actualizar(EventoGUI.BUSCAR_SOCIO_ERROR); 
					}
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}
		
			} break;
			
			case EventoNegocio.LISTAR_SOCIO:{
					
				ServicioAplicacionSocio SASocio  = FactoriaNegocio.getInstance().creaServicioAplicacionSocio();				
				try{
					ArrayList<TSocio> missocios = SASocio.listarSocios();
					
					if(missocios!=null){
						if (missocios.size()!=0){
							VentanaListarSocios.getInstance().actualiza(EventoGUI.LISTAR_SOCIOS, missocios);
							VentanaListarSocios.getInstance().setVisible(true);
						}
						else{
							VentanaListarSocios.getInstance().actualiza(EventoGUI.LISTAR_SOCIOS_ERRORAUX, missocios);
						}
					}else{
						VentanaListarSocios.getInstance().actualiza(EventoGUI.LISTAR_SOCIOS_ERROR, null);
					}
					
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
				};
				
			} break;
		
			// ******************* EVENTOS RESERVAS ******************//
			//*****************************************************//	
			
			case EventoNegocio.CREAR_RESERVA:{
				TReserva mireserva = (TReserva) datos;

				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();
				
				int resultado = -1;
				try {
					resultado = SAReserva.crearReserva(mireserva);
				} catch (ExcepcionNegocio e) {
					e.printStackTrace();
				}
				
				//*****Actualizar la ventana adecuadamente******
				
				if(resultado >= 0){
					VentanaCrearReserva.getInstance().actualiza(EventoGUI.MOSTRAR_RESERVA, resultado);
				}else{
					if (resultado==-2)
					{
						VentanaCrearReserva.getInstance().actualiza(EventoGUI.ERROR_PLAZAS_LLENAS, resultado);
					}
					else if (resultado==-3)
					{
						VentanaCrearReserva.getInstance().actualiza(EventoGUI.ERROR_VEHICULO_RESERVA_NOEXISTE, resultado);
					}
					else if (resultado==-4){
						VentanaCrearReserva.getInstance().actualiza(EventoGUI.ERROR_RESERVA_SOCIOINACTIVO, resultado);
					}
					else
						VentanaCrearReserva.getInstance().actualiza(EventoGUI.ERROR_CREAR_RESERVA, resultado); 
				}
			} break;


			case EventoNegocio.MODIFICAR_RESERVA:{
				TReserva mireserva = (TReserva) datos;

				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();

				try{
					boolean resultado = SAReserva.modificarReserva(mireserva);

					if(resultado){
						VentanaModificarReserva.getInstance().actualizar(EventoGUI.RESERVA_MODIFICADO, mireserva);
					}else{
						VentanaModificarReserva.getInstance().actualizar(EventoGUI.MODIFICAR_RESERVA_ERROR, mireserva);
					}
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				};

			} break;

			case EventoNegocio.BORRAR_RESERVA:{
				TReserva mireserva = (TReserva) datos;
				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();

				boolean resultado;
				try {
					resultado = SAReserva.borrarReserva(mireserva);

					if(resultado){
						VentanaBorrarReserva.getInstance().actualizar(EventoGUI.RESERVA_BORRADA);
					}else{
						VentanaBorrarReserva.getInstance().actualizar(EventoGUI.RESERVA_INEXISTENTE);
					}
				}catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
				}

			} break;
			
			case EventoNegocio.BUSCAR_RESERVA_MODIFICAR:{
				TReserva mireserva = (TReserva) datos;

				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();

				TReserva miAuxiliar;

				try{
					miAuxiliar = SAReserva.buscarReserva(mireserva);

					if(miAuxiliar != null){
						miAuxiliar.setId_Reserva(mireserva.getId_Reserva());
						VentanaBuscarReserva.getInstance().dispose();
						VentanaModificarReserva.getInstance().actualizar(EventoGUI.MODIFICAR_RESERVA_MOSTRAR_DATOS, miAuxiliar);
						VentanaModificarReserva.getInstance().setVisible(true);
					}else{
						VentanaBuscarReserva.getInstance().actualizar(EventoGUI.BUSCAR_RESERVA_ERROR);
					}

				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			} break;

			case EventoNegocio.BUSCAR_RESERVA:{
				TReserva mireserva = (TReserva) datos;
				TReserva miauxiliar= null;
				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();


				try{
					miauxiliar = SAReserva.buscarReserva(mireserva);
					if(miauxiliar != null){
						miauxiliar.setId_Reserva(mireserva.getId_Reserva());
						VentanaBuscarReserva.getInstance().dispose();
						VentanaMostrarReserva.getInstance().actualiza(EventoGUI.MOSTRAR_RESERVA, miauxiliar);
						VentanaMostrarReserva.getInstance().setVisible(true);
					}else{
						VentanaBuscarReserva.getInstance().actualizar(EventoGUI.BUSCAR_RESERVA_ERROR);
					}
				} catch (ExcepcionNegocio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);

				}

			} break;


			case EventoNegocio.LISTAR_RESERVA:{
					
				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();

				ArrayList<TReserva> mireservas= null;
				
				try{
					mireservas = SAReserva.listarReservas();
					
					if(mireservas!=null){
						if (mireservas.size()!=0){
							VentanaListarReservas.getInstance().actualiza(EventoGUI.LISTAR_RESERVAS, mireservas);
							VentanaListarReservas.getInstance().setVisible(true);
						}
						else{
							VentanaListarReservas.getInstance().actualiza(EventoGUI.LISTAR_RESERVAS_ERRORAUX, mireservas);
						}
					}else{
						VentanaListarReservas.getInstance().actualiza(EventoGUI.LISTAR_RESERVAS_ERROR, null);
					}
					
				}catch(ExcepcionNegocio e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					JPrincipal.getInstance().setVisible(true);
				};
				
			} break;
			
			case EventoNegocio.ACTUALIZAR_RESERVAS:{
				
				ServicioAplicacionReserva SAReserva  = FactoriaNegocio.getInstance().creaServicioAplicacionReserva();
				boolean llave;
				llave = SAReserva.actualizarReservas();
				if (llave)
				{
					JPrincipal.getInstance().actualiza(EventoGUI.RESERVAS_ACTUALIZADAS, null);
				}
				else JPrincipal.getInstance().actualiza(EventoGUI.ACTUALIZACION_ERROR, null);
				//JPrincipal.getInstance().setVisible(true);
								
			} break;
			
			default:
				break;
			}		
	}
}