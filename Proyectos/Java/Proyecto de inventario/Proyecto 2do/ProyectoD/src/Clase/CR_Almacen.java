package Clase;

import javax.swing.JTextArea;

public class CR_Almacen {
	private String Nombre; 
	private String Direccion; 
	private String Telefono; 
	private String Correo; 
	
    public CR_Almacen(String Nombre, String Direccion, String Telefono, String Correo) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }
    
	 //---------------------------------------
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    //---------------------------------------
    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    //---------------------------------------
    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    //---------------------------------------
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    //---------------------------------------
    public void Imprime (JTextArea JTArea) {
    	JTArea.setText("");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("REGISTRO GUARDADO\n");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("Nombre: 			" + Nombre + "\n");
    	JTArea.append("Direccion: 			" + Direccion + "\n");
    	JTArea.append("Telefono: 			" + Telefono + "\n");
    	JTArea.append("Correo: 			" + Correo + "\n");
    }   
}
