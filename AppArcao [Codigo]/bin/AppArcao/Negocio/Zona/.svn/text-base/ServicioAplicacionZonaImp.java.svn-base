/**
 * 
 */
package AppArcao.Negocio.Zona;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Integracion.FactoriaIntegracion.FactoriaIntegracion;
import AppArcao.Integracion.Plaza.DAOPlaza;
import AppArcao.Integracion.Zona.DAOZona;
import AppArcao.Negocio.Excepciones.ExcepcionNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioAplicacionZonaImp implements ServicioAplicacionZona {
	
	
	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionZona#listarZonas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public ArrayList<TZona> listarZonas() throws ExcepcionNegocio {
		// begin-user-code
		ArrayList<TZona> miarray = null;
		DAOZona DAOZona = FactoriaIntegracion.getInstance().creaDAOZona();
		
		try{
			//Buscamos a ver si existe la zona por el campo color.
			miarray = DAOZona.listarZonas();
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return miarray;	
		// end-user-code4
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionZona#crearZona()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int crearZona(TZona tZona) throws ExcepcionNegocio {
		// begin-user-code
		int ID_Zona = -1;
		
		DAOZona DAOZona = FactoriaIntegracion.getInstance().creaDAOZona();
		
		try{
			//Buscamos a ver si existe la zona por el campo color.
			TZona mizona = DAOZona.readZonaByColor(tZona.getColor());
			
			//en el caso de que no existe, procedemos a realizar el registro.
			if (mizona  == null) {
				ID_Zona = DAOZona.registrarZona(tZona);
			}else {
				ID_Zona = -1;
			}
		
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return ID_Zona;		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionZona#leerZona()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public TZona buscarZona(TZona mizona) throws ExcepcionNegocio {
		// begin-user-code
		DAOZona miDAO = FactoriaIntegracion.getInstance().creaDAOZona();
		TZona miZona;
		try {
			miZona = miDAO.buscaZona(mizona.getId_zona());
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		
		return miZona;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionZona#borrarZona()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean borrarZona(TZona mizona) throws ExcepcionNegocio {
		// begin-user-code
		
		boolean result = false;
		DAOZona DAOZona = FactoriaIntegracion.getInstance().creaDAOZona();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		
		TZona TZona;
		try {
			TZona = DAOZona.buscaZona(mizona.getId_zona());
			
			if (TZona  != null) {
				//Comprobamos que la zona no tiene plazas asignadas.
				if (DAOPlaza.numPlazasById(mizona.getId_zona())==0){
					result = DAOZona.borrarZona(mizona.getId_zona());
				}
			}
		}
		catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return result;		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionNegocio 
	 * @see ServicioAplicacionZona#modificarZona()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean modificarZona(TZona modZona) throws ExcepcionNegocio {
		boolean resultado= false;
		
		DAOZona miDAO = FactoriaIntegracion.getInstance().creaDAOZona();
		
		try {
			if(miDAO.buscaZona(modZona.getId_zona())!=null){
			//CAMBIAR VALORES DE ZONA Y LLAMAR MODIFICAR ZONA CON DAOZONA
				if(modZona.getColor()!=null && modZona.getPlanta()!= -1){
					resultado = miDAO.modificarZona(modZona);
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
	}
}