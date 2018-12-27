// Assumptions: b must be >= 0
// Idea: use recursion to solve the problem

public class aToThePowerOfb {
	public long power(int a, int b) {
		if (a == 0) {
			return 0;
		}
		if (b == 0) {
			return 1;
		}
		long half = power(a, b / 2);
		return b % 2 == 0 ? half * half : half * half * a;
	}
}
// Time: O(n) since the recursion will be called O(n/2) times.
// Space: O(1)
