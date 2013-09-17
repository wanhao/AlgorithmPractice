package practice;

import java.util.Random;

public class TextGenerator {

	public static void main(String[] args) {
		TextGenerator t=new TextGenerator();
		String sed="I like this book. She like is too. How are about you.";
		System.out.println(t.generateText(sed));
	}
	
	public String generateText(String sed){
		if(sed==null || sed.length()<=1) return sed;
		
		int[][] count=new int[256][257];
		for(int i=0;i<sed.length()-1;i++){
			count[sed.charAt(i) & 0xFF][sed.charAt(i+1) & 0xFF]++;
		}
		count[sed.charAt(sed.length()-1) & 0xFF][256]++;
		
		int[] maxcount=new int[256];
		for(int i=0;i<256;i++){
			for(int j=0;j<257;j++){
				maxcount[i]+=count[i][j];
			}
		}
		
		StringBuilder sb=new StringBuilder();
		int sedChar=sed.charAt(0) & 0xFF;
		
		Random r=new Random();
		while(true){
			sb.append((char)sedChar);
			int max=r.nextInt(maxcount[sedChar]);
			for(int i=0;i<257;i++){
				max-=count[sedChar][i];
				if(max<0){
					sedChar=i;
					break;
				}
			}
			if(sedChar==256){
				break;
			}
		}
		
		return sb.toString();
	}
}
