package codinginterview;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10 {
	public static void main(String args[]) throws IOException {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		while(st.nextToken()!=StreamTokenizer.TT_EOF){
			int n=(int)st.nval;
			
			for(int i=0;i<n;i++){
				st.nextToken();
				System.out.println(numberOfOne((int)st.nval));
			}
		}
		
	}

	public static long numberOfOne(int n){
		int count=0;
		while(n!=0){
//			if((n&0x01) !=0) count++;
//			n=n>>>1;
			count++;
			n=n&(n-1);
		}
		return count;
	}

}
