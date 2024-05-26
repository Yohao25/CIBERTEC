package Clase;

import javax.swing.JTextArea;

public class CR_Clientes {

	private String Nombre; 
	private String Apellido; 
	private String Telefono; 
	private String Direccion; 
	private String Correo; 
	
    public CR_Clientes(String Nombre, String Apellido, String Telefono, String Direccion, String Correo) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    public void Imprime (JTextArea JTArea) {
    	JTArea.setText("");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("REGISTRO GUARDADO\n");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("Nombre: 			" + Nombre + "\n");
    	JTArea.append("Apellido: 			" + Apellido + "\n");
    	JTArea.append("Telefono: 			" + Telefono + "\n");
    	JTArea.append("Direccion: 			" + Direccion + "\n");
    	JTArea.append("Correo: 			" + Correo + "\n");
    }   
    
}
