package practice;

public class PreNextPermutation {

	public static void main(String[] args){
		PreNextPermutation t=new PreNextPermutation();
		
		String s="1234";
		System.out.println(t.nextPermutation(s));
		s="4321";
		System.out.println(t.nextPermutation(s));
		
		s="1234";
		System.out.println(t.prePermutation(s));
		s="4321";
		System.out.println(t.prePermutation(s));
	}
	
	public String prePermutation(String s){
		if(s==null|| s.length()<=1){
			return null;
		}
		char[] array=s.toCharArray();
		if(prePermutation(array)){
			return new String(array);
		}else{
			return null;
		}
	}
	
	private boolean prePermutation(char[] s){
		int i=s.length-1, ii=0;
		
		for(;;){
			ii=i;
			i--;
			if(s[i]>s[ii]){
				int j=s.length-1;
				while(s[j]>=s[i]){
					j--;
				}
				char tmp=s[i];
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
	
	public String nextPermutation(String s){
		if(s==null|| s.length()<=1){
			return null;
		}
		char[] array=s.toCharArray();
		if(nextPermutation(array)){
			return new String(array);
		}else{
			return null;
		}
	}
	
	private boolean nextPermutation(char[] s){
		int i=s.length-1, ii=0;
		
		for(;;){
			ii=i;
			i--;
			if(s[i]<s[ii]){
				int j=s.length-1;
				while(s[j]<=s[i]){
					j--;
				}
				char tmp=s[i];
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
