#include <stdio.h>
#define RENGLONES 2
#define COLUMNAS 3
int main() {
	int matriz [RENGLONES][COLUMNAS] =
	{
		{100, 200, 300}, //Primer renglon
	{400, 500, 600}, // Segundo Renglon 
	};
	printf("\nProporciona el numero de renglones: ");
	scanf ("%d");
	//printf("\nValor 1 [0][0] = %d", matriz[0][0]);
	//printf("\nValor 2 [0][1] = %d", matriz[0][1]);
	//printf("\nValor 3 [0][2] = %d", matriz[0][2]);
	//printf("\nValor 4 [1][0] = %d", matriz[1][0]);
	//printf("\nValor 5 [1][1] = %d", matriz[1][1]);
	//printf("\nValor 6 [1][2] = %d", matriz[1][2]);
	printf("-----Iteramos la matriz-----");
	for(int ren=0 ; ren < RENGLONES ; ren++){
		printf("\nrenglon (pivote): %d", ren);
		for(int col=0 ; col < COLUMNAS ; col++){
		printf("\nMatriz[%d][%d]=%d",ren,col,matriz[ren][col]);	
		}
		printf("\n");
	}
		
		
		
		
	return 0;
}

