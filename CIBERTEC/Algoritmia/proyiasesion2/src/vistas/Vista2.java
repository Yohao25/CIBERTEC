package vistas;

public class Vista2 {

	public static void main(String[] args) {
		/// CALCULO DEL AREA Y PERIMETRO DE UN RECTANGULO
		
		//1. Declaración variables
		double base;
		double area;
		double altura;
		double perimetro;
		
		//2. Entrada de datos
		base=10;
		altura=5;		
		
		//3. Proceso
		area=base*altura;
		perimetro=2*(base+altura);
		
		//4. Salida de datos
		System.out.println("---------------------------------");
		System.out.println("AREA Y PERIMETRO DE UN RECTANGULO");
		System.out.println("---------------------------------");
		System.out.println("El área es                 :"+area);
		System.out.println("El perimetro es           :"+perimetro);
		System.out.println("---------------------------------");
		

	}

}
