package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (array.length > 1 && leftIndex < rightIndex) {

			//chamadas recursivas para metades do array passado
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			
			merge(array, leftIndex, middleIndex, rightIndex);

		}

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

	}

}
