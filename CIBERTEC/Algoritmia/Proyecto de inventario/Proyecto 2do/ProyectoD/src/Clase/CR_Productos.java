package Clase;

import javax.swing.JTextArea;

public class CR_Productos {
	private String Nombre; 
	private String Categoria; 
	private String CategoriaSub;
	
	
	public CR_Productos(String Nombre, String Categoria, String CategoriaSub) {
        this.Nombre = Nombre;
        this.Categoria = Categoria;
        this.CategoriaSub = CategoriaSub;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
    public String getCategoriaSub() {
        return CategoriaSub;
    }

    public void setCategoriaSub(String CategoriaSub) {
        this.CategoriaSub = CategoriaSub;
    }
    
    public void Imprime (JTextArea JTArea) {
    	JTArea.setText("");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("REGISTRO GUARDADO\n");
    	JTArea.append("---------------------------------------------\n");
    	JTArea.append("Nombre: 			" + Nombre + "\n");
    	JTArea.append("Categoria: 			" + Categoria + "\n");
    	JTArea.append("Sub-Categoria: 			" + CategoriaSub + "\n");
    }
}
