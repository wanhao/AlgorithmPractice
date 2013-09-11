package leetcode;

public class BestTimetoBuyandSellStockIII {
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockIII t=new BestTimetoBuyandSellStockIII();
		
		int[] prices=new int[]{3,2,6,5,0,3};
		System.out.println(t.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length<=0) return 0;
		
		int[] min=new int[prices.length];
		min[0]=prices[0];
		int[] f=new int[prices.length];
		f[0]=0;
		
		for(int i=1;i<prices.length;i++){
			min[i]=Math.min(prices[i],min[i-1]);
			
			if(prices[i]-min[i-1] >0){
				f[i]=prices[i]-min[i-1];
			}
		}
		
		min[prices.length-1]=prices[prices.length-1];
		int[] g=new int[prices.length];
		g[prices.length-1]=0;
		
		for(int i=prices.length-2;i>=0;i--){
			g[i]=Math.max(g[i+1],min[i+1]-prices[i]);
			min[i]=Math.max(prices[i],min[i+1]);
		}
		
		int maxProfit=0;
		for(int i=-1;i<prices.length;i++){
			int profit=0;
			if(i>=0){
				profit+=f[i];
			}
			if(i+1<prices.length){
				profit+=g[i+1];
			}
			if(profit>maxProfit){
				maxProfit=profit;
			}
		}
		
		return maxProfit;
	}
}
