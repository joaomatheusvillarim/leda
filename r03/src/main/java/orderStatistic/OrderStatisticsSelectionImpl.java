package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o array original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * 
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {

		int index = getMenor(array);
		for (int i = 1; i < k; i++) {
			int aux = getMenorMaiorQueK(array, index);
			index = aux;
		}
		return array[index];

	}

	public int getMenor(T[] array) {
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[index].compareTo(array[i]) > 0) {
				index = i;
			}
		}
		return index;
	}

	public int getMenorMaiorQueK(T[] array, int k) {
		int indexMenor = k;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(array[k]) > 0) {
				if (array[i].compareTo(array[indexMenor]) < 0) {
					indexMenor = i;
				}
			}
		}
		return indexMenor;
	}


}
