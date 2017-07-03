/**
 * 
 */
package AppArcao.Integracion.Vehiculo;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Vehiculo.TVehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOVehiculo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id_zona
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVehiculo buscaVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param mizona
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int registrarVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param mizona
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean modificarVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id_zona
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean borrarVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion;
	
	public boolean borraTodos(int id) throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TVehiculo> listarVehiculos() throws ExcepcionIntegracion;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param nombreZona
	 * @param TZona
	 * @throws ExcepcionIntegracion 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVehiculo readVehiculoByName(String miMatricula) throws ExcepcionIntegracion;

}