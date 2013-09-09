package leetcode;

public class ClimbingStairs {
	
	public int climbStairs(int n) {
		if(n<=0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		
		int step1=1;
		int step2=2;
		int tmp;
		for(int i=3;i<=n;i++){
			tmp=step1+step2;
			step1=step2;
			step2=tmp;
		}
		
		return step2;
    }
}
