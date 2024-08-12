package sorting.divideAndConquer;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array.length > 1 && leftIndex < rightIndex) {

			int pivotIndex = partition(array, leftIndex, rightIndex);

			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);

		}

	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		//o pivot é o primeiro elemento e iniciamos resp como seu index
		T pivot = array[leftIndex];
		int resp = leftIndex;

		for (int j = resp + 1; j <= rightIndex; j++) {

			//a cada elemento menor que o pivot, o trocamos para o começo
			//do intervalo e incrementamos resp
			if (array[j].compareTo(pivot) <= 0) {
				resp++;
				swap(array, resp, j);

			}
		}
		//por fim trocamos o pivot com o elemento na posição resp
		swap(array, leftIndex, resp);

		return resp;

	}

}
