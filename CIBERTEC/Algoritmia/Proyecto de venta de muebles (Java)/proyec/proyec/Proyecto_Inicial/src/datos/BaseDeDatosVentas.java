package datos;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.Venta;
import datos.BaseDeDatosProductos;
import gui.GenerarReportes;

public class BaseDeDatosVentas {

	private ArrayList<Venta> ventas;
	
	private String nombreArchivo = "D:\\ventas.txt";
	
	private DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public BaseDeDatosVentas() {
		ventas = new ArrayList<>();
		cargarVentas();
	}
	
	private void cargarVentas() {
    	File file = new File(nombreArchivo);
		
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			
			String linea;
			
			/*int numeroVenta, String cliente, String dniRuc, String producto, int cantidad, double igv,
			double precio, Date fecha*/
			
			while ((linea = bufferedReader.readLine()) != null) {
				/*linea.split(";");*/
				int numeroVenta = Integer.parseInt(linea);
				String cliente = bufferedReader.readLine();
				String dniRuc = bufferedReader.readLine();
				String producto = bufferedReader.readLine();
				int cantidad = Integer.parseInt(bufferedReader.readLine());
				double igv = Double.parseDouble(bufferedReader.readLine());
				double precio = Double.parseDouble(bufferedReader.readLine());
				Date fecha = dateFormat.parse(bufferedReader.readLine());
				
				Venta nuevaVenta = new Venta(numeroVenta, cliente, dniRuc, producto, cantidad,igv,precio,fecha);
				
				ventas.add(nuevaVenta);
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public void registrarVenta(String cliente, String dniRuc, BaseDeDatosProductos producto, int cantidad,
			String fecha) {
		// para obtener información del producto
		int codigoProducto = producto.getCodigo();
		String modeloProducto = producto.getModelo();
		double precioProducto = producto.getPrecio();
		double igv = calcularIGV(precioProducto);
		double precioTotal = precioProducto * cantidad + igv;

		// para generar número de boleta
		int numeroBoleta = generarNumeroBoleta();

		// para instancia de Venta y agregar a la lista
		Venta nuevaVenta = new Venta(numeroBoleta, cliente, dniRuc, String.valueOf(modeloProducto), cantidad, igv, precioTotal, new Date());
		ventas.add(nuevaVenta);
		adicionarVentaArchivo(nuevaVenta);
	}

	private void adicionarVentaArchivo(Venta x) {
		try {
			FileWriter fileWriter = new FileWriter(nombreArchivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			
			bufferedWriter.write(String.valueOf(x.getNumeroVenta()));
			bufferedWriter.newLine();
			bufferedWriter.write(x.getCliente());
			bufferedWriter.newLine();
			bufferedWriter.write(x.getDniRuc());
			bufferedWriter.newLine();
			bufferedWriter.write(x.getProducto());
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(x.getCantidad()));
			bufferedWriter.newLine();
			bufferedWriter.write(decimalFormat.format(x.getIgv()));
			bufferedWriter.newLine();
			bufferedWriter.write(decimalFormat.format(x.getPrecio()));
			bufferedWriter.newLine();
			bufferedWriter.write(dateFormat.format(x.getFecha()));
			bufferedWriter.newLine();
			
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private double calcularIGV(double precio) {
		// Lógica para calcular el IGV
		return precio * 0.18; // % de IGV
	}

	private int generarNumeroBoleta() {
		// falta personalizar
		return (int) (Math.random() * 100000);
	}

	public List obtenerProductoPorModelo(String modeloSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}

	public java.util.List<Venta> obtenerVentas() {
		// TODO Auto-generated method stub
		return this.ventas;
	}

	public List obtenerTodosLosProductos() {
		// TODO Auto-generated method stub
		return null;
	}


	// Otras operaciones

}
