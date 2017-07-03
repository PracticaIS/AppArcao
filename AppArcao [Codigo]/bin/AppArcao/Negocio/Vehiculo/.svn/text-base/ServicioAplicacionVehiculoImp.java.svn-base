/**
 * 
 */
package AppArcao.Negocio.Vehiculo;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Integracion.FactoriaIntegracion.FactoriaIntegracion;
import AppArcao.Integracion.Plaza_vehiculo.DAOPlaza_vehiculo;
import AppArcao.Integracion.Socio.DAOSocio;
import AppArcao.Integracion.Vehiculo.DAOVehiculo;
import AppArcao.Negocio.Excepciones.ExcepcionNegocio;
import AppArcao.Negocio.Socio.TSocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Chema
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioAplicacionVehiculoImp implements
		ServicioAplicacionVehiculo {
	/** 
	 * (sin Javadoc)
	 * @see ServicioAplicacionVehiculo#listarVehiculos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public ArrayList<TVehiculo> listarVehiculos() throws ExcepcionNegocio {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		
		//Buscamos a ver si existe la zona por el campo color.
		ArrayList<TVehiculo> miarray = null;
		try {
			miarray = DAOVehiculo.listarVehiculos();
		} catch (ExcepcionIntegracion e) {
			// TODO Bloque catch generado automáticamente
			throw new ExcepcionNegocio( e.getMessage());
		}
		
		return miarray;	
		// end-user-code
		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see ServicioAplicacionVehiculo#crearVehiculo(Clase nombreZona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int crearVehiculo(TVehiculo mivehiculo) throws ExcepcionNegocio {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		DAOSocio dAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		TSocio socio = new TSocio();
		socio.setTipo_socio("vip");
		socio.setId_socio(mivehiculo.getId_socio());
		
		int id_vehiculo;
		try {
			TSocio misocio = dAOSocio.buscaSocio(socio);
		if(misocio!=null){
		TVehiculo vehiculo;
		
			vehiculo = DAOVehiculo.readVehiculoByName(mivehiculo.getMatricula());
		
		
		if(vehiculo==null){
			
				id_vehiculo=DAOVehiculo.registrarVehiculo(mivehiculo);
			
			
		}else 
			id_vehiculo=-1;
		}else{
			id_vehiculo=-2;
		}
		
		} catch (ExcepcionIntegracion e1) {
			// TODO Bloque catch generado automáticamente
			throw new ExcepcionNegocio(e1.getMessage());
		}
	
		
		return id_vehiculo;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see ServicioAplicacionVehiculo#leerVehiculo()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public TVehiculo buscarVehiculo(TVehiculo vehiculo) throws ExcepcionNegocio {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		TVehiculo mivehiculo;
		
		try{
		 mivehiculo=DAOVehiculo.buscaVehiculo(vehiculo);
		
		}catch(Exception e){
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return mivehiculo;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see ServicioAplicacionVehiculo#borrarVehiculo(int ID_Zona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean borrarVehiculo(TVehiculo vehiculo) throws ExcepcionNegocio {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean resultado= false;
		
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		TVehiculo mivehiculo;
		
		try{
			mivehiculo= DAOVehiculo.buscaVehiculo(vehiculo);
			 DAOPlaza_vehiculo reserva= FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
		
			 
			if(mivehiculo!=null && !reserva.vehiculoTieneReserva(mivehiculo.getId_vehiculo())){
				resultado=DAOVehiculo.borrarVehiculo(vehiculo);
			}
			
		}catch(ExcepcionIntegracion e){
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see ServicioAplicacionVehiculo#modificarVehiculo()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean modificarVehiculo(TVehiculo modvehiculo) throws ExcepcionNegocio {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean resultado = false;
		DAOVehiculo DAOVehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
		
		try {
			if(DAOVehiculo.buscaVehiculo(modvehiculo)!=null){
			//CAMBIAR VALORES DE ZONA Y LLAMAR MODIFICAR ZONA CON DAOZONA
				if(modvehiculo.getColor()!=null && modvehiculo.getId_socio()!= -1 && modvehiculo.getMarca()!=null && modvehiculo.getMatricula()!=null){
					resultado = DAOVehiculo.modificarVehiculo(modvehiculo);
				}
				else resultado = false;
				
			}else{
				resultado = false;
			}
		} catch (ExcepcionIntegracion e) {
			// TODO Bloque catch generado automáticamente
			throw new ExcepcionNegocio(e.getMessage());
		}
		return resultado;
		// end-user-code
	}
}