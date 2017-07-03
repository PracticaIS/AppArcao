/**
 * 
 */
package AppArcao.Negocio.FactoriaNegocio;

import AppArcao.Negocio.Plaza.ServicioAplicacionPlaza;
import AppArcao.Negocio.Reserva.ServicioAplicacionReserva;
import AppArcao.Negocio.Socio.ServicioAplicacionSocio;
import AppArcao.Negocio.Vehiculo.ServicioAplicacionVehiculo;
import AppArcao.Negocio.Zona.ServicioAplicacionZona;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaNegocio {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param SAZona
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract ServicioAplicacionZona creaServicioAplicacionZona();
		
	public abstract ServicioAplicacionPlaza creaServicioAplicacionPlaza();

	public abstract ServicioAplicacionVehiculo creaServicioAplicacionVehiculo();
	
	public abstract ServicioAplicacionSocio creaServicioAplicacionSocio();
	
	public abstract ServicioAplicacionReserva creaServicioAplicacionReserva();
	
	/** 
	 * @generated "Singleton (com.ibm.xtools.patterns.content.gof.creational.singleton.SingletonPattern)"
	 */
	private static FactoriaNegocio instance = null;

	/** 
	 * @generated "Singleton (com.ibm.xtools.patterns.content.gof.creational.singleton.SingletonPattern)"
	 */
	public static FactoriaNegocio getInstance() {
		
		if(instance == null){
			instance = new FactoriaNegocioImp();
		}
		
		return instance;
		
	}
}