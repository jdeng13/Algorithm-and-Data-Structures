public class Fibonacci_DPO1 {
	public long fibonacci(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		long m = 0;
		long n = 1;
		while (k > 1) {
			long temp = m + n;
			m = n;
			n = temp;
			k--;
		}
		return n;
	}
}
