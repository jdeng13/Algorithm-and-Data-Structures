import java.util.Arrays;

public class MoveAllZerosToTheEnd {
	public int[] moveZeros(int[] array) {
		// corner case
		if (array == null || array.length == 0) {
			return array;
		}
		// initiate the positions of the pointer i and j
		int i = 0;
		int j = array.length - 1;		
		while (i <= j) {	// O(n)
			if (array[i] != 0) {
				i++;
			} else if (array[j] == 0) {
				j--;
			} else {
				swap(array, i, j);	// only swap i and j when i == 0 and j != 0
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
		MoveAllZerosToTheEnd solution = new MoveAllZerosToTheEnd();
		
		int[] array = null;
		array = solution.moveZeros(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		array = solution.moveZeros(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] { 1, 2, 3, 4, 0, 0, 0};
		array = solution.moveZeros(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] { 1, 0, 3, 0, 4, 9, 0};
		array = solution.moveZeros(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] { 0, 1, 2, 0, 3, 0, 4, 0, 0, 0};
		array = solution.moveZeros(array);
		System.out.println(Arrays.toString(array));
	}
}

// time: O(n) since the only operation here is comparison and swap
// space: O(1) since we didn't create any new object
