/**
 * 
 */
package AppArcao.Integracion.Plaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Plaza.TPlaza;

/** 
 * <!-- begin-UML-doc -->
 * <br>@author&nbsp;tomas
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOPlazaImp implements DAOPlaza {

	@Override
	public TPlaza buscaPlaza(TPlaza plaza) throws ExcepcionIntegracion {
			//Declaracion de variables locales.
			TPlaza miplaza=null;
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
		    
	       //:::BUSCAMOS LA PLAZA:::
	       try{
	           String sql="SELECT * FROM Plazas WHERE id_plaza="+plaza.getId_plaza();
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error SQL al buscar plaza en la BBDD ");
	       }
	       try{
	           if (rs.next()){
	        	   miplaza=new TPlaza(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
	               
	           }else{
	        	   miplaza=null;
	           }
	           
	         //Realizamos el cierre de la conexi�n.
		     con.close();
		     stmt.close();
		     rs.close();
	           
	       }
	       catch (Exception e){
	         throw new ExcepcionIntegracion("Error SQL al buscar plaza en la BBDD ");
	           
	       }
	       return miplaza;
	}

	@Override
	public int registrarPlaza(TPlaza miplaza) throws ExcepcionIntegracion {
		
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
	    
       //:::INSERTAMOS LA PLAZA::: 
		
		try{
	           String sql="insert Plazas(id_zona, tipo_plaza, num_plaza, descripcion, estado)"
	           		+ "values("+miplaza.getId_zona()+", '"+miplaza.getTipo_plaza()+"', "
	           		+ miplaza.getNum_plaza()+",'"+miplaza.getDescripcion()+"',"+miplaza.getEstado()+")";
	           stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		}
		catch (Exception e)
		{
	       
	           throw new ExcepcionIntegracion("Error SQL al insertar una plaza en la BBDD. ");
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
	    	    throw new ExcepcionIntegracion("Error SQL al insertar una plaza en la BBDD. ");
	       }
	   return(codigo);
	}

	@Override
	public boolean modificarPlaza(TPlaza miplaza) throws ExcepcionIntegracion {
		boolean sw = false;
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
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
	    //:::MODIFICACI�N DE UNA PLAZA:::
		try{
		           String sql="update Plazas SET id_zona="+miplaza.getId_zona()+","
		        		   + "tipo_plaza='"+miplaza.getTipo_plaza()+"',"
		        		   + "estado="+miplaza.getEstado()+","
		        		   + "descripcion='"+miplaza.getDescripcion()+"' WHERE id_plaza="
		        		   + miplaza.getId_plaza();
		           stmt.executeUpdate(sql);
		           sw=true;	           
		}
		catch (Exception e)
		{
		    throw new ExcepcionIntegracion("Error SQL al modificar una plaza en la BBDD. ");
		}  
		try{
		           con.commit();
		           
		         //Realizamos el cierre de la conexi�n.
			     con.close();
			     stmt.close();
		}
		catch (Exception e)
		{
			throw new ExcepcionIntegracion("Error SQL al modificar una plaza en la BBDD. ");
		}
	   return(sw);
	}

	@Override
	public boolean borrarPlaza(TPlaza plaza) throws ExcepcionIntegracion {
		 boolean sw = false;
		//Declaraci�n de variables locales.
			Connection con = null;
			Statement stmt = null;
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
		    //:::BORRAR UNA PLAZA:::  
	    	   try{
	               String sql="delete from Plazas where id_plaza="+plaza.getId_plaza();
	               stmt.executeUpdate(sql);
	               sw=true;
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion("Error SQL al borrar una plaza en la BBDD. ");
	           }  
	            try{
	               con.commit();
	               
	             //Realizamos el cierre de la conexi�n.
				 con.close();
				 stmt.close();
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion("Error SQL al borrar una plaza en la BBDD. ");
	           }
	       return sw;
	}

	@Override
	public ArrayList<TPlaza> listarPlaza() throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TPlaza miplaza=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TPlaza> misPlazas = new ArrayList<TPlaza>();
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
	           String sql="SELECT * FROM Plazas";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar plaza en la BBDD.");
	    }
	    try{
	    	   //A�adimos a la lista todas las zonas encontradas en la base de datos.
	           while (rs.next()){
			           miplaza=new TPlaza(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
			           misPlazas.add(miplaza);
			    }
	           
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en la busqueda de la zona.");
	    }
		return misPlazas;
	}

	@Override
	public TPlaza readPlazaByName(String nombrePlaza) throws ExcepcionIntegracion {
		
		//Declaraci�n de variables locales.
		TPlaza miPlaza=null;
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
			String sql="SELECT * FROM Plazas WHERE tipo_plaza = '"+nombrePlaza+"'" ;
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD.");
		}
		try{
			if (rs.next()){
				miPlaza=new TPlaza(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
	               
	        }else{
	        	miPlaza=null;
	        }
	           
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda de la zona.");
		}	
		return miPlaza;
	}

	@Override
	public int numPlazasById(int id_zona) throws ExcepcionIntegracion {
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
			String sql="SELECT num_plaza FROM plazas WHERE id_zona=" +id_zona + " order by num_plaza DESC limit 1";
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD.");
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
			throw new ExcepcionIntegracion("Error al contar las plazas.");
		}	
		return cantidadPlazas;
	}
	
	@Override
	public int numPlazasTotales() throws ExcepcionIntegracion {
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
			String sql="SELECT count(id_plaza) FROM plazas";
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD.");
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
			throw new ExcepcionIntegracion("Error al contar las plazas.");
		}	
		return cantidadPlazas;
	}
	
	@Override
	public int plazaOptima() throws ExcepcionIntegracion{
		//Declaraci�n de variables locales.
		int id_plaza = -1;
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
			String sql="SELECT * FROM plazas as pla, zonas as zo where pla.estado=0 AND pla.id_zona=zo.id_zona group by planta having min(planta) order by planta limit 1";
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD.");
		}
		try{
			if (rs.next()){
				id_plaza = rs.getInt(1);
	               
	        }else{
	        	id_plaza= -1;
	        }
	           
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error al contar las plazas.");
		}	
		return id_plaza;
	}
}