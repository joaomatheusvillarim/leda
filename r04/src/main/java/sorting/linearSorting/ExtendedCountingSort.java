package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {
			
			//encontrar o k (maior) e j (menor)
			int k = array[leftIndex], j = array[leftIndex];
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i] > k) {
					k = array[i];
				} else if (array[i] < j) {
					j = array[i];
				}
			}
			
			//construir o array de frequências
			int[] frequencies = new int[k - j + 1];
			for (int i = leftIndex; i <= rightIndex; i++) {
				++frequencies[array[i] - j];
			}
			
			//somas cumulativas no array de frequências
			for (int i = 1; i < frequencies.length; i++) {
				frequencies[i] += frequencies[i-1];
			}
			
			//construir o array resultante
			Integer[] result = new Integer[rightIndex - leftIndex + 1];
			for (int i = rightIndex; i >= leftIndex; i--) {
				result[frequencies[array[i] - j] - 1] = array[i];
				--frequencies[array[i] - j];
			}
			
			//integrar o resultado ao array no intervalo [leftIndex, rightIndex]
			for (int i = 0; i < result.length; i++) {
				array[i + leftIndex] = result[i];
			}
			
		}
	}

}
