/**
 * 
 */
package AppArcao.Integracion.FactoriaIntegracion;

import AppArcao.Integracion.Plaza.DAOPlaza;
import AppArcao.Integracion.Plaza_vehiculo.DAOPlaza_vehiculo;
import AppArcao.Integracion.Reserva.DAOReserva;
import AppArcao.Integracion.Socio.DAOSocio;
import AppArcao.Integracion.Vehiculo.DAOVehiculo;
import AppArcao.Integracion.Zona.DAOZona;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaIntegracion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOZona creaDAOZona();
	
	public abstract DAOPlaza creaDAOPlaza();
	
	public abstract DAOVehiculo creaDAOVehiculo();
	
	public abstract DAOSocio creaDAOSocio();
	
	public abstract DAOReserva creaDAOReserva();
	
	public abstract DAOPlaza_vehiculo creaDAOPlazaVehiculo();
	/** 
	 * @generated "Singleton (com.ibm.xtools.patterns.content.gof.creational.singleton.SingletonPattern)"
	 */
	private static FactoriaIntegracion instance = null;

	/** 
	 * @generated "Singleton (com.ibm.xtools.patterns.content.gof.creational.singleton.SingletonPattern)"
	 */
	public static FactoriaIntegracion getInstance() {
		// begin-user-code
		if (instance == null){
			instance = new FactoriaIntegracionImp();
		}
		return instance;
		// end-user-code
	}
}