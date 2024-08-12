package sorting.divideAndConquer.quicksort3;

import static util.Util.swap;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (array.length > 1 && leftIndex < rightIndex) {

			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);

		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		int pivotIndex = getPivotIndex(array, leftIndex, rightIndex);
		swap(array, leftIndex, pivotIndex);

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

	private int getPivotIndex(T[] array, int leftIndex, int rightIndex) {

		int centerIndex = (leftIndex + rightIndex) / 2;
		int resp = centerIndex;
		
		boolean p = array[leftIndex].compareTo(array[centerIndex]) <= 0;
		boolean q = array[leftIndex].compareTo(array[rightIndex]) <= 0;
		boolean r = array[centerIndex].compareTo(array[rightIndex]) <= 0;

		if ((p && ! r && q) || (! p && r && ! q)) {
			resp = rightIndex;

		} else if ((! p && r && q) || (p && ! r && ! q)) {
			resp = leftIndex;
		
		}

		return resp;

	}

}
