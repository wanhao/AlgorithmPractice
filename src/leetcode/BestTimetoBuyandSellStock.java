package leetcode;

public class BestTimetoBuyandSellStock {
	
	
	
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length<=0) return 0;
		
		int[] min=new int[prices.length];
		min[0]=prices[0];
		
		int maxProfit=0;
		for(int i=1;i<prices.length;i++){
			min[i]=Math.min(prices[i],min[i-1]);
			
			if(prices[i]-min[i-1] >maxProfit){
				maxProfit=prices[i]-min[i-1];
			}
		}
		return maxProfit;
	}
}
