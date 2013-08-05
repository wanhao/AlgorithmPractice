package codinginterview;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));

		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;

			for (int i = 0; i < n; i++) {
				st.nextToken();
				double base=st.nval;
				st.nextToken();
				int exponent=(int)st.nval;
				
				try{
				System.out.println(power(base,exponent));
				}catch(Exception e){
					System.out.println("INF");
				}
			}
		}

	}

	public static double power(double base, int exponent) {
		if (base < 0.0000001 && base > -0.0000001 && exponent <= 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		int newExponent = exponent >= 0 ? exponent : -exponent;
//		double result = 1.0;
//		for (int i = 1; i <= newExponent; i++) {
//			result *= base;
//		}
		
		double result=powerWithUnsigned(base,newExponent);
		return exponent >= 0 ? result : 1.0 / result;
	}
	
	private static double powerWithUnsigned(double base, int exponent){
		if(exponent==0) return 1.0;
		
		double result=powerWithUnsigned(base, exponent>>>1);
		result*=result;
		if((exponent& 0x01) !=0){
			result*=base;
		}
		return result;
	}

}
