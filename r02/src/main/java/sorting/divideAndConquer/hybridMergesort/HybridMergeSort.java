package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

import static util.Util.swap;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			if ((rightIndex - leftIndex) >= SIZE_LIMIT) {
				//merge sort
				int middleIndex = (leftIndex + rightIndex)/2;
				sort(array, leftIndex, middleIndex);
				sort(array, middleIndex + 1, rightIndex);
				merge(array, leftIndex, middleIndex, rightIndex);

			} else {
				//insertion sort
				insertionSort(array, leftIndex, rightIndex);

			}

		}

	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {

		for (int outerLoop = leftIndex; outerLoop <= rightIndex; outerLoop++) {
			
			int currentIndex = outerLoop;
			for (int innerLoop = outerLoop - 1; innerLoop >= 0; innerLoop--) {

				if (array[currentIndex].compareTo(array[innerLoop]) < 0) {
					swap(array, currentIndex, innerLoop);
					currentIndex--;

				} else break;

			}
		}

		INSERTIONSORT_APPLICATIONS++;

	}

	@SuppressWarnings("unchecked")
	private void merge(T[] array, int left, int middle, int right) {
		
		//copia do array passado
		T[] clone = (T[]) new Comparable[array.length];
		for (int i = left; i <= right; i++) {
			clone[i] = array[i];
		}

		int i = left, j = middle + 1, k = left;

		//comparacao entre metades
		while (i <= middle && j <= right) {
		
			if (clone[i].compareTo(clone[j]) <= 0) {
				array[k] = clone[i++];
			
			} else {
				array[k] = clone[j++];
			}
		
			k++;
		}

		//caso a segunda metade tenha sido completamente consumida
		while (i <= middle) {
			array[k++] = clone[i++];
		}

		//caso a primeira metade tenha sido completamente consumida
		while (j <= right) {
			array[k++] = clone[j++];
		}

		MERGESORT_APPLICATIONS++;

	}

	/**
	 * Returns how many times insertionSort was applied.
	 * @return InsertionSort applications
	*/
	public int getInsertionSortApplications() {
		return this.INSERTIONSORT_APPLICATIONS;
	}

	/**
	 * Returns how many times mergeSort was applied.
	 * @return MergeSort applications
	*/
	public int getMergeSortApplications() {
		return this.MERGESORT_APPLICATIONS;
	}

}
