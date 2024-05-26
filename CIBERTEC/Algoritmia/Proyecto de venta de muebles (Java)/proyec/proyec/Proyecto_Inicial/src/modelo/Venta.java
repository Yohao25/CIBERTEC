package modelo;

import datos.BaseDeDatosVentas;
import java.util.Date;
import datos.BaseDeDatosProductos;
public class Venta {
    private int numeroVenta;  
    private String cliente;
    private String dniRuc;
    private String producto;
    private int cantidad;
    private double igv;
    private double precio;
    private Date fecha;

 

   
    
    public Venta(int numeroVenta, String cliente, String dniRuc, String producto, int cantidad, double igv,
			double precio, Date fecha) {
		super();
		this.numeroVenta = numeroVenta;
		this.cliente = cliente;
		this.dniRuc = dniRuc;
		this.producto = producto;
		this.cantidad = cantidad;
		this.igv = igv;
		this.precio = precio;
		this.fecha = fecha;
	}

	public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = dniRuc;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    @Override
    public String toString() {
        return "Venta{" +
                "numeroVenta=" + numeroVenta +
                ", cliente='" + cliente + '\'' +
                ", dniRuc='" + dniRuc + '\'' +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", igv=" + igv +
                ", precio=" + precio +
                ", fecha=" + fecha +
                '}';
    }
}