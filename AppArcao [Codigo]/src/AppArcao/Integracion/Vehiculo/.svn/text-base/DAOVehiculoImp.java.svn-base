/**
 * 
 */
package AppArcao.Integracion.Vehiculo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Vehiculo.TVehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <br>@author&nbsp;tomas
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOVehiculoImp implements DAOVehiculo {

	@Override
	public TVehiculo buscaVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion {
		//Declaracion de variables locales.
		TVehiculo miVehiculo=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//Realizamos la conexion con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD");
	    }
	    
	    //:::BUSQUEDA DEL VEHÍCULO:::
	       
	       try{
	           String sql="SELECT * FROM Vehiculos WHERE id_vehiculo="+mivehiculo.getId_vehiculo();
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error SQL al buscar vehículo en la BBDD");
	       }
	       try{
	           if (rs.next()){
	        	 
	        	   miVehiculo=new TVehiculo(rs.getInt(1),rs.getInt(6),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	               
	           }else{
	        	   miVehiculo=null;
	           }
	         //Realizamos el cierre de la conexi�n.
		     con.close();
		     stmt.close();
		     rs.close();
	           
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error en la busqueda del vehículo");
	       }
	       return miVehiculo;
	}

	@Override
	public int registrarVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//Esta variable se va a usar para recibir el valor del campo autonum�rico
        int codigo = -1;
        
		//Realizamos la conexi�n con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD");
	    }
	    //:::INSERCCIÓN DE UN VEHÍCULO:::
	       
	       try{
	           String sql="insert Vehiculos(id_socio,matricula,marca,tipo,color) "
	           		+ "values("+mivehiculo.getId_socio()+",'"+mivehiculo.getMatricula()+"', '"+mivehiculo.getMarca()+"', "
	           		+ "'"+mivehiculo.getTipo()+"','"+mivehiculo.getColor()+"')";
	           stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
	       }
	       catch (Exception e)
	       {
	    	   throw new ExcepcionIntegracion("Error SQL al insertar un vehículo en la BBDD.");
	       }  
	        try{
	           con.commit();
	           
	           rs = stmt.getGeneratedKeys();

	           //Se recupera al igual que cualquier otro registro y se asigna el valor a la variable codigo
	           if (rs.next()) {
	        	   codigo = rs.getInt(1);
	           } else {
	        	   //Manejar la excepci�n
	           }
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	       }
	       catch (Exception e)
	       {
	    	   throw new ExcepcionIntegracion(e.getMessage());
	       }
	       return(codigo);
	}

	@Override
	public boolean modificarVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean sw = false;
		//Realizamos la conexi�n con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD");
	    }
	    //:::MODIFICACI�N DE UN VEHÍCULO:::
	       try{
	           String sql="SELECT * FROM Vehiculos WHERE id_vehiculo="+mivehiculo.getId_vehiculo();
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e)
	       {
	    	   throw new ExcepcionIntegracion("Error SQL al buscar vehículo en la BBDD");
	       }
	       try{
	           if (rs.next()){
	               sw = true;
	           }         
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error en la busqueda del vehículo para poder modificarlo");       
	       }
		   if (sw){
		       try{
		           String sql="update Vehiculos SET matricula='"+mivehiculo.getMatricula()+"',"
		           		   + "id_socio="+mivehiculo.getId_socio()+","
		        		   + "marca='"+mivehiculo.getMarca()+"',"
		        		   + "tipo='"+mivehiculo.getTipo()+"',"
		        		   + "color='"+mivehiculo.getColor()+"' "
		        		   +" WHERE id_vehiculo="+mivehiculo.getId_vehiculo();
		           stmt.executeUpdate(sql);
		           sw=true;	           
		       }
		       catch (Exception e)
		       {	
		    	   throw new ExcepcionIntegracion("Error al modificar un vehículo");
		       }  
		        try{
		           con.commit();
		           //Realizamos el cierre de la conexi�n.
			       con.close();
			       stmt.close();
			       rs.close();
		       }
		       catch (Exception e)
		       {
		    	   throw new ExcepcionIntegracion(e.getMessage());
		       }
	       }
	       return(sw);
	}

	@Override
	public boolean borrarVehiculo(TVehiculo mivehiculo) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		boolean sw = false;
		Connection con = null;
		Statement stmt = null;
		//Realizamos la conexi�n con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql.");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
	    }
	    //:::BORRAR UN VEHÍCULO:::
	    	   try{
	               String sql="delete from Vehiculos where id_vehiculo="+mivehiculo.getId_vehiculo();
	               stmt.executeUpdate(sql);
	               sw=true;
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion("Error SQL borrar vehículos");
	           }  
	            try{
	               con.commit();
	             //Realizamos el cierre de la conexi�n.
			       con.close();
			       stmt.close();
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion(e.getMessage());
	           }
	       return sw;
	}

	@Override
	public ArrayList<TVehiculo> listarVehiculos() throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TVehiculo miVehiculo=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TVehiculo> misVehiculos = new ArrayList<TVehiculo>();
		//Realizamos la conexi�n con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql.");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
	    }
		//:::CONSULTAMOS A LA BBDD:::
		try{
	           String sql="SELECT * FROM Vehiculos";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar vehículo en la BBDD.");
	    }
	    try{
	    	   
	    	   //A�adimos a la lista todas las zonas encontradas en la base de datos.
	           while (rs.next()){
	        	   miVehiculo=new TVehiculo(rs.getInt(1),rs.getInt(6),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	               misVehiculos.add(miVehiculo);
	           }
	           
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en la busqueda del vehículo.");
	    }
		return misVehiculos;
	}

	@Override
	public TVehiculo readVehiculoByName(String miMatricula) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TVehiculo miVehiculo=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//Realizamos la conexi�n con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql.");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
	    }
	    //:::REALIZAMOS LA CONSULTA A LA BBDD:::
		try{
			String sql="SELECT * FROM Vehiculos WHERE matricula = '"+miMatricula+"'" ;
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar un vehiculo por matricula en la BBDD.");
		}
		try{
			if (rs.next()){
				miVehiculo=new TVehiculo(rs.getInt(1),rs.getInt(6),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	               
	        }else{
	       	    miVehiculo=null;
	        }
	           
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda de la zona.");
		}
		return miVehiculo;	
	}

	@Override
	public boolean borraTodos(int id) throws ExcepcionIntegracion {
		// TODO Apéndice de método generado automáticamente
		//Declaraci�n de variables locales.
		boolean sw = false;
		Connection con = null;
		Statement stmt = null;
		//Realizamos la conexi�n con la BBDD.
		try{
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en Driver mysql.");
		}
	    try{
	    	con=DriverManager.getConnection("jdbc:mysql://localhost/MyBBDD","root","1Manager");
	    	con.setAutoCommit(false);
	    	stmt=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
	    }
	    //:::BORRAR UN VEHÍCULO:::
	    	   try{
	               String sql="delete from Vehiculos where id_socio="+id;
	               stmt.executeUpdate(sql);
	               sw=true;
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion("Error SQL borrar vehículos");
	           }  
	            try{
	               con.commit();
	             //Realizamos el cierre de la conexi�n.
			       con.close();
			       stmt.close();
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion(e.getMessage());
	           }
	       return sw;
	}	
}