package leetcode;

import java.util.ArrayList;

public class PascalsTriangle {

	public static void main(String[] args) {
		PascalsTriangle t=new PascalsTriangle();
		System.out.println(t.generate(5));
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		
		if(numRows<=0) return list;
		int[] row=new int[numRows];
		row[0]=1;
		for(int i=1;i<=numRows;i++){
			for(int j=i-1;j>=1;j--){
				row[j]+=row[j-1];
			}
			ArrayList<Integer> tmpList=new ArrayList<Integer>();
			for(int k=0;k<i;k++){
				tmpList.add(row[k]);
			}
			list.add(tmpList);
		}
		return list;
	}
}
