package leetcode;

public class BestTimetoBuyandSellStockII {
	
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

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
