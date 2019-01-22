// Assumption: there can be duplicates in the array.
// Idea: we can apply the binary search to this problem since the binary search can narrow down the searching range quickly. 
// Since we need to find the last occurence, we need to return the right index first when we find the target, if not, return left index.
public class LastOccurence {
	public int lastOccurence(int[] array, int target) {
		// corner case check
		if (array == null || array.length == 0) {
			return -1;
		}
		// initial 2 pointers
		int left = 0;
		int right = array.length - 1;
		// use right - 1 because if left == right - 1, mid might == left, which will cause infinite loop.
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (array[right] == target) {
			return right;
		} else if (array[left] == target) {
			return left;
		}
		return -1;
	}
}

// Time: log(n) since the binary search takes logn time to locate the target.
// Space: O(1) since we do operations only in the original array.
