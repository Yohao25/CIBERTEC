#include <stdio.h>

int main() {
	// Sumar los primeros 5 numeros
	int minimo = 0, maximo = 5, acumuladorSuma = 0;
	for (int numero = 1; numero <= maximo; numero++){
		// Imprimimos la expresion a ejecutar
		printf("(acumuladorSuma + numero) -> %d + %d\n", acumuladorSuma, numero);
		
		// Realizamos la suma acumulativa
		acumuladorSuma += numero;
		
		// Se imprime el resultado de la suma acuulativa parcial
		printf("Suma parcial acumulada: %d\n\n", acumuladorSuma);
	}
	printf("\nLa suma de los primeros 5 numeros: %d", acumuladorSuma);
	return 0;
}

