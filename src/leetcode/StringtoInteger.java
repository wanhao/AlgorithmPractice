package leetcode;

public class StringtoInteger {

	public static void main(String[] args) {
		StringtoInteger t=new StringtoInteger();
		
		System.out.println(t.atoi("")==0);
		System.out.println(t.atoi("   ")==0);
		System.out.println(t.atoi("  + ")==0);
		System.out.println(t.atoi(" - ")==0);
		System.out.println(t.atoi("  +0a d")==0);
		System.out.println(t.atoi("  +1ad ")==1);
		
		System.out.println(t.atoi(" -992 ")==-992);
		System.out.println(t.atoi(" 2838848830000228888")==Integer.MAX_VALUE);
		System.out.println(t.atoi(" -2838848830000228888")==Integer.MIN_VALUE);
	}

	public int atoi(String str) {
		if(str==null || str.isEmpty()) return 0;
		
		str=str.trim();
		if(str.isEmpty()) return 0;
		
		long value=0;
		boolean positive=true;
		
		int i=0;
		if(str.charAt(0)=='+'){
			positive=true;
			i++;
		}else if(str.charAt(0)=='-'){
			positive=false;
			i++;
		}
		
		for(;i<str.length();i++){
			if(str.charAt(i)<'0' || str.charAt(i)>'9'){
				break;
			}
			value=value*10+(str.charAt(i)-'0');
		}
		
		if(!positive){
			value=-value;
		}
		
		if(value>Integer.MAX_VALUE){
			value=Integer.MAX_VALUE;
		}else if(value<Integer.MIN_VALUE){
			value=-Integer.MIN_VALUE;
		}
		
		return (int)value;
	}
}
