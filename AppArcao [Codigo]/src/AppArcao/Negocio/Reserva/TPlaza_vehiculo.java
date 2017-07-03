/**
 * @ProjectName AppArcaoProg
 */
package AppArcao.Negocio.Reserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @Project_Name AppArcaoProg
 * @Author Rodrigo de Miguel González
 * @Date 19/05/2015
 * @File_Name TReserva.java
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TPlaza_vehiculo {
	
	//Atributos del transfer.
	int id_pv;
	int id_vehiculo;
	int id_plaza;
	int id_reserva;
	String fecha_registro;
	String estado;
	String tipo_reserva;
	
	
	//Constructor sin parámetros.
	public TPlaza_vehiculo() {
		this.id_pv = 0;
		this.id_vehiculo = 0;
		this.id_plaza = 0;
		this.id_reserva = 0;
		this.fecha_registro = "";
		this.estado = "";
		this.tipo_reserva = "";
	}
	
	//Constructor con parámetros.
	public TPlaza_vehiculo(int id_pv, int id_vehiculo, int id_plaza,
			int id_reserva, String fecha_registro, String estado,
			String tipo_reserva) {
		this.id_pv = id_pv;
		this.id_vehiculo = id_vehiculo;
		this.id_plaza = id_plaza;
		this.id_reserva = id_reserva;
		this.fecha_registro = fecha_registro;
		this.estado = estado;
		this.tipo_reserva = tipo_reserva;
	}


	//Getters and Setters.
	
	public int getId_pv() {
		return id_pv;
	}

	public void setId_pv(int id_pv) {
		this.id_pv = id_pv;
	}

	public int getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public int getId_plaza() {
		return id_plaza;
	}

	public void setId_plaza(int id_plaza) {
		this.id_plaza = id_plaza;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo_reserva() {
		return tipo_reserva;
	}

	public void setTipo_reserva(String tipo_reserva) {
		this.tipo_reserva = tipo_reserva;
	}

	
	//Método toString.
	@Override
	public String toString() {
		return "TPlaza_vehiculo [id_pv=" + id_pv + ", id_vehiculo="
				+ id_vehiculo + ", id_plaza=" + id_plaza + ", id_reserva="
				+ id_reserva + ", fecha_registro=" + fecha_registro
				+ ", estado=" + estado + ", tipo_reserva=" + tipo_reserva + "]";
	}
}