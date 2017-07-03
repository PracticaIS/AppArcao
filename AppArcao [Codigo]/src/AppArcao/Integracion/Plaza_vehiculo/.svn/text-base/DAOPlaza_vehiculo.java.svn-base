/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Integracion.Plaza_vehiculo;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Reserva.TPlaza_vehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name DAOReserva.java
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOPlaza_vehiculo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TPlaza_vehiculo buscarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int registrarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean modificarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean borrarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TPlaza_vehiculo readPlaza_vehiculoById(int id_reserva) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public int numReservasByFecha(String fecha) throws ExcepcionIntegracion;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TPlaza_vehiculo> cargarReservasPasadas() throws ExcepcionIntegracion;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TPlaza_vehiculo> cargarReservasPorHacer() throws ExcepcionIntegracion;
	
	public boolean plazaTieneReserva(int id_plaza) throws ExcepcionIntegracion;
	
	public boolean vehiculoTieneReserva(int id_vehiculo) throws ExcepcionIntegracion;
}