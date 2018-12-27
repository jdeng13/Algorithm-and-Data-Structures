// Assumption: the matrix is not null, and has size N * M where N >= 0 and M >= 0.

public class FindTargetIn2DMatrix {
	public int[] findTarget(int[][] matrix, int target) {
		int[] result = new int[] { -1, -1 };
		// corner case
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		// locate the row index of the target
		int rowIndex = targetRowIndex(matrix, 0, matrix.length - 1, target);
		if (rowIndex == -1) {
			return result;
		}
		// locate the column index of the target
		int columnIndex = targetColumnIndex(matrix[rowIndex], 0, matrix[rowIndex].length - 1, target);
		if (columnIndex == -1) {
			return result;
		}
		result[0] = rowIndex;
		result[1] = columnIndex;
		return result;
	}
	private int targetRowIndex(int[][] matrix, int up, int down, int target) {		// O(logn)
		while (up <= down) {
			int mid = up + (down - up) / 2;
			if (matrix[mid][0] < target) {
				up = mid + 1;
			} else {
				down = mid - 1;
			}
		}
		return down;	// finally up will equal to down, so return down
	}
	// since we have known the index of the row, then it becomes a binary search in 1D array problem, 
	// we can apply the classical binary search to it.
	private int targetColumnIndex(int[] array, int left, int right, int target) {	// O(logm)
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}

// Time: if n rows, m columns, that will be log(n) for rows locating, log(m) for column locating, so totally log(n*m)
// Space: O(1) for result array, O(n*m) for matrix, so totally O(n*m)
