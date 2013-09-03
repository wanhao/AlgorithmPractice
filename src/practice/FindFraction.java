package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFraction {
	
	public static void main(String[] args){
		findFraction(5,10);
	}

	public static void findFraction(int m, int n) {
		if (m <= 0 || n < m)
			throw new IllegalArgumentException();
		
		ArrayList<String> irreducible=new ArrayList<String>();
		ArrayList<String> reducible=new ArrayList<String>();
		
		for(int a=0;a<=m;a++){			
			for(int b=m;b<=n;b++){
				if(findGreatestCommonDivisor(b,a)==1){
					irreducible.add(a+"/"+b);
				}else{
					reducible.add(a+"/"+b);
				}
			}
		}
		
		System.out.println(Arrays.toString(irreducible.toArray(new String[0])));
		System.out.println(Arrays.toString(reducible.toArray(new String[0])));
	}
	
	private static int findGreatestCommonDivisor(int x, int y){
		if(y==0) return x;
		return findGreatestCommonDivisor(y, x%y);
	}
}
