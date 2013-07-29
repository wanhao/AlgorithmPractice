package codinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
	public static void main(String args[]) throws IOException {
		char[] str=new char[10*1024*1024];
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=reader.readLine())!=null){
			line.getChars(0, line.length(), str, 0);
			int newlen=replaceBlank(str, line.length());
			for(int i=0;i<newlen;i++){
				System.out.print(str[i]);
			}
			System.out.println();
		}
		
	}

	public static int replaceBlank(char[] str, int len){
		if(str==null || len<=0) return 0;
		if(str.length<=len) return str.length;
		
		int count=0;
		for(int i=0;i<len;i++){
			if(str[i]==' '){
				count++;
			}
		}
		
		if(len+(count<<1) > str.length) return str.length;
		
		int offset=len-1+(count<<1);
		for(int i=len-1;i>=0;i--){
			if(str[i]==' '){
				str[offset-2]='%';
				str[offset-1]='2';
				str[offset]='0';
				offset-=3;
			}else{
				str[offset--]=str[i];
			}
		}
		return  len+(count<<1);
	}
}
