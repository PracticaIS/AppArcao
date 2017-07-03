/**
 * 
 */
package AppArcao.Integracion.Socio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Socio.TSocio;
import AppArcao.Negocio.Socio.TSocioNoVIP;
import AppArcao.Negocio.Socio.TSocioVIP;

/** 
 * <!-- begin-UML-doc -->
 * <br>@author&nbsp;tomas
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOSocioImp implements DAOSocio {
	
	@Override
	public TSocio buscaSocio(TSocio socio) throws ExcepcionIntegracion{
		//Declaracion de variables locales.
		TSocio miSocio=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String nombre;
		String apellidos;
		String direccion;
		String ciudad;
		String provincia;
		String cod_postal;
		String num_tarjeta;
		String fecha_regis;
		int estado;
		String tipo_socio;
		String telefono;
		String email;
	
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
	    
	    //:::COMPROBAMOS DE QUE TIPO DE SOCIO SE TRATA:::
	    try{
	           String sql="SELECT * FROM Socios WHERE id_socio="+socio.getId_socio();
	           rs=stmt.executeQuery(sql);
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error SQL al buscar socio en la BBDD");
	       }
	       try{
	           if (rs.next()){
	        	   nombre = rs.getString(2);
		           apellidos = rs.getString(3);
		           direccion = rs.getString(4);
		           ciudad = rs.getString(5);
		           provincia = rs.getString(6);
		           cod_postal = rs.getString(7);
		           num_tarjeta = rs.getString(8);
		           fecha_regis = rs.getString(9);
		           estado = rs.getInt(10);
		           tipo_socio = rs.getString(11);
	        	   //Comprobamos que tipo de socio hemos encontrado.
	        	   if (rs.getString("tipo_socio").equalsIgnoreCase("vip")){
	        		   //Procedemos a consultar los datos en la tabla socio vip.
	        		   try{
	        	           String sql="SELECT * FROM Sociosvip WHERE id_socio="+socio.getId_socio();
	        	           rs=stmt.executeQuery(sql);
	        	       }
	        	       catch (Exception e){
	        	    	   throw new ExcepcionIntegracion("Error SQL al buscar socio vip en la BBDD");
	        	       }
	        	       if (rs.next()){
	        	    	   telefono = rs.getString("telefono");
	        	    	   miSocio = new TSocioVIP(rs.getInt(1), nombre, apellidos, direccion, ciudad, provincia, cod_postal, num_tarjeta, fecha_regis, estado, tipo_socio, rs.getInt("id_socioVIP"), telefono, socio.getId_socio());
	    	           }else{
	    	        	   miSocio=null;
	    	           }
	        	   }
	        	   else{
	        		 //Procedemos a consultar los datos en la tabla socio vip.
	        		   try{
	        	           String sql="SELECT * FROM Sociosnovip WHERE id_socio="+socio.getId_socio();
	        	           rs=stmt.executeQuery(sql);
	        	       }
	        	       catch (Exception e){
	        	    	   throw new ExcepcionIntegracion("Error SQL al buscar socio no vip en la BBDD");
	        	       }
	        	       if (rs.next()){
	        	    	   email = rs.getString("email");
	        	    	   miSocio = new TSocioNoVIP(rs.getInt(1), nombre, apellidos, direccion, ciudad, provincia, cod_postal, num_tarjeta, fecha_regis, estado, tipo_socio, rs.getInt("id_socioNoVIP"), email, socio.getId_socio());
	        	    	   
	        	    	   
	    	           }else{
	    	        	   miSocio=null;
	    	           }
	        	   }
	           }
	           else{
	        	   miSocio=null;
	           }
	         //Realizamos el cierre de la conexi�n.
		        con.close();
		        stmt.close();
		        rs.close();
	       }
	       catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error en la busqueda del socio");
	       }
	       
	       return miSocio;
		
	}
	
	public int registrarSocio(TSocio misocio) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		
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
	    //:::INSERCCIÓN DE UN SOCIO:::
	    try{
	           sql="INSERT INTO socios(nombre,apellidos,direccion,ciudad,provincia,cod_postal,num_tarjeta,fecha_regis,estado,tipo_socio) VALUES('"
	           +misocio.getNombre()+"','"
	           +misocio.getApellidos()+"','"
	           +misocio.getDireccion()+"','"
	           +misocio.getCiudad()+"','"
	           +misocio.getProvincia()+"','"
	           +misocio.getCod_postal()+"','"
	           +misocio.getNum_tarjeta()+"',"
	           +"date_format(CURDATE(), '%d/%m/%Y'),"
	           +misocio.getEstado()+",'"
	           +misocio.getTipo_socio()+"')";
	           
	           stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
	    }
	    catch (Exception e){
	    	   throw new ExcepcionIntegracion("Error num 1 SQL al insertar un socio en la BBDD.");
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
		   	   try{
		   		   if (misocio.getTipo_socio().equalsIgnoreCase("vip")){
		   			   TSocioVIP misocioVIP = (TSocioVIP) misocio;
		   			   sql="INSERT INTO sociosvip(telefono,id_socio) VALUES ('"+misocioVIP.getTelefono()+"',"+codigo+")";
		   		   }
		   		   else{
		   			   TSocioNoVIP misocioNoVIP = (TSocioNoVIP) misocio;
		   			   sql="INSERT INTO sociosnovip(email,id_socio) VALUES ('"+misocioNoVIP.getEmail()+"',"+codigo+")";
		   	           
		   		   }
		   		   stmt.executeUpdate(sql);
		   	   }
		   	   catch (Exception e){
		   	    	   throw new ExcepcionIntegracion("Error 2 SQL al insertar un socio vip en la BBDD.");
		   	   }  
		   	   try{
		           con.commit();
		   	   }
			   catch (Exception e)
			   {
		    	   throw new ExcepcionIntegracion(e.getMessage());
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
	    return codigo;
	}
	
	public boolean modificarSocio(TSocio misocio) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		boolean sw = false;
		String sql = "";
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
	    //:::MODIFICACIÓN DE UN SOCIO:::
	    try{
	           sql="update socios SET "
	           		   + "nombre='"+misocio.getNombre()+"',"
	        		   + "apellidos='"+misocio.getApellidos()+"',"
	        		   + "direccion='"+misocio.getDireccion()+"',"
	        		   + "ciudad='"+misocio.getCiudad()+"',"
	        		   + "provincia='"+misocio.getProvincia()+"',"
	        		   + "cod_postal='"+misocio.getCod_postal()+"',"
	        		   + "num_tarjeta='"+misocio.getNum_tarjeta()+"',"
	        		   + "estado="+misocio.getEstado()+","
	        		   + "tipo_socio='"+misocio.getTipo_socio()
	        		   +"' WHERE id_socio="+misocio.getId_socio();
	           stmt.executeUpdate(sql);
	           sw=true;	           
	    }
	    catch (Exception e)
	    {
	    	   throw new ExcepcionIntegracion("Error SQL al modificar un socio en la BBDD.");
	    }  
	    try{
	           con.commit();
	           
	           try{
	        	   if (misocio.getTipo_socio().equalsIgnoreCase("vip")){
		   			   TSocioVIP misocioVIP = (TSocioVIP) misocio;
		   			   sql="update sociosvip SET "
		        		   + "telefono="+misocioVIP.getTelefono()+" WHERE id_socio="+misocio.getId_socio();
		   		   }
		   		   else{
		   			   TSocioNoVIP misocioNoVIP = (TSocioNoVIP) misocio;
		   			   sql="update sociosvip SET "
		        		   + "email="+misocioNoVIP.getEmail()+" WHERE id_socio="+misocio.getId_socio();
		   		   }
		           stmt.executeUpdate(sql);
		           sw=true;	           
		       }
		       catch (Exception e)
		       {
		    	   throw new ExcepcionIntegracion("Error SQL al modificar un socio en la BBDD.");
		       }  
		       try{
		           con.commit();
		       }
		       catch (Exception e)
			   {
			    	   throw new ExcepcionIntegracion(e.getMessage());
			   }
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
	
	public boolean borrarSocio(TSocio misocio) throws ExcepcionIntegracion {
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
	    //:::BORRAR UN SOCIO:::
	    try{
            String sql="update Socios set estado=0 where id_socio="+misocio.getId_socio();
            stmt.executeUpdate(sql);
            sw=true;
        }
        catch (Exception e)
        {
        	throw new ExcepcionIntegracion("Error SQL borrar socio.");
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

	public ArrayList<TSocio> listarSocios() throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TSocio miSocio=null;
		Connection con = null;
		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<TSocio> misSocios = new ArrayList<TSocio>();
		String sql = "";
		int id_socio;
		String nombre;
		String apellidos;
		String direccion;
		String ciudad;
		String provincia;
		String cod_postal;
		String num_tarjeta;
		String fecha_regis;
		int estado;
		String tipo_socio;
		int id_socioNoVIP;
		int id_socioVIP;
		String telefono;
		String email;
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
	    	stmt2=con.createStatement();
	    }
	    catch(SQLException e){
	    	throw new ExcepcionIntegracion("Error al establecer conexion con la BBDD.");
	    }
		//:::CONSULTAMOS A LA BBDD:::
		try{
	           sql = "SELECT * FROM socios";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL al buscar socios en la BBDD.");
	    }
	    try{
	    	   
	    	   //A�adimos a la lista todos los socios encontrados en la base de datos.
	    	   while(rs.next()){
	        	    id_socio=rs.getInt(1);
		       		nombre=rs.getString(2);
		       		apellidos=rs.getString(3);
		       		direccion=rs.getString(4);
		       		ciudad=rs.getString(5);
		       		provincia=rs.getString(6);
		       		cod_postal=rs.getString(7);
		       		num_tarjeta=rs.getString(8);
		       		fecha_regis=rs.getString(9);
		       		estado=rs.getInt(10);
		       		tipo_socio=rs.getString(11);
	        	   if (rs.getString(11).equalsIgnoreCase("vip")){
	        		   sql = "SELECT * FROM sociosvip WHERE id_socio="+rs.getInt("id_socio");
	        		   rs2=stmt2.executeQuery(sql);
	        		   if (rs2.next()){
	        			   id_socioVIP = rs2.getInt(1);
	        			   telefono = rs2.getString(2);
	        	    	   TSocioVIP auxmisocio = new TSocioVIP(id_socio,nombre,apellidos,direccion,ciudad,provincia,cod_postal,num_tarjeta,fecha_regis,estado,tipo_socio,id_socioVIP,telefono,id_socio);
	        			   miSocio = auxmisocio;
	        			   miSocio.setId_socio(id_socio);
	        	    	   misSocios.add(miSocio);
	        	    	   telefono = rs2.getString(2);
	    	           }else{
	    	        	   throw new ExcepcionIntegracion("No encuentro el socio 'vip' al listar");
	    	           }
	        	   }
	        	   else{
	        		   sql = "SELECT * FROM sociosnovip WHERE id_socio="+rs.getInt("id_socio");
	        		   rs2=stmt2.executeQuery(sql);
	        		   if (rs2.next()){
	        			   id_socioNoVIP = rs2.getInt(1);
	        			   email = rs2.getString(2);
	        	    	   TSocioNoVIP auxmisocio = new TSocioNoVIP(id_socio,nombre,apellidos,direccion,ciudad,provincia,cod_postal,num_tarjeta,fecha_regis,estado,tipo_socio,id_socioNoVIP,email,id_socio);
	        			   miSocio = auxmisocio;
	        			   miSocio.setId_socio(id_socio);
	        	    	   misSocios.add(miSocio);
	    	           }else{
	    	        	   throw new ExcepcionIntegracion("No encuentro el socio 'no vip' al listar");
	    	           }
	        	   }
	           }
	           
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en listar un socio.");
	    }
		return misSocios;
	}
	
	public TSocio readSocioByNum_Tarjeta(TSocio misocio) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TSocio miSocio=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//Realizamos la conexión con la BBDD.
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
			String sql="SELECT * FROM Socios WHERE num_tarjeta = '"+misocio.getNum_tarjeta()+"'" ;
			rs=stmt.executeQuery(sql);
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error SQL al buscar socio read socio by num en la BBDD.");
		}
		try{
			if (rs.next()){
				miSocio = new TSocio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11));
	               
	        }else{
	        	miSocio=null;
	        }
	           
			//Realizamos el cierre de la conexi�n.
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e){
			throw new ExcepcionIntegracion("Error en la busqueda del socio read socio by num 2.");
		}	
		return miSocio;
	}
}