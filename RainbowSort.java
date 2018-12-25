import java.util.Arrays;

public class RainbowSort {
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		// initiate the positions of the 3 pointers
		// 1. everything to the left of i, not including i, is red balls, which is -1
		// 2. everthing between i and j, not including j, is green balls, which is 0
		// 3. everything between j and k, not including k, needs to be sorted
		// 4. everything after k is blue balls, which is 1
		int i = 0;
		int j = 0;
		int k = array.length - 1;
		while (j <= k) {
			// we check the value at pointer j directly
			if (array[j] == -1) {
				swap(array, i, j);
				i++;
				j++;
			} else if (array[j] == 0) {
				j++;
			} else {
				swap(array, j, k);
				k--;
			}
		}
		return array;
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	public static void main(String[] args) {
		RainbowSort solution = new RainbowSort();

		int[] array = null;
		array = solution.rainbowSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[0];
		array = solution.rainbowSort(array);
		System.out.println(Arrays.toString(array));

		array = new int[] { 1, 0, -1, -1, 0, 1, 1, -1, 0 };
		array = solution.rainbowSort(array);
		System.out.println(Arrays.toString(array));
	}
}

//Time: O(n) since the only operation is camparison and pointer j and k will iterate through entire array.
//Space: O(1)
