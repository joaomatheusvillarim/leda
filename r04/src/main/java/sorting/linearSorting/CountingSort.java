package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {

			//encontrar o k
			int k = array[leftIndex];
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i] > k) {
					k = array[i];
				}
			}

			//construir o array de frequências
			int[] frequencies = new int[k + 1];
			for (int i = leftIndex; i <= rightIndex; i++) {
				++frequencies[array[i]];
			}

			//somas cumulativas no array de frequências
			for (int i = 1; i < frequencies.length; i++) {
				frequencies[i] += frequencies[i-1];
			}

			//construir o array resultante
			Integer[] result = new Integer[rightIndex - leftIndex + 1];
			for (int i = rightIndex; i >= leftIndex; i--) {
				result[frequencies[array[i]] - 1] = array[i];
				--frequencies[array[i]];
			}

			//integrar o resultado ao array no intervalo [leftIndex, rightIndex]
			for (int i = 0; i < result.length; i++) {
				array[i + leftIndex] = result[i];
			}

		}

	}

}
