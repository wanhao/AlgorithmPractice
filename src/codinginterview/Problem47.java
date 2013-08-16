package codinginterview;

public class Problem47 {

	public static void main(String[] args) {
		System.out.println(add(2, 3) == 5);
		System.out.println(add(-1, 1) == 0);
		System.out.println(add(3, 0) == 3);
		System.out.println(add(2, -3) == -1);
		System.out.println();

		System.out.println(subtract(2, 3) == -1);
		System.out.println(subtract(-1, 1) == -2);
		System.out.println(subtract(3, 0) == 3);
		System.out.println(subtract(-2, -3) == 1);
		System.out.println();

		System.out.println(mutiply(2, 3) == 6);
		System.out.println(mutiply(0, 3) == 0);
		System.out.println(mutiply(-2, 3) == -6);
		System.out.println(mutiply(2, 3) == 6);
		System.out.println();

		System.out.println(divide(2, 3) == 0);
		System.out.println(divide(3, 3) == 1);
		System.out.println(divide(-2, 3) == 0);
		System.out.println(divide(3, 2) == 1);
		System.out.println();
	}

	public static int add(int m, int n) {
		int sum, carry;
		do {
			sum = m ^ n;
			carry = (m & n) << 1;

			m = sum;
			n = carry;
		} while (carry != 0);

		return sum;
	}

	public static int subtract(int m, int n) {
		int result = 0;
		do {
			result = m ^ n;
			n = (result & n) << 1;
			m = result;
		} while (n != 0);
		return result;
	}

	public static int mutiply(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int result = 0;
		while (n != 0) {
			if ((n & 1) != 0) {
				result = add(result, m);
			}
			n >>>= 1;
			m <<= 1;
		}

		return result;
	}
	
	public static int divide(int m, int n){
		if(n==0) throw new IllegalArgumentException();
		
		int result=0;
		while(m>=n){
			m=subtract(m,n);
			result=add(result,1);
		}
		
		return result;
	}

}
