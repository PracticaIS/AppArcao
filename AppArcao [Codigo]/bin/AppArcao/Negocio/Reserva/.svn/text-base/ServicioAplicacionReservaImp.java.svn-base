/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Negocio.Reserva;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Integracion.FactoriaIntegracion.FactoriaIntegracion;
import AppArcao.Integracion.Plaza.DAOPlaza;
import AppArcao.Integracion.Plaza_vehiculo.DAOPlaza_vehiculo;
import AppArcao.Integracion.Reserva.DAOReserva;
import AppArcao.Integracion.Socio.DAOSocio;
import AppArcao.Integracion.Vehiculo.DAOVehiculo;
import AppArcao.Negocio.Excepciones.ExcepcionNegocio;
import AppArcao.Negocio.Plaza.TPlaza;
import AppArcao.Negocio.Socio.TSocio;
import AppArcao.Negocio.Vehiculo.TVehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name ServicioAplicacionReservaImp.java
 */
public class ServicioAplicacionReservaImp implements ServicioAplicacionReserva {
	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionReserva#listarReservas()
	 */
	@Override
	public ArrayList<TReserva> listarReservas() throws ExcepcionNegocio {
		//Creamos un arraylist de reservas y lo rellenamos.
		ArrayList<TReserva> misReservas = new ArrayList<TReserva>();
		//Necesitamos un plaza vehículo auxiliar para poder cargarlas en las reservas.
		TPlaza_vehiculo auxpv = new TPlaza_vehiculo();
		TReserva auxreserva = new TReserva();
		TVehiculo auxvehiculo = new TVehiculo();
		//Le pedimos al DAO que nos devuelva las reservas.
		DAOReserva DAOReserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		DAOPlaza_vehiculo DAOPlaza_vehiculo = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		
		try {
			misReservas = DAOReserva.listarReservas();
			//Comprobamos si hay algo en el arraylist.
			if (misReservas.size()!=0){
				//Cargamos las plazas vehículos.
				for (int i = 0; i < misReservas.size(); i++){
					auxreserva = misReservas.get(i);
					auxpv.setId_reserva(auxreserva.getId_Reserva());
					auxpv = DAOPlaza_vehiculo.readPlaza_vehiculoById(auxpv.getId_reserva());
					if (auxpv!=null){
						auxvehiculo.setId_vehiculo(auxpv.getId_vehiculo());
						auxvehiculo = DAOVehiculo.buscaVehiculo(auxvehiculo);
						if (auxvehiculo != null){
							auxreserva.setMatricula(auxvehiculo.getMatricula());
						}
						misReservas.get(i).setPlaza_vehiculo(auxpv);
					}
				}
			}
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
	
		return misReservas;
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionReserva#crearReserva(TReserva NombreReserva)
	 */
	@Override
	public int crearReserva(TReserva reserva) throws ExcepcionNegocio {
		int Id_reserva = -1;
		int id_socio = -1;
		int id_plaza = -1;
		boolean llave = false;
		
		DAOReserva DAOReserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		DAOPlaza_vehiculo DAOPlaza_vehiculo = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		DAOSocio DAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		
		try{
			//Recogemos el id del socio.
			TVehiculo auxvehiculo = DAOVehiculo.readVehiculoByName(reserva.getMatricula());
			if (auxvehiculo != null)
			{
				id_socio = auxvehiculo.getId_socio();
				//Compruebo si el socio esta activo.
				TSocio auxsocio = new TSocio();
				auxsocio.setId_socio(id_socio);
				auxsocio = DAOSocio.buscaSocio(auxsocio);
				if (auxsocio!=null && auxsocio.getEstado()==1){
					//Calculamos cual es la plaza libre mas cercana siempre y cuando sea para hoy la reserva.
					String stringFechaActual = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
					if(reserva.getFecha_Registro().equalsIgnoreCase(stringFechaActual)) {
						id_plaza = DAOPlaza.plazaOptima();
					}
					else{
						//Comprobamos que las reservas para ese día no superan las plazas totales.
						if (DAOPlaza.numPlazasTotales()<=DAOPlaza_vehiculo.numReservasByFecha(reserva.getPlaza_vehiculo().getFecha_registro()))
						{
							llave=true;
						}
						id_plaza = 0;
					}
					if (!llave){
						reserva.setId_Socio(id_socio);
						//Ahora, registramos la reserva.
						if (id_plaza != -1){
							reserva.setEstado("ACTIVO");
							Id_reserva = DAOReserva.registrarReserva(reserva);
							if (Id_reserva != -1)
							{
								//Realizamos la insercción de Plaza-Vehiculo.
								TPlaza_vehiculo mipv = reserva.getPlaza_vehiculo();
								mipv.setId_vehiculo(auxvehiculo.getId_vehiculo());
								mipv.setId_plaza(id_plaza);
								mipv.setId_reserva(Id_reserva);
								mipv.setEstado("ACTIVA");
								mipv.setTipo_reserva("");
								mipv.setFecha_registro(reserva.getFecha_Registro());
								DAOPlaza_vehiculo.registrarPlaza_vehiculo(mipv);
								
								//Una vez esta hecho todo el registro deberiamos de colocar el estado de la plaza a ocupada.
								TPlaza plaza = new TPlaza();
								plaza.setId_plaza(id_plaza);
								plaza = DAOPlaza.buscaPlaza(plaza);
								if (plaza != null)
								{
									plaza.setEstado(1);
									DAOPlaza.modificarPlaza(plaza);
								}
							}
						}
						else Id_reserva=-2;
					}
					else Id_reserva=-2;
				}
				else Id_reserva=-4;
			}
			else Id_reserva=-3;
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return Id_reserva;
	}

	/** 
	 * (sin Javadoc)
	 * @see ServicioAplicacionReserva#buscarReserva(TReserva Id_Reserva)
	 */
	@Override
	public TReserva buscarReserva(TReserva Id_Reserva) throws ExcepcionNegocio {
		DAOReserva midaoReserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		DAOPlaza_vehiculo DAOpv = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		DAOVehiculo midaoVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		
		TReserva lareserva;
		TPlaza_vehiculo pv = null;
		try{
			 lareserva = midaoReserva.buscarReserva(Id_Reserva);
			 if(lareserva!=null){
				 pv = DAOpv.readPlaza_vehiculoById(lareserva.getId_Reserva());
				 lareserva.setPlaza_vehiculo(pv);
				 TVehiculo mivehiculo = new TVehiculo(pv.getId_vehiculo(),-1,null,null,null,null);
				 lareserva.setMatricula(midaoVehiculo.buscaVehiculo(mivehiculo).getMatricula());
			 }
		}catch(ExcepcionIntegracion e){
			
			throw new ExcepcionNegocio(e.getMessage());
			
		}
		return lareserva;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @throws ExcepcionIntegracion 
	 * @see ServicioAplicacionReserva#borrarReserva(TReserva Id_Reserva)
	 */
	@Override
	public boolean borrarReserva(TReserva mireserva) throws ExcepcionNegocio {
		boolean llave = false;
		
		DAOReserva DAOReserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		DAOPlaza_vehiculo DAOPlaza_vehiculo = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		try{
		//Buscamos la reserva correspondiente.
		TReserva auxreserva = DAOReserva.buscarReserva(mireserva);
		if (auxreserva!=null){
			//Comprobamos que no es con fecha de hoy.
			String stringFechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			stringFechaActual += " 00:00:00.0";
			//Buscamos su plazavehiculo.
			TPlaza_vehiculo pv = DAOPlaza_vehiculo.readPlaza_vehiculoById(mireserva.getId_Reserva());
			if (pv!=null)
			{
				if(!pv.getFecha_registro().equalsIgnoreCase(stringFechaActual)) {
					//Ahora habilitamos la plaza si la encontramos.
					TPlaza auxplaza = new TPlaza();
					auxplaza.setId_plaza(pv.getId_plaza());
					auxplaza = DAOPlaza.buscaPlaza(auxplaza);
					if (auxplaza != null){
						auxplaza.setEstado(0);
						DAOPlaza.modificarPlaza(auxplaza);
					}
					//Borramos el plaza vehículo encontrado.
					DAOPlaza_vehiculo.borrarPlaza_vehiculo(pv);

					//Y por último, borramos la reserva.
					DAOReserva.borrarReserva(auxreserva);
					llave=true;
				}
				else llave=false;
			}
			else{
				//En el caso de que sean iguales las fechas no se puede borrar.
				llave=false;
			}
		}	
		}catch(ExcepcionIntegracion e){
			throw new ExcepcionNegocio(e.getMessage());
		}
		return llave;
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionReserva#modificarReserva(TReserva miReserva)
	 */
	@Override
	public boolean modificarReserva(TReserva miReserva) throws ExcepcionNegocio {
		boolean resultOK = false;
		int llave = -2;
		int id_socio = -1;
		int id_plaza = -1;
		int id_plaza_antes = 0;
		TReserva auxreserva = new TReserva();
		TPlaza_vehiculo mipvaux = new TPlaza_vehiculo();
		
		DAOReserva DAOReserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		DAOPlaza_vehiculo DAOPlaza_vehiculo = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		DAOSocio DAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		
		
		try{
			//Cargamos el estado que tenia antes de ser modificada la reserva
			auxreserva = DAOReserva.buscarReserva(miReserva);
			if (auxreserva != null){
				mipvaux = DAOPlaza_vehiculo.readPlaza_vehiculoById(auxreserva.getId_Reserva());
				if (mipvaux != null){
					llave=0;
					id_plaza_antes = mipvaux.getId_plaza();
				}
			}
			//El caso de recuperar el estado anterior con éxito.
			if (llave!=-2){
					TVehiculo auxvehiculo = DAOVehiculo.readVehiculoByName(miReserva.getMatricula());
					if (auxvehiculo != null)
					{
						//Compruebo si el socio esta activo.
						TSocio auxsocio = new TSocio();
						id_socio = auxvehiculo.getId_socio();
						auxsocio.setId_socio(id_socio);
						auxsocio = DAOSocio.buscaSocio(auxsocio);
						if (auxsocio!=null && auxsocio.getEstado()==1){
							String stringFechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
							stringFechaActual += " 00:00:00.0";
							//Comprobamos si la fecha ha cambiado.
							if (!mipvaux.getFecha_registro().equalsIgnoreCase(miReserva.getPlaza_vehiculo().getFecha_registro())){
								if (miReserva.getPlaza_vehiculo().getFecha_registro().equalsIgnoreCase(stringFechaActual)){
									//Comprobamos si hay sitio para hoy.
									id_plaza = DAOPlaza.plazaOptima();
									if (id_plaza!=-1){
										llave=1;
									}
									else llave=-1;
								}
								else {
									//Comprobamos que las reservas para ese día no superan las plazas totales.
									if (DAOPlaza.numPlazasTotales()>DAOPlaza_vehiculo.numReservasByFecha(miReserva.getPlaza_vehiculo().getFecha_registro()))
									{
										llave=2;
									}
									else llave=-1;
								}
							}
							if (llave!=-1){
								miReserva.setId_Socio(id_socio);
								//Ahora, modificamos la reserva.
								miReserva.setEstado("ACTIVO");
								if (DAOReserva.modificarReserva(miReserva))
								{						
										//Realizamos la modificación de Plaza-Vehiculo.
										TPlaza_vehiculo mipv = DAOPlaza_vehiculo.readPlaza_vehiculoById(miReserva.getId_Reserva());
										if (mipv != null){
											//Antes no era hoy ahora si lo es
											if (llave==1){
												mipv.setId_plaza(id_plaza);
											}
											//Antes era hoy ahora no lo es
											else if (llave==2){
												mipv.setId_plaza(0);
											}
											else{
												mipv.setId_plaza(mipvaux.getId_plaza());
											}
											
											mipv.setId_vehiculo(auxvehiculo.getId_vehiculo());
											mipv.setId_reserva(miReserva.getId_Reserva());
											mipv.setEstado("ACTIVA");
											mipv.setTipo_reserva("");
											mipv.setFecha_registro(miReserva.getPlaza_vehiculo().getFecha_registro());
											
											//Modificacion del estado plaza en estos casos.
											if (llave==1 || llave==2){
												TPlaza auxplaza = new TPlaza();
												//Modifico la plaza de ahora.
												if (llave==1){
													auxplaza.setId_plaza(id_plaza);
												}
												//Modifico la plaza de antes.
												else if (llave==2){
													auxplaza.setId_plaza(id_plaza_antes);
												}
												auxplaza = DAOPlaza.buscaPlaza(auxplaza);
												if (auxplaza != null){
													if (llave==1){	
														auxplaza.setEstado(1);
													}
													else if (llave==2){
														auxplaza.setEstado(0);
													}
													DAOPlaza.modificarPlaza(auxplaza);
												}
											}
		
											if(DAOPlaza_vehiculo.modificarPlaza_vehiculo(mipv)){
												resultOK= true;
											}
										}
								}
							}
						}
					}
			}
		}
		catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return resultOK;
		// end-user-code
	}
	
	@Override
	public boolean actualizarReservas(){
		boolean resultOK = true;
		TPlaza auxplaza = new TPlaza();
		TPlaza_vehiculo auxpv;
		TReserva auxreserva;
		int plazaop;
		
		DAOReserva DAOReserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		DAOPlaza_vehiculo DAOPlaza_vehiculo = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		
		//Llamo al método que comprueba si hay alguna plaza_vehiculo que borrar.
		try {
			ArrayList<TPlaza_vehiculo> mispvs = DAOPlaza_vehiculo.cargarReservasPasadas();
			//Compruebo que existe alguna.
			if (mispvs.size()!=0){
				/*Comenzamos a borrar de plaza vehiculo y posteriormente de reservas actualizando
				 * a la vez las plazas que tenian reservadas.
				 */
				auxreserva = new TReserva();
				for (int i = 0; (i < mispvs.size()) && resultOK; i++){
					//Borramos los primero plaza vehiculo.
					auxpv = mispvs.get(i);
					resultOK = DAOPlaza_vehiculo.borrarPlaza_vehiculo(auxpv);
					if (resultOK == true){
						//Ahora procedemos a habilitar la plaza.
						//Primero busamos los datos de la plaza.
						auxplaza.setId_plaza(auxpv.getId_plaza());
						auxplaza = DAOPlaza.buscaPlaza(auxplaza);
						if (auxplaza!=null){
							//Colocamos su estado a habilitada.
							auxplaza.setEstado(0);
							//Y la modificamos.
							DAOPlaza.modificarPlaza(auxplaza);
						}
						//Ahora procedemos a borrar la reserva.
						auxreserva.setId_Reserva(auxpv.getId_reserva());
						auxreserva = DAOReserva.buscarReserva(auxreserva);
						if (auxreserva!=null)
						{
							resultOK = DAOReserva.borrarReserva(auxreserva);
						}
						else resultOK = false;
					}
				}
			}
			//Una vez tenemos todo listo. Procedemos a asignar plazas a las reservas de hoy.
			if (resultOK){
				mispvs.clear();
				mispvs = DAOPlaza_vehiculo.cargarReservasPorHacer();
				for (int j = 0; (j < mispvs.size()) && resultOK; j++){
					//Buscamos la plaza vehiculo.
					auxpv = mispvs.get(j);
					auxpv = DAOPlaza_vehiculo.buscarPlaza_vehiculo(auxpv);
					if (auxpv != null){
						//Comprobamos que no tiene plaza asignada.(Sin asignar = 0)
						if (auxpv.getId_plaza()==0){
							//Pedimos una plaza optima.
							plazaop = DAOPlaza.plazaOptima();
							if (plazaop != -1){
								auxpv.setId_plaza(plazaop);
								//Y actualizamos la plaza_vehiculo.
								resultOK = DAOPlaza_vehiculo.modificarPlaza_vehiculo(auxpv);
								//Por último, colocamos la plaza a ocupada.
								auxplaza.setId_plaza(plazaop);
								auxplaza = DAOPlaza.buscaPlaza(auxplaza);
								if (auxplaza!=null){
									auxplaza.setEstado(1);
									DAOPlaza.modificarPlaza(auxplaza);
								}
							}
							else resultOK = false;
						}
					}
				}
			}
		} catch (ExcepcionIntegracion e) {
			e.printStackTrace();
		}
		return resultOK;
	}
}