package leetcode;

import java.util.ArrayList;

public class BestTimetoBuyandSellStockII {
	
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		ArrayList<Integer> tmpList=new ArrayList<Integer>();
		tmpList.add(prices[0]);
		for(int i=1;i<prices.length;i++){
			if(prices[i]!=prices[i-1]){
				tmpList.add(prices[i]);
			}
		}
		prices=new int[tmpList.size()];
		for(int i=0;i<tmpList.size();i++){
			prices[i]=tmpList.get(i);
		}
		
		int[] min = new int[prices.length];
		for(int i=0;i<prices.length;i++){
			min[i]=prices[i];
		}
		
		int max=0;
		int[] maxProfit = new int[prices.length+1];
		maxProfit[0] = 0;
		maxProfit[1] = 0;

		for (int i = 2; i <= prices.length; i++) {
			for (int j = 0; j <= i - 2; j++) {
				if (prices[i-1] > min[j]) {
					maxProfit[i] = Math.max(maxProfit[i], maxProfit[j]
							+ (prices[i-1] - min[j]));
				}
				if(prices[i-1]<min[j]){					
					min[j] = prices[i-1];
				}
			}
			if(maxProfit[i]>max){
				max=maxProfit[i];
			}
		}

		return max;
	}
}
