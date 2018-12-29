public class FindTargetIn1DArray {
	public int[] findTargetIn1DArray(int[][] matrix, int target) {
		// corner case
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}
		// convert the 2D matrix to 1D array
		int rows = matrix.length;
		int columns = matrix[0].length;
		int left = 0;
		int right = rows * columns - 1;
		// apply the binary search to the 1D array
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int CorrespondingRow = mid / columns;
			int CorrespondingColumn = mid % columns;
			if (matrix[CorrespondingRow][CorrespondingColumn] == target) {
				return new int[] { CorrespondingRow, CorrespondingColumn };
			} else if (matrix[CorrespondingRow][CorrespondingColumn] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[] { -1, -1 };
	}
}
// Time: O(log(n*m)). O(logn) to locate the row number, O(logm) to locate the column number.
// Space: O(1) for result array, O(n*m) for N * M matrix, so totally O(nm)
