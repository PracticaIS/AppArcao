/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Integracion.Plaza_vehiculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Reserva.TPlaza_vehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name DAOReservaImp.java
 */

public class DAOPlaza_vehiculoImp implements DAOPlaza_vehiculo {

	@Override
	public TPlaza_vehiculo buscarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo)
			throws ExcepcionIntegracion {
		//Declaracion de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		TPlaza_vehiculo pla_ve=null;
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
	    
       //:::BUSCAMOS LA PLAZA VEHICULO::: 
	       
	       
	       try{
	           String sql="SELECT * FROM Plazas_vehiculos WHERE id_pv="+miPlaza_vehiculo.getId_pv();
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");
	       }
	       try{
	           if (rs.next()){
	               pla_ve=new TPlaza_vehiculo(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),
	            		   rs.getString(6), rs.getString(7));
	               
	           }else{
	               pla_ve=null;
	           }
	         //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	       }
	       catch (Exception e){
	         
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");
	           
	       }
	       return pla_ve;
	}

	@Override
	public int registrarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo)
			throws ExcepcionIntegracion {
		//Esta variable se va a usar para recibir el valor del campo autonum�rico
        int codigo = -1;
		//Declaracion de variables locales.
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
	    
       //:::INSERTAMOS LA PLAZA _ VEHICULO::: 
		
		try{
	           String sql="insert plazas_vehiculos(id_vehiculo, id_plaza, id_reserva, fecha_registro, estado, tipo_reser)"
	           		+ "values("+miPlaza_vehiculo.getId_vehiculo()+","+miPlaza_vehiculo.getId_plaza()+","+miPlaza_vehiculo.getId_reserva()+
	           		",'"+miPlaza_vehiculo.getFecha_registro()+"','"+miPlaza_vehiculo.getEstado()+"','"+miPlaza_vehiculo.getTipo_reserva()+"')";
	           stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		}
		catch (Exception e)
		{
			throw new ExcepcionIntegracion("Error SQL al insertar plaza vehiculo en la BBDD.");
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
	    	   throw new ExcepcionIntegracion("Error SQL al insertar plaza vehiculo en la BBDD.");
	       }
	   return(codigo);
	}

	@Override
	public boolean modificarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo)
			throws ExcepcionIntegracion {
		boolean sw = false;
		//Declaracion de variables locales.
		Connection con = null;
		Statement stmt = null;
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

		try{
			String sql="update Plazas_vehiculos SET id_pv="+miPlaza_vehiculo.getId_pv()+","
			+ "id_vehiculo="+miPlaza_vehiculo.getId_vehiculo()+","
			+ "id_reserva="+miPlaza_vehiculo.getId_reserva()+","
			+ "id_plaza="+miPlaza_vehiculo.getId_plaza()+","
			+ "fecha_registro='"+miPlaza_vehiculo.getFecha_registro()+"',"
			+ "estado='"+miPlaza_vehiculo.getEstado()+"',"
			+ "tipo_reser='"+miPlaza_vehiculo.getTipo_reserva()+"' WHERE id_pv="
			+ miPlaza_vehiculo.getId_pv();
			stmt.executeUpdate(sql);
			sw=true;	           
		}
		catch (Exception e)
		{
		    throw new ExcepcionIntegracion("Error SQL al modificar una plaza_vehiculo en la BBDD.");
		}  
		try{
			con.commit();
		}
		catch (Exception e)
		{
		    throw new ExcepcionIntegracion("Error SQL al modificar una plaza_vehiculo en la BBDD.");
		}

		return(sw);
	
	}

	@Override
	public boolean borrarPlaza_vehiculo(TPlaza_vehiculo miPlaza_vehiculo) throws ExcepcionIntegracion{
		boolean sw = false;
		//Declaracion de variables locales.
		Connection con = null;
		Statement stmt = null;
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
	
		//:::BORRAMOS LA PLAZA VEHICULO::: 
		try{
			String sql="delete from Plazas_vehiculos where id_pv="+miPlaza_vehiculo.getId_pv();
			stmt.executeUpdate(sql);
			sw=true;
		}
		catch (Exception e)
		{
		    throw new ExcepcionIntegracion("Error SQL borrar plazas vehiculos");
		}  
		try{
			con.commit();
			
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		}
		catch (Exception e)
		{
	           throw new ExcepcionIntegracion("Error SQL borrar plazas vehiculos");

		}
	
		return sw;
	}
	
	@Override
	public TPlaza_vehiculo readPlaza_vehiculoById(int id_reserva) throws ExcepcionIntegracion {
		//Declaracion de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		TPlaza_vehiculo pla_ve=null;
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
	    
       //:::BUSCAMOS LA PLAZA VEHICULO::: 
	       
	       
	       try{
	           String sql="SELECT * FROM Plazas_vehiculos WHERE id_reserva="+id_reserva;
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");

	       }
	       try{
	           if (rs.next()){
	               pla_ve=new TPlaza_vehiculo(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),
	            		   rs.getString(6), rs.getString(7));
	               
	           }else{
	               pla_ve=null;
	           }
	           
	       }
	       catch (Exception e){
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");

	           
	       }
	       return pla_ve;
		
	}

	@Override
	public int numReservasByFecha(String fecha) throws ExcepcionIntegracion {
		// TODO Apéndice de método generado automáticamente
		//Declaraci�n de variables locales.
		int cantidadPlazas = 0;
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
			String sql="SELECT count(id_pv) FROM plazas_vehiculos where fecha_registro = '"+fecha+"'";
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar plazas registradas en reserva en la BBDD.");
		}
		try{
			if (rs.next()){
				cantidadPlazas = rs.getInt(1);
	               
	        }else{
	        	cantidadPlazas= 0;
	        }
	           
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error al contar las plazas en plaza vehiculo.");
		}	
		return cantidadPlazas;
	}
	
	public ArrayList<TPlaza_vehiculo> cargarReservasPasadas() throws ExcepcionIntegracion{
		//Declaraci�n de variables locales.
		TPlaza_vehiculo mipv=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TPlaza_vehiculo> misPvs = new ArrayList<TPlaza_vehiculo>();
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
	           String sql="SELECT * FROM plazas_vehiculos WHERE fecha_registro<CURDATE()";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al una plaza vehiculo en la BBDD.");
	    }
	    try{
	    	   //A�adimos a la lista todas las zonas encontradas en la base de datos.
	    	   
	           while(rs.next()){
	        	   mipv=new TPlaza_vehiculo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
	               misPvs.add(mipv);
	           }
	           
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en la busqueda de una plaza vehiculo.");
	    }
		return misPvs;
	}
	
	public ArrayList<TPlaza_vehiculo> cargarReservasPorHacer() throws ExcepcionIntegracion{
		//Declaraci�n de variables locales.
		TPlaza_vehiculo mipv=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TPlaza_vehiculo> misPvs = new ArrayList<TPlaza_vehiculo>();
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
	           String sql="SELECT * FROM plazas_vehiculos WHERE fecha_registro=CURDATE()";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al una plaza vehiculo en la BBDD.");
	    }
	    try{
	    	   //A�adimos a la lista todas las zonas encontradas en la base de datos.
	           while (rs.next()){
	        	   mipv=new TPlaza_vehiculo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
	               misPvs.add(mipv);
	           }
	           
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en la busqueda de una plaza vehiculo.");
	    }
		return misPvs;
	}

	@Override
	public boolean plazaTieneReserva(int id_plaza) throws ExcepcionIntegracion {
		//Declaracion de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean pla_ve=false;
		
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
	    
       //:::BUSCAMOS LA PLAZA VEHICULO::: 
	       
	       
	       try{
	           String sql="SELECT * FROM Plazas_vehiculos WHERE id_plaza="+id_plaza;
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");
	       }
	       try{
	           if (rs.next()){
	               pla_ve=true;
	               
	           }else{
	               pla_ve=false;
	           }
	           
	       }
	       catch (Exception e){
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");     
	       }
	       return pla_ve ;
	}
	
	
	public boolean vehiculoTieneReserva(int id_vehiculo) throws ExcepcionIntegracion {
		//Declaracion de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean pla_ve=false;
		
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
	    
       //:::BUSCAMOS LA PLAZA VEHICULO::: 
	       
	       
	       try{
	           String sql="SELECT * FROM Plazas_vehiculos WHERE id_vehiculo="+id_vehiculo;
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");
	       }
	       try{
	           if (rs.next()){
	               pla_ve=true;
	               
	           }else{
	               pla_ve=false;
	           }
	           
	       }
	       catch (Exception e){
	           throw new ExcepcionIntegracion("Error en la busqueda de la plaza_vehiculo");     
	       }
	       return pla_ve ;
	}
}