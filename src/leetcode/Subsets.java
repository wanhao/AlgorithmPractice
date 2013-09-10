package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public static void main(String[] args) {
		Subsets t=new Subsets();
		int[] S=new int[]{1,2,3};
		System.out.println(t.subsets(S));
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		if(S!=null && S.length>0){
			Arrays.sort(S);
			subsets(result,S,0);
		}
		return result;
	}
	
	private void subsets(ArrayList<ArrayList<Integer>> result, int[] S, int pos){
		if(pos>=S.length){
			return;
		}
		int size=result.size();
		for(int i=0;i<size;i++){
			ArrayList<Integer> tmp=new ArrayList<Integer>();
			tmp.addAll(result.get(i));
			tmp.add(S[pos]);
			result.add(tmp);
		}
		subsets(result,S,pos+1);
	}
}
