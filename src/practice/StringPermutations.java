package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class StringPermutations {

	public static void main(String[] args) throws IOException {
		StringPermutations t = new StringPermutations();

		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			String s=st.sval;

			t.permutation(s);
			System.out.println("----------");
			t.permutation1(s);
			
		}
	}
	
	public int permutation(String s){
		if(s==null || s.isEmpty()){
			return 0;
		}
		if(s.length()==1){
			System.out.println(s);
			return 1;
		}
		int count=0;
		char[] array=s.toCharArray();
		Arrays.sort(array);
		do{
			count++;
			System.out.println(new String(array));
		}while(nextPermutation(array));
		
		return count;
	}
	
	public boolean nextPermutation(char[] s){
		int i=s.length-1, ii=0;
		
		for(;;){
			ii=i;
			i--;
			if(s[i]<s[ii]){
				int j=s.length-1;
				while(s[j]<=s[i]){
					j--;
				}
				char tmp=s[i];
				s[i]=s[j];
				s[j]=tmp;
				
				j=s.length-1;
				while(ii<j){
					tmp=s[ii];
					s[ii]=s[j];
					s[j]=tmp;
					ii++;
					j--;
				}
				return true;
			}
			
			if(i==0){
				return false;
			}
		}
	}

	public int permutation1(String s) {
		TreeSet<String> set = new TreeSet<String>();

		if (s != null && !s.isEmpty()) {
			char[] array=s.toCharArray();
			permutation1(set, array, 0);
		}

		for(String tmp:set){
			System.out.println(tmp);
		}
		return set.size();
	}

	public Set<String> permutation1(Set<String> set, char[] array, int start) {
		if (start >= array.length) {
			set.add(new String(array));
		}

		char tmp;
		for (int i = start; i < array.length; i++) {
			if(start!=i && array[start]==array[i]) continue;
			tmp = array[start];
			array[start] = array[i];
			array[i] = tmp;

			permutation1(set, array, start + 1);
			
			tmp = array[start];
			array[start] = array[i];
			array[i] = tmp;
		}
		return set;
	}

}
