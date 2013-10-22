package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		int[] num=new int[]{0, 0, 0,0,0,-2,1,1};
		ThreeSum t=new ThreeSum();
		
		System.out.println(t.threeSum(num));
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < num.length; i++) {
			int total = -num[i];
			int low = i + 1, high = num.length - 1, sum;
			while (low < high) {
				sum = num[low] + num[high];
				if (sum == total) {
					ArrayList<Integer> tmpList=new ArrayList<Integer>();
					tmpList.add(num[i]);
					tmpList.add(num[low]);
					tmpList.add(num[high]);

					if (result.size() == 0
							|| !listEquals(result.get(result.size() - 1),tmpList)) {
						result.add(tmpList);
					}

					low++;
					high--;
				} else if (sum < total) {
					low++;
				} else {
					high--;
				}
			}
		}
		
		return result;
	}
	
	private boolean listEquals(ArrayList<Integer> list1, ArrayList<Integer> list2){
		for(int i=0;i<list1.size();i++){
			if(list1.get(i)!=list2.get(i))return false;
		}
		return true;
	}
}
