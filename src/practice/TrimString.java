package practice;

public class TrimString {

	public static void main(String[] args){
		TrimString t=new TrimString();
		
		char[] str="    a   b    cd e  ".toCharArray();
		t.print(str,t.trimString(str));
		
		str="a   b    cd e  ".toCharArray();
		t.print(str,t.trimString(str));
	}
	
	public void print(char[] str, int len){
		System.out.print('[');
		for(int i=0;i<len;i++){
			System.out.print(str[i]);
		}
		System.out.println(']');
	}
	
	public int trimString(char[] str){
		if(str==null || str.length==0) return 0;
		
		boolean lastSpace=false;
		int offset=0;
		for(int i=0;i<str.length;i++){
			if(str[i]==' '){
				lastSpace=true;
			}else{
				if(lastSpace&& offset>0){
					str[offset++]=' ';
				}
				str[offset++]=str[i];
			}
		}
		
		return offset;
	}
}
