package codinginterview;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem9 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken()!=StreamTokenizer.TT_EOF){
			int n=(int)st.nval;
			System.out.println(fibonacci(n));
		}
		
	}

	public static long fibonacci(int n){
		if(n<=0) return 0;
		if(n==1) return 1;
		long a=0,b=1;
		long result=0;
		for(int i=2;i<=n;i++){
			result=a+b;
			a=b;
			b=result;
		}
		return result;
	}

}
