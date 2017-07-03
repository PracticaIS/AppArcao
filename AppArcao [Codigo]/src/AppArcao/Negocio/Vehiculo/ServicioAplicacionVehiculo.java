package AppArcao.Negocio.Vehiculo;

import java.util.ArrayList;

import AppArcao.Negocio.Excepciones.ExcepcionNegocio;

public interface ServicioAplicacionVehiculo {

	
	public ArrayList<TVehiculo> listarVehiculos() throws ExcepcionNegocio;
	
	public int crearVehiculo(TVehiculo mivehiculo) throws ExcepcionNegocio;
	
	public TVehiculo buscarVehiculo(TVehiculo mivehiculo) throws ExcepcionNegocio;
	
	public boolean borrarVehiculo(TVehiculo mivehiculo) throws ExcepcionNegocio;
	
	public boolean modificarVehiculo(TVehiculo modvehiculo) throws ExcepcionNegocio;
	
	
}
