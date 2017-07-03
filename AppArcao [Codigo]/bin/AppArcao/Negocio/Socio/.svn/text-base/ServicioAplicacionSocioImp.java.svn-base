/**
 * 
 */
package AppArcao.Negocio.Socio;

import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Integracion.FactoriaIntegracion.FactoriaIntegracion;
import AppArcao.Integracion.Reserva.DAOReserva;
import AppArcao.Integracion.Socio.DAOSocio;
import AppArcao.Integracion.Vehiculo.DAOVehiculo;
import AppArcao.Negocio.Excepciones.ExcepcionNegocio;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioAplicacionSocioImp implements ServicioAplicacionSocio{

	@Override
	public ArrayList<TSocio> listarSocios() throws ExcepcionNegocio {
		ArrayList<TSocio> miarray = null;
		DAOSocio DAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		
		try{
			//Buscamos a ver si existe la zona por el campo color.
			miarray = DAOSocio.listarSocios();
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		
		return miarray;	
	}

	@Override
	public int crearSocio(TSocio socio) throws ExcepcionNegocio {
		int ID_Socio = -1;
		
		DAOSocio DAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		
		try{
			//Buscamos a ver si existe el socio.
			TSocio misocio = DAOSocio.readSocioByNum_Tarjeta(socio);
			
			//en el caso de que no existe, procedemos a realizar el registro.
			if (misocio  == null) {
				ID_Socio = DAOSocio.registrarSocio(socio);
			}else {
				ID_Socio = -1;
			}
		
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return ID_Socio;	
	}

	@Override
	public TSocio buscarSocio(TSocio misocio) throws ExcepcionNegocio {
		DAOSocio miDAO = FactoriaIntegracion.getInstance().creaDAOSocio();
		TSocio miSocio;
		try {
			miSocio = miDAO.buscaSocio(misocio);
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return miSocio;
	}

	@Override
	public boolean borrarSocio(TSocio socio) throws ExcepcionNegocio {
		boolean result = false;
		DAOSocio DAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		DAOReserva reserva = FactoriaIntegracion.getInstance().creaDAOReserva();
		
		
		TSocio TSocio;
		try {
			TSocio = DAOSocio.buscaSocio(socio);
				
			if (TSocio  != null && !reserva.tieneReserva(socio.getId_socio()) ) {
				DAOVehiculo borravehiculo = FactoriaIntegracion.getInstance().creaDAOVehiculo();
				
				borravehiculo.borraTodos(socio.getId_socio());
				result = DAOSocio.borrarSocio(socio);	
			}
		}
		catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean modificarSocio(TSocio socio) throws ExcepcionNegocio {
		
		boolean resultado= false;
		DAOSocio miDAOSocio = FactoriaIntegracion.getInstance().creaDAOSocio();
		try {
			//Buscamos a ver si existe el socio.
			//Comprobamos si ha cambiado el numero de tarjeta.
			TSocio auxsocio = new TSocio();
			auxsocio = miDAOSocio.buscaSocio(socio);
			if (!auxsocio.getNum_tarjeta().equalsIgnoreCase(socio.getNum_tarjeta())){
				TSocio misocio = miDAOSocio.readSocioByNum_Tarjeta(socio);
				if (misocio == null)
				{
					resultado = miDAOSocio.modificarSocio(socio);
				}
			}
			else resultado = miDAOSocio.modificarSocio(socio);
			
		} catch (ExcepcionIntegracion e) {
			throw new ExcepcionNegocio(e.getMessage());
		}
		return resultado;
	}	
}