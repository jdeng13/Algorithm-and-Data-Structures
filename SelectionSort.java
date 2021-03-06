// Assumption: there are no duplicates in the array.
// Idea: we can select the minimum number each time when we loop through the entire array and swap the minimum number 
// to the left most position, then the final array after the swap process is the result.

import java.util.Arrays;

public class SelectionSort {
	public int[] selectionSort(int[] array) {
		// corner case check
		if (array == null || array.length <= 1) {
			return array;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
		return array;
	}
	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		SelectionSort solution = new SelectionSort();

		// test all possible cases
		int[] array = null;
		array = solution.selectionSort(array);

		array = new int[0];
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[] { 1, 2, 3, 4 };
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[] { 2, 4, 1, 5, 3 };
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
}

// Time Complexity Analysis:
// for (int i = 0; i < n - 1; i++) {		
// 	for (int j = i + 1; j < n; j++)
	
// iteration i = 0: inner      (0...n-1) = 4 (assume the length of the array is 5)
// iteration i = 1: inner n-1  (1...n-1) = 3
// iteration i = 2: inner n-2  (2...n-1) = 2
// iteration i = 3: inner n-3  (3...n-1) = 1
// 1+2+3+....+n = n(n+1)/2 --> n^2 --> O(n^2)
// Space: O(1)
