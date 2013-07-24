package dp;

import java.util.Arrays;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
 * 
 * @author wanhao
 * 
 */
public class FlowerGarden {

	public static void main(String[] args) {
		
		// 0
		int[] height = new int[] { 5, 4, 3, 2, 1 };
		int[] bloom = new int[] { 1, 1, 1, 1, 1 };
		int[] wilt = new int[] { 365, 365, 365, 365, 365 };
		System.out.println("expect:{ 1,  2,  3,  4,  5 },result:"
				+ Arrays.toString(getOrdering(height, bloom, wilt)));

		// 1
		height = new int[] { 5, 4, 3, 2, 1 };
		bloom = new int[] { 1, 5, 10, 15, 20 };
		wilt = new int[] { 4, 9, 14, 19, 24 };
		System.out.println("expect:{ 5,  4,  3,  2,  1 },result:"
				+ Arrays.toString(getOrdering(height, bloom, wilt)));

		// 2
		height = new int[] { 5, 4, 3, 2, 1 };
		bloom = new int[] { 1, 5, 10, 15, 20 };
		wilt = new int[] { 5, 10, 15, 20, 25 };
		System.out.println("expect:{ 1,  2,  3,  4,  5 },result:"
				+ Arrays.toString(getOrdering(height, bloom, wilt)));

		// 3
		height = new int[] { 5, 4, 3, 2, 1 };
		bloom = new int[] { 1, 5, 10, 15, 20 };
		wilt = new int[] { 5, 10, 14, 20, 25 };
		System.out.println("expect:{ 3,  4,  5,  1,  2 },result:"
				+ Arrays.toString(getOrdering(height, bloom, wilt)));

		// 4
		height = new int[] { 1, 2, 3, 4, 5, 6 };
		bloom = new int[] { 1, 3, 1, 3, 1, 3 };
		wilt = new int[] { 2, 4, 2, 4, 2, 4 };
		System.out.println("expect:{ 2,  4,  6,  1,  3,  5 },result:"
				+ Arrays.toString(getOrdering(height, bloom, wilt)));

		// 5
		height = new int[] { 3, 2, 5, 4 };
		bloom = new int[] { 1, 2, 11, 10 };
		wilt = new int[] { 4, 3, 12, 13 };
		System.out.println("expect:{ 4,  5,  2,  3 },result:"
				+ Arrays.toString(getOrdering(height, bloom, wilt)));

	}

	public static int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
		int[] order = new int[height.length];
		for (int i = 0; i < order.length; i++) {
			order[i] = i;
		}
		quickSort(height,order,0,order.length-1);
		for(int tmp:order){
			System.out.print(height[tmp]+",");
		}
		System.out.println();

		for (int i = 1; i < order.length; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (height[order[i]] < height[order[j]]
						&& bloom[order[i]] <= wilt[order[j]]
						&& bloom[order[j]] <= wilt[order[i]]) {
					break;
				}
			}
			if (j == i)
				continue;

			int tmp = order[i];
			for (int k = i - 1; k >= j; k--) {
				order[k + 1] = order[k];
			}
			order[j] = tmp;
		}

		int[] result = new int[order.length];
		for (int i = 0; i < order.length; i++) {
			result[i] = height[order[i]];
		}

		return result;
	}
	
	public static void quickSort(int[] height, int[] order, int low, int high){
		if(low<high){
			int pivot=height[order[low]];
			int i=low;
			int j=high+1;
			for(;;){
				while(++i<=high && height[order[i]]>pivot);
				while(height[order[--j]]<pivot);
				if(i>=j) break;
				int tmp=order[i];
				order[i]=order[j];
				order[j]=tmp;
			}
			int tmp=order[low];
			order[low]=order[j];
			order[j]=tmp;
			
			quickSort(height,order,low, j-1);
			quickSort(height,order,j+1,high);
		}
	}
}
