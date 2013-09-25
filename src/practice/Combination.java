package practice;

/**
 * 
 * 
 问题描述：找出从自然数1、2、... 、n中任取r个数的所有组合。例如n=5，r=3的所有组合为:
1,2,3
1,2,4 
1,3,4 
2,3,4 
1,2,5 
1,3,5 
2,3,5 
1,4,5 
2,4,5 
3,4,5
 * 
 * @author wanhao
 *
 */
public class Combination {

	public static void main(String[] args) {
		Combination c=new Combination();
		c.combination(5,3);
		
		System.out.println();
		
		c.combination1(5,3);
	}

	public void combination(int n, int r){
		combination(new int[r],n,r);
	}
	
	private void combination(int[] array, int n, int r){
		if(r==0){
			for(int tmp:array){
				System.out.print(tmp);
			}
			System.out.println();
			return;
		}
		
		if(n<r) return;
		array[r-1]=n;
		combination(array, n-1, r-1);
		combination(array, n-1, r);
	}
	
	public void combination1(int n, int r){
		int[] s=new int[n];
		for(int i=n-r;i<n;i++){
			s[i]=1;
		}
		do{
			for(int i=0;i<s.length;i++){
				if(s[i]==1){
					System.out.print(i+1);
				}
			}
			System.out.println();
		}while(nextPermutation(s));
	}
	
	private boolean nextPermutation(int[] s){
		int i=s.length-1, ii=0;
		
		for(;;){
			ii=i;
			i--;
			if(s[i]<s[ii]){
				int j=s.length-1;
				while(s[j]<=s[i]){
					j--;
				}
				int tmp=s[i];
				s[i]=s[j];
				s[j]=tmp;
				
				j=s.length-1;
				while(ii<j){
					tmp=s[ii];
					s[ii]=s[j];
					s[j]=tmp;
					ii++;
					j--;
				}
				return true;
			}
			
			if(i==0){
				return false;
			}
		}
		
	}
}
