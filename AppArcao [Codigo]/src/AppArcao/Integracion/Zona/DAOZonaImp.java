/**
 * 
 */
package AppArcao.Integracion.Zona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Zona.TZona;

/** 
 * <!-- begin-UML-doc -->
 * <br>@author&nbsp;tomas
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOZonaImp implements DAOZona {
	

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOZona#buscaZona(int id_zona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public TZona buscaZona(int id_zona) throws ExcepcionIntegracion {
		//Declaracion de variables locales.
		TZona miZona=null;
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
	    
	    //:::BUSQUEDA DE LA ZONA:::
		try{
	        String sql="SELECT * FROM Zonas WHERE id_zona="+id_zona;
	        rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD");	
	    }
	    try{
	        if (rs.next()){
	        	miZona=new TZona(rs.getInt(1),rs.getString(2),rs.getInt(3));
	               
	        }else{
	        	   miZona=null;
	        }
	        //Realizamos el cierre de la conexi�n.
	        con.close();
	        stmt.close();
	        rs.close();
	           
	    }
	    catch (Exception e){
	    		throw new ExcepcionIntegracion("Error en la busqueda de la zona");
	    }
		return miZona;
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOZona#registrarZona(TZona mizona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int registrarZona(TZona mizona) throws ExcepcionIntegracion {
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
	    //:::INSERCCI�N DE UNA ZONA:::
		try{
	           String sql="insert Zonas(color, planta) " +
	           		"values('"+mizona.getColor()+"', "+mizona.getPlanta()+")";
	           stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS); 
	    }
	    catch (Exception e)
	    {
	    	   throw new ExcepcionIntegracion("Error SQL al insertar una zona en la BBDD.");
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
	    //Si todo es correcto, devuelvo el �ltimo id insertado.
	    return codigo;
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOZona#modificarZona(Object mizona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean modificarZona(TZona mizona) throws ExcepcionIntegracion {
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
	    //:::MODIFICACI�N DE UNA ZONA:::
	    try{
	           String sql="SELECT * FROM Zonas WHERE id_zona="+mizona.getId_zona();
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e)
	    {
	    	throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD");
	    }
	    try{
	           if (rs.next()){
	               sw = true;
	           }         
	    }
	    catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error en la busqueda de la zona para poder modificarla");	           
	    }
		if (sw){
		   try{
		           String sql="update Zonas SET color='"+mizona.getColor()+"',"
		        		   + "planta="+mizona.getPlanta()+" WHERE id_zona="
		        		   + mizona.getId_zona();
		           stmt.executeUpdate(sql);
		           sw=true;	           
		   }
		   catch (Exception e){
			   	   throw new ExcepcionIntegracion("Error SQL al modificar una zona en la BBDD.");
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
			   throw new ExcepcionIntegracion("Error SQL al modificar una zona en la BBDD.");
		   }
		}
		return(sw);
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOZona#borrarZona(int id_zona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean borrarZona(int id_zona) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		boolean sw = false;
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
	    //:::BORRAR UNA ZONA:::
	    try{
	           String sql="SELECT * FROM Zonas WHERE id_zona="+id_zona;
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD para borrarla.");
	    }
	    try{
	       if (rs.next()){
	          sw = true;
	       }         
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD para borrarla.");
	    }
	    if (sw){
	    	   try{
	               String sql="delete from Zonas where id_zona="+id_zona;
	               stmt.executeUpdate(sql);
	               sw=true;
	           }
	           catch (Exception e)
	           {
	        	   throw new ExcepcionIntegracion("Error SQL borrar zonas.");
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
	    return sw;
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOZona#listarZonas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public ArrayList<TZona> listarZonas() throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TZona miZona=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TZona> misZonas = new ArrayList<TZona>();
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
	           String sql="SELECT * FROM Zonas";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD.");
	    }
	    try{
	    	   
	    	   //A�adimos a la lista todas las zonas encontradas en la base de datos.
	           while(rs.next()){
	        	   miZona=new TZona(rs.getInt(1),rs.getString(2),rs.getInt(3));
	               misZonas.add(miZona);
	           }

	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en la busqueda de la zona.");
	    }
		return misZonas;
	}

	/** 
	 * (sin Javadoc)
	 * @throws ExcepcionIntegracion 
	 * @see DAOZona#readZonaByName(String nombreZona, TZona TZona)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	//Modifico la salida.
	@Override
	public TZona readZonaByColor(String colorZona) throws ExcepcionIntegracion{
		
		//Declaraci�n de variables locales.
		TZona miZona=null;
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
			String sql="SELECT * FROM Zonas WHERE color = '"+colorZona+"'" ;
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar zona en la BBDD.");
		}
		try{
			if (rs.next()){
				miZona=new TZona(rs.getInt(1),rs.getString(2),rs.getInt(3));
	               
	        }else{
	       	   miZona=null;
	        }
	           
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda de la zona.");
		}	
		return miZona;
	}
}