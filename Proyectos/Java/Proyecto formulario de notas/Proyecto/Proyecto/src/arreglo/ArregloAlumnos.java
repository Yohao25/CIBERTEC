package arreglo;

import java.util.ArrayList;

import clases.Alumno;

public class ArregloAlumnos {
	
	//Atributo de tipo ArrayLIst de la clase ArregloAlumnos
	private ArrayList<Alumno> alu;
	
	public ArregloAlumnos(){
		alu = new ArrayList<Alumno>();
		alu.add(new Alumno(123, "Juan Castro", 15, 13));
		alu.add(new Alumno(456, "Ana Mendoza", 18, 17));
		alu.add(new Alumno(789, "Carlos Azabache", 14, 16));
		alu.add(new Alumno(147, "Ricardo Iglesias", 13, 15));
	}
	//public ArregloAlumnos(int codigo, String nombre, int nota1, int nota2)
	
	public void agregar(Alumno alumno) {
		alu.add(alumno);
	}
	
	
	
	//M�todos personalizados
	public int tamaño(){
		return alu.size();
	}
	
	public Alumno obtener(int i){
		return alu.get(i);
	}
	
	public double promedioGeneral(){
		double suma  = 0.0;
		for(int i =0;i<tamaño();i++)
			suma+=obtener(i).promedio();
		return suma/tamaño();
	}
	
}
