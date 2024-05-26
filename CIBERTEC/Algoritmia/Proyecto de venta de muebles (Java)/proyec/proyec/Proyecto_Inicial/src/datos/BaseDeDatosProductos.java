package datos;
import modelo.ConsultarProducto;
public class BaseDeDatosProductos {
	
	//  Atributos privados
	private int codigo, stock;
	private String nombre, Modelo;
	private double Precio;
	
	//  Constructor
	public BaseDeDatosProductos(int codigo, String nombre, String Modelo, double Precio, int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.Modelo = Modelo;
		this.Precio = Precio;
		this.stock = stock;
		
	}
	//  Métodos de acceso público: set/get
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setModelo(String Modelo) {
		this.Modelo = Modelo;
	}
	public void setPrecio(double Precio) {
		this.Precio = Precio;
	}
	
	public void setstock(int estado) {
		this.stock = estado;
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getModelo() {
		return Modelo;
	}
	public double getPrecio() {
		return Precio;
	}
	
	public int getstock() {
		return stock;
	}
	
	
	
	
	//  Operaciones públicas complementarias
	
	
}