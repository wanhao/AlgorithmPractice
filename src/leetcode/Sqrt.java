package leetcode;

public class Sqrt {

	public static void main(String[] args) {
		Sqrt t=new Sqrt();
		
		System.out.println(t.sqrt(0));
		System.out.println(t.sqrt(1));
		System.out.println(t.sqrt(2));
		System.out.println(t.sqrt(4));
		System.out.println(t.sqrt(7));
		System.out.println(t.sqrt(8));
		System.out.println(t.sqrt(9));
	}

    public int sqrt(int x) {
        if(x<0) throw new IllegalArgumentException();
        
        int low=0, high=x/2 +1 ;
        long mid,tmp;
        
        while(low<=high){
        	mid=low+((high-low)>>>1);
        	tmp=mid*mid;
        	
        	if(tmp==x){
        		return (int)mid;
        	}else if(tmp<x){
        		low=(int)mid+1;
        	}else{
        		high=(int)mid-1;
        	}
        }
        
        return high;
    }
}
