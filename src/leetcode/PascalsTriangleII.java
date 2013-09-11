package leetcode;

import java.util.ArrayList;

public class PascalsTriangleII {

	public static void main(String[] args) {
		PascalsTriangleII t=new PascalsTriangleII();
		System.out.println(t.getRow(5));
	}

	public ArrayList<Integer> getRow(int rowIndex) {		
		if(rowIndex<0) return new ArrayList<Integer>();
		
		int[] row=new int[rowIndex+1];
		row[0]=1;
		for(int i=1;i<=rowIndex+1;i++){
			for(int j=i-1;j>=1;j--){
				row[j]+=row[j-1];
			}
		}
		ArrayList<Integer> tmpList=new ArrayList<Integer>();
		for(int k=0;k<rowIndex+1;k++){
			tmpList.add(row[k]);
		}
		return tmpList;
	}
}
