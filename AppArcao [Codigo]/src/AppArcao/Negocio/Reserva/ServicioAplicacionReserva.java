/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Negocio.Reserva;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Excepciones.ExcepcionNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name ServicioAplicacionReserva.java
 */
public interface ServicioAplicacionReserva {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TReserva> listarReservas() throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param NombreReserva
	 * @return
	 * @throws ExcepcionNegocio 
	 */
	public int crearReserva(TReserva NombreReserva) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param Id_Reserva
	 * @return
	 * @throws ExcepcionNegocio 
	 */
	public TReserva buscarReserva(TReserva mireserva) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param Id_Reserva
	 * @return
	 * @throws ExcepcionIntegracion 
	 * @throws ExcepcionNegocio 
	 */
	public boolean borrarReserva(TReserva mireserva) throws ExcepcionNegocio;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param miReserva
	 * @return
	 */
	public boolean modificarReserva(TReserva miReserva) throws ExcepcionNegocio;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param miReserva
	 * @return
	 */
	public boolean actualizarReservas();
}