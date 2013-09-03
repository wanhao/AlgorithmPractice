package codinginterview;

public class NumToString {
	
	public static void main(String[] args){
		int num=0;
		System.out.println(intToString(num));
		
		num=100;
		System.out.println(intToString(num));

		num=1000;
		System.out.println(intToString(num));
		
		num=101;
		System.out.println(intToString(num));
		
		num=100010;
		System.out.println(intToString(num));
		
		num=10000100;
		System.out.println(intToString(num));
		
		num=2003000100;
		System.out.println(intToString(num));
	}

	
	public static String[] NUM=new String[]{"零","一","二","三","四","五","六","七","八","九"};
	public static String[] BASEUNIT=new String[]{"","十","百","千"};
	public static String[] UNIT=new String[]{"","万","亿"};
	
	public static String intToString(int num){
		if(num<0) throw new IllegalArgumentException();
		
		if(num==0) return NUM[0];
		
		StringBuilder sb=new StringBuilder();
		char[] numstr=Integer.toString(num).toCharArray();
		
		for(int i=0;i<numstr.length/2;i++){
			char tmp=numstr[i];
			numstr[i]=numstr[numstr.length-i-1];
			numstr[numstr.length-i-1]=tmp;
		}

		for(int i=numstr.length-1;i>=0;i--){		
			if(numstr[i]=='0'){
				if(i%4!=0 && numstr[i-1]!='0'){
					sb.append(NUM[0]);
				}
			}else{
				sb.append(NUM[numstr[i]-'0']);
				sb.append(BASEUNIT[i%4]);
			}
			
			if(i%4==0){
				sb.append(UNIT[i/4]);
			}
		}
		
		return sb.toString();
	}
}
