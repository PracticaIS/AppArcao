/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Integracion.Reserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AppArcao.Integracion.Excepciones.ExcepcionIntegracion;
import AppArcao.Negocio.Reserva.TReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name DAOReservaImp.java
 */

public class DAOReservaImp implements DAOReserva {

	
	@Override
	public TReserva buscarReserva(TReserva miReserva) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		TReserva re = null;
		
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
	       
	    try{
	           sql="SELECT * FROM Reservas WHERE id_reserva="+miReserva.getId_Reserva();
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	           System.out.println("Error SQL al buscar reserva en la BBDD");
	           System.out.println(e.getMessage());
	    }
	    try{
	           if (rs.next()){
	               re=new TReserva(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
	               
	           }else{
	               re=null;
	           }
	         //Realizamos el cierre de la conexi�n.
		     con.close();
		     stmt.close();
		     rs.close();
	       }
	    catch (Exception e){
	           System.out.println("Error en la busqueda de la reserva");
	           System.out.println(e.getMessage());
	           
	    }
	    return re;
	}

	@Override
	public int registrarReserva(TReserva miReserva) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
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
		   
		   ///:::REALIZAMOS LA INSERCCIÓN DE LA RESERVA:::
	       try{
	           sql="insert Reservas(id_socio, fecha_registro, estado)"
	           		+ " values("+miReserva.getId_Socio()+", "
	           		+"date_format(CURDATE(), '%Y/%m/%d'),'"+miReserva.getEstado()+"')";
	           stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
	       }
	       catch (Exception e)
	       {
	           System.out.println("Error SQL al insertar una reserva en la BBDD.");
	           System.out.println(e.getMessage());
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
	           System.out.println(e.getMessage());
	       }
		return codigo;
	}

	@Override
	public boolean modificarReserva(TReserva miReserva) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		String sql = "";
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
		   
		   ///:::REALIZAMOS LA MODIFICACIÓN DE LA RESERVA:::
		       try{
		           sql="update Reservas SET "
		           		   + "id_reserva="+miReserva.getId_Reserva()+","
		        		   + "id_socio="+miReserva.getId_Socio()+","
		        		   + "estado='"+miReserva.getEstado()+"' WHERE id_reserva="
		        		   + miReserva.getId_Reserva();
		           stmt.executeUpdate(sql);
		           sw=true;	           
		       }
		       catch (Exception e)
		       {
		           System.out.println("Error SQL al modificar una reserva en la BBDD.");
		           System.out.println(e.getMessage());
		       }  
		        try{
		           con.commit();
		           
		           //Realizamos el cierre de la conexi�n.
			       con.close();
			       stmt.close();
		       }
		       catch (Exception e)
		       {
		           System.out.println(e.getMessage());
		       }
	       return(sw);
	}

	/* (sin Javadoc)
	 * @see AppArcao.Integracion.Reserva.DAOReserva#borrarReserva(int)
	 */
	@Override
	public boolean borrarReserva(TReserva miReserva) throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		String sql = "";
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
		   
		   ///:::REALIZAMOS LA MODIFICACIÓN DE LA RESERVA:::
		       try{
		           sql="delete from Reservas WHERE id_reserva="
		        		   + miReserva.getId_Reserva();
		           stmt.executeUpdate(sql);
		           sw=true;	           
		       }
		       catch (Exception e)
		       {
		           System.out.println("Error SQL al borrar una reserva en la BBDD.");
		           System.out.println(e.getMessage());
		       }  
		        try{
		           con.commit();
		           
		           //Realizamos el cierre de la conexi�n.
			       con.close();
			       stmt.close();
		       }
		       catch (Exception e)
		       {
		           System.out.println(e.getMessage());
		       }
	       return(sw);
	}

	/* (sin Javadoc)
	 * @see AppArcao.Integracion.Reserva.DAOReserva#listarReservas()
	 */
	@Override
	public ArrayList<TReserva> listarReservas() throws ExcepcionIntegracion {
		//Declaraci�n de variables locales.
		TReserva miReserva=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TReserva> misReservas = new ArrayList<TReserva>();
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
	           String sql="SELECT * FROM Reservas";
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	    	throw new ExcepcionIntegracion("Error SQL en listar reservas en la BBDD.");
	    }
	    try{
	    	   
	    	   //A�adimos a la lista todas las reservas encontradas en la base de datos.
	           while (rs.next()){
	        	   miReserva=new TReserva(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
	               misReservas.add(miReserva);
	           }
	           
	           //Realizamos el cierre de la conexi�n.
		       con.close();
		       stmt.close();
		       rs.close();
	    }catch (Exception e){
	    	throw new ExcepcionIntegracion("Error en listar reservas.");
	    }
		return misReservas;
	}
	
	@Override
	public boolean tieneReserva(int id) throws ExcepcionIntegracion{
		//Declaraci�n de variables locales.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		boolean re = false;
		
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
	       
	    try{
	           sql="SELECT * FROM Reservas WHERE id_socio="+id;
	           rs=stmt.executeQuery(sql);
	    }
	    catch (Exception e){
	           System.out.println("Error SQL al buscar reserva en la BBDD");
	           System.out.println(e.getMessage());
	    }
	    try{
	           if (rs.next()){
	               re=true;
	               
	           }else{
	               re= false;
	           }
	         //Realizamos el cierre de la conexi�n.
		     con.close();
		     stmt.close();
		     rs.close();
	       }
	    catch (Exception e){
	           System.out.println("Error en la busqueda de la reserva");
	           System.out.println(e.getMessage());
	    }
		return re;
	}
}