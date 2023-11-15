#include <stdio.h>

int main() {
	int numero = 1, minimo = 0, maximo = 5, acumuladorSuma = 0;
	do{
		printf("(acumuladorSuma + numero) -> %d + %d\n", acumuladorSuma, numero);
		acumuladorSuma += numero;
		printf("Suma parcial acumulada: %d\n\n", acumuladorSuma);
		numero++;
	}while (numero <= maximo);
	printf("\nLa suma de los primeros 5 numeros: %d", acumuladorSuma);
	return 0;
}

