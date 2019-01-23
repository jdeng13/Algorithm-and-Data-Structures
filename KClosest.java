package algorithm;

//Assumptions: the array can contain duplicate numbers, K > 0, and K < array.length
//Idea: first, we locate the left pointer to the position where it’s the largest smaller or equal number to the target, then we set up the right pointer that is 1 more index than left pointer. Now, there are 2 possible situations here: first, the right pointer can be out of bound, in this situation, the K closest numbers are K numbers to the left of the left pointer; second, the left and right pointers are not out of bound, we compare which pointer is closer to the target each time (use for loop to achieve this), then we can finally get all the numbers that are closest to the target.

public class KClosest {
	public int[] kClosest(int[] array, int target, int k) {
		// corner case check
		if (array == null || array.length == 0) {
			return array;
		}
		// initial 2 pointers, left pointer is the largest smaller or equal number to the target, this way we can locate the target using these 2 pointers.
		int left = LargestSmallerOrEqual(array, target);
		int right = left + 1;
		// initial an array to store the result
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			// 2 cases
			// 1. right pointer is out of bound
			// 2. left and right pointers are both in the bound, but left one is closer to the target
			if (right >= array.length || left >= 0 && (target - array[left] <= array[right] - target)) {
				result[i] = array[left--];
			} else {
				result[i] = array[right++];
			}
		}
		return result;
	}
	private int LargestSmallerOrEqual(int[] array, int target) {
		// corner case check
		if (array == null || array.length == 0) {
			return -1;
		}
		// initial 2 pointers to locate the target
		int left = 0;
		int right = array.length - 1;
		// use right - 1 here because if left == right - 1, the mid might == left, which will cause infinite loop.
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
		if (array[right] <= target) {   // because if the right number is smaller than target, left number must be smaller too, so check the right first.
			return right;
		}
		if (array[left] <= target) {
			return left;
		}
		if (array[left] == target) {
			return left;
		} else if (array[right] == target) {
			return right;
		}
		// if there is no such number
		return -1;
	}
}

//Time: O(log(n) + k). Since the binary search will take log(n) time, and there are k comparisons
//Space: O(n). worst case can have n elements in the result array
