package practice;


public class MinimalLargerNumber {
	
	public static void main(String[] args){
		MinimalLargerNumber t=new MinimalLargerNumber();
		
		System.out.println(t.minLargerNumber(1234));
		System.out.println(t.minLargerNumber(4321));
		System.out.println(t.minLargerNumber(4312));
	}
	
	public int minLargerNumber(int num){
		if(num<=0) return -1;
		
		char[] strNum=Integer.toString(num).toCharArray();
		
		if(minLargerNumber(strNum,0)){
			return Integer.valueOf(new String(strNum));
		}else{
			return -1;
		}
	}
	
	private boolean minLargerNumber(char[] strNum, int pos){
		if(pos>=strNum.length-1){
			return false;
		}
		
		if(minLargerNumber(strNum,pos+1)){
			return true;
		}
		
		int largerPos=-1;
		for(int i=pos+1;i<strNum.length;i++){
			if(strNum[i]>strNum[pos]){
				if(largerPos<0 ||strNum[i]<strNum[largerPos]){
					largerPos=i;
				}
			}
		}
		
		if(largerPos<0) return false;
		char tmp=strNum[pos];
		strNum[pos]=strNum[largerPos];
		strNum[largerPos]=tmp;
		
		for(int i=1;i<strNum.length-pos-1;i++){
			for(int j=pos+1;j<strNum.length-i;j++){
				if(strNum[j]<strNum[j+1]){
					tmp=strNum[j];
					strNum[j]=strNum[j+1];
					strNum[j+1]=strNum[j];
				}
			}
		}
		
		return true;
	}
}
