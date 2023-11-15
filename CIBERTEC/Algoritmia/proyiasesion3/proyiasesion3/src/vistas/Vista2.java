package vistas;

import java.util.Scanner;

public class Vista2 {

	public static void main(String[] args) {
		// Declaración de variables
		//MONTO DONACION PARA CADA AREA
		double monto,censal,posmed,escuela,comedor,asianc;
		
		
		//Entrada de Datos
		System.out.print("Ingrese el monto de donacion: ");
		Scanner sc = new Scanner(System.in);
		monto=sc.nextDouble();
		
	
		//Proceso
		censal=0.25*monto;
		escuela=0.35*monto;
		comedor=0.28*(escuela+censal);
		posmed=0.4*comedor;
		asianc=monto-(censal+escuela+comedor+posmed);
		
		//Salida
		System.out.println("--------------------------------------------");
		System.out.println("MONTO DE DONACION PARA CADA ÁREA");
		System.out.println("--------------------------------------------");
		System.out.println("Centro de Salud........: "+censal);
		System.out.println("Posta médica...........: "+posmed);
		System.out.println("Escuela................: "+escuela);
		System.out.println("Comedor................: "+comedor);
		System.out.println("Asilo para ancianos....: "+asianc);
		System.out.println("--------------------------------------------");
	
	}


}
