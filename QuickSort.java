import java.util.Arrays;

	public class QuickSort {
	public int[] quickSort(int[] array) {
		// corner case check
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		// first step: define the position of the pivot
		int pivotPos = partition(array, left, right); 	// O(nlogn)
		quickSort(array, left, pivotPos - 1);		// O(1/2 nlogn)
		quickSort(array, pivotPos + 1, right);		// O(1/2 nlogn)
	}
	private int partition(int[] array, int left, int right) {	// O(nlogn)
		int pivotIndex = randomSelection(left, right);	// O(1)
		int pivot = array[pivotIndex];
		// swap the pivot to the rightmost position first
		swap(array, pivotIndex, right);			// O(1)
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {		// O(nlogn) since there are logn levels, and each level do O(1) comparison
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		// swap the pivot back to the position it should be
		swap(array, leftBound, right);
		return leftBound;
	}
	private int randomSelection(int left, int right) {	// O(1)
		return left + (int)(Math.random() * (right - left + 1));
	}
	private void swap(int[] array, int left, int right) {	// O(1)
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	// test cases
	public static void main(String[] args) {
		QuickSort solution = new QuickSort();

		int[] array = null;
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[0];
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[] {1, 2, 3, 4, 5};
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[] {5, 4, 3, 2, 1};
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[] {3, 4, 7, 9, 0, 6, 1};
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
// Time: average O(nlogn), worst case O(n^2) (if the pivot is chosen to be at the rightmost position)
// Space: O(n)
