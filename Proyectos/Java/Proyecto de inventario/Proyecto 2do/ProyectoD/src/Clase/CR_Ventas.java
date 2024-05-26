package Clase;

import javax.swing.JTextArea;

public class CR_Ventas {
	
	private String Nombre; 
	private Double Precio; 
	private Integer Cantidad;
	private String Cliente;
	
	public CR_Ventas(String Nombre, Double Precio, Integer Cantidad, String Cliente) {
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Cliente = Cliente;
	}
	
	 //---------------------------------------
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    //---------------------------------------
    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }
    //---------------------------------------
    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
    //---------------------------------------
    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }
    //---------------------------------------
    public void Imprime (JTextArea JTArea) {
    	double Multi;
    	Multi = Precio * Cantidad;
    	
    	JTArea.setText("");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("REGISTRO GUARDADO\n");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("Nombre: 			" + Nombre + "\n");
    	JTArea.append("Precio Und.: 			" + String.format("%.2f", Precio) + "\n");
    	JTArea.append("Cantidad: 			" + Cantidad + "\n");
    	JTArea.append("Cliente: 			" + Cliente + "\n");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("TOTAL: 			" + String.format("%.2f", Multi) + "\n");
    	JTArea.append("---------------------------------------------\n");
    }
}
