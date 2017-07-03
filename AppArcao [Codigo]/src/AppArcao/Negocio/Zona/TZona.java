/**
 * 
 */
package AppArcao.Negocio.Zona;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomas
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TZona {
	private int id_zona;
	private String color;
	private int planta;
	
	//Constructor por defecto
	public TZona() {
		this.id_zona = 0;
		this.color = "";
		this.planta = 0;
	}
	
	//Constructor con par�metros.
	public TZona(int id_zona, String color, int planta) {
		super();
		this.id_zona = id_zona;
		this.color = color;
		this.planta = planta;
	}

	//Getters and Setterssss
	public int getId_zona() {
		return id_zona;
	}

	public void setId_zona(int id_zona) {
		this.id_zona = id_zona;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	//M�todo toString.
	@Override
	public String toString() {
		return "Zona [id_zona=" + id_zona + ", color=" + color + ", planta="
				+ planta + "]";
	}
}