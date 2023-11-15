package vistas;

import java.util.Scanner;

public class Vista1 {

	public static void main(String[] args) {
		// Declaración de variables
		//CALCULAR EL AREA LATERAL, AREA TOTAL Y AREA DE LA BASE
		double rad, alt, al, at, ab;
		
		
		//Entrada de Datos
		System.out.print("Ingrese radio: ");
		Scanner sc = new Scanner(System.in);
		rad=sc.nextDouble();
		
		System.out.print("Ingrese altura: ");
		Scanner sc1 = new Scanner(System.in);
		alt=sc1.nextDouble();
		//Proceso
		al=2*3.1416*rad*alt;
		ab=3.1416*rad*rad;
		at=2*ab+al;
		
		//Salida
		System.out.println("--------------------------------------------");
		System.out.println("ÁREA LATERAL, ÁREA TOTAL Y ÁREA DE LA BASE");
		System.out.println("--------------------------------------------");
		System.out.println("El área lateral es........: "+al);
		System.out.println("El área de la base es.....: "+ab);
		System.out.println("El área total es..........: "+at);
		System.out.println("--------------------------------------------");
	
	}

}
