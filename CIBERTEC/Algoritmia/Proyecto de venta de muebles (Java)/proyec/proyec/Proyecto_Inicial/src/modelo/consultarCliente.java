package modelo;

import datos.BaseDeDatosClientes;
import datos.BaseDeDatosProductos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class consultarCliente {
	
	//  Atributo privado
	private ArrayList <BaseDeDatosClientes> per;
	
	private String nombreArchivo = "D:\\clientes.txt";
	
	/*private DecimalFormat decimalFormat = new DecimalFormat("0.00");*/

	//  Constructor
    public consultarCliente() {
    	per = new ArrayList <BaseDeDatosClientes> ();
    	cargarClientes();
    }
    private void cargarClientes() {
    	File file = new File(nombreArchivo);
		
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			
			String linea;
			
			while ((linea = bufferedReader.readLine()) != null) {
				/*linea.split(";");*/
				int codigo = Integer.parseInt(linea);
				String nombre = bufferedReader.readLine();
				String dni = bufferedReader.readLine();
				String RUC = bufferedReader.readLine();
				/*double precio = Double.parseDouble(bufferedReader.readLine());*/
				int ClienteNuevo = Integer.parseInt(bufferedReader.readLine());
				
				BaseDeDatosClientes nuevoCliente = new BaseDeDatosClientes(codigo, nombre, dni, RUC, ClienteNuevo);
				
				per.add(nuevoCliente);
			}
			
			bufferedReader.close();
		 } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
    }
	//  Operaciones publicas basicas
	public void adicionarCliente(BaseDeDatosClientes x) {
		per.add(x);
		adicionarClientesArchivo1(x);
	}
	private void adicionarClientesArchivo1(BaseDeDatosClientes x) {
		try {
			FileWriter fileWriter = new FileWriter(nombreArchivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(x.getCodigo());
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(x.getNombre()));
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(x.getDni()));
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(x.getRUC()));
			bufferedWriter.newLine();
			bufferedWriter.write(x.getClienteNuevo());
			bufferedWriter.newLine();
			
			bufferedWriter.close();
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public int tamaño(){
		return per.size();
	}
	public BaseDeDatosClientes obtener(int i) {
		return per.get(i);
	}
	public BaseDeDatosClientes buscar(int codigo) {
		BaseDeDatosClientes x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	public BaseDeDatosClientes buscar(String dni) {
		BaseDeDatosClientes x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(BaseDeDatosClientes x) {
		per.remove(x);
	}
	//  Operaciones publicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
	
}