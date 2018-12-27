// Assumptions: the array A can contain negative numbers
// Idea: we can use recursion to solve this problem. We narrow down the searching range by comparing the value 
// of the target with the median value, and we keep doing so until the target is found.

public class ClassicalBinarySearch {
	public int classicalBinarySearch(int[] array, int target) {
		// corner cases
		if (array == null || array.length == 0) {
			return -1;
		}
		// narrow down the searching range by defining left and right bounds
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;	// +1 because mid has been searched, then left bound can now move 1 step further
			} else {
				right = mid - 1;  // -1 because mid has been searched, then right bound can now move 1 step further
			}
		}
		return -1;
	}
}

// Time: log(n). The whlie loop will be executed at most log(n) times, and each time only does comparison operation which is O(1) time, so totally O(log(n)).
// Space: O(1)
