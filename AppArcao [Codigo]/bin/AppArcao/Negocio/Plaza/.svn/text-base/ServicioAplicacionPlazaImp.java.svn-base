/**
 * 
 */
package AppArcao.Negocio.Plaza;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Integracion.FactoriaIntegracion.FactoriaIntegracion;
import AppArcao.Integracion.Plaza.DAOPlaza;
import AppArcao.Integracion.Plaza_vehiculo.DAOPlaza_vehiculo;
import AppArcao.Integracion.Zona.DAOZona;
import AppArcao.Negocio.Excepciones.ExcepcionNegocio;
import AppArcao.Negocio.Zona.TZona;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioAplicacionPlazaImp implements ServicioAplicacionPlaza {

	/* (sin Javadoc)
	 * @see AppArcao.Negocio.Plaza.ServicioAplicacionPlaza#listarPlazas()
	 */
	@Override
	public ArrayList<TPlaza> listarPlazas() throws ExcepcionNegocio {
		// begin-user-code
		ArrayList<TPlaza> miarray = null;
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		DAOZona DAOZona = FactoriaIntegracion.getInstance().creaDAOZona();
		try{
			//Buscamos a ver si existe la zona por el campo color.
			miarray = DAOPlaza.listarPlaza();
			
			for(int i = 0; i< miarray.size(); i++){
				miarray.get(i).setColor_Zona( DAOZona.buscaZona( miarray.get(i).getId_zona() ).getColor() );
			}
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return miarray;	
		// end-user-code
	}

	/* (sin Javadoc)
	 * @see AppArcao.Negocio.Plaza.ServicioAplicacionPlaza#crearPlaza(java.lang.String)
	 */
	@Override
	public int crearPlaza(TPlaza tPlaza) throws ExcepcionNegocio {
		
		int ID_Plaza = -2;
		
		DAOZona DAOZona = FactoriaIntegracion.getInstance().creaDAOZona();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		
		try {
			TZona zonaAux = DAOZona.readZonaByColor(tPlaza.getColor_Zona());
			if(zonaAux != null){ //si la zona existe
				
				
				tPlaza.setId_zona(zonaAux.getId_zona());
				
				tPlaza.setNum_plaza( DAOPlaza.numPlazasById(zonaAux.getId_zona()) +1);
				//tPlaza.setNum_plaza(02);
				
				ID_Plaza = 	DAOPlaza.registrarPlaza(tPlaza);
			}else{
				ID_Plaza = -1;
			}
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return ID_Plaza;
	}

	/* (sin Javadoc)
	 * @see AppArcao.Negocio.Plaza.ServicioAplicacionPlaza#leerPlaza()
	 */
	@Override
	public TPlaza buscarPlaza(TPlaza plaza) throws ExcepcionNegocio {

		DAOZona DAOZona = FactoriaIntegracion.getInstance().creaDAOZona();
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		
		try {
			TPlaza plazaAux = DAOPlaza.buscaPlaza(plaza);
			if(plazaAux != null){
				
				plaza.setColor_Zona(DAOZona.buscaZona(plazaAux.getId_zona()).getColor());
				plaza.setNum_plaza(plazaAux.getNum_plaza());
				plaza.setTipo_plaza(plazaAux.getTipo_plaza());
				plaza.setDescripcion(plazaAux.getDescripcion());
				
			}else{
				plaza = null;
			}
			
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
	
		
		return plaza;
	}

	
	/* (sin Javadoc)
	 * @see AppArcao.Negocio.Plaza.ServicioAplicacionPlaza#borrarPlaza(int)
	 */
	@Override
	public boolean borrarPlaza(TPlaza plaza) throws ExcepcionNegocio {
		boolean result = false;
		DAOPlaza DAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		DAOPlaza_vehiculo pv = FactoriaIntegracion.getInstance().creaDAOPlazaVehiculo();
	
		try {
			if(DAOPlaza.buscaPlaza(plaza) != null && !pv.plazaTieneReserva(plaza.getId_plaza())){
				result = DAOPlaza.borrarPlaza(plaza);
			}
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return result;
	}

	/* (sin Javadoc)
	 * @see AppArcao.Negocio.Plaza.ServicioAplicacionPlaza#modificarPlaza()
	 */
	@Override
	public boolean modificarPlaza(TPlaza modPlaza) throws ExcepcionNegocio {
		boolean resultado= false;
		TZona zonaAux;
		DAOPlaza miDAOPlaza = FactoriaIntegracion.getInstance().creaDAOPlaza();
		DAOZona miDAOZona = FactoriaIntegracion.getInstance().creaDAOZona();

		try {
			if(miDAOPlaza.buscaPlaza(modPlaza)!= null){ //Si la plaza existe...
				if(!modPlaza.getColor_Zona().equals(null) && !modPlaza.getTipo_plaza().equals(null)){ //Si los datos son correctos...
					
					zonaAux = miDAOZona.readZonaByColor(modPlaza.getColor_Zona());
					if(zonaAux != null){ //Si el color de zona existe
						modPlaza.setId_zona(zonaAux.getId_zona());
						resultado = miDAOPlaza.modificarPlaza(modPlaza); //se modifica la plaza
					}
				}else{
					resultado = false;
				}
			}else{
				resultado = false;
			}
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return resultado;
	}

	
}