package vistas;
import java.util.Scanner;

public class Vista3 {

	public static void main(String[] args) {
		///CALCULO DEL AREA Y PERIMETRO DE UN RECTANGULO
		//1. Declaración variables
		double are,vol,rad,alt;
		String usuario;
		String apellido;
		int edad;
		//2. Entrada de datos
		System.out.print("Ingrese nombre de usuario: ");
		Scanner sc=new Scanner(System.in);
		usuario=sc.nextLine();
		
		System.out.print("Ingrese su apellido: ");
		Scanner sc1=new Scanner(System.in);
		apellido=sc1.nextLine();
		
		System.out.printf("Ingrese su edad: ");
		Scanner sc2=new Scanner(System.in);
		edad=sc2.nextInt();
		
		alt=5;
		rad=10;
		//3. Proceso
		vol=3.14*rad*rad*alt;
		are=2*3.14*rad*(rad+alt);
		//4. Salida de datos
		System.out.println("------------------------------------------");
		System.out.println("EL AREA Y VOLUMEN DE UN CILINDRO");
		System.out.println("------------------------------------------");
		System.out.println("El area del cilindro es :"+are);
		System.out.println("El volumen del cilindro es :"+vol);
		System.out.println("------------------------------------------");
        System.out.println("Usuario: "+usuario);
        System.out.println("Apellido: "+apellido);
        System.out.println("Edad: "+edad);
		
	}

}
