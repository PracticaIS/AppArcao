package AppArcao.Negocio.Socio;

public class TSocio {

	protected int id_socio;
	protected String nombre;
	protected String apellidos;
	protected String direccion;
	protected String ciudad;
	protected String provincia;
	protected String cod_postal;
	protected String num_tarjeta;
	protected String fecha_regis;
	protected int estado;
	protected String tipo_socio;
	
	//Constructor por defecto.
	public TSocio() {
		this.id_socio = 0;
		this.nombre = "";
		this.apellidos = "";
		this.direccion = "";
		this.ciudad = "";
		this.provincia = "";
		this.cod_postal = "";
		this.num_tarjeta = "";
		this.fecha_regis = "";
		this.estado = 0;
		this.tipo_socio = "";
	}
	
	//Constructor con parámetros.
	public TSocio(int id_socio, String nombre, String apellidos,
			String direccion, String ciudad, String provincia,
			String cod_postal, String num_tarjeta, String fecha_regis,
			int estado, String tipo_socio) {
		
		this.id_socio = id_socio;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.cod_postal = cod_postal;
		this.num_tarjeta = num_tarjeta;
		this.fecha_regis = fecha_regis;
		this.estado = estado;
		this.tipo_socio = tipo_socio;
	}

	//Método toString.
	@Override
	public String toString() {
		return "TSocio [id_socio=" + id_socio + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + ", provincia=" + provincia
				+ ", cod_postal=" + cod_postal + ", num_tarjeta=" + num_tarjeta
				+ ", fecha_regis=" + fecha_regis + ", estado=" + estado
				+ ", id_vehiculo=" + ", tipo_socio=" + tipo_socio
				+ "]";
	}

	//Métodos getters and setters.
	public int getId_socio() {
		return id_socio;
	}

	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getNum_tarjeta() {
		return num_tarjeta;
	}

	public void setNum_tarjeta(String num_tarjeta) {
		this.num_tarjeta = num_tarjeta;
	}

	public String getFecha_regis() {
		return fecha_regis;
	}

	public void setFecha_regis(String fecha_regis) {
		this.fecha_regis = fecha_regis;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTipo_socio() {
		return tipo_socio;
	}

	public void setTipo_socio(String tipo_socio) {
		this.tipo_socio = tipo_socio;
	}
	
}
