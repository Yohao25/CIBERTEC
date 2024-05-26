package modelo;

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

import javax.swing.JOptionPane;

public class ConsultarProducto {
	
	//  Atributo privado
	private ArrayList <BaseDeDatosProductos> pas;
	
	private String nombreArchivo = "D:\\productos.txt";
	
	private DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	//  Constructor
    public ConsultarProducto() {
    	pas = new ArrayList <BaseDeDatosProductos> ();
		
		cargarProductos();
    }
    
    private void cargarProductos() {
    	File file = new File(nombreArchivo);
		
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			
			String linea;
			
			while ((linea = bufferedReader.readLine()) != null) {
				/*linea.split(";");*/
				int codigo = Integer.parseInt(linea);
				String nombre = bufferedReader.readLine();
				String modelo = bufferedReader.readLine();
				double precio = Double.parseDouble(bufferedReader.readLine());
				int stock = Integer.parseInt(bufferedReader.readLine());
				
				BaseDeDatosProductos nuevoProducto = new BaseDeDatosProductos(codigo, nombre, modelo, precio, stock);
				
				pas.add(nuevoProducto);
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
		}
    }
    
	//  Operaciones públicas básicas
	public void adicionarProducto(BaseDeDatosProductos x) {
		pas.add(x);
		adicionarProductoArchivo(x);
	}
	
	private void adicionarProductoArchivo(BaseDeDatosProductos x) {
		try {
			FileWriter fileWriter = new FileWriter(nombreArchivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(String.valueOf(x.getCodigo()));
			bufferedWriter.newLine();
			bufferedWriter.write(x.getNombre());
			bufferedWriter.newLine();
			bufferedWriter.write(x.getModelo());
			bufferedWriter.newLine();
			bufferedWriter.write(decimalFormat.format(x.getPrecio()));
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(x.getstock()));
			bufferedWriter.newLine();
			
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int tamaño() {
		if (pas != null) {
	        return pas.size();
	    } else {
	        return 0; // valor predeterminado
	    }
	}
	public BaseDeDatosProductos obtener(int i) {
		  if (pas != null && i >= 0 && i < pas.size()) {
		        return pas.get(i);
		    } else {
		        return null;
		    }
	}
	public BaseDeDatosProductos buscar(int codigo) {
		BaseDeDatosProductos x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	public BaseDeDatosProductos buscar(String Modelo) {
		BaseDeDatosProductos x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getModelo().equals(Modelo))
				return x;
		}
		return null;
	}
	public void eliminar(BaseDeDatosProductos x) {
		pas.remove(x);
	}
	//  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
	public String[] obtenerModelos() {
        String[] modelos = new String[pas.size()];
        for (int i = 0; i < pas.size(); i++) {
            modelos[i] = pas.get(i).getModelo();
        }
        return modelos;
    }
	
	public BaseDeDatosProductos obtenerProductoPorModelo(String modeloSeleccionado) {
        for (BaseDeDatosProductos producto : pas) {
            if (producto.getModelo().equals(modeloSeleccionado)) {
                return producto;
            }
        }
        return null; 
    }
	public void registrarNuevoProducto() {
	    // Solicitar al usuario los detalles del nuevo producto
	    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
	    String modelo = JOptionPane.showInputDialog("Ingrese el modelo del producto:");
	    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
	    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));

	    // Generar un código de producto correlativo
	    int codigo = codigoCorrelativo();

	    // Crear un nuevo producto con los detalles proporcionados
		BaseDeDatosProductos nuevoProducto = new BaseDeDatosProductos(codigo, nombre, modelo, precio, stock);

	    // Agregar el nuevo producto a la lista de productos
	    adicionarProducto(nuevoProducto);

	    // Mostrar un mensaje de confirmación
	    JOptionPane.showMessageDialog(null, "Producto registrado exitosamente.");
	}

}