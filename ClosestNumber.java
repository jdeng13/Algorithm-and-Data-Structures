// Assumptions: there can be duplicates in the array, and we can return any indices with the same value.
// Idea: we can apply the binary search to this problem to narrow down the searching range, since the array A has 
// already been sorted in ascending order, we can simply do a comparison for the smaller number with larger number.

public class ClosestNumber {
	public int closeNumber(int[] array, int target) {
		// corner case check
		if (array == null || array.length == 0) {
			return -1;
		}
		// initial 2 pointers
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
			return left;
		} else {
			return right;
		}
	}
}

// Time: logn. Since the searching process is binary search and it takes logn time.
// Space: O(1)
