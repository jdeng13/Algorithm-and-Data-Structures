import java.util.Arrays;

public class Fibonacci {
	public long fibonacci(long k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		long[] array = new long[(int) (k + 1)];
		array[0] = 0;
		array[1] = 1;
		for (int i = 2; i <= k; i++) {
			array[i] = array[i - 2] + array[i - 1];
		}
		return array[k];
	}
	public static void main(String[] args) {
		Fibonacci solution = new Fibonacci();
		
		long k = 0;
		k = solution.fibonacci(k);
		System.out.println(array[k]);
	}
}

//Time: O(n) since the for loop takes O(n) time
//Space: O(n) since we create a new array with length k
