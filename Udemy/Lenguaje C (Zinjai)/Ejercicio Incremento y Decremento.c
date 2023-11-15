#include <stdio.h>

int main(){
	// Imprimimos los primeros 10 numeros de 3 en 3 
	int maximo = 10;
	printf("Incrementos de 3 en 3: \n");
    for (int numero = 1; numero <= maximo; numero += 3){
		printf("\n%d \n", numero);

    }
	printf("\nDecremento de 3 en 3: \n");
	for (int numero = -1; numero >= -maximo; numero -= 3){
		printf("\n%d \n", numero);
	}
	
	
	
	return 0;
}

