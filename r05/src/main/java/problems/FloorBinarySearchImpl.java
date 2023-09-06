package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		if (array.length > 0 && array != null) {

			quickSort(array, 0, array.length - 1);
			return recursiveFloor(array, x, null, 0, array.length - 1);

		}

		return null;
		
	}
	
	private Integer recursiveFloor(Integer[] array, Integer x, Integer floor, int leftIndex, int rightIndex) {

		if(leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int middle = (rightIndex + leftIndex) / 2;

			if(array[middle].compareTo(x) > 0) {
				return recursiveFloor(array, x, floor, leftIndex, middle -1 );
			}

			if(array[middle].compareTo(x) < 0) {
				return recursiveFloor(array, x, array[middle], middle + 1, rightIndex);
			}

			return array[middle];

		}

		return floor;

	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			
			int pivotIndex = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, rightIndex);
			
		}
			
	}

	private int partition (Integer [] array, int left, int right) {
		
		int middle = (left + right) / 2;
		averageOfThree(array,left,middle,right);
		Integer pivot = array[middle];
		Util.swap(array, middle, right-1);
		int pivotIndex = right - 1;
		
		for (int j = pivotIndex-1; j > left; j--) {

			if(pivot.compareTo(array[j]) < 0) {
				pivotIndex--;
				Util.swap(array, pivotIndex, j);
			}

		}

		Util.swap(array, right-1, pivotIndex);
		return pivotIndex;
	}
	
	private void averageOfThree(Integer[] array, int leftIndex, int middle, int rightIndex) {

		if(array[leftIndex].compareTo(array[middle]) > 0) {
			Util.swap(array, leftIndex, middle);
		}

		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}

		if(array[middle].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, middle, rightIndex);
		}
	}

}
