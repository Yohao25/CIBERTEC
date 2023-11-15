#include <stdio.h>
#define RENGLONES 2
#define COLUMNAS 3

int main() {
	// Definir constantes tamanio matriz
	//const int RENGLONES = 2;
	//const int COLUMNAS = 3;
	//Definimos la matriz
	//int matriz[RENGLONES][COLUMNAS] = {100, 200, 300, 400, 500, 600};
	int matriz [RENGLONES][COLUMNAS] =
		{
		{100, 200, 300}, //Primer renglon
	    {400, 500, 600}, // Segundo Renglon 
	};
	// Llenamos la matriz manualmente

	// Accedemos a los valores
	printf("\nValor 1 [0][0] = %d", matriz[0][0]);
	printf("\nValor 2 [0][1] = %d", matriz[0][1]);
	printf("\nValor 3 [0][2] = %d", matriz[0][2]);
	printf("\nValor 4 [1][0] = %d", matriz[1][0]);
	printf("\nValor 5 [1][1] = %d", matriz[1][1]);
	printf("\nValor 6 [1][2] = %d", matriz[1][2]);
	return 0;
}

