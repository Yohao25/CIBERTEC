package Clase;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Compartido {

private String Nombre;
	
	public Compartido(String Nombre) {
		this.Nombre = Nombre;
	}
	
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
	
    public void Imprime_Borrar (JTextArea JTArea) {
    	JTArea.setText("");
    }
    
    public void Borrar (JTextField JText) {
    	JText.setText("");
    }
    
    public void BorrarSPinner (JSpinner JText) {
    	JText.setValue(0);
    }
    
    public void BorrarCombo (JComboBox<?> Combo,String Indice) {
    	Combo.setSelectedItem(Indice);
    }
    
    public void HabilitaTexto (JTextField JText,Boolean Activo) {
    	JText.setEnabled(Activo);
    }

    public void HabilitaCombo (JComboBox<?> JText,Boolean Activo) {
    	JText.setEnabled(Activo);
    }
    
    public void HabilitaSpinner (JSpinner JText,Boolean Activo) {
    	JText.setEnabled(Activo);
    }
    
    public void HabilitaButton (JButton Boton,Boolean Activo) {
    	Boton.setEnabled(Activo);
    }
    
    public void HabilitaBotones_Nuevo(JButton Nuevo,JButton Grabar,JButton Cancelar,JButton Salir) {
    	Nuevo.setEnabled(false);	
    	Grabar.setEnabled(true);	
    	Cancelar.setEnabled(true);	
    	Salir.setEnabled(false);	
    }
    
    public void HabilitaBotones_Cancelar(JButton Nuevo,JButton Grabar,JButton Cancelar,JButton Salir) {
    	Nuevo.setEnabled(true);	
    	Grabar.setEnabled(false);	
    	Cancelar.setEnabled(false);	
    	Salir.setEnabled(true);	
    }
    
	public static Double FormatDecimales(Double Num, Integer Decimal) {
		return Math.round(Num * Math.pow(10, Decimal)) / Math.pow(10, Decimal);
	}
}
