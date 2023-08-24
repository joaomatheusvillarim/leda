package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import static util.Util.swap;


public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {
			
			int menor = leftIndex;

			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				
				if (array[menor].compareTo(array[i]) > 0) {
					menor = i;
				}
				
			}
			swap(array, menor, leftIndex);

			sort(array, leftIndex+1, rightIndex);
			
		}

	}

}
