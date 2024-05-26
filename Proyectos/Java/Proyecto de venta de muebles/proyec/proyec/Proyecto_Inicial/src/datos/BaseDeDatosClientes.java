package datos;


public class BaseDeDatosClientes {
	
	//  Atributos privados
	private int codigo, ClienteNuevo;
	private String nombre, dni, RUC;
	
	//  Constructor
	public BaseDeDatosClientes (int codigo, String nombre, String dni, String RUC, int ClienteNuevo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.dni = dni;
		this.RUC = RUC;
		this.ClienteNuevo = ClienteNuevo;
	}
	//  Métodos de acceso público: set/get
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setRUC(String RUC) {
		this.RUC = RUC;
	}
	public void setClienteNuevo(int ClienteNuevo) {
		this.ClienteNuevo = ClienteNuevo;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public String getRUC() {
		return RUC;
	}
	
	public int getClienteNuevo() {
		return ClienteNuevo;
	}
	//  Operaciones públicas complementarias
	
	
}