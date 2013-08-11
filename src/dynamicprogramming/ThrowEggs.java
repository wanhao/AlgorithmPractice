package dynamicprogramming;

public class ThrowEggs {

	public static void main(String[] args) {
		System.out.println(minTryTimes(100, 2)==14);
		System.out.println(minTryTimes(300, 3)==13);
		
		System.out.println(minTryTimes(1000, 4)==13);
	}

	public static int minTryTimes(int height, int eggs) {
		if (height < 1 || eggs < 1)
			return -1;

		int[][] data = new int[height + 1][eggs + 1];
		for(int i=0;i<=eggs;i++){
			data[0][i]=0;
			data[1][i]=0;
		}
		for(int i=1;i<=height;i++){
			data[i][1]=i-1;
		}
		for (int n = 2; n <= height; n++) {
			for (int k = 2; k <= eggs; k++) {
				data[n][k] = Integer.MAX_VALUE;
				for (int i = 1; i <= n; i++) {
					int tmp = 1+Math.max(data[i][k - 1] , data[n - i][k]);
					if (tmp < data[n][k]) {
						data[n][k] = tmp;
					}
				}
			}
		}

		return data[height][eggs];
	}
}
