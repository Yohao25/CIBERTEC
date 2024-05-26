package Clase;

import javax.swing.JTextArea;

public class CR_Proveedores {
	private String Nombre; 
	private String RSocial; 
	private String Ruc;
	private String Correo;
	private String Telefono;
	private String Direccion;
	
	public CR_Proveedores(String Nombre, String RSocial, String Ruc, String Correo, String Telefono, String Direccion) {
        this.Nombre = Nombre;
        this.RSocial = RSocial;
        this.Ruc = Ruc;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }
	 //---------------------------------------
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    //---------------------------------------
    public String getRSocial() {
        return RSocial;
    }

    public void setRSocial(String RSocial) {
        this.RSocial = RSocial;
    }
    //---------------------------------------
    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }
    //---------------------------------------
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    //---------------------------------------
    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    //---------------------------------------
    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    //---------------------------------------
    public void Imprime (JTextArea JTArea) {
    	JTArea.setText("");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("REGISTRO GUARDADO\n");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("Nombre: 			" + Nombre + "\n");
    	JTArea.append("RSocial: 			" + RSocial + "\n");
    	JTArea.append("Ruc: 			" + Ruc + "\n");
    	JTArea.append("Correo: 			" + Correo + "\n");
    	JTArea.append("Telefono: 			" + Telefono + "\n");
    	JTArea.append("Direccion: 			" + Direccion + "\n");
    }
}
